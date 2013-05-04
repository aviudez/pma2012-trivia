package com.adaptionsoft.games.uglytrivia;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayersTest {
	
	private Players players = null;
	private Players emptyPlayers = null;
	private static Responder DEFAULT_RESPONDER = new DefaultResponder();
	
	@Before
	public void setUp() throws Exception {
		players = new Players();
		players.add(new Player("Player 1", DEFAULT_RESPONDER));
		players.add(new Player("Player 2", DEFAULT_RESPONDER ));
		players.add(new Player("Player 3", DEFAULT_RESPONDER ));
		
		emptyPlayers = new Players();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=IllegalStateException.class)
	public void test_current_player_from_empty() {
		emptyPlayers.getCurrentPlayer();
	}
	
	@Test(expected=IllegalStateException.class)
	public void test_next_player_from_empty() {
		emptyPlayers.nextTurn();
		emptyPlayers.getCurrentPlayer();
		
	}
	
	
	
	@Test
	public void test_player_order() {
		Assert.assertEquals("Player 1", players.getCurrentPlayer().getName());
		players.nextTurn();
		Assert.assertEquals("Player 2", players.getCurrentPlayer().getName());
		players.nextTurn();
		Assert.assertEquals("Player 3", players.getCurrentPlayer().getName());
	}
	
	@Test
	public void test_roll_entire_list() {
		Assert.assertEquals("Player 1", players.getCurrentPlayer().getName());
		players.nextTurn();
		players.nextTurn();
		players.nextTurn();
		Assert.assertEquals("Player 1", players.getCurrentPlayer().getName());

	}
	

}
