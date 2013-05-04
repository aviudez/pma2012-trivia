package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Category> places = null;
	
	public Board() {
		places = new ArrayList<Category>();
	}
	
	public void addPlaceCategory(Category category) {
		places.add(category);
	}
		
	public int getNumPlaces() {
		return places.size();
	}
	
	public int getNewPlace(int actual, int roll) {
		return (actual + roll) % places.size();
	}
	
	public Category getPlaceCategory(int place) {
		if (place >= places.size() || place < 0) {
			throw new IllegalArgumentException("Incorrect place requested, num places: " + places.size() + ", place requested: " + place);
		}
		return places.get(place);
	}

}
