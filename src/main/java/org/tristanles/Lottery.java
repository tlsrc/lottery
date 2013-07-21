package org.tristanles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
	
	List<Subscriber> subscribers;
	CashRegister cashRegister;
	
	public Lottery() {
		this.subscribers = new ArrayList<Subscriber>();
		this.cashRegister = new CashRegister(200);
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
		
		throw new IllegalArgumentException("Commande non reconnue");
	}

	private void buy(String buyCommand) {
		String[] tokens = buyCommand.trim().split("\\s+");
		if (tokens.length != 2) {
			throw new IllegalArgumentException("Commande d'achat attendue : \"achat <prénom>\"");
		}
		
		int subscriberNumber = new Random().nextInt(49) + 1;
		String subscriberName = tokens[1];
		subscribers.add(new Subscriber(subscriberName, subscriberNumber));
		cashRegister.add(10);
	}

	public List<Subscriber> getSubscribers() {
		return subscribers;
	}

	public CashRegister getCashRegister() {
		return cashRegister;
	}
}
