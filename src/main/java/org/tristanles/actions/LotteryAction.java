package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.Tickets;
import org.tristanles.results.LotteryResult;

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
