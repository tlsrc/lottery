package org.tristanles.actions;

import org.tristanles.money.CashRegister;
import org.tristanles.results.LotteryResult;
import org.tristanles.results.NoResult;
import org.tristanles.tickets.Tickets;

public class NoAction extends LotteryAction {

	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		return new NoResult();
	}

}
