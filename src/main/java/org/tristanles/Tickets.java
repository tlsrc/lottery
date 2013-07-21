package org.tristanles;

import java.util.HashMap;
import java.util.Map;

public class Tickets {

	public static int NUMBER_OF_TICKETS = 50;
	private static final String AVAILABLE_TICKET = "";
	
	private Map<Integer, String> tickets;

	public Tickets() {
		this.tickets = new HashMap<Integer, String>(NUMBER_OF_TICKETS);
		for(int i = 1; i <= NUMBER_OF_TICKETS; i++) {
			tickets.put(i, AVAILABLE_TICKET);
		}
	}

	public int buy(int ticketNumber, String buyerName) {
		if (ticketIsUnavailable(ticketNumber)) {
			return 0;
		}
		
		tickets.put(ticketNumber, buyerName);
		return ticketNumber;
	}

	private boolean ticketIsUnavailable(int ticketNumber) {
		return AVAILABLE_TICKET != (tickets.get(ticketNumber));
	}

	public int getSize() {
		return tickets.size();
	}

	public String get(int i) {
		return tickets.get(i);
	}

}
