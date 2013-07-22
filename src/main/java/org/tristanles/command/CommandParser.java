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

	private List<Command> availableCommands;
	
	public CommandParser() {
		availableCommands = new ArrayList<Command>();
		availableCommands.add(new Command("achat\\s.+", new BuyAction()));
		availableCommands.add(new Command("tirage", new DrawAction()));
		availableCommands.add(new Command("gagnants", new WinnersAction()));
		availableCommands.add(new Command("\\s*", new NoAction()));
	}
	
	public LotteryAction parse(String input) {
		for(Command command : availableCommands) {
			if(command.matches(input)) {
				return command.getAction();
			};
		}
		return new IncorrectAction();
	}

	
}