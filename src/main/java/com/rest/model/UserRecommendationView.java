package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class UserRecommendationView {
	private List<UserRecommendation> aaData = new ArrayList<UserRecommendation>();

	public UserRecommendationView(List<UserRecommendation> aaData) {
		this.aaData = aaData;
	}

	public List<UserRecommendation> getAaData() {
		return aaData;
	}

	public void setAaData(List<UserRecommendation> aaData) {
		this.aaData = aaData;
	}
}
