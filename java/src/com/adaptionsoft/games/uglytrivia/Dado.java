package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Dado {
	
	private Random random = null;
	private int caras = 0;
	
	public Dado(Random random, int caras) {
		if (caras <= 1) {
			throw new IllegalArgumentException("El dado debe tener más de una cara, valor introducido: " + caras);
		}

		this.random = random;
		this.caras = caras;
	}
	
	public int tirada() {
		return (random.nextInt(caras-1) + 1);
	}
	

}
