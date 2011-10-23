package tiw5.services.impl;

import java.util.Iterator;
import java.util.List;

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

		//si l'album n'a jamais été en stock
		if(stock == null){
			log.info("did not found {}",albumId);
			stock = new Stock();
			stock.setId(albumId);
			stock.setQuantite(0);
			em.persist(stock); //si c'est le cas, on l'ajoute au stock avec quantité 0
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
			//on regarde si il est disponible (cela créé
			if(!disponible(couple.getAlbumId())){
				stock = em.find(Stock.class, couple.getAlbumId());
			}
			else{
				log.info("did not found {}",couple.getAlbumId());
				em.persist(couple);
			}
		}
		
	}
	
	@WebMethod void commande(List<Integer> albumIds){
		
	}
	
	/*
	@WebMethod
	public Album getAlbumDescription(long albumId) {
		EntityManager em = Persistence.createEntityManagerFactory("etudiant")
				.createEntityManager();
		Album album = em.find(Album.class, albumId);
		return album;
	}
 
	@Oneway
	@WebMethod
	public void addAlbumDescription(Album album) {
		EntityManager em = Persistence.createEntityManagerFactory("etudiant")
				.createEntityManager();
		em.getTransaction().begin();
		if (em.find(Album.class, album.getId()) != null) {
			log.info("found {}",album.getId());
			em.merge(album);
		} else {
			log.info("did not found {}",album.getId());
			em.persist(album);
		}
		for(Artiste a : album.getArtistes()) {
			if (em.find(Artiste.class, a.getUri()) != null) {
				em.merge(a);
			} else {
				em.persist(a);
			}
		}
		em.getTransaction().commit();
	}
 */
}
