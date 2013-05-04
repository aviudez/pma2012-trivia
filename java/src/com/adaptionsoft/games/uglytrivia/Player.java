package com.adaptionsoft.games.uglytrivia;

public class Player {
	
	private String name = null;
	private int place = 0;
	private int purses = 0;
	private boolean isInPenaltyBox = false;
	
	public Player(String name) {
		this.name = name;
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
	
}
