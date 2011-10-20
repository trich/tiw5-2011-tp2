
package tiw5.ventecd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import tiw5.services.Album;
import tiw5.services.ArtisteRef;
import tiw5.services.Piste;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.univ_lyon1.master_info.m2ti.tiw5.ventecd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Album_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", "album");
    private final static QName _Artiste_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", "artiste");
    private final static QName _Contributeur_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", "contributeur");
    private final static QName _Piste_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", "piste");
    private final static QName _Titre_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", "titre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.univ_lyon1.master_info.m2ti.tiw5.ventecd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Album }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", name = "album")
    public JAXBElement<Album> createAlbum(Album value) {
        return new JAXBElement<Album>(_Album_QNAME, Album.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArtisteRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", name = "artiste")
    public JAXBElement<ArtisteRef> createArtiste(ArtisteRef value) {
        return new JAXBElement<ArtisteRef>(_Artiste_QNAME, ArtisteRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArtisteRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", name = "contributeur")
    public JAXBElement<ArtisteRef> createContributeur(ArtisteRef value) {
        return new JAXBElement<ArtisteRef>(_Contributeur_QNAME, ArtisteRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Piste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", name = "piste")
    public JAXBElement<Piste> createPiste(Piste value) {
        return new JAXBElement<Piste>(_Piste_QNAME, Piste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", name = "titre")
    public JAXBElement<String> createTitre(String value) {
        return new JAXBElement<String>(_Titre_QNAME, String.class, null, value);
    }

}
