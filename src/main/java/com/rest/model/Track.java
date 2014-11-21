package com.rest.model;

import java.util.List;

public class Track {
	private int trackid;
	private String title;	
	private double price;
	private int year;
	private String trackTime;
	private Feedback feedback;
	private int albumid;
	private List<String> genre;
	private List<Artist> artistList;
	private List<Feedback> feedbackList;
	public int getTrackid() {
		return trackid;
	}
	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTrackTime() {
		return trackTime;
	}
	public void setTrackTime(String trackTime) {
		this.trackTime = trackTime;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public int getAlbumid() {
		return albumid;
	}
	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public List<Artist> getArtistList() {
		return artistList;
	}
	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}
	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}
	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
}
