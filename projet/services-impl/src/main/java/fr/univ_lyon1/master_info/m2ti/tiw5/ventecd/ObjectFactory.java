
package fr.univ_lyon1.master_info.m2ti.tiw5.ventecd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import fr.univ_lyon1.master_info.m2ti.tiw5.services.CoupleAlbumQuantite;


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

    private final static QName _CoupleAlbumQuantite_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", "coupleAlbumQuantite");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.univ_lyon1.master_info.m2ti.tiw5.ventecd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoupleAlbumQuantite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd", name = "coupleAlbumQuantite")
    public JAXBElement<CoupleAlbumQuantite> createCoupleAlbumQuantite(CoupleAlbumQuantite value) {
        return new JAXBElement<CoupleAlbumQuantite>(_CoupleAlbumQuantite_QNAME, CoupleAlbumQuantite.class, null, value);
    }

}
