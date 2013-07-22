package org.tristanles.actions;

import org.tristanles.money.CashRegister;
import org.tristanles.tickets.Tickets;

public class BuyAction extends LotteryAction {
	
	public String execute(Tickets tickets, CashRegister cashRegister) {
		if(hasNoBuyer()) {
			throw new RuntimeException("Pas d'acheteur spécifié");
		}
		
		int ticketNumber = tickets.buy(buyerName());
		cashRegister.add(Tickets.PRICE);
		return String.valueOf(ticketNumber);
	}
	
	private String buyerName() {
		return arg;
	}
	
	private boolean hasNoBuyer() {
		return arg == null || arg.isEmpty();
	}

}
