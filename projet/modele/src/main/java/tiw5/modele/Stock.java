package tiw5.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {
	
	/**
	 * Un identifiant unique incrémenté pour chaque entrée
	 */
	@Id
	@GeneratedValue
	private long id;
	
	private Album album;
	
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

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Album getAlbum() {
		return album;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public long getQuantite() {
		return quantite;
	}
	
}
