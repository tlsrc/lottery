package org.tristanles.actions;

import org.tristanles.money.CashRegister;
import org.tristanles.results.IncorrectResult;
import org.tristanles.results.LotteryResult;
import org.tristanles.tickets.Tickets;

public class IncorrectAction extends LotteryAction {
	
	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		return new IncorrectResult();
	}

}
