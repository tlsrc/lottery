package org.tristanles.command;

import static org.tristanles.TestValues.*;
import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.tristanles.actions.BuyAction;
import org.tristanles.actions.DrawAction;
import org.tristanles.actions.IncorrectAction;
import org.tristanles.actions.LotteryAction;
import org.tristanles.actions.NoAction;
import org.tristanles.actions.WinnersAction;
import org.tristanles.command.CommandParser;

@RunWith(JUnit4.class)
public class CommandParserTest {

	private CommandParser commandParser;
	
	@Before
	public void init() {
		this.commandParser = new CommandParser();
	}
	
	@Test
	public void theBuyCommandReturnsABuyAction() {
		LotteryAction action = commandParser.parse(BUY_COMMAND + " " + NAME_ANDRE);
		
		assertThat(action).isInstanceOf(BuyAction.class);
	}
	
	@Test
	public void theBuyCommandWithoutANameReturnsAnIncorrectAction() {
		LotteryAction action = commandParser.parse(BUY_COMMAND);
		
		assertThat(action).isInstanceOf(IncorrectAction.class);
	}
	
	@Test
	public void theDrawCommandReturnsADrawAction() {
		LotteryAction action = commandParser.parse(DRAW_COMMAND);
		
		assertThat(action).isInstanceOf(DrawAction.class);
	}
	
	@Test
	public void theWinnersCommandReturnsAWinnersAction() {
		LotteryAction action = commandParser.parse(WINNERS_COMMAND);
		
		assertThat(action).isInstanceOf(WinnersAction.class);
	}
	
	@Test
	public void anEmptyCommandReturnsANoAction() {
		LotteryAction action = commandParser.parse("");
		
		assertThat(action).isInstanceOf(NoAction.class);
	}
}
