package org.tristanles;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InOrder;
import org.tristanles.actions.LotteryAction;
import org.tristanles.command.CommandParser;
import org.tristanles.results.LotteryResult;

@RunWith(JUnit4.class)
public class LotteryTest {
	
	private Lottery lottery;
	private Tickets mockTickets;
	private CashRegister mockCashRegister;
	private CommandParser mockCommandParser;
	private LotteryAction mockLotteryAction;
	private LotteryResult mockLotteryResult;
	
	@Before
	public void init() {
		initObjects();
	}
	
	private void initObjects() {
		lottery = new Lottery();
		mockTickets = mock(Tickets.class);
		mockCashRegister = mock(CashRegister.class);
		mockCommandParser = mock(CommandParser.class);
		mockLotteryAction = mock(LotteryAction.class);
		mockLotteryResult = mock(LotteryResult.class);
		
		lottery.setTickets(mockTickets);
		lottery.setCashRegister(mockCashRegister);
		lottery.setCommandParser(mockCommandParser);
	}
	
	@Test
	public void objectCollaborationsTest() {
		String someInput = "some input 123";
		when(mockCommandParser.parse(anyString())).thenReturn(mockLotteryAction);
		when(mockLotteryAction.execute(mockTickets, mockCashRegister)).thenReturn(mockLotteryResult);
		
		lottery.read(someInput);
		
		InOrder inOrder = inOrder(mockCommandParser, mockLotteryAction, mockLotteryResult);
		inOrder.verify(mockCommandParser).parse(someInput);
		inOrder.verify(mockLotteryAction).execute(mockTickets, mockCashRegister);
		inOrder.verify(mockLotteryResult).display();
	}
	
}
