package org.tristanles.actions;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tristanles.CashRegister;
import org.tristanles.results.LotteryResult;
import org.tristanles.tickets.Tickets;

@RunWith(MockitoJUnitRunner.class)
public class DrawActionTest extends ActionTest {

	private DrawAction drawAction;
	
	@Before
	public void init() {
		drawAction = new DrawAction();
		
		mockTickets = mock(Tickets.class);
		mockCashRegister = mock(CashRegister.class);
	}
	
	@Test
	public void drawActionCallsTicketsPickWinners() {
		drawAction.execute(mockTickets, mockCashRegister);
		
		verify(mockTickets).pickWinners();
	}
	
	@Test
	public void drawActionReturnsADrawResult() {
		LotteryResult result = drawAction.execute(mockTickets, mockCashRegister);
		
		assertThat(result).isInstanceOf(LotteryResult.class);
	}
	
}
