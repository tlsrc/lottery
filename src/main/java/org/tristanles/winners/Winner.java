package org.tristanles.winners;

import org.tristanles.tickets.TicketNumberUtils;
import org.tristanles.tickets.Tickets;

public class Winner {

	private String name;
	private int ticketNumber;
	private int prize;
	
	public Winner(String name, int ticketNumber) {
		this.name = name;
		this.ticketNumber = ticketNumber;
	}
	
	public String getName() {
		return name;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}

	public boolean isNoOne() {
		return this.name != null && this.name != Tickets.TICKET_NOT_BOUGHT;
	}
	
}
