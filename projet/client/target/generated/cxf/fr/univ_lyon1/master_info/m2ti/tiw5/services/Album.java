
package fr.univ_lyon1.master_info.m2ti.tiw5.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for album complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="album">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd}titre" minOccurs="0"/>
 *         &lt;element ref="{http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd}piste" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd}artiste" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "album", propOrder = {
    "titre",
    "piste",
    "artiste"
})
public class Album {

    @XmlElement(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd")
    protected String titre;
    @XmlElement(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd")
    protected List<Piste> piste;
    @XmlElement(namespace = "http://master-info.univ-lyon1.fr/M2TI/TIW5/ventecd")
    protected List<ArtisteRef> artiste;
    @XmlAttribute(name = "id", required = true)
    protected long id;

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
     * Gets the value of the piste property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the piste property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPiste().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Piste }
     * 
     * 
     */
    public List<Piste> getPiste() {
        if (piste == null) {
            piste = new ArrayList<Piste>();
        }
        return this.piste;
    }

    /**
     * Gets the value of the artiste property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artiste property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtiste().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArtisteRef }
     * 
     * 
     */
    public List<ArtisteRef> getArtiste() {
        if (artiste == null) {
            artiste = new ArrayList<ArtisteRef>();
        }
        return this.artiste;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

}
