package org.tristanles.tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tristanles.Winner;
import org.tristanles.results.WinnersResult;

public class Tickets {

	public static final String NO_BUYER = "";
	public static final int FIRST_TICKET = 1;
	public static final int LAST_TICKET = 50;
	public static final int PRICE = 10;
	
	private Map<Integer, String> ticketsBuyers;
	private WinnersResult winners;
	private final TicketsUtils ticketsUtils = new TicketsUtils();

	public Tickets() {
		this.ticketsBuyers = new HashMap<Integer, String>();
		for(int i = FIRST_TICKET; i <= LAST_TICKET; i++) {
			ticketsBuyers.put(i, NO_BUYER);
		}
	}

	public int buy(String buyerName) {
		checkATicketIsAvailable();
		
		int ticketNumber = ticketsUtils.random();
		while(isTaken(ticketNumber)) {
			ticketNumber = ticketsUtils.next(ticketNumber);
		}
		
		ticketsBuyers.put(ticketNumber, buyerName);
		return ticketNumber;
	}
	
	private void checkATicketIsAvailable() {
		for(int i = FIRST_TICKET; i <= LAST_TICKET; i++) {
			if (isAvailable(i)) return; 
		}
		throw new IllegalStateException("Tous les tickets sont achetés");
	}
	
	private boolean isAvailable(int i) {
		return ticketsBuyers.get(i) == NO_BUYER;
	}
	
	private boolean isTaken(int i) {
		return ! isAvailable(i);
	}
	
	public void pickWinners() {
		if (getWinners() != null) {
			throw new IllegalStateException("Les gagnants ont déjà été tirés");
		}
		
		List<Integer> winningTickets = new ArrayList<Integer>(3);
		while(winningTickets.size() < 3) {
			int picked = ticketsUtils.random();
			if(!winningTickets.contains(picked)) {
				winningTickets.add(picked);
			}
		}
		
		Winner firstWinner = buildWinner(winningTickets.get(0));
		Winner secondWinner = buildWinner(winningTickets.get(1));
		Winner thirdWinner = buildWinner(winningTickets.get(2));
		winners = new WinnersResult(firstWinner, secondWinner, thirdWinner);
	}
	
	private Winner buildWinner(int ticketNumber) {
		String winnerName = ticketsBuyers.get(ticketNumber);
		return new Winner(winnerName, ticketNumber);
	}

	public WinnersResult getWinners() {
		return winners;
	}

	public void resetWinners() {
		winners = null;
	}
}
