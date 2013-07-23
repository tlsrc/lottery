package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.results.LotteryResult;
import org.tristanles.tickets.Tickets;

public abstract class LotteryAction {

	protected String arg;
	protected String result;

	public abstract LotteryResult execute(Tickets tickets, CashRegister cashRegister);
	
	public void setArg(String arg) {
		this.arg = arg;
	}
	
	public String getArg() {
		return arg;
	}
	
	public String getResult() {
		return result;
	}
}
