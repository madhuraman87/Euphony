package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class ItemRecommendationView {
	private List<ItemRecommendation> aaData = new ArrayList<ItemRecommendation>();

	public ItemRecommendationView(List<ItemRecommendation> aaData) {
		this.aaData = aaData;
	}

	public List<ItemRecommendation> getAaData() {
		return aaData;
	}

	public void setAaData(List<ItemRecommendation> aaData) {
		this.aaData = aaData;
	}
}
