package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.tristanles.utils.Matchers.aListWithOneBuyer;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LotteryTest {
	
	private Lottery lottery;
	
	@Before
	public void init() {
		lottery = new Lottery();
	}
	
	@org.junit.Test
	public void iCanBuyATicketWithAName() {
		String buyCommand = "achat";
		String buyerName = "André";
		
		lottery.read(buyCommand + " " + buyerName);
		
		assertThat(lottery.getSubscribers()).is(aListWithOneBuyer(buyerName));	
	}

}
