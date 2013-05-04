package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player aPlayer = null;
	@Before
	public void setUp() throws Exception {
		aPlayer = new Player("A Player", new DefaultResponder());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_one_category_score() {
		Assert.assertTrue(aPlayer.scoreCategory(Category.POP));
		Assert.assertEquals(1, aPlayer.countScores());
		Assert.assertFalse(aPlayer.scoreCategory(Category.POP));
		Assert.assertEquals(1, aPlayer.countScores());
	}
	
	
	@Test
	public void test_four_category_score() {
		Assert.assertTrue(aPlayer.scoreCategory(Category.POP));
		Assert.assertTrue(aPlayer.scoreCategory(Category.ROCK));
		Assert.assertTrue(aPlayer.scoreCategory(Category.SCIENCE));
		Assert.assertTrue(aPlayer.scoreCategory(Category.SPORTS));
		Assert.assertEquals(4, aPlayer.countScores());
	}
	
	@Test
	public void test_cero() {
		Assert.assertEquals(0, aPlayer.countScores());
	}
	
}
