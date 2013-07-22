package org.tristanles.actions;

import org.tristanles.money.CashRegister;
import org.tristanles.tickets.Tickets;

public interface LotteryAction {

	public void execute(Tickets tickets, CashRegister cashRegister);
}
