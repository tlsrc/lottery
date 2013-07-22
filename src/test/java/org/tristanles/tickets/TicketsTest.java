package org.tristanles.tickets;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.tristanles.TestValues.NAME_ANDRE;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.tristanles.money.CashRegister;
import org.tristanles.winners.Winners;

@RunWith(JUnit4.class)
public class TicketsTest {

	private Tickets tickets;
	private CashRegister mockCashRegister;

	@Before
	public void init() {
		tickets = new Tickets();
		mockCashRegister = mock(CashRegister.class);
	}
	
	@Test
	public void iCanBuyATicket() {
		int boughtTicket = tickets.buy(NAME_ANDRE);
		
		assertThat(tickets.numbersWithBuyer.get(boughtTicket)).isEqualTo(NAME_ANDRE);
	}

	@Test
	public void iCanBuyMultipleTicketsWithTheSameName() {
		int firstTicket = tickets.buy(NAME_ANDRE);
		int secondTicket = tickets.buy(NAME_ANDRE);

		assertThat(firstTicket).isNotEqualTo(secondTicket);
	}

	@Test(expected = IllegalStateException.class)
	public void iCantBuyMoreThan50Tickets() {
		buyNTickets(51, NAME_ANDRE);
	}

	private void buyNTickets(int numberToBuy, String buyerName) {
		for (int i = 0; i < numberToBuy; i++) {
			tickets.buy(buyerName);
		}
	}
	
	@Test
	public void pickWinnersReturnThreeDifferentTickets() {
		Winners winners = tickets.pickWinners(mockCashRegister);
		int firstTicket = winners.getFirst().getTicketNumber();
		int secondTicket = winners.getSecond().getTicketNumber();
		int thirdTicket = winners.getThird().getTicketNumber();
		
		assertThat(firstTicket).isNotEqualTo(secondTicket).isNotEqualTo(thirdTicket);
		assertThat(secondTicket).isNotEqualTo(thirdTicket).isNotEqualTo(firstTicket);
		assertThat(thirdTicket).isNotEqualTo(firstTicket).isNotEqualTo(secondTicket);
		
	}
	
}
