package org.tristanles.actions;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tristanles.results.LotteryResult;
import org.tristanles.results.NoResult;

@RunWith(MockitoJUnitRunner.class)
public class NoActionTest extends ActionTest {

	private NoAction noAction;
	
	@Before
	public void init() {
		noAction = new NoAction();
	}
	
	@Test
	public void noActionReturnsANoResult() {
		LotteryResult result = noAction.execute(mockTickets, mockCashRegister);
		
		assertThat(result).isInstanceOf(NoResult.class);
	}
	
	@Test
	public void noActionDoesNothing() {
		noAction.execute(mockTickets, mockCashRegister);
		
		verifyZeroInteractions(mockTickets, mockCashRegister);
	}
}
