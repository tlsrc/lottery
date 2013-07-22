package org.tristanles;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.tristanles.money.CashRegisterTest;
import org.tristanles.tickets.TicketsTest;


@Suite.SuiteClasses({
	LotteryTest.class,
	TicketsTest.class,
	CashRegisterTest.class
})
@RunWith(Suite.class)
public class TestSuite {

}
