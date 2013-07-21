package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.tristanles.TestValues.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TicketsTest {

	private Tickets tickets;
	
	@Before
	public void init() {
		tickets = new Tickets();
	}
	
	@Test
	public void thereAre50Tickets() {
		assertThat(tickets.getSize()).isEqualTo(50);
	}
	
	@Test
	public void buyingATicketReturnsTheTicketNumber() {
		int ticketToBuy = 1;
		int ticketBought = tickets.buy(ticketToBuy, NAME_ANDRE);
		assertThat(ticketBought).isEqualTo(ticketToBuy);
	}
	
	@Test
	public void buyingATicketAlreadyBoughtIsImpossible() {
		int ticketToBuy = 1;
		
		int ticketBoughtFirst = tickets.buy(ticketToBuy, NAME_ANDRE);
		int ticketBoughtSecond = tickets.buy(ticketToBuy, NAME_DOMINIC);
		
		assertThat(ticketBoughtFirst).isEqualTo(ticketToBuy);
		assertThat(ticketBoughtSecond).isEqualTo(0);
		assertThat(tickets.get(ticketToBuy)).isEqualTo(NAME_ANDRE);
	}
	
	@Test
	public void iCanBuyMultipleTicketsWithTheSameName() {
		tickets.buy(1, NAME_ANDRE);
		tickets.buy(2, NAME_ANDRE);
		
		assertThat(tickets.get(1)).isEqualTo(NAME_ANDRE);
		assertThat(tickets.get(2)).isEqualTo(NAME_ANDRE);
	}
	
	
	@Test
	public void iCanBuyMultipleTicketsWithDifferentNames() {
		tickets.buy(1, NAME_ANDRE);
		tickets.buy(2, NAME_DOMINIC);
		tickets.buy(3, NAME_SYLVIE);
		
		assertThat(tickets.get(1)).isEqualTo(NAME_ANDRE);
		assertThat(tickets.get(2)).isEqualTo(NAME_DOMINIC);
		assertThat(tickets.get(3)).isEqualTo(NAME_SYLVIE);
	}
	
	@Test
	public void iCantBuyMoreThan50Tickets() {
		int ticketBought = tickets.buy(51, NAME_ANDRE);
		assertThat(ticketBought).isEqualTo(0);
		assertThat(tickets.get(51)).isNull();
	}
	
	
}
