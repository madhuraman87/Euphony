package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class FeedbackView {
	private List<Feedback> aaData = new ArrayList<Feedback>();

	public FeedbackView(List<Feedback> aaData) {
		this.aaData = aaData;
	}

	public List<Feedback> getAaData() {
		return aaData;
	}

	public void setAaData(List<Feedback> aaData) {
		this.aaData = aaData;
	}
}
