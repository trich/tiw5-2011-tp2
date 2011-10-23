
package fr.univ_lyon1.master_info.m2ti.tiw5.services;

import javax.xml.bind.annotation.XmlRegistry;


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
     * Create an instance of {@link CoupleAlbumQuantite }
     * 
     */
    public CoupleAlbumQuantite createCoupleAlbumQuantite() {
        return new CoupleAlbumQuantite();
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

}
