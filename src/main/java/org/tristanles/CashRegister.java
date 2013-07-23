package org.tristanles;

import static java.lang.Math.round;
import org.tristanles.results.WinnersResult;

public class CashRegister {

	public static final int STARTING_MONEY = 200;
	public static final float TOTAL_PRIZE_RATIO = 0.5f;
	public static final float FIRST_PRIZE_RATIO = 0.75f;
	public static final float SECOND_PRIZE_RATIO = 0.15f;
	public static final float THIRD_PRIZE_RATIO = 0.10f;
	
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
	
	private void remove(int amount) {
		this.total -= amount;
	}

	public WinnersResult assignPrizes(WinnersResult winners) {
		int totalPrize = round(total * TOTAL_PRIZE_RATIO);
		assign(winners.getFirst(), round(totalPrize * FIRST_PRIZE_RATIO));
		assign(winners.getSecond(), round(totalPrize * SECOND_PRIZE_RATIO));
		assign(winners.getThird(), round(totalPrize * THIRD_PRIZE_RATIO));
		
		return winners;
	}

	private void assign(Winner winner, int prize) {
		if(!winner.isNoOne()) {
			remove(prize);
		}
		winner.setPrize(prize);
	}

}
