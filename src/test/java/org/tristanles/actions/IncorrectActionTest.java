package org.tristanles.actions;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tristanles.results.IncorrectResult;
import org.tristanles.results.LotteryResult;

@RunWith(MockitoJUnitRunner.class)
public class IncorrectActionTest extends ActionTest {

	private IncorrectAction incorrectAction;
	
	@Before
	public void init() {
		incorrectAction = new IncorrectAction();
	}
	
	@Test
	public void incorrectActionReturnsAnIncorrectResult() {
		LotteryResult result = incorrectAction.execute(mockTickets, mockCashRegister);
		
		assertThat(result).isInstanceOf(IncorrectResult.class);
	}
	
	@Test
	public void incorrectActionsDoesNothing() {
		incorrectAction.execute(mockTickets, mockCashRegister);
		
		verifyZeroInteractions(mockTickets, mockCashRegister);
	}
}
