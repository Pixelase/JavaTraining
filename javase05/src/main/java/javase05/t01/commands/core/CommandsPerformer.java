package javase05.t01.commands.core;

public interface CommandsPerformer {
	void perform(String commandName, String... args);

	boolean tryPerform(String commandName, String... args);
}
