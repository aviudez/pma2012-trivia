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
		Dado dado = new Dado(random, -2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_cero_caras() {
		Dado dado = new Dado(random, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_una_cara() {
		Dado dado = new Dado(random, 1);
	}
	

	@Test
	public void test_dos_caras() {
		Dado dado = new Dado(random, 2);
		Assert.assertEquals(2,dado.tirada());
		Assert.assertEquals(2,dado.tirada());
		Assert.assertEquals(1,dado.tirada());
		Assert.assertEquals(2,dado.tirada());
		Assert.assertEquals(2,dado.tirada());
		Assert.assertEquals(1,dado.tirada());
		Assert.assertEquals(2,dado.tirada());

	}
	
	@Test
	public void test_seis_caras() {
		Dado dado = new Dado(random, 6);
		Assert.assertEquals(1,dado.tirada());
		Assert.assertEquals(5,dado.tirada());
		Assert.assertEquals(2,dado.tirada());
		Assert.assertEquals(6,dado.tirada());
		Assert.assertEquals(6,dado.tirada());
		Assert.assertEquals(6,dado.tirada());
		Assert.assertEquals(6,dado.tirada());
		Assert.assertEquals(4,dado.tirada());
		Assert.assertEquals(4,dado.tirada());
		Assert.assertEquals(3,dado.tirada());
		Assert.assertEquals(6,dado.tirada());
	}

}
