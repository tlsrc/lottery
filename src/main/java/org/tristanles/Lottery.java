package org.tristanles;

import java.util.Scanner;

import org.tristanles.actions.LotteryAction;
import org.tristanles.command.CommandParser;
import org.tristanles.results.LotteryResult;
import org.tristanles.tickets.Tickets;


public class Lottery {
	
	private CommandParser commandParser;
	private Tickets tickets;
	private CashRegister cashRegister;
	
	private Scanner consoleInput;
	
	public Lottery() {
		this.tickets = new Tickets();
		this.cashRegister = new CashRegister();
		this.commandParser = new CommandParser();
		consoleInput = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		System.out.println("Bienvenue à la loterie");
		Lottery lottery = new Lottery();
		lottery.run();
	}

	private void run() {
		String input = null;
		while ((input = consoleInput.nextLine()) != null) {
			read(input);
		}
	}

	protected void read(String input) {
		try {
			LotteryAction action = commandParser.parse(input);
			LotteryResult result = action.execute(tickets, cashRegister);
			result.display();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
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

	public void setCommandParser(CommandParser commandParser) {
		this.commandParser = commandParser;
	}

	public void setConsoleInput(Scanner consoleInput) {
		this.consoleInput = consoleInput;
	}
	
}
