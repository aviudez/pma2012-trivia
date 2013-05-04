package com.adaptionsoft.games.uglytrivia;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board = null;
	private Board emptyBoard = null;
	
	@Before
	public void setUp() throws Exception {
		this.emptyBoard = new Board();
		
		this.board = new Board();
		board.addPlaceCategory(Category.POP);
		board.addPlaceCategory(Category.ROCK);
		board.addPlaceCategory(Category.SCIENCE);
		board.addPlaceCategory(Category.SPORTS);
		board.addPlaceCategory(Category.POP);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_fuera_de_rango() {
		board.getPlaceCategory(7);
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_negativo() {
		board.getPlaceCategory(-1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_vacio() {
		emptyBoard.getPlaceCategory(0);
	}
	
	@Test
	public void test_orden() {
		Assert.assertEquals(Category.POP, board.getPlaceCategory(0));
		Assert.assertEquals(Category.ROCK, board.getPlaceCategory(1));
		Assert.assertEquals(Category.SCIENCE, board.getPlaceCategory(2));
		Assert.assertEquals(Category.SPORTS, board.getPlaceCategory(3));
		Assert.assertEquals(Category.POP, board.getPlaceCategory(4));

	}

}
