package org.tristanles.testutils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.tristanles.CashRegisterTest;
import org.tristanles.LotteryTest;
import org.tristanles.TicketNumberUtilsTest;
import org.tristanles.TicketsTest;


@Suite.SuiteClasses({
	LotteryTest.class,
	TicketsTest.class,
	CashRegisterTest.class,
	TicketNumberUtilsTest.class,
	
})
@RunWith(Suite.class)
public class TestSuite {

}
