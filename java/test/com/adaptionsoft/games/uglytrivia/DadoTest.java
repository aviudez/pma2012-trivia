package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.*;

import java.util.Random;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DadoTest {

	private Random random = null;
	@Before
	public void setUp() throws Exception {
		random = new Random(0L);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_caras_negativas() {
		Dice dado = new Dice(random, -2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_cero_caras() {
		Dice dado = new Dice(random, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_una_cara() {
		Dice dado = new Dice(random, 1);
	}
	

	@Test
	public void test_dos_caras() {
		Dice dado = new Dice(random, 2);
		Assert.assertEquals(2,dado.roll());
		Assert.assertEquals(2,dado.roll());
		Assert.assertEquals(1,dado.roll());
		Assert.assertEquals(2,dado.roll());
		Assert.assertEquals(2,dado.roll());
		Assert.assertEquals(1,dado.roll());
		Assert.assertEquals(2,dado.roll());

	}
	
	@Test
	public void test_seis_caras() {
		Dice dado = new Dice(random, 6);
		Assert.assertEquals(1,dado.roll());
		Assert.assertEquals(5,dado.roll());
		Assert.assertEquals(2,dado.roll());
		Assert.assertEquals(6,dado.roll());
		Assert.assertEquals(6,dado.roll());
		Assert.assertEquals(6,dado.roll());
		Assert.assertEquals(6,dado.roll());
		Assert.assertEquals(4,dado.roll());
		Assert.assertEquals(4,dado.roll());
		Assert.assertEquals(3,dado.roll());
		Assert.assertEquals(6,dado.roll());
	}

}
