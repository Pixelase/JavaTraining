package javase03.t02.faq.client;

import java.util.Locale;

import javase03.t02.faq.lib.FaqHandler;

public class FaqCommandPerformer implements CommandPerformer {

	private FaqHandler faqHandler;

	public FaqCommandPerformer(FaqHandler faqHandler) {
		super();
		this.faqHandler = faqHandler;
	}

	private boolean isNumber(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	private void printHelp() {
		System.out.println();
		System.out.println("List of commands: ");
		for (Command command : Command.values()) {
			System.out.println(command);
		}
		System.out.println();
	}

	private void printWrongCommandMessage() {
		System.out.println();
		System.out.println("Wrong command!");
		System.out.println();
	}

	private void printAnswer(int questionNumber) {
		int i = 1;
		for (String answer : faqHandler.getAnswers()) {
			if (i == questionNumber) {
				System.out.println();
				System.out.println(answer);
				System.out.println();
				return;
			}
			i++;
		}
	}

	private void switchLang() {
		clearConsole();
		Locale ruRuLocale = new Locale("ru", "RU");
		Locale enUsLocale = new Locale("en", "US");

		if (faqHandler.getResourceBundle().getLocale().equals(ruRuLocale)) {
			faqHandler.setLocale(enUsLocale);
		} else if (faqHandler.getResourceBundle().getLocale().equals(enUsLocale)) {
			faqHandler.setLocale(ruRuLocale);
		}
	}

	private void printQuestions() {
		System.out.println();
		System.out.println("Questions list: ");
		for (String question : faqHandler.getQuestions()) {
			System.out.println(question);
		}
		System.out.println();
	}

	private void clearConsole() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	private void exit() {
		System.exit(0);
	}

	@Override
	public void performCommand(String command) {
		Command tempCommand = null;

		try {
			tempCommand = Command.valueOf(command);
		} catch (IllegalArgumentException ex) {
			// TODO something, but skip it for now
		}

		if (tempCommand == null) {
			if (isNumber(command)) {
				printAnswer(Integer.parseInt(command));
				return;
			}
			printWrongCommandMessage();
			return;
		}

		switch (tempCommand) {
		case clear:
			clearConsole();
			break;
		case exit:
			exit();
			break;
		case questions:
			printQuestions();
			break;
		case switchlang:
			switchLang();
			break;
		case help:
			printHelp();
			break;
		default:
			break;
		}
	}
}
