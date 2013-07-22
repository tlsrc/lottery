package org.tristanles;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicketNumberUtils {
	
	public static final int NUMBER_OF_TICKETS = 50;
	
	private TicketNumberUtils() {
		
	}
	
	public static int random() {
		return new Random().nextInt(NUMBER_OF_TICKETS - 1) + 1;
	}
	
	public static int next(int ticketNumber) {
		if(ticketNumber == NUMBER_OF_TICKETS) {
			return 1;
		}
		return ticketNumber + 1;
	}
	
	public static int randomExcept(Integer... forbiddenValues) {
		List<Integer> forbiddenValuesList = Arrays.asList(forbiddenValues);
		
		int result = random();
		while(forbiddenValuesList.contains(result)) {
			result = next(result);
		}
		
		return result;
	}
}
