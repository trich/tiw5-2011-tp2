package tiw5.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType(propOrder={"albumId","quantite"})
public class Stock {
	
	/**
	 * Un identifiant unique incrémenté pour chaque entrée
	 */
	@Id
	@GeneratedValue
	private long id;
	
	private long albumId;
	
	private long quantite;
	
	/**
	 * Le constructeur par défaut
	 */
	public Stock(){
		
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public long getQuantite() {
		return quantite;
	}
	
}
