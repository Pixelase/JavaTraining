package javase02.t05.lib;

public enum Discipline {
	java(Integer.class), android(Integer.class), ios(Double.class), markup(Double.class);

	private final Class<? extends Number> markMype;

	private Discipline(Class<? extends Number> markMype) {
		this.markMype = markMype;
	}

	public Class<? extends Number> getMarkMype() {
		return markMype;
	}
}
