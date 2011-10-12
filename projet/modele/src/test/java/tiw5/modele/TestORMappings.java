package tiw5.modele;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public class TestORMappings extends TestCase {

	private EntityManager em;

	protected void setUp() throws Exception {
		em = Persistence.createEntityManagerFactory("test")
				.createEntityManager();
	}

	protected void tearDown() throws Exception {
		em.close();
	}

	public void testSetup() {
		// on ne fait rien
	}

	public void testCreateRemove() {
		long nbPistes = (Long) em.createQuery("SELECT COUNT(*) FROM Piste")
				.getSingleResult();
		Album album = new Album("TestAlbum");
		album.addPiste(new Piste(1, "Piste1", 123));
		album.addPiste(new Piste(3, "Piste3", 345));
		album.addPiste(new Piste(2, "Piste2", 234));
		em.getTransaction().begin();
		em.persist(album);
		long albumId = album.getId();
		em.getTransaction().commit();
		em.clear();
		album = null;
		em.getTransaction().begin();
		album = em.find(Album.class, albumId);
		assertNotNull(album);
		assertEquals(3, album.getNbPistes());
		assertNotNull(album.getPiste(2));
		assertEquals("Piste2", album.getPiste(2).getTitre());
		em.remove(album);
		em.getTransaction().commit();
		em.clear();
		em.getTransaction().begin();
		assertEquals((Long) nbPistes,
				(Long) em.createQuery("SELECT COUNT(*) FROM Piste")
						.getSingleResult());
		em.getTransaction().commit();
	}
	
}
