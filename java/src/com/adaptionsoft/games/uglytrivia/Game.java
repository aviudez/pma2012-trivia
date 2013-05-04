package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
	Players players = null;
    private QuestionsDecks questionsDecks = null;
    private Board board = null;
    private Dado dado = null;
    private boolean gameFinished = false;
 
    int[] highscores= new int[6];

    boolean isGettingOutOfPenaltyBox;
    
    
    public  Game(Dado dado, QuestionsDecks questionsDecks, Board board){
    	this.dado = dado;
    	this.questionsDecks = questionsDecks;
    	this.board = board;
    	this.players = new Players();
    }

	/**
	 * Return true if the game is playable.
	 * 
	 * @return true if the game is playable.
	 */
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
	    players.add(new Player(playerName));
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll() {
		int roll = dado.tirada();
		Player currentPlayer = players.getCurrentPlayer();
		System.out.println(currentPlayer.getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (currentPlayer.isInPenaltyBox()) {
			if (roll % 2 == 0) {
				System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
				
				isGettingOutOfPenaltyBox = false;
				
				return;
			} else {
				isGettingOutOfPenaltyBox = true;
				System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
			}
		}
			
		currentPlayer.setPlace(board.getNewPlace(currentPlayer.getPlace(), roll));
		System.out.println(currentPlayer.getName()
				+ "'s new location is " 
				+ currentPlayer.getPlace());
		System.out.println("The category is " + currentCategory());
		askQuestion();		
}

	private void askQuestion() {
		Question question = questionsDecks.nextQuestion(currentCategory());
		
		System.out.println(question.getText());
	
	}
	
	private Category currentCategory() {
		return board.getPlaceCategory(players.getCurrentPlayer().getPlace());
	}

	public void wasCorrectlyAnswered() {
		Player currentPlayer = players.getCurrentPlayer();
		if (currentPlayer.isInPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer.incrementPurses();
				System.out.println(currentPlayer.getName() 
						+ " now has "
						+ currentPlayer.getPurses()
						+ " Gold Coins.");
					players.nextTurn();
			} else {
				players.nextTurn();
			}
		} else {
			System.out.println("Answer was corrent!!!!");
			currentPlayer.incrementPurses();
			System.out.println(currentPlayer.getName() 
					+ " now has "
					+ currentPlayer.getPurses()
					+ " Gold Coins.");
			players.nextTurn();
		}
		
		gameFinished = (currentPlayer.getPurses() == 6);
		
	}
	
	public boolean isGameFinished() {
		return gameFinished;
	}
	
	public void wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		Player currentPlayer = players.getCurrentPlayer();
		System.out.println(currentPlayer.getName()+ " was sent to the penalty box");
		currentPlayer.setInPenaltyBox(true);

		gameFinished = (currentPlayer.getPurses() == 6);
		
		players.nextTurn();
	}

}
