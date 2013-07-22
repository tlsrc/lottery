package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.Tickets;
import org.tristanles.results.IncorrectResult;
import org.tristanles.results.LotteryResult;

public class IncorrectAction extends LotteryAction {
	
	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		return new IncorrectResult();
	}

}
