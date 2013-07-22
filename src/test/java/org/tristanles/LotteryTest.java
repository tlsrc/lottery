package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.tristanles.TestValues.BUY_COMMAND;
import static org.tristanles.TestValues.DRAW_COMMAND;
import static org.tristanles.TestValues.NAME_ANDRE;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.tristanles.command.CommandParser;
import org.tristanles.money.CashRegister;
import org.tristanles.tickets.Tickets;

@RunWith(JUnit4.class)
public class LotteryTest {
	
	private Lottery lottery;
	private Tickets mockTickets;
	private CashRegister mockCashRegister;
	private CommandParser mockCommandParser;
	
	private PrintStream stdOut;
	private ByteArrayOutputStream testOut;
	
	@Before
	public void init() {
		initObjects();
		redirectStdout();
	}
	
	private void initObjects() {
		lottery = new Lottery();
		mockTickets = mock(Tickets.class);
		mockCashRegister = mock(CashRegister.class);
		mockCommandParser = mock(CommandParser.class);
		
		lottery.setTickets(mockTickets);
		lottery.setCashRegister(mockCashRegister);
		lottery.setCommandParser(mockCommandParser);
	}

	private void redirectStdout() {
		stdOut = System.out;
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}
	
	@After
	public void tearDown() {
		System.setOut(stdOut);
	}
	
	@Test
	public void theBuyCommandCallsTickets() throws IOException {
		when(mockTickets.buy(anyString())).thenReturn(1);
		
		lottery.parse(BUY_COMMAND + " " + NAME_ANDRE);
		
		verify(mockTickets).buy(eq(NAME_ANDRE));
	}
	
	@Test
	public void theBuyCommandAdds10InTheCashRegister() throws IOException {
		when(mockTickets.buy(anyString())).thenReturn(1);
		
		lottery.parse(BUY_COMMAND + " " + NAME_ANDRE);
		
		verify(mockCashRegister).add(10);
	}
	
	@Test
	public void theNumberOfTheBoughtTicketIsDisplayed() throws IOException {
		int ticketBought = 1;
		when(mockTickets.buy(anyString())).thenReturn(ticketBought);
		
		lottery.parse(BUY_COMMAND + " " + NAME_ANDRE);
		
		assertThat(testOut.toString()).isEqualTo(ticketBought + System.lineSeparator());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void iCantBuyATicketWithoutAName() throws IOException {		
		lottery.parse(BUY_COMMAND);
	}
	
	@Test
	public void iCanStartADraw() throws IOException {
		lottery.parse(DRAW_COMMAND);
		
		verify(mockTickets).pickWinners(mockCashRegister);
	}

}
