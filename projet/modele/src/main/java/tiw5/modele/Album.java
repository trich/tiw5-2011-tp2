package tiw5.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 * Représente un cd avec un titre et un ensemble de pistes.
 * 
 * @author Emmanuel Coquery <emmanuel.coquery@liris.cnrs.fr>
 */
@Entity
@XmlRootElement(name = "album", namespace = ModeleConstants.NS)
@XmlType(propOrder = { "id", "titre", "listePistes", "artistes" })
public class Album implements Serializable, Comparable<Album>, Iterable<Piste> {

	public static class RefAdapter extends XmlAdapter<AlbumRef, Album> {

		@Override
		public AlbumRef marshal(Album v) throws Exception {
			AlbumRef ref = new AlbumRef();
			ref.id = v.id;
			return ref;
		}

		@Override
		public Album unmarshal(AlbumRef v) throws Exception {
			Album a = new Album();
			a.setId(v.id);
			return a;
		}

	}

	public static class AlbumRef {
		@XmlAttribute
		public long id;
	}

	private static final long serialVersionUID = 5779065999435872649L;

	/**
	 * Un identifiant unique pour chaque cd
	 */
	@Id
	//@GeneratedValue
	@XmlAttribute
	private long id;

	/**
	 * Le titre du cd
	 */
	@XmlElement(name = "titre", namespace = ModeleConstants.NS)
	private String titre;

	/**
	 * La liste des plages du cd.
	 */
	@MapKey(name = "numero")
	@OneToMany(mappedBy = "album", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Sort(type = SortType.NATURAL)
	@XmlTransient
	private SortedMap<Integer, Piste> pistes;

	@ManyToMany
	@XmlJavaTypeAdapter(Artiste.RefAdapter.class)
	@XmlElement(name = "artiste", namespace = ModeleConstants.NS)
	private Set<Artiste> artistes;

	// Only for entity manager
	private Album() {
		this.pistes = new TreeMap<Integer, Piste>();
		this.artistes = new HashSet<Artiste>();
	}

	/**
	 * Créée un nouveau cd ayant pour titre l'argument.
	 * 
	 * @param titre
	 *            Le titre du cd
	 */
	public Album(String titre) {
		this.titre = titre;
		this.pistes = new TreeMap<Integer, Piste>();
		this.artistes = new HashSet<Artiste>();
	}

	/**
	 * Le titre du cd.
	 * 
	 * @return Le titre du cd.
	 */
	@XmlTransient
	public String getTitre() {
		return titre;
	}

	/**
	 * Change le titre du cd
	 * 
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * L'identifiant du cd.
	 * 
	 * @return
	 */
	@XmlTransient
	public long getId() {
		return id;
	}

	/**
	 * Change l'identifiant du cd. Ne devrait être changé que si le cd n'avait
	 * pas d'identifiant auparavant.
	 * 
	 * @param id
	 *            l'identifiant du cd
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * La ieme piste du cd
	 * 
	 * @param index
	 *            le numéro de la piste sur le cd
	 * @return la piste
	 * @throws IndexOutOfBoundsException
	 *             si le numéro ne correspond pas à une piste.
	 */
	public Piste getPiste(int index) {
		return pistes.get(index);
	}

	/**
	 * Ajoute une piste à la fin du cd.
	 * 
	 * @param piste
	 *            la piste à ajouter
	 */
	public void addPiste(Piste piste) {
		piste.album = this;
		pistes.put(piste.getNumero(), piste);
	}

	/**
	 * Insère la piste à l'index spécifié. Les pistes apparaissant plus loin
	 * voient leur numéro décalé.
	 * 
	 * @param piste
	 *            la piste à insérer.
	 * @param index
	 *            le numéro que prendra la piste un fois insérée.
	 */
	public void insertPiste(Piste piste, int index) {
		pistes.put(index, piste);
	}

	/**
	 * Supprime une piste de la liste des pistes
	 * 
	 * @param piste
	 */
	public void removePiste(Piste piste) {
		pistes.remove(piste);
		piste.album = null;
	}

	/**
	 * Le nombre de pistes du cd
	 * 
	 * @return le nombre de pistes du cd
	 */
	@XmlTransient
	public int getNbPistes() {
		return pistes.size();
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Album other = (Album) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Album o) {
		return (this.id - o.id < 0) ? -1 : ((this.id == o.id) ? 0 : 1);
	}

	@Override
	public Iterator<Piste> iterator() {
		return pistes.values().iterator();
	}

	@XmlTransient
	public Collection<Artiste> getArtistes() {
		return artistes;
	}

	public void addArtiste(Artiste artiste) {
		artistes.add(artiste);
		artiste.albums.add(this);
	}

	public void removeArtiste(Artiste artiste) {
		artistes.remove(artiste);
		artiste.albums.remove(this);
	}

	// For JAXB only
	@SuppressWarnings("unused")
	@XmlElement(name = "piste", namespace = ModeleConstants.NS)
	private ArrayList<Piste> getListePistes() {
		return new ArrayList<Piste>(pistes.values());
	}

	@SuppressWarnings("unused")
	private void setListePistes(ArrayList<Piste> list) {
		if (pistes == null) {
			pistes = new TreeMap<Integer, Piste>();
		} else {
			pistes.clear();
		}
		for (Piste p : list) {
			addPiste(p);
		}
	}

}
