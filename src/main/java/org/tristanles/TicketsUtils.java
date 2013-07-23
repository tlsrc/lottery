package org.tristanles;

import java.util.Random;

class TicketsUtils {
	
	public TicketsUtils() {
		
	}
	
	public int random() {
		return new Random().nextInt(Tickets.LAST_TICKET - 1) + Tickets.FIRST_TICKET;
	}
	
	public int next(int ticketNumber) {
		if(ticketNumber == Tickets.LAST_TICKET) {
			return Tickets.FIRST_TICKET;
		}
		return ticketNumber + 1;
	}

}
