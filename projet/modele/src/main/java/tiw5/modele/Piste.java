package tiw5.modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import tiw5.modele.Artiste.RefAdapter;

/**
 * Classe représentant une piste. Remarque: on ne souhaite pas faire des pistes
 * des entités à part entière.
 * 
 * @author Emmanuel Coquery <emmanuel.coquery@liris.cnrs.fr>
 */
@Entity
@IdClass(tiw5.modele.PistePk.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Piste implements Serializable, Comparable<Piste> {

	private static final long serialVersionUID = -3024423623006124648L;

	/**
	 * L'album contenant la piste.
	 */
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@XmlTransient
	Album album; // package private pour autoriser Album à changer ces valeurs
					// lors d'un ajout de piste.

	/**
	 * Le numéro de la piste dans le disque.
	 */
	@Id
	@XmlAttribute
	private int numero;

	/**
	 * Le titre de la piste.
	 */
	@XmlElement(name="titre",namespace=ModeleConstants.NS)
	private String titre;

	/**
	 * La durée de la piste en secondes.
	 */
	@XmlAttribute
	private int duree;

	@ManyToMany
	@XmlJavaTypeAdapter(value=RefAdapter.class)
	@XmlElement(name="contributeur",namespace=ModeleConstants.NS)
	private Set<Artiste> contributeurs;

	// Used only by reflection APIs
	@SuppressWarnings("unused")
	private Piste() {
	}

	/**
	 * Créée une piste.
	 * 
	 * @param titre
	 *            le titre de la piste.
	 * @param duree
	 *            la durée de la piste en secondes.
	 */
	public Piste(int numero, String titre, int duree) {
		this.titre = titre;
		this.duree = duree;
		this.numero = numero;
		this.contributeurs = new HashSet<Artiste>();
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 * @exception IllegalArgumentException
	 *                si le numero de la piste est déjà employé dans l'album.
	 */
	public void setAlbum(Album album) throws IllegalArgumentException {
		this.album.removePiste(this);
		album.addPiste(this);
	}

	/**
	 * Le numéro de la piste dans l'album.
	 * 
	 * @return le numéro de la piste.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Change le numéro de la piste dans le Cd. Replace l'éventuelle piste ayant
	 * ce numéro dans l'album.
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) throws IllegalArgumentException {
		album.removePiste(this);
		this.numero = numero;
		album.addPiste(this);
	}

	/**
	 * @return le titre.
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Change le titre de la piste.
	 * 
	 * @param titre
	 *            le nouveau titre.
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return la durée.
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * Change la durée de la piste.
	 * 
	 * @param duree
	 *            la nouvelle durée.
	 */
	public void setDuree(int duree) {
		this.duree = duree;
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
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + numero;
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
		Piste other = (Piste) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public int compareTo(Piste piste) {
		if (piste.album == this.album
				|| (this.album != null && this.album.equals(piste.album))) {
			return this.numero - piste.numero;
		} else {
			return this.album.compareTo(piste.album);
		}
	}

	/**
	 * @return the contributeurs
	 */
	public Set<Artiste> getContributeurs() {
		return contributeurs;
	}

	public void addContributeur(Artiste contributeur) {
		contributeurs.add(contributeur);
	}

	public void removeContributeur(Artiste contributeur) {
		contributeurs.remove(contributeur);
	}

}

class PistePk implements Serializable {
	public PistePk() {
	}

	private static final long serialVersionUID = 7162675527669345865L;
	private Album album;
	private int numero;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + numero;
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
		PistePk other = (PistePk) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

}
