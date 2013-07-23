package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.results.LotteryResult;
import org.tristanles.results.WinnersResult;
import org.tristanles.tickets.Tickets;

public class WinnersAction extends LotteryAction {

	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		WinnersResult winners = tickets.getWinners();
		if(winners == null) {
			throw new RuntimeException("Aucun tirage n'a été fait");
		}
		
		LotteryResult result = cashRegister.assignPrizes(winners);
		tickets.reset();
		return result;
	}

}
