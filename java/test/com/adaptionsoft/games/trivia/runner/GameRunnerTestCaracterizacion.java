package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sun.misc.IOUtils;

import com.adaptionsoft.games.uglytrivia.Dado;
import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunnerTestCaracterizacion extends GameRunner {
	
	private ByteArrayOutputStream baos = null;
	private PrintStream originalPrintstream = null;

	@Before
	public void setUp() throws Exception {
		originalPrintstream = System.out;
		baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalPrintstream);
	}

	@Test
	public void test() throws IOException {

		Random rand = new Random(0L);
		Game aGame = new Game(new Dado(rand,6));
		aGame.add("Ángel");
		aGame.add("Rubén");
		aGame.add("Sandra");
		
		
		GameRunner.run(aGame, rand);
		String content = baos.toString();
		//originalPrintstream.print(content);		
		Assert.assertEquals(loadResourceContents("TestCaracterizacion_3jugadores.txt"),content);
	}
	
	private static String loadResourceContents(String resourcePath) throws IOException {
		InputStream input = null;
		try {
			input = GameRunnerTestCaracterizacion.class.getResourceAsStream(resourcePath);
			StringWriter stringWriter = new StringWriter();
			PrintWriter writer = new PrintWriter(stringWriter);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
			String line = bufferedReader.readLine();
			while(line != null){
				writer.println(line);
				line = bufferedReader.readLine();
			}
			return stringWriter.toString();
		} finally {
			input.close();
			
		}

		
	}
	
	

}
