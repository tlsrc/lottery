package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.tristanles.testutils.TestValues.NAME_ANDRE;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.tristanles.results.WinnersResult;

@RunWith(JUnit4.class)
public class TicketsTest {

	private Tickets tickets;

	@Before
	public void init() {
		tickets = new Tickets();
	}
	
	@Test
	public void iCanBuyATicket() {
		int boughtTicket = tickets.buy(NAME_ANDRE);
		
//		assertThat(tickets.ticketsBuyers.get(boughtTicket)).isEqualTo(NAME_ANDRE);
	}

	@Test
	public void iCanBuyMultipleTicketsWithTheSameName() {
		int firstTicket = tickets.buy(NAME_ANDRE);
		int secondTicket = tickets.buy(NAME_ANDRE);

		assertThat(firstTicket).isNotEqualTo(secondTicket);
	}

	@Test
	public void iCantBuyMoreThan50Tickets() {
		try {
			buyNTickets(51, NAME_ANDRE);
			fail("Exception expected");
		} catch(Exception e) {
			assertThat(e.getMessage()).isEqualTo("Tous les tickets sont achetés");
		}
	}

	private void buyNTickets(int numberToBuy, String buyerName) {
		for (int i = 0; i < numberToBuy; i++) {
			tickets.buy(buyerName);
		}
	}
	
	@Test
	public void pickWinnersUpdatesTheWinnersWithTicketNumber() {
		
	}
	
}
