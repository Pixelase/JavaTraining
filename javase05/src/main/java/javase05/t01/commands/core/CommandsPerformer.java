package javase05.t01.commands.core;

import java.util.List;

import javase05.t01.commands.utils.input.CommandParseResult;

public class CommandsPerformer implements Performer {
	protected List<Command> commands;

	public CommandsPerformer(List<Command> commands) {
		super();
		this.commands = commands;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	@Override
	public void perform(CommandParseResult parseResult) {
		if (!tryPerform(parseResult)) {
			throw new IllegalArgumentException("Command not found");
		}
	}

	@Override
	public boolean tryPerform(CommandParseResult parseResult) {
		for (Command command : commands) {
			if (command.getName().equals(parseResult.getCommandName())) {
				command.setArgs(parseResult.getArgs());
				command.execute();
				return true;
			}
		}

		return false;
	}

}
