package org.tristanles.results;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NoResultTest extends StreamRedirectTest {

	private NoResult noResult;

	@Before
	public void init() {
		noResult = new NoResult();
	}

	@Test
	public void noResultDisplaysNothing() {
		noResult.display();
		
		assertThat(testOut.toString()).isEmpty();
	}
}
