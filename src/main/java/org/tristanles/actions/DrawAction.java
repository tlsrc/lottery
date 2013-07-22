package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.Tickets;
import org.tristanles.results.DrawResult;
import org.tristanles.results.LotteryResult;

public class DrawAction extends LotteryAction {

	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		tickets.pickWinners(cashRegister);
		return new DrawResult();
	}

}
