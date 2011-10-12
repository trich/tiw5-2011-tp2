package tiw5.services.impl;
 
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import tiw5.modele.Album;
import tiw5.modele.Artiste;
 
@WebService(targetNamespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", 
            serviceName = "AlbumDataService", 
            name = "AlbumDataPortType", 
            portName = "AlbumDataPort")
public class AlbumDataService {
 
	private static final Logger log = LoggerFactory.getLogger(AlbumDataService.class);
 
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
