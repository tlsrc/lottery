package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.tristanles.TestValues.BUY_COMMAND;
import static org.tristanles.TestValues.NAME_ANDRE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LotteryTest {
	
	private Lottery lottery;
	private Tickets mockTickets;
	private CashRegister mockCashRegister;
	private PrintStream stdout;
	
	
	@Before
	public void init() {
		lottery = new Lottery();
		mockTickets = mock(Tickets.class);
		mockCashRegister = mock(CashRegister.class);
		
		lottery.setTickets(mockTickets);
		lottery.setCashRegister(mockCashRegister);
		stdout = System.out;
	}
	
	@After
	public void tearDown() {
		System.setOut(stdout);
	}
	
	@Test
	public void theCashRegisterStartsAt200() {
		lottery = new Lottery();
		
		assertThat(lottery.getCashRegister()).isNotNull();
		assertThat(lottery.getCashRegister().getTotal()).isEqualTo(200);
	}
	
	@Test
	public void theBuyCommandCallsTickets() {
		when(mockTickets.buy(anyInt(), anyString())).thenReturn(1);
		
		lottery.read(BUY_COMMAND + " " + NAME_ANDRE);
		
		verify(mockTickets).buy(anyInt(), eq(NAME_ANDRE));
	}
	
	@Test
	public void theBuyCommandAdds10InTheCashRegister() {
		when(mockTickets.buy(anyInt(), anyString())).thenReturn(1);
		
		lottery.read(BUY_COMMAND + " " + NAME_ANDRE);
		
		verify(mockCashRegister).add(10);
	}
	
	@Test
	public void theNumberOfTheBoughtTicketIsDisplayed() {
		ByteArrayOutputStream temporaryOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(temporaryOut));
		
		int ticketBought = 1;
		when(mockTickets.buy(anyInt(), anyString())).thenReturn(ticketBought);
		
		lottery.read(BUY_COMMAND + " " + NAME_ANDRE);
		
		assertThat(temporaryOut.toString()).isEqualTo(ticketBought + System.lineSeparator());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void iCantBuyATicketWithoutAName() {		
		lottery.read(BUY_COMMAND);
	}

}
