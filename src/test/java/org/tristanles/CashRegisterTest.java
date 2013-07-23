package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.tristanles.CashRegister;
import org.tristanles.results.WinnersResult;
import org.tristanles.testutils.TestValues;
import org.tristanles.tickets.Tickets;

@RunWith(JUnit4.class)
public class CashRegisterTest {

	private CashRegister cashRegister;
	private int startingMoney;
	private int totalPrize;
	int firstPrize;
	int secondPrize;
	int thirdPrize;
	
	private WinnersResult winners;
	private Winner firstWinner;
	private Winner secondWinner;
	private Winner thirdWinner;
	
	@Before
	public void init() {
		cashRegister = new CashRegister();
		startingMoney = cashRegister.getTotal();
		totalPrize = startingMoney / 2;
		firstPrize = Math.round(0.75f * totalPrize);
		secondPrize = Math.round(0.15f * totalPrize);
		thirdPrize = Math.round(0.10f * totalPrize);
		
		firstWinner = new Winner(TestValues.NAME_ANDRE, 1);
		secondWinner = new Winner(TestValues.NAME_DOMINIC, 2);
		thirdWinner = new Winner(TestValues.NAME_SYLVIE, 3);
		winners = new WinnersResult(firstWinner, secondWinner, thirdWinner);
	}
	
	@Test
	public void theCashRegisterStartsAt200() {
		assertThat(cashRegister.getTotal()).isEqualTo(200);
	}
	
	@Test
	public void theCashRegisterGivesHalfOfItsValueToWinners() {
		int startingAmount = cashRegister.getTotal();
		
		cashRegister.assignPrizes(winners);
		
		int finalAmount = cashRegister.getTotal();
		assertThat(finalAmount).isEqualTo(startingAmount/2);
	}
	
	@Test
	public void theCashRegisterAssignsDifferentRatiosToWinners() {
		
		cashRegister.assignPrizes(winners);
		
		assertThat(firstWinner.getPrize()).isEqualTo(firstPrize);
		assertThat(secondWinner.getPrize()).isEqualTo(secondPrize);
		assertThat(thirdWinner.getPrize()).isEqualTo(thirdPrize);
	}
	
	@Test
	public void ifNoWinnersTheCashRegisterTakesTheMoneyBack() {
		winners = new WinnersResult(firstWinner, secondWinner, new Winner(Tickets.NO_BUYER, 5));
		
		cashRegister.assignPrizes(winners);
		
		assertThat(firstWinner.getPrize()).isEqualTo(firstPrize);
		assertThat(secondWinner.getPrize()).isEqualTo(secondPrize);
		assertThat(thirdWinner.getPrize()).isEqualTo(0);
		assertThat(cashRegister.getTotal()).isEqualTo(startingMoney - firstPrize - secondPrize);
	}
}
