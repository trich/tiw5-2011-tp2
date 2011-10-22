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

import tiw5.modele.Album;
import tiw5.modele.Artiste;
import tiw5.modele.Stock;
 
@WebService(targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", 
            serviceName = "AlbumDataService", 
            name = "AlbumDataPortType", 
            portName = "AlbumDataPort")
public class StockService {
 
	private static final Logger log = LoggerFactory.getLogger(StockService.class);
 
	@WebMethod
	public boolean disponible(long albumId){
		EntityManager em = Persistence.createEntityManagerFactory("etudiant")
		.createEntityManager();
		Stock stock = em.find(Stock.class, albumId);
		if(stock.getQuantite() > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	@WebMethod
	public boolean assureCapacite(List<CoupleAlbumQuantite> couples){
		Iterator<CoupleAlbumQuantite> it = couples.iterator();
		CoupleAlbumQuantite couple;
		while(it.hasNext()){
			couple = it.next();
			if(disponible(couple.getAlbumId())){
				EntityManager em = Persistence.createEntityManagerFactory("etudiant")
				.createEntityManager();
				Stock stock = em.find(Stock.class, couple.getAlbumId());
				if(stock.getQuantite() > 0){
					return true;
				}
				else{
					return false;
				}
			}
		}
		return false;
	}
	
	@WebMethod void commande(List<Integer> albumIds){
		
	}
	
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
 
}
