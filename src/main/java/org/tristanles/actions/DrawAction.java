package org.tristanles.actions;

import org.tristanles.money.CashRegister;
import org.tristanles.results.DrawResult;
import org.tristanles.results.LotteryResult;
import org.tristanles.tickets.Tickets;

public class DrawAction extends LotteryAction {

	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		tickets.pickWinners(cashRegister);
		return new DrawResult();
	}

}
