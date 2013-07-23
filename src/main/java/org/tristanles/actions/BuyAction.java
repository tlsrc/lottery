package org.tristanles.actions;

import org.tristanles.CashRegister;
import org.tristanles.Messages;
import org.tristanles.results.BuyResult;
import org.tristanles.results.LotteryResult;
import org.tristanles.tickets.Tickets;

public class BuyAction extends LotteryAction {
	
	public LotteryResult execute(Tickets tickets, CashRegister cashRegister) {
		if(hasNoBuyer()) {
			throw new IllegalArgumentException(Messages.PAS_DACHETEUR_SPECIFIE);
		}
		if(tickets.getWinners() != null) {
			throw new IllegalStateException(Messages.GAGNANTS_DEJA_TIRES);
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
