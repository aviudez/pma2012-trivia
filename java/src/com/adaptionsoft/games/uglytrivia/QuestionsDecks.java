package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

public class QuestionsDecks {
	
	private Map<Category, Queue<Question>> categoryDecks = null;
	
	public QuestionsDecks() {
		categoryDecks = new HashMap<Category, Queue<Question>>();
	}
	
	public void addQuestion(Question question) {
		Queue<Question> deck = categoryDecks.get(question.getCategory());
		if (deck == null) {
			deck = new LinkedList<Question>();
			categoryDecks.put(question.getCategory(), deck);
		}
		deck.add(question);
	}

	public Question nextQuestion(Category category) {
		Queue<Question> deck = categoryDecks.get(category);
		if (deck == null ) {
			return null;
		} else {
			return deck.poll();
		}
	}

}
