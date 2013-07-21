package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.tristanles.utils.Matchers.aListWithOneBuyer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LotteryTest {
	
	private Lottery lottery;
	private final String buyCommand = "achat";
	private final String andréName = "André";
	private final String sylvieName = "Sylvie";
	private final String dominicName = "Dominic";
	
	@Before
	public void init() {
		lottery = new Lottery();
	}
	
	@Test
	public void iCanBuyATicketWithAName() {
		lottery.read(buyCommand + " " + andréName);
		
		assertThat(lottery.getSubscribers()).is(aListWithOneBuyer(andréName));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void iCantBuyATicketWithoutAName() {		
		lottery.read(buyCommand);
	}
	
	@Test
	public void iCanBuyMultipleTicketsWithTheSameName() {
		lottery.read(buyCommand + " " + andréName);
		lottery.read(buyCommand + " " + andréName);
		
		assertThat(lottery.getSubscribers()).hasSize(2);
		assertThat(lottery.getSubscribers().get(0).getName()).isEqualTo(andréName);
		assertThat(lottery.getSubscribers().get(1).getName()).isEqualTo(andréName);
	}
	
	public void iCanBuyMultipleTicketsWithDifferentNams() {
		lottery.read(buyCommand + " " + andréName);
		lottery.read(buyCommand + " " + sylvieName);
		lottery.read(buyCommand + " " + dominicName);
		
		assertThat(lottery.getSubscribers()).hasSize(3);
		assertThat(lottery.getSubscribers().get(0).getName()).isEqualTo(andréName);
		assertThat(lottery.getSubscribers().get(1).getName()).isEqualTo(sylvieName);
		assertThat(lottery.getSubscribers().get(2).getName()).isEqualTo(dominicName);
	}

}
