package org.tristanles;

public class CashRegister {

	public static final int STARTING_MONEY = 200;
	private int total;
	
	public int getTotal() {
		return total;
	}

	public CashRegister() {
		this.total = STARTING_MONEY;
	}
	
	public void add(int amount) {
		this.total += amount;
	}

}
