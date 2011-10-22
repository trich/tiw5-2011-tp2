
package fr.univ_lyon1.master_info.m2ti.tiw5.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.univ_lyon1.master_info.m2ti.tiw5.services package. 
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

    private final static QName _Commande_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/services", "commande");
    private final static QName _Disponible_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/services", "disponible");
    private final static QName _DisponibleResponse_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/services", "disponibleResponse");
    private final static QName _AssureCapacite_QNAME = new QName("http://master-info.univ-lyon1.fr/M2TI/TIW5/services", "assureCapacite");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.univ_lyon1.master_info.m2ti.tiw5.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AssureCapacite }
     * 
     */
    public AssureCapacite createAssureCapacite() {
        return new AssureCapacite();
    }

    /**
     * Create an instance of {@link DisponibleResponse }
     * 
     */
    public DisponibleResponse createDisponibleResponse() {
        return new DisponibleResponse();
    }

    /**
     * Create an instance of {@link Commande }
     * 
     */
    public Commande createCommande() {
        return new Commande();
    }

    /**
     * Create an instance of {@link Disponible }
     * 
     */
    public Disponible createDisponible() {
        return new Disponible();
    }

    /**
     * Create an instance of {@link CoupleAlbumQuantite }
     * 
     */
    public CoupleAlbumQuantite createCoupleAlbumQuantite() {
        return new CoupleAlbumQuantite();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Commande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", name = "commande")
    public JAXBElement<Commande> createCommande(Commande value) {
        return new JAXBElement<Commande>(_Commande_QNAME, Commande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Disponible }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", name = "disponible")
    public JAXBElement<Disponible> createDisponible(Disponible value) {
        return new JAXBElement<Disponible>(_Disponible_QNAME, Disponible.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisponibleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", name = "disponibleResponse")
    public JAXBElement<DisponibleResponse> createDisponibleResponse(DisponibleResponse value) {
        return new JAXBElement<DisponibleResponse>(_DisponibleResponse_QNAME, DisponibleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssureCapacite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/services", name = "assureCapacite")
    public JAXBElement<AssureCapacite> createAssureCapacite(AssureCapacite value) {
        return new JAXBElement<AssureCapacite>(_AssureCapacite_QNAME, AssureCapacite.class, null, value);
    }

}
