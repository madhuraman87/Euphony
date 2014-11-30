package com.rest.model;


public class Track {
	private Integer trackid;
	private String albumid;
	private String genre;
	private String artist;
	public Integer getTrackid() {
		return trackid;
	}
	public void setTrackid(Integer trackid) {
		this.trackid = trackid;
	}
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}
