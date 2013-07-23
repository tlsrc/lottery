package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tristanles.testutils.TestValues;

@RunWith(MockitoJUnitRunner.class)
public class WinnerTest {

	private Winner winner;
	
	private Winner winnerWithoutName;
	
	@Before
	public void init() {
		winner = new Winner(TestValues.NAME_ANDRE, 42);
		
		winnerWithoutName = new Winner("", 43);
	}
	
	@Test
	public void aWinnerWithoutNameIsNoOne() {
		assertThat(winnerWithoutName.isNoOne()).isTrue();
	}
	
	@Test
	public void aWinnerWithANameIsSomeone() {
		assertThat(winner.isNoOne()).isFalse();
	}
	
}
