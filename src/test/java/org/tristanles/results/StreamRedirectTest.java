package org.tristanles.results;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

public class StreamRedirectTest {

	protected PrintStream stdOut;
	protected ByteArrayOutputStream testOut;
	
	@Before
	public void init() {	
		stdOut = System.out;
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}
	
	@After
	public void resetOutputStream() {
		System.setOut(stdOut);
	}
}
