package org.tristanles;

public class CashRegister {

	private int total;
	
	public int getTotal() {
		return total;
	}

	public CashRegister(int total) {
		this.total = total;
	}
	
	public void add(int amount) {
		this.total += amount;
	}

}
