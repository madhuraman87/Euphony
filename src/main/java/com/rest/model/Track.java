package com.rest.model;

import java.util.List;

public class Track {
	private Integer trackid;
	private String albumid;
	private String genre;
	private String artist;
	private List<Feedback> feedbackList;
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
	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}
	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
	
}
