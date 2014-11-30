package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class PersonalizeRecommendationView {
	private List<PersonalizeRecommendation> aaData = new ArrayList<PersonalizeRecommendation>();

	public PersonalizeRecommendationView(List<PersonalizeRecommendation> aaData) {
		this.aaData = aaData;
	}

	public List<PersonalizeRecommendation> getAaData() {
		return aaData;
	}

	public void setAaData(List<PersonalizeRecommendation> aaData) {
		this.aaData = aaData;
	}
}
