package com.adaptionsoft.games.uglytrivia;

public class Game {
	Players players = null;
    private QuestionsDecks questionsDecks = null;
    private Board board = null;
    private Dice dice = null;
    private boolean gameFinished = false;
 
    public  Game(Dice dado, QuestionsDecks questionsDecks, Board board){
    	this.dice = dado;
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
		return (players.size()>1);
	}

	public boolean add(Player player) {
	    players.add(player);
	    
	    System.out.println(player.getName() + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}

	public void playTurn() {
		int roll = dice.roll();
		Player currentPlayer = players.getCurrentPlayer();
		System.out.println(currentPlayer.getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (currentPlayer.isInPenaltyBox()) {
			if (roll % 2 == 0) {
				System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
				dice.roll();
			} else {
				System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
				currentPlayer.setInPenaltyBox(false);
			}
		}
		
		if (currentPlayer.isInPenaltyBox()) {
			players.nextTurn();
			return;
		}
		
		currentPlayer.setPlace(board.getNewPlace(currentPlayer.getPlace(), roll));
		System.out.println(currentPlayer.getName()
				+ "'s new location is " 
				+ currentPlayer.getPlace());
		System.out.println("The category is " + currentCategory());
		Question question = askQuestion();
		boolean correct = answerQuestion(question);
		currentPlayer.setInPenaltyBox(!correct);
		gameFinished = (currentPlayer.countScores() == Category.values().length);
		if (gameFinished) {
			System.out.println(currentPlayer.getName() + " wins!!!");
		}
		players.nextTurn();		
	}
	
	private boolean answerQuestion(Question question) {
		Player currentPlayer = players.getCurrentPlayer();
		
		if (currentPlayer.respond(question)) {
			System.out.println("Answer was correct!!!!");
			currentPlayer.incrementPurses();
			if(currentPlayer.scoreCategory(question.getCategory())) {
				System.out.println(currentPlayer.getName() + " scores new category: " + question.getCategory() + ",  and now have " + currentPlayer.countScores() + " already scored");
			}
			return true;
		} else {
			System.out.println("Question was incorrectly answered");
			System.out.println(currentPlayer.getName()+ " was sent to the penalty box");
			return false;
		}
	}

	private Question askQuestion() {
		Question question = questionsDecks.nextQuestion(currentCategory());
		if (question == null) {
			System.out.println("There are no more questions of category " + currentCategory());
		} else {
			System.out.println(question.getText());
		}
		
		return question;
	
	}
	
	private Category currentCategory() {
		return board.getPlaceCategory(players.getCurrentPlayer().getPlace());
	}
	
	public boolean isGameFinished() {
		return gameFinished;
	}
}
