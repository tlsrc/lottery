package org.tristanles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Tickets {

	private static final String TICKET_NOT_BOUGHT = "";
	private static final int NUMBER_OF_BALLS = 50;
	
	protected Map<Integer, String> numbersWithBuyer;
	protected Map<String, List<Integer>> buyersWithNumbers;

	public Tickets() {
		initNumbers();
		initBuyers();
	}

	private void initNumbers() {
		this.numbersWithBuyer = new HashMap<Integer, String>(NUMBER_OF_BALLS);
		for(int i = 1; i <= NUMBER_OF_BALLS; i++) {
			numbersWithBuyer.put(i, TICKET_NOT_BOUGHT);
		}
	}

	private void initBuyers() {
		buyersWithNumbers = new HashMap<String, List<Integer>>();
	}

	public int buy(String buyerName) {
		int ticketNumber = randomFreeTicketNumber();
		updateTickets(ticketNumber, buyerName);
		updateBuyers(ticketNumber, buyerName);		
		return ticketNumber;
	}

	private void updateBuyers(int ticketNumber, String buyerName) {
		if(buyersWithNumbers.get(buyerName) == null) {
			buyersWithNumbers.put(buyerName, new ArrayList<Integer>());
		}
		buyersWithNumbers.get(buyerName).add(ticketNumber);
	}

	private void updateTickets(int ticketNumber, String buyerName) {
		numbersWithBuyer.put(ticketNumber, buyerName);
	}

	private int randomFreeTicketNumber() {
		if(allTicketsAreBought()) {
			throw new IllegalStateException("Tous les tickets sont achetés");
		}
		
		int ticketNumber = randomTicketNumber();
		while(isBought(ticketNumber)) {
			ticketNumber = nextTicketNumber(ticketNumber);
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

	private int nextTicketNumber(int number) {
		if(number == NUMBER_OF_BALLS) {
			return 1;
		}
		return number + 1;
	}

	public int randomTicketNumber() {
		return new Random().nextInt(NUMBER_OF_BALLS - 1) + 1;
	}

	public Map<String, Integer> pickWinners(CashRegister cashRegister) {
		if(buyersWithNumbers.keySet().size() == 1) {
			
		}
		return null;
	}

}
