
package fr.univ_lyon1.master_info.m2ti.tiw5.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for coupleAlbumQuantite complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="coupleAlbumQuantite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="albumId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coupleAlbumQuantite", propOrder = {
    "albumId",
    "quantite"
})
public class CoupleAlbumQuantite {

    protected long albumId;
    protected long quantite;

    /**
     * Gets the value of the albumId property.
     * 
     */
    public long getAlbumId() {
        return albumId;
    }

    /**
     * Sets the value of the albumId property.
     * 
     */
    public void setAlbumId(long value) {
        this.albumId = value;
    }

    /**
     * Gets the value of the quantite property.
     * 
     */
    public long getQuantite() {
        return quantite;
    }

    /**
     * Sets the value of the quantite property.
     * 
     */
    public void setQuantite(long value) {
        this.quantite = value;
    }

}
