package org.tristanles.testutils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.tristanles.CashRegisterTest;
import org.tristanles.LotteryTest;
import org.tristanles.TicketsUtilsTest;
import org.tristanles.TicketsTest;
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

@Suite.SuiteClasses({
		// org.tristanles package
		CashRegisterTest.class, LotteryTest.class, TicketsUtilsTest.class,
		TicketsTest.class, WinnerTest.class,
		// org.tristanles.actions package
		BuyActionTest.class, DrawActionTest.class, IncorrectActionTest.class,
		NoActionTest.class, WinnersActionTest.class,
		// org.tristanles.command package
		CommandParserTest.class,
		// org.tristanles.results package
		BuyResultTest.class, DrawResultTest.class, IncorrectResultTest.class,
		NoResultTest.class, WinnersResultTest.class

})
@RunWith(Suite.class)
public class TestSuite {

}
