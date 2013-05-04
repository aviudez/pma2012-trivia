package com.adaptionsoft.games.uglytrivia;

import java.util.HashSet;

public class Player {
	
	private String name = null;
	private int place = 0;
	private int purses = 0;
	private boolean isInPenaltyBox = false;
	private Responder responder = null;;
	private HashSet<Category> categoryScores = null;
	
	public Player(String name, Responder responder) {
		this.name = name;
		this.responder = responder;
		this.categoryScores = new HashSet<Category>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void incrementPurses() {
		this.purses++;
	}
	
	public int getPurses() {
		return this.purses;
	}
	
	public int getPlace() {
		return this.place;
	}
	
	public void setPlace(int newPlace) {
		this.place = newPlace;
	}
	
	public void setInPenaltyBox(boolean isInPenaltyBox) {
		this.isInPenaltyBox = isInPenaltyBox;
	}
	
	public boolean isInPenaltyBox() {
		return isInPenaltyBox;
	}
	
	public boolean respond(Question question) {
		return responder.respond(question);
	}
	
	public boolean scoreCategory(Category category) {
		boolean exists = categoryScores.contains(category);
		categoryScores.add(category);
		return !exists;
	}
	
	public int countScores() {
		return categoryScores.size();
	}

}
