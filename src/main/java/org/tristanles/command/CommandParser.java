package org.tristanles.command;

import java.util.ArrayList;
import java.util.List;

import org.tristanles.actions.BuyAction;
import org.tristanles.actions.DrawAction;
import org.tristanles.actions.IncorrectAction;
import org.tristanles.actions.LotteryAction;
import org.tristanles.actions.NoAction;
import org.tristanles.actions.WinnersAction;

public class CommandParser {

	private static final String BUY_REGEX = "achat\\s.+";
	private static final String DRAW_REGEX = "tirage";
	private static final String WINNERS_REGEX = "gagnants";
	private static final String EMPTY_REGEX = "\\s*";
	
	private List<Command> availableCommands;
	
	
	public CommandParser() {
		availableCommands = new ArrayList<Command>();
		availableCommands.add(new Command(BUY_REGEX, BuyAction.class));
		availableCommands.add(new Command(DRAW_REGEX, DrawAction.class));
		availableCommands.add(new Command(WINNERS_REGEX, WinnersAction.class));
		availableCommands.add(new Command(EMPTY_REGEX, NoAction.class));
	}
	
	public LotteryAction parse(String input) {
		for(Command command : availableCommands) {
			if(command.matches(input)) {
				String arg = extractArg(input);
				return command.getAction(arg);
			};
		}
		return new IncorrectAction();
	}
	
	private String extractArg(String input) {
		String[] tokens = input.trim().split("\\s+");
		
		if (tokens.length == 2) {
			return tokens[1];
		}
		return null;
	}

	
}