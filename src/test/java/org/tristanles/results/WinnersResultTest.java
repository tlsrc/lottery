package org.tristanles.results;

import static org.fest.assertions.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tristanles.Winner;

@RunWith(MockitoJUnitRunner.class)
public class WinnersResultTest extends StreamRedirectTest {

	private WinnersResult winnersResult;
	private Winner firstWinner;
	private Winner secondWinner;
	private Winner thirdWinner;
	
	@Before
	public void init() {
		firstWinner = new Winner("First", 1);
		firstWinner.setPrize(75);
		secondWinner = new Winner("Second", 2);
		secondWinner.setPrize(15);
		thirdWinner = new Winner("Third", 3);
		thirdWinner.setPrize(10);
		
		winnersResult = new WinnersResult(firstWinner, secondWinner, thirdWinner);
	}
	
	@Test
	public void winnersResultDisplaysATable(){
		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append(" 1ère boule   | 2ème boule   | 3ème boule   ");
		expectedOutput.append(System.lineSeparator());							
		expectedOutput.append(" First : 75$  | Second : 15$ | Third : 10$  ");
		expectedOutput.append(System.lineSeparator());
		
		winnersResult.display();
		
		assertThat(testOut.toString()).isEqualTo(expectedOutput.toString());
	}
}
