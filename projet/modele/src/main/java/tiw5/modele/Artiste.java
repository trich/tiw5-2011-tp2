package tiw5.modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@XmlRootElement(name="artiste",namespace=ModeleConstants.NS)
@XmlType(propOrder={"uri","nom","albums"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Artiste implements Serializable {
	
	static class RefAdapter extends XmlAdapter<ArtisteRef, Artiste>{

		@Override
		public ArtisteRef marshal(Artiste v) throws Exception {
			ArtisteRef ref = new ArtisteRef();
			ref.uri = v.getUri();
			return ref;
		}

		@Override
		public Artiste unmarshal(ArtisteRef v) throws Exception {
			return new Artiste(v.uri,null);
		}
		
	}
	
	static class ArtisteRef {
		@XmlAttribute
		public String uri;
	}

	private static final long serialVersionUID = 3490668647763848697L;

	@Id
	@XmlAttribute
	private String uri;

	@XmlElement(name="nom",namespace=ModeleConstants.NS)
	private String nom;

	@ManyToMany(mappedBy = "artistes")
	@XmlElement(name="album", namespace=ModeleConstants.NS)
	@XmlJavaTypeAdapter(value=Album.RefAdapter.class)
	Set<Album> albums;

	@SuppressWarnings("unused")
	private Artiste() {
	}

	public Artiste(String uri, String nom) {
		this.uri = uri;
		this.nom = nom;
		this.albums = new HashSet<Album>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artiste other = (Artiste) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the albums
	 */
	public Set<Album> getAlbums() {
		return albums;
	}

	public void addAlbum(Album album) {
		album.addArtiste(this);
	}

	public void removeAlbum(Album album) {
		album.removeArtiste(this);
	}

}
