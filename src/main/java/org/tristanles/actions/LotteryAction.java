package org.tristanles.actions;

import org.tristanles.money.CashRegister;
import org.tristanles.tickets.Tickets;

public abstract class LotteryAction {

	private String arg;

	public abstract void execute(Tickets tickets, CashRegister cashRegister);
	
	public void setArg(String arg) {
		this.arg = arg;
	}
	
	public String getArg() {
		return arg;
	}
}
