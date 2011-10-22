package tiw5.client;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import tiw5.services.Album;

@XmlRootElement
public class AlbumDescription {

	@XmlElement
	public Album album;

	public AlbumDescription(){
		
	}
	
	public Album getAlbum(){
		return this.album;
	}
	
	public void setAlbum(Album album){
		this.album = album;
	}
}
