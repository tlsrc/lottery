package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class TicketsUtilsTest {
	
	private TicketsUtils ticketUtils;
	
	@Before
	public void init() {
		ticketUtils = new TicketsUtils();
	}

	@Test
	public void randomGeneratesANumberBetween1and50() {
		int random = ticketUtils.random();
		assertThat(random).isGreaterThan(0).isLessThan(51);
	}
	
	@Test
	public void nextIncrementsByOne() {
		int two = 2;
		int result = ticketUtils.next(two);
		
		assertThat(result).isEqualTo(3);
	}
	
	@Test
	public void nextReturnsTo1IfAt50() {
		int fifty = 50;
		int result = ticketUtils.next(fifty);
		
		assertThat(result).isEqualTo(1);
	}
}
