package javase03.t01.client;

import java.text.ParseException;
import java.util.Date;

import javase03.t01.logger.CrazyLogger;
import javase03.t01.logger.Entry;
import javase03.t01.logger.Logger;

public class ConsoleClient {
	public static void main(String[] args) throws ParseException {

		Logger logger = new CrazyLogger();

		Date date = new Date(System.currentTimeMillis());
		String message = "Some message";
		Entry entry = new Entry(date, message);

		logger.addEntry(new Entry(date, "Start logger"));
		logger.addEntry(new Entry(date, message));
		logger.addEntry(new Entry(new Date(System.currentTimeMillis() - 1245), "New message"));
		logger.addEntry(new Entry(new Date(System.currentTimeMillis() + 12421445), "Some message"));
		logger.addEntry(new Entry(new Date(System.currentTimeMillis() * 2), "Another message"));

		System.out.println("> Print log: ");
		System.out.println(logger.getLog());
		System.out.println();

		System.out.printf("> Find log entries by date (\"%s\"):\n", entry.getDateFormat().format(date));
		System.out.println(logger.findByDate(date));
		System.out.println();

		System.out.printf("> Find log entries by message (\"%s\"):\n", message);
		System.out.println(logger.findByMessage(message));
		System.out.println();

		System.out.printf("> Find log entries by entry (%s):\n", entry);
		System.out.println(logger.findByEntry(entry));
		System.out.println();

	}
}
