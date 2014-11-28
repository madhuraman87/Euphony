package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class SearchView {
	private List<Search> aaData = new ArrayList<Search>();

	public SearchView(List<Search> aaData) {
		this.aaData = aaData;
	}

	public List<Search> getAaData() {
		return aaData;
	}

	public void setAaData(List<Search> aaData) {
		this.aaData = aaData;
	}
}
