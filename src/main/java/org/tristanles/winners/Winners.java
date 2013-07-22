package org.tristanles.winners;

import org.tristanles.money.CashRegister;

public class Winners {
	
	private static final float FIRST_RATIO = 0.75F;
	private static final float SECOND_RATIO = 0.15F;
	private static final float THIRD_RATIO = 0.1F;

	private Winner first;
	private Winner second;
	private Winner third;
	
	public Winners(Winner firstWinner, Winner secondWinner, Winner thirdWinner) {
		this.first = firstWinner;
		this.second = secondWinner;
		this.third = thirdWinner;
	}

	public Winner getFirst() {
		return first;
	}

	public Winner getSecond() {
		return second;
	}

	public Winner getThird() {
		return third;
	}

	public void assignPrizes(CashRegister cashRegister) {
		int totalPrize = cashRegister.withdrawTotalPrize();
		
		int firstPrize = Math.round(totalPrize * FIRST_RATIO);
		int secondPrize = Math.round(totalPrize * SECOND_RATIO);
		int thirdPrize = Math.round(totalPrize * THIRD_RATIO);
		
		first.setPrize(firstPrize);
		second.setPrize(secondPrize);
		third.setPrize(thirdPrize);
		
		if(first.isNoOne()) {
			cashRegister.add(firstPrize);
		}
		if(second.isNoOne()) {
			cashRegister.add(secondPrize);
		}
		if(third.isNoOne()) {
			cashRegister.add(thirdPrize);
		}
		
		
	}
	
}
