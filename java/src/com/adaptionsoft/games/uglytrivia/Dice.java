package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Dice {
	
	private Random random = null;
	private int caras = 0;
	
	public Dice(Random random, int caras) {
		if (caras <= 1) {
			throw new IllegalArgumentException("The dice must have more than one face, value entered: " + caras);
		}

		this.random = random;
		this.caras = caras;
	}
	
	public int roll() {
		return (random.nextInt(caras) + 1);
	}
	

}
