package org.tristanles.testutils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.tristanles.CashRegisterTest;
import org.tristanles.LotteryTest;
import org.tristanles.WinnerTest;
import org.tristanles.actions.BuyActionTest;
import org.tristanles.actions.DrawActionTest;
import org.tristanles.actions.IncorrectActionTest;
import org.tristanles.actions.NoActionTest;
import org.tristanles.actions.WinnersActionTest;
import org.tristanles.command.CommandParserTest;
import org.tristanles.results.BuyResultTest;
import org.tristanles.results.DrawResultTest;
import org.tristanles.results.IncorrectResultTest;
import org.tristanles.results.NoResultTest;
import org.tristanles.results.WinnersResultTest;
import org.tristanles.tickets.TicketsTest;
import org.tristanles.tickets.TicketsUtilsTest;

@Suite.SuiteClasses({ CashRegisterTest.class, LotteryTest.class,
		TicketsUtilsTest.class, TicketsTest.class, WinnerTest.class,
		BuyActionTest.class, DrawActionTest.class, IncorrectActionTest.class,
		NoActionTest.class, WinnersActionTest.class, CommandParserTest.class,
		BuyResultTest.class, DrawResultTest.class, IncorrectResultTest.class,
		NoResultTest.class, WinnersResultTest.class
})
@RunWith(Suite.class)
public class TestSuite {

}
