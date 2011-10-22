
package fr.univ_lyon1.master_info.m2ti.tiw5.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for piste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="piste">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd}titre" minOccurs="0"/>
 *         &lt;element ref="{http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd}contributeur" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numero" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="duree" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "piste", propOrder = {
    "titre",
    "contributeur"
})
public class Piste {

    @XmlElement(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd")
    protected String titre;
    @XmlElement(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd")
    protected List<ArtisteRef> contributeur;
    @XmlAttribute(name = "numero", required = true)
    protected int numero;
    @XmlAttribute(name = "duree", required = true)
    protected int duree;

    /**
     * Gets the value of the titre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Sets the value of the titre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    /**
     * Gets the value of the contributeur property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contributeur property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContributeur().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArtisteRef }
     * 
     * 
     */
    public List<ArtisteRef> getContributeur() {
        if (contributeur == null) {
            contributeur = new ArrayList<ArtisteRef>();
        }
        return this.contributeur;
    }

    /**
     * Gets the value of the numero property.
     * 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     */
    public void setNumero(int value) {
        this.numero = value;
    }

    /**
     * Gets the value of the duree property.
     * 
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Sets the value of the duree property.
     * 
     */
    public void setDuree(int value) {
        this.duree = value;
    }

}
