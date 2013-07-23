package org.tristanles.actions;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tristanles.Messages;
import org.tristanles.Winner;
import org.tristanles.results.BuyResult;
import org.tristanles.results.LotteryResult;
import org.tristanles.results.WinnersResult;
import org.tristanles.testutils.TestValues;

@RunWith(MockitoJUnitRunner.class)
public class BuyActionTest extends ActionTest {

	private BuyAction buyAction;
	
	@Before
	public void init() {
		buyAction = new BuyAction();
		buyAction.setArg(TestValues.NAME_ANDRE);
	}
	
	@Test
	public void theBuyActionBuysATicketFor10Dollars() {
		buyAction.execute(mockTickets, mockCashRegister);
		
		verify(mockTickets).buy(TestValues.NAME_ANDRE);
		verify(mockCashRegister).add(10);
	}
	
	@Test
	public void theBuyActionReturnsABuyResult() {
		when(mockTickets.buy(anyString())).thenReturn(1);
		LotteryResult result = buyAction.execute(mockTickets, mockCashRegister);
		
		assertThat(result).isInstanceOf(BuyResult.class);
	} 
	
	@Test
	public void theBuyActionFailsIfNoBuyerName() {
		try {
			buyAction.setArg(null);
			buyAction.execute(mockTickets, mockCashRegister);
			fail("Exception expected");
		} catch (Exception e) {
			verifyZeroInteractions(mockTickets, mockCashRegister);
			assertThat(e.getMessage()).isEqualTo(Messages.PAS_DACHETEUR_SPECIFIE);
		}
	}
	
	@Test
	public void theBuyActionFailsIfWinnersPicked() {
		Winner firstWinner = new Winner(TestValues.NAME_ANDRE, 1);
		Winner secondWinner = new Winner(TestValues.NAME_ANDRE, 2);
		Winner thirdWinner = new Winner(TestValues.NAME_ANDRE, 3);
		when(mockTickets.getWinners()).thenReturn(new WinnersResult(firstWinner, secondWinner, thirdWinner));
		
		try {
			buyAction.execute(mockTickets, mockCashRegister);
			fail("Exception expected");
		} catch (Exception e) {
			verify(mockTickets, never()).buy(anyString());
			verifyZeroInteractions(mockCashRegister);
			assertThat(e.getMessage()).isEqualTo(Messages.GAGNANTS_DEJA_TIRES);
		}
	}
	
	@Test
	public void noMoneyIsAddedToTheCashRegisterIfNoTicketIsBought() {
		String message = "Test exception";
		when(mockTickets.buy(anyString())).thenThrow(new RuntimeException(message));
		
		try {
			buyAction.execute(mockTickets, mockCashRegister);
		} catch (Exception e) {
			assertThat(e.getMessage()).isEqualTo(message);
			verifyNoMoreInteractions(mockCashRegister);
		}
	}
}
