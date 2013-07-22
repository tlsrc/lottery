package org.tristanles.results;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IncorrectResultTest extends StreamRedirectTest {
	
	private IncorrectResult incorrectResult;
	
	@Before
	public void init() {
		incorrectResult = new IncorrectResult();
	}
	
	@Test
	public void incorrectResultDisplaysAnErrorMessage() {
		incorrectResult.display();
		
		assertThat(testOut.toString()).isEqualTo("Commande non reconnue" + System.lineSeparator());
	}
}
