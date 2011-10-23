package tiw5.services.impl;

import java.util.Iterator;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univ_lyon1.master_info.m2ti.tiw5.services.CoupleAlbumQuantite;

import tiw5.modele.Stock;
 
@WebService(targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", 
            serviceName = "StockService", 
            name = "StockPortType", 
            portName = "StockPort")
public class StockService {
 
	private static final Logger log = LoggerFactory.getLogger(StockService.class);
 
	/**
	 * Cette fonction retourne si oui ou non il reste l'album passé en paramètre en stock
	 * @param albumId l'identifiant de l'album
	 * @return si l'album est en stock avec au moins 1 album
	 */
	@WebMethod
	public boolean disponible(long albumId){
		EntityManager em = Persistence.createEntityManagerFactory("etudiant")
		.createEntityManager();
		em.getTransaction().begin();
		Stock stock = em.find(Stock.class, albumId); //on regarde si l'album est en stock
		Stock newStock;
		
		//si l'album n'a jamais été en stock
		if(stock == null){
			log.info("did not found {}",albumId);
			newStock = new Stock();
			newStock.setId(albumId);
			newStock.setQuantite(0);
			em.persist(newStock); //si c'est le cas, on l'ajoute au stock avec quantité 0
			em.getTransaction().commit();
			return false;
		}
		//si il est en stock, alors si il ne reste même plus 1 album en stock
		if(stock.getQuantite() <= 0){
			log.info("no even one album {}",albumId);
			return false;
		}
		return true; //il reste au moins 1 album d'identifiant albumId en stock
	}
	
	/**
	 * Cette méthode assure qu'il y a une quantité suffisante pour les albums passés en paramètre
	 * @param couples de type une liste de coupleAlbumQuantite
	 * 			représentant plusieurs albums ainsi que la quantité devant être assurée
	 * @return
	 */
	@Oneway
	@WebMethod
	public void assureCapacite(List<CoupleAlbumQuantite> couples){
		Iterator<CoupleAlbumQuantite> it = couples.iterator();
		CoupleAlbumQuantite couple;
		Stock stock;
		EntityManager em = Persistence.createEntityManagerFactory("etudiant")
		.createEntityManager();
		em.getTransaction().begin();
		
		//pour chaque couple
		while(it.hasNext()){
			couple = it.next();
			//on regarde si il est disponible (cela créé au moins les entrées pour 
			//		les albums qui n'étaient pas déjà en stock)
			//on aurait pu éviter l'utilisation de disponible car il y a redondance
			//		de code. Il aurait fallu que disponible soit une méthode ou bien
			//		exporter le code de disponible ici
			if(!disponible(couple.getAlbumId())){
				stock = em.find(Stock.class, couple.getAlbumId());
				stock.setId(couple.getQuantite());
			}
			//si il existait déjà
			else{
				stock = em.find(Stock.class, couple.getAlbumId());
				//on test si la quantité est suffisante
				if(stock.getQuantite() < couple.getQuantite()){
					stock.setQuantite(couple.getQuantite());
				}
			}
			//on met à jour
			em.merge(stock);
		}
		log.info("fin assureCapacite");
		em.getTransaction().commit();
	}

	@Oneway
	@WebMethod
	public void commande(List<Long> albumIds){
		Iterator<Long> it = albumIds.iterator();
		Long albumId;
		Stock stock;
		EntityManager em = Persistence.createEntityManagerFactory("etudiant")
		.createEntityManager();
		em.getTransaction().begin();
		
		//pour chaque albumId
		while(it.hasNext()){
			albumId = it.next();
			//on regarde si il n'est pas encore en stock
			if(!disponible(albumId)){
				log.info("did not found {}",albumId);
			}
			//si il est en stock
			else{
				stock = em.find(Stock.class, albumId);
				//on reagrde si il n'y a plus aucun album pour la commande
				if(stock.getQuantite() < 1){
					log.info("no more album {}",albumId);
				}
				else{
					//si l'album est bien disponible alors on a récupère un
					stock.setQuantite(stock.getQuantite() - 1);
					em.merge(stock); //et on met à jour
				}
			}
		}
		log.info("fin commande");
		em.getTransaction().commit();
	}
}
