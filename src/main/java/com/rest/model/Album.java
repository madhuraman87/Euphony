package com.rest.model;

import java.util.List;

public class Album {
	private Integer albumid;
	private String genre;
	private Integer artist;
	private List<Feedback> feedbackList;
	private List<Track> trackList;
	public Integer getAlbumid() {
		return albumid;
	}
	public void setAlbumid(Integer albumid) {
		this.albumid = albumid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getArtist() {
		return artist;
	}
	public void setArtist(Integer artist) {
		this.artist = artist;
	}
	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}
	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
	public List<Track> getTrackList() {
		return trackList;
	}
	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}
	
}
