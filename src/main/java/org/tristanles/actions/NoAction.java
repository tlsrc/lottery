package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.Tickets;
import org.tristanles.results.LotteryResult;
import org.tristanles.results.NoResult;

public class NoAction extends LotteryAction {

	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		return new NoResult();
	}

}
