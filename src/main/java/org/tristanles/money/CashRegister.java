package org.tristanles.money;

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

	public int withdrawTotalPrize() {
		int half = total / 2;
		total = total - half;
		return half;
	}

}
