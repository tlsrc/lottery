package org.tristanles.command;

import org.tristanles.actions.LotteryAction;

class Command {

	private String commandRegex;
	private LotteryAction correspondingAction;
	
	public Command(String commandRegex, LotteryAction correspondingAction) {
		this.commandRegex = commandRegex;
		this.correspondingAction = correspondingAction;
	}

	public boolean matches(String input) {
		return input.matches(commandRegex);
	}

	public LotteryAction getAction() {
		return correspondingAction;
	}
	
}
