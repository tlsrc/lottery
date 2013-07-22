package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.Tickets;
import org.tristanles.results.LotteryResult;
import org.tristanles.results.WinnersResult;

public class WinnersAction extends LotteryAction {

	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		WinnersResult winners = tickets.getWinners();
		if(winners == null) {
			throw new RuntimeException("Aucun tirage n'a été fait");
		}
		
		winners.assignPrizes(cashRegister);
		return winners;
	}

}
