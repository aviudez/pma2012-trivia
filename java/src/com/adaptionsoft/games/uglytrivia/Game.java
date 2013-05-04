package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
	Players players = null;
    private QuestionsDecks questionsDecks = null;
    private Board board = null;
    private Dado dado = null;
    
 
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
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
				currentPlayer.setPlace(board.getNewPlace(currentPlayer.getPlace(), roll));
				System.out.println(currentPlayer.getName()
						+ "'s new location is " 
						+ currentPlayer.getPlace());
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
			currentPlayer.setPlace(board.getNewPlace(currentPlayer.getPlace(), roll));
			System.out.println(currentPlayer.getName() 
					+ "'s new location is " 
					+ currentPlayer.getPlace());
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
}

	private void askQuestion() {
		Question question = questionsDecks.nextQuestion(currentCategory());
		
		System.out.println(question.getText());
	
	}
	
  public static void main(String[] args) {
    System.out.println("Hello World!"); // Display the string.
  }

	// randomly return a category
	private Category currentCategory() {
		return board.getPlaceCategory(players.getCurrentPlayer().getPlace());
	}

	public boolean wasCorrectlyAnswered() {
		Player currentPlayer = players.getCurrentPlayer();
		if (currentPlayer.isInPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer.incrementPurses();
				System.out.println(currentPlayer.getName() 
						+ " now has "
						+ currentPlayer.getPurses()
						+ " Gold Coins.");
					boolean winner = didPlayerWin();
					players.nextTurn();
					return winner;
			} else {
				players.nextTurn();
				return true;
			}
		} else {
			System.out.println("Answer was corrent!!!!");
			currentPlayer.incrementPurses();
			System.out.println(currentPlayer.getName() 
					+ " now has "
					+ currentPlayer.getPurses()
					+ " Gold Coins.");
			boolean winner = didPlayerWin();
			players.nextTurn();
			return winner;
			
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		Player currentPlayer = players.getCurrentPlayer();
		System.out.println(currentPlayer.getName()+ " was sent to the penalty box");
		currentPlayer.setInPenaltyBox(true);
		
		players.nextTurn();
		return true;
	}

	public static class SimpleSingleton {
    private static SimpleSingleton singleInstance =  new SimpleSingleton();
 
    //Marking default constructor private
    //to avoid direct instantiation.
    private SimpleSingleton() {
    }
 
    //Get instance for class SimpleSingleton
    public static SimpleSingleton getInstance() {
 
        return singleInstance;
  }
}
	/**
	 * Tells if the last player won.
	 */
	private boolean didPlayerWin() {
		return !(players.getCurrentPlayer().getPurses() == 6);
//		return !(purses[currentPlayer] == 6);
	}
}
