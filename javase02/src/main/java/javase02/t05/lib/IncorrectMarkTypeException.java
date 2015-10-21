package javase02.t05.lib;

@SuppressWarnings("serial")
public class IncorrectMarkTypeException extends Exception {
	public IncorrectMarkTypeException(String message) {
		super(message);
	}

	public IncorrectMarkTypeException(String message, Throwable cause) {
		super(message, cause);
	}
}
