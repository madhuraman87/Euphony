package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartView {
	private List<ShoppingCart> aaData = new ArrayList<ShoppingCart>();

	public ShoppingCartView(List<ShoppingCart> aaData) {
		this.aaData = aaData;
	}

	public List<ShoppingCart> getAaData() {
		return aaData;
	}

	public void setAaData(List<ShoppingCart> aaData) {
		this.aaData = aaData;
	}
}
