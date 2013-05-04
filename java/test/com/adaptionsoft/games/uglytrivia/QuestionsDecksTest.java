package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuestionsDecksTest {

	private QuestionsDecks decks = null;
	
	@Before
	public void setUp() throws Exception {
		decks = new QuestionsDecks();
		
		populateQuestions(decks, Category.POP, 5);
		populateQuestions(decks, Category.ROCK, 1);
	}
	
	private void populateQuestions(QuestionsDecks questions, Category category, int number) {
		for (int i = 0; i< number; i++) {
			questions.addQuestion(new Question(category,getQuestionText(category,i+1)));
		}
	}
	
	private String getQuestionText(Category category, int i) {
		return (category.toString() + " " + (i));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_empty_category_questions() {
		Assert.assertNull(decks.nextQuestion(Category.SCIENCE));
	}
	
	@Test
	public void test_one_category_questions() {
		decks.nextQuestion(Category.ROCK);
		Assert.assertNull(decks.nextQuestion(Category.ROCK));
	}
	
	@Test
	public void test_order_questions() {
		Assert.assertEquals(getQuestionText(Category.POP,1), decks.nextQuestion(Category.POP).getText());
		Assert.assertEquals(getQuestionText(Category.POP,2), decks.nextQuestion(Category.POP).getText());
		Assert.assertEquals(getQuestionText(Category.POP,3), decks.nextQuestion(Category.POP).getText());
		Assert.assertEquals(getQuestionText(Category.POP,4), decks.nextQuestion(Category.POP).getText());
		Assert.assertEquals(getQuestionText(Category.POP,5), decks.nextQuestion(Category.POP).getText());
	}

}
