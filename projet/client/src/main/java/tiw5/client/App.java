package tiw5.client;

import java.io.File;
import java.rmi.MarshalException;
import java.rmi.UnmarshalException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tiw5.services.Album;
import tiw5.services.AlbumDataPortType;
import tiw5.services.AlbumDataService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AlbumDataService ads = new AlbumDataService();
        AlbumDataPortType adpt = ads.getAlbumDataPort();
        
        AlbumDescription albumDesc = new AlbumDescription();
        //déclaration des variables utiles pour le marshaller
        JAXBContext contx; //le contexte
        Marshaller m; //le marshaller...
        Unmarshaller unm; //le unmarshaller..
        
        try{
	        albumDesc.setAlbum(adpt.getAlbumDescription(Integer.parseInt(args[0])));
	        
	        try{
	        	contx = JAXBContext.newInstance(AlbumDescription.class); //on récupère le contexte
		        m = contx.createMarshaller();
		        m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE ); //sortie XML correct
		        m.marshal(albumDesc, System.out);
	        }
	        catch(JAXBException eJAXB){ //JAXBException if any prob during the marshalling
	        	eJAXB.printStackTrace();
	        }
        }
        catch(Exception e){
        	try{
        		contx = JAXBContext.newInstance(AlbumDescription.class); //on récupère le contexte
		        unm = contx.createUnmarshaller();
				albumDesc = (AlbumDescription)unm.unmarshal(new File(args[0]));
				adpt.addAlbumDescription(albumDesc.getAlbum());
        	}
	        catch(JAXBException eJAXB){
	        	eJAXB.printStackTrace();
	        }
        }
    }
}
