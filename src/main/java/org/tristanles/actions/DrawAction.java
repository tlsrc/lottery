package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.results.DrawResult;
import org.tristanles.results.LotteryResult;
import org.tristanles.tickets.Tickets;

public class DrawAction extends LotteryAction {

	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		tickets.pickWinners();
		return new DrawResult();
	}

}
