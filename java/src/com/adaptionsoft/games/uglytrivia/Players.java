package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
	
	private List<Player> playerList = null;
	private int currentPlayer = 0;
	
	public Players() {
		this.playerList = new ArrayList<Player>();
	}

	public void add(Player player) {
		playerList.add(player);
	}
	
	public int size() {
		return playerList.size();
	}
	
	public Player getCurrentPlayer() {
		if (playerList.size() == 0) {
			throw new IllegalStateException("Trying to retrieve a player, but no player was added");
		}
		return playerList.get(currentPlayer);
	}
	
	public void nextTurn() {
		if (playerList.size() == 0) {
			throw new IllegalStateException("Trying to change the current player, but no player was added");
		}
		currentPlayer = (currentPlayer+1)%playerList.size();
	}
	
	public Player getPlayer(int index) {
		return playerList.get(index);
	}

}
