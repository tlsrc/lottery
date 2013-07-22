package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.Tickets;
import org.tristanles.results.BuyResult;
import org.tristanles.results.LotteryResult;

public class BuyAction extends LotteryAction {
	
	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		if(hasNoBuyer()) {
			throw new RuntimeException("Pas d'acheteur spécifié");
		}
		
		int ticketNumber = tickets.buy(buyerName());
		cashRegister.add(Tickets.PRICE);
		return new BuyResult(ticketNumber);
	}
	
	private String buyerName() {
		return arg;
	}
	
	private boolean hasNoBuyer() {
		return arg == null || arg.isEmpty();
	}

}
