package org.tristanles.tickets;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class TicketNumberUtilsTest {

	@Test
	public void randomGeneratesANumberBetween1and50() {
		int random = TicketNumberUtils.random();
		assertThat(random).isGreaterThan(0).isLessThan(51);
	}
	
	@Test
	public void randomExceptAvoidsForbiddenValues() {
		int random = TicketNumberUtils.randomExcept(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		assertThat(random).isGreaterThan(20).isLessThan(51);
	}
	
	@Test
	public void nextIncrementsByOne() {
		int two = 2;
		int result = TicketNumberUtils.next(two);
		
		assertThat(result).isEqualTo(3);
	}
	
	@Test
	public void nextReturnsTo1IfAt50() {
		int fifty = 50;
		int result = TicketNumberUtils.next(fifty);
		
		assertThat(result).isEqualTo(1);
	}
}
