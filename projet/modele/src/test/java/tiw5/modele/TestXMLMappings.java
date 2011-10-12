package tiw5.modele;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import junit.framework.TestCase;

import org.xml.sax.SAXException;

public class TestXMLMappings extends TestCase {

	private Validator validator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		if (validator == null) {
			validator = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
					.newSchema(
							new StreamSource(Album.class
									.getResourceAsStream("/VentesCd.xsd")))
					.newValidator();
		}
	}

	public void testArtisteMapping() throws SAXException, IOException, JAXBException {
		Artiste artiste = new Artiste("urn:artiste:toto", "Toto");
		Album album = new Album("The first album");
		long albumId = 345;
		album.addPiste(new Piste(1,"Piste1",123));
		Piste piste = new Piste(2,"Piste1",234);
		album.addPiste(piste);
		piste.addContributeur(artiste);
		album.setId(albumId);
		artiste.addAlbum(album);
		validator.validate(new JAXBSource(JAXBContext.newInstance(Artiste.class), artiste));
	}
	
	public void testAlbumMapping() throws Exception {
		JAXBContext ctx = JAXBContext.newInstance(Album.class);
		Artiste artiste = new Artiste("urn:artiste:toto", "Toto");
		Album album = new Album("The first album");
		long albumId = 345;
		album.addPiste(new Piste(1,"Piste1",123));
		Piste piste = new Piste(2,"Piste1",234);
		album.addPiste(piste);
		piste.addContributeur(artiste);
		album.setId(albumId);
		artiste.addAlbum(album);
		validator.validate(new JAXBSource(ctx, album));
	}

}
