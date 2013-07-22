package org.tristanles;

import java.util.HashMap;
import java.util.Map;

import org.tristanles.winners.Winner;
import org.tristanles.winners.Winners;

public class Tickets {

	public static final String TICKET_NOT_BOUGHT = "";
	public static final int PRICE = 10;
	
	protected Map<Integer, String> numbersWithBuyer;

	public Tickets() {
		this.numbersWithBuyer = new HashMap<Integer, String>(TicketNumberUtils.NUMBER_OF_TICKETS);
		for(int i = 1; i <= TicketNumberUtils.NUMBER_OF_TICKETS; i++) {
			numbersWithBuyer.put(i, TICKET_NOT_BOUGHT);
		}
	}

	public int buy(String buyerName) {
		int ticketNumber = randomFreeTicketNumber();
		updateTickets(ticketNumber, buyerName);
		return ticketNumber;
	}


	private void updateTickets(int ticketNumber, String buyerName) {
		numbersWithBuyer.put(ticketNumber, buyerName);
	}

	private int randomFreeTicketNumber() {
		if(allTicketsAreBought()) {
			throw new IllegalStateException("Tous les tickets sont achetés");
		}
		
		int ticketNumber = TicketNumberUtils.random();
		while(isBought(ticketNumber)) {
			ticketNumber = TicketNumberUtils.next(ticketNumber);
		}
		return ticketNumber;
	}
	
	private boolean allTicketsAreBought() {
		for(int i = 1; i <= 50; i ++) {
			if (! isBought(i)) return false;
		}
		return true;
	}
	
	private boolean isBought(int ticketNumber) {
		return TICKET_NOT_BOUGHT != (numbersWithBuyer.get(ticketNumber));
	}

	public Winners pickWinners(CashRegister cashRegister) {
		int firstTicket = TicketNumberUtils.random();
		Winner firstWinner = create(firstTicket);
		
		int secondTicket = TicketNumberUtils.randomExcept(firstTicket);
		Winner secondWinner = create(secondTicket);
		
		int thirdTicket = TicketNumberUtils.randomExcept(firstTicket, secondTicket);
		Winner thirdWinner = create(thirdTicket);
		
		Winners winners = new Winners(firstWinner, secondWinner, thirdWinner);
		winners.assignPrizes(cashRegister);
		return winners;
	}
	
	private Winner create(int ticketNumber) {
		String name = numbersWithBuyer.get(ticketNumber);
		return new Winner(name, ticketNumber);
	}

}
