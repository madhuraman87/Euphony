package com.rest.model;

public class Search {
	private Integer albumid;
	private Integer trackid;
	private Integer artistid;
	private String genreid;
	private double rating;
	public Integer getAlbumid() {
		return albumid;
	}
	public void setAlbumid(Integer albumid) {
		this.albumid = albumid;
	}
	public Integer getTrackid() {
		return trackid;
	}
	public void setTrackid(Integer trackid) {
		this.trackid = trackid;
	}
	public Integer getArtistid() {
		return artistid;
	}
	public void setArtistid(Integer artistid) {
		this.artistid = artistid;
	}
	public String getGenreid() {
		return genreid;
	}
	public void setGenreid(String genreid) {
		this.genreid = genreid;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
