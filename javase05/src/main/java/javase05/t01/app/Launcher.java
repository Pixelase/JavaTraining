package javase05.t01.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import javase05.t01.commands.utils.input.CommandInputParser;
import javase05.t01.commands.utils.input.CommandInputReader;
import javase05.t01.commands.utils.input.CommandParseResult;

public class Launcher {
	public static void main(String[] args) {
		try {
			final FileManager fileManager = new FileManager();

			while (true) {
				System.out.print(fileManager.getCurrentPath() + ">");

				try {
					CommandParseResult parseResult = CommandInputParser.parse(CommandInputReader.readLine(System.in));

					if (!fileManager.tryPerform(parseResult.getCommandName(), parseResult.getArgs())) {
						System.out.println("Команда не найдена.");
					}
				} catch (FileNotFoundException e) {
					System.out.println("Файл или каталог не найден: " + e.getLocalizedMessage());
				} catch (IOException e) {
					System.out.println("При работе с файлами произошла ошибка: " + e.getLocalizedMessage());
				} catch (Exception e) {
					System.out.println("Что-то пошло не так: " + e.getLocalizedMessage());
				}
			}

		} catch (Exception e) {
			System.out.println("Критическая ошибка: " + e.getLocalizedMessage());
		}
	}
}
