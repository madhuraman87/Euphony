package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class TrackView {
	private List<Track> aaData = new ArrayList<Track>();

	public TrackView(List<Track> aaData) {
		this.aaData = aaData;
	}

	public List<Track> getAaData() {
		return aaData;
	}

	public void setAaData(List<Track> aaData) {
		this.aaData = aaData;
	}
}
