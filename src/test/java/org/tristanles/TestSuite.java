package org.tristanles;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@Suite.SuiteClasses({
	LotteryTest.class,
	TicketsTest.class,
	CashRegisterTest.class
})
@RunWith(Suite.class)
public class TestSuite {

}
