package org.tristanles.command;

import org.tristanles.actions.LotteryAction;

class Command {

	private String commandRegex;
	private Class<? extends LotteryAction> correspondingAction;

	public Command(String commandRegex,
			Class<? extends LotteryAction> correspondingAction) {
		this.commandRegex = commandRegex;
		this.correspondingAction = correspondingAction;
	}

	public boolean matches(String input) {
		return input.matches(commandRegex);
	}

	public LotteryAction getAction(String actionArgument) {
		try {
			LotteryAction action = correspondingAction.newInstance();
			action.setArg(actionArgument);
			return action;
		} catch (Exception e) {
			throw new RuntimeException("Impossible d'obtenir l'action "
					+ correspondingAction.getName(), e);
		}
	}
}
