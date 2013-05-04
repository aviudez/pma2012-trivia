package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class DefaultResponder implements Responder {

	private Random random = null;
	
	public DefaultResponder() {
	}

	public DefaultResponder(Random random) {
		this.random = random;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
	
	public boolean respond(Question question) {
		return (random.nextInt(9) != 7);
		
	}

}
