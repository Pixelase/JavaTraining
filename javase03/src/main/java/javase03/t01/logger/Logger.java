package javase03.t01.logger;

import java.text.ParseException;
import java.util.Date;

public interface Logger {
	String getLog();
	void addEntry(Entry entry);
	String findByDate(Date date) throws ParseException;
	String findByMessage(String message);
	String findByEntry(Entry entry) throws ParseException;
	void clearLog();
}
