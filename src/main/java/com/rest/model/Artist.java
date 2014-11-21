package com.rest.model;

import java.util.List;

public class Artist {
	private int artistid;
	private String fname;
	private String lname;
	private List<Album> albumList;
	public int getArtistid() {
		return artistid;
	}
	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public List<Album> getAlbumList() {
		return albumList;
	}
	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
}
