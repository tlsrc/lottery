package org.tristanles;


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

	public void parse(String command) {
		if(command == null || command.isEmpty()) {
			throw new IllegalArgumentException("Commande vide");
		}
		
		if(command.toUpperCase().startsWith("ACHAT")) {
			String buyerName = parseBuyerName(command);
			int ticketBought = tickets.buy(buyerName);
			cashRegister.add(10);
			System.out.println(ticketBought);
			return;
		}
		
		if (command.toUpperCase().startsWith("TIRAGE")) {
			tickets.pickWinners( cashRegister);
			return;
		}
		
		throw new IllegalArgumentException("Commande non reconnue");
	}

	private String parseBuyerName(String buyCommand) {
		String[] tokens = buyCommand.trim().split("\\s+");
		if (tokens.length != 2) {
			throw new IllegalArgumentException("Commande d'achat attendue : \"achat <prénom>\"");
		}
		
		return tokens[1];
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
