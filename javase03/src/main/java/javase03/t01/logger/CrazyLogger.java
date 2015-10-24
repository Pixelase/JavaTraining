package javase03.t01.logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrazyLogger implements Logger {
	/*
	 * Used a StringBuilder according to the requirement of the task. I would
	 * prefer to use List<Entry> instead of StringBuilder to hold log entries.
	 */
	private StringBuilder entriesHolder;

	public CrazyLogger() {
		super();
		entriesHolder = new StringBuilder();
	}

	@Override
	public String getLog() {
		return entriesHolder.toString();
	}

	@Override
	public void addEntry(Entry entry) {
		entriesHolder.append(entry + "\n");
	}

	@Override
	public String findByDate(Date date) throws ParseException {
		StringBuilder result = new StringBuilder();
		if (entriesHolder.length() != 0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy : HH-mm");
			String[] entryLines = entriesHolder.toString().split("\\n");

			// Ignore the seconds and milliseconds
			Date paramDate = dateFormat.parse(dateFormat.format(date));
			Date tempDate;

			for (String entryLine : entryLines) {
				tempDate = dateFormat.parse(entryLine.substring(0, entryLine.indexOf(" -")));

				if (tempDate.getTime() == paramDate.getTime()) {
					result.append(entryLine + "\n");
				}

			}
		}

		return result.toString();
	}

	@Override
	public String findByMessage(String message) {
		StringBuilder result = new StringBuilder();
		if (entriesHolder.length() != 0) {
			String[] entryLines = entriesHolder.toString().split("\\n");
			String tempMessage;

			for (String entryLine : entryLines) {
				tempMessage = entryLine.substring(entryLine.indexOf("\"") + 1, entryLine.length() - 1);

				if (tempMessage.equals(message)) {
					result.append(entryLine + "\n");
				}
			}
		}

		return result.toString();
	}

	@Override
	public String findByEntry(Entry entry) throws ParseException {
		StringBuilder result = new StringBuilder();
		if (entriesHolder.length() != 0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy : HH-mm");
			String[] entryLines = entriesHolder.toString().split("\\n");
			Date tempDate;
			String tempMessage;
			Entry tempEntry = null;

			// Ignore the seconds and milliseconds in paramEntry
			Entry paramEntry = new Entry(dateFormat.parse(dateFormat.format(entry.getDate())), entry.getMessage());

			for (String entryLine : entryLines) {
				tempDate = dateFormat.parse(entryLine.substring(0, entryLine.indexOf(" -")));
				tempMessage = entryLine.substring(entryLine.indexOf("\"") + 1, entryLine.length() - 1);
				tempEntry = new Entry(tempDate, tempMessage);

				if (tempEntry.equals(paramEntry)) {
					result.append(entryLine + "\n");
				}
			}
		}
		return result.toString();
	}

	@Override
	public void clearLog() {
		entriesHolder.setLength(0);
		entriesHolder.trimToSize();
	}
}
