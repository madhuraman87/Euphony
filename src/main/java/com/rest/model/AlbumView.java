package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class AlbumView {
	private List<Album> aaData = new ArrayList<Album>();

	public AlbumView(List<Album> aaData) {
		this.aaData = aaData;
	}

	public List<Album> getAaData() {
		return aaData;
	}

	public void setAaData(List<Album> aaData) {
		this.aaData = aaData;
	}
}
