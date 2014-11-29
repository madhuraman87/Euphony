package com.rest.model;

public class ShoppingCart {
	private int userid;
	private int trackid;
	private String albumid;
	private String artistid;
	private String genre;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTrackid() {
		return trackid;
	}
	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	public String getArtistid() {
		return artistid;
	}
	public void setArtistid(String artistid) {
		this.artistid = artistid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
