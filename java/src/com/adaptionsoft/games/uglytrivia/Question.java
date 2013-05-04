package com.adaptionsoft.games.uglytrivia;

public class Question {
	
	private Category category = null;
	private String text = null;
	
	public Question(Category category, String questionText) {
		this.category = category;
		this.text = questionText;
	}
	
	public String getText() {
		return text;
	}
	
	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "[Category:" + category.toString() + ", Text:" + text + "]";
	}
	
	
	
}
