package org.tristanles.results;

public class BuyResult implements LotteryResult {

	private int ticketNumber;
	
	public BuyResult(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public void display() {
		System.out.println(ticketNumber);
	}


}
