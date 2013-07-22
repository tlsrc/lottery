package org.tristanles.results;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BuyResultTest extends StreamRedirectTest {

	private final int ticketNumber = 1;
	private BuyResult buyResult;
	
	
	@Before
	public void init() {	
		buyResult = new BuyResult(ticketNumber);
	}
	
	@Test
	public void buyResultDisplaysTheTicketNumber() {
		buyResult.display();
		
		assertThat(testOut.toString()).isEqualTo(ticketNumber + System.lineSeparator());
	}
}
