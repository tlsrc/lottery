package org.tristanles;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CashRegisterTest {

	private CashRegister cashRegister;
	
	@Before
	public void init() {
		cashRegister = new CashRegister();
	}
	
	@Test
	public void theCashRegisterStartsAt200() {
		assertThat(cashRegister.getTotal()).isEqualTo(200);
	}
}
