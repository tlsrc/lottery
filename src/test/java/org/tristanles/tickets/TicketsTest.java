package org.tristanles.tickets;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.tristanles.testutils.TestValues.NAME_ANDRE;

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

		assertThat(boughtTicket).isNotNull();
	}

	@Test
	public void iCanBuyMultipleTicketsWithTheSameName() {
		int firstTicket = tickets.buy(NAME_ANDRE);
		int secondTicket = tickets.buy(NAME_ANDRE);

		assertThat(firstTicket).isNotNull();
		assertThat(secondTicket).isNotNull();
		assertThat(firstTicket).isNotEqualTo(secondTicket);
	}

	@Test
	public void iCantBuyMoreThan50Tickets() {
		try {
			buyNTickets(51, NAME_ANDRE);
			fail("Exception expected");
		} catch (Exception e) {
			assertThat(e.getMessage()).isEqualTo(
					"Tous les tickets sont achetés");
		}
	}

	private void buyNTickets(int numberToBuy, String buyerName) {
		for (int i = 0; i < numberToBuy; i++) {
			tickets.buy(buyerName);
		}
	}

	@Test
	public void iCanPickEmptyWinnersIfThereAreNoBuyers() {

		tickets.pickWinners();
		WinnersResult winners = tickets.getWinners();
		
		assertThat(winners.getFirst().getName()).isEmpty();
		assertThat(winners.getSecond().getName()).isEmpty();
		assertThat(winners.getThird().getName()).isEmpty();
		assertThreeDifferentTicketNumbers(winners);
	}
	
	@Test
	public void iCanPickWinnersIfThereAreBuyers() {
		buyNTickets(50, NAME_ANDRE);
		
		tickets.pickWinners();
		WinnersResult winners = tickets.getWinners();
		
		assertThat(winners.getFirst().getName()).isEqualTo(NAME_ANDRE);
		assertThat(winners.getSecond().getName()).isEqualTo(NAME_ANDRE);
		assertThat(winners.getThird().getName()).isEqualTo(NAME_ANDRE);
		assertThreeDifferentTicketNumbers(winners);
	}

	private void assertThreeDifferentTicketNumbers(WinnersResult winners) {
		assertThat(winners.getFirst().getTicketNumber()).isNotEqualTo(winners.getSecond().getTicketNumber());
		assertThat(winners.getFirst().getTicketNumber()).isNotEqualTo(winners.getThird().getTicketNumber());
		assertThat(winners.getSecond().getTicketNumber()).isNotEqualTo(winners.getThird().getTicketNumber());
	}

}
