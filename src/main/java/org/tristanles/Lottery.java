package org.tristanles;

import java.util.Random;

public class Lottery {
	
	Tickets tickets;
	CashRegister cashRegister;
	
	public Lottery() {
		this.tickets = new Tickets();
		this.cashRegister = new CashRegister();
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public void read(String command) {
		if(command == null || command.isEmpty()) {
			throw new IllegalArgumentException("Commande vide");
		}
		
		if(command.toUpperCase().startsWith("ACHAT")) {
			buy(command);
			return;
		}
		
		if (command.toUpperCase().startsWith("TIRAGE")) {
			
		}
		
		throw new IllegalArgumentException("Commande non reconnue");
	}

	private void buy(String buyCommand) {
		String[] tokens = buyCommand.trim().split("\\s+");
		if (tokens.length != 2) {
			throw new IllegalArgumentException("Commande d'achat attendue : \"achat <prénom>\"");
		}
		
		String buyerName = tokens[1];
		int ticketBought = 0;
		while(ticketBought == 0) {
			ticketBought = tickets.buy(randomBetween(1, 50), buyerName);
		}

		cashRegister.add(10);
		System.out.println(ticketBought);
	}
	
	private int randomBetween(int i, int j) {
		return new Random().nextInt(j) + i;
	}

	public Tickets getTickets() {
		return tickets;
	}

	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}

	public void setCashRegister(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
	}


	public CashRegister getCashRegister() {
		return cashRegister;
	}
}
