package org.tristanles;

import java.io.IOException;
import java.util.Scanner;

import org.tristanles.money.CashRegister;
import org.tristanles.tickets.Tickets;
import org.tristanles.winners.Winners;


public class Lottery {
	
	private Tickets tickets;
	private CashRegister cashRegister;
	private Winners winners;
	
	private Scanner consoleInput;
	
	public Lottery() {
		this.tickets = new Tickets();
		this.cashRegister = new CashRegister();
		this.winners = null;
		consoleInput = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Bienvenue à la loterie Pyxis");
		Lottery lottery = new Lottery();
		lottery.run();
	}

	private void run() throws IOException {
		String input = null;
		while ((input = consoleInput.nextLine()) != null) {
			try {
				parse(input);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void parse(String command) throws IOException {
		if(command == null || command.isEmpty()) {
			return;
		}
		
		if(command.toUpperCase().startsWith("ACHAT")) {
			String buyerName = parseBuyerName(command);
			int ticketBought = tickets.buy(buyerName);
			cashRegister.add(10);
			System.out.println(ticketBought);
			return;
		}
		
		if (command.toUpperCase().startsWith("TIRAGE")) {
			this.winners = tickets.pickWinners( cashRegister);
			return;
		}
		
		if(command.toUpperCase().startsWith("GAGNANTS")) {
			if(this.winners == null) {
				throw new IllegalArgumentException("Vous devez faire un tirage avant");
			}
			System.out.println(winners);
			tickets = new Tickets();
			winners = null;
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
