package org.tristanles.actions;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.tristanles.results.LotteryResult;
import org.tristanles.results.WinnersResult;

@RunWith(MockitoJUnitRunner.class)
public class WinnersActionTest extends ActionTest {

	private WinnersAction winnersAction;
	
	@Mock
	private WinnersResult mockWinnersResult;
	
	@Before
	public void init() {
		winnersAction = new WinnersAction();
	}
	
	@Test
	public void winnersActionReturnsAWinnersResult() {
		when(mockTickets.getWinners()).thenReturn(mockWinnersResult);
		
		LotteryResult result = winnersAction.execute(mockTickets, mockCashRegister);
		
		assertThat(result).isInstanceOf(WinnersResult.class);
	}
	
	@Test
	public void winnersActionFailsIfNoWinnersHaveBeenPicked() {
		when(mockTickets.getWinners()).thenReturn(null);
		
		try {
			winnersAction.execute(mockTickets, mockCashRegister);
		} catch (Exception e) {
			assertThat(e.getMessage()).isEqualTo("Aucun tirage n'a été fait");
		}
	}
	
	@Test
	public void winnersActionAssignPrizes() {
		when(mockTickets.getWinners()).thenReturn(mockWinnersResult);
		
		winnersAction.execute(mockTickets, mockCashRegister);
		
		verify(mockTickets).getWinners();
		verify(mockCashRegister).assignPrizes(mockWinnersResult);
		verifyNoMoreInteractions(mockWinnersResult, mockCashRegister, mockTickets);
	}
}
