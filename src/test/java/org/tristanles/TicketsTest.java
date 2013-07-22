package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.tristanles.TestValues.NAME_ANDRE;
import static org.tristanles.TestValues.NAME_DOMINIC;
import static org.tristanles.TestValues.NAME_SYLVIE;
import static org.tristanles.TestValues.NAME_ANNIE;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		
		assertThat(tickets.buyersWithNumbers).hasSize(1);
		assertThat(tickets.buyersWithNumbers.keySet()).containsOnly(NAME_ANDRE);
		assertThat(tickets.buyersWithNumbers.get(NAME_ANDRE)).containsExactly(boughtTicket);
		
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
	public void iWillHaveOneWinnerIfOneBuyer() {
		tickets.buy(NAME_ANDRE);

		Map<String, Integer> winners = tickets.pickWinners(mockCashRegister);

		assertThat(winners).hasSize(1);
		assertThat(winners.keySet()).containsOnly(NAME_ANDRE);
	}

	@Test
	public void iWillHaveTwoWInnersIfTwoBuyers() {
		tickets.buy(NAME_DOMINIC);
		tickets.buy(NAME_ANDRE);

		Map<String, Integer> winners = tickets.pickWinners(mockCashRegister);

		assertThat(winners).hasSize(2);
		assertThat(winners.keySet()).containsOnly(NAME_DOMINIC, NAME_ANDRE);
	}

	@Test
	public void iWillHaveThreeWinnersIfThreeBuyers() {
		tickets.buy(NAME_DOMINIC);
		tickets.buy(NAME_ANDRE);
		tickets.buy(NAME_SYLVIE);

		Map<String, Integer> winners = tickets.pickWinners(mockCashRegister);

		assertThat(winners).hasSize(3);
		assertThat(winners.keySet()).containsOnly(NAME_DOMINIC, NAME_ANDRE,
				NAME_SYLVIE);
	}

	@Test
	public void iWillHaveThreeWinnersIfMoreThanThreeBuyers() {
		tickets.buy(NAME_DOMINIC);
		tickets.buy(NAME_ANDRE);
		tickets.buy(NAME_SYLVIE);
		tickets.buy(NAME_ANNIE);

		Map<String, Integer> winners = tickets.pickWinners(mockCashRegister);

		assertThat(winners).hasSize(3);
	}

}
