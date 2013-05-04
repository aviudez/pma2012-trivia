package com.adaptionsoft.games.uglytrivia;

public enum Category {
	POP("Pop"), SCIENCE("Science"), SPORTS("Sports"), ROCK("Rock");
	
	private String printName = null;
	
	private Category(String printName) {
		this.printName = printName;
	}
	
	@Override
	public String toString() {
		return printName;
	}
	
}
