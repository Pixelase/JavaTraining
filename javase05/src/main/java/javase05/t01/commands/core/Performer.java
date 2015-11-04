package javase05.t01.commands.core;

import javase05.t01.commands.utils.input.CommandParseResult;

public interface Performer {
	void perform(CommandParseResult parseResult);

	boolean tryPerform(CommandParseResult parseResult);
}
