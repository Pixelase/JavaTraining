package javase02.t05.lib;

public class Mark<T extends Number> implements Comparable<Mark<T>> {
	private T value;
	private final Discipline discipline;

	public Mark(T value, Discipline discipline) throws IncorrectMarkTypeException {
		super();
		if (!value.getClass().equals(discipline.getMarkMype())) {
			throw new IncorrectMarkTypeException("Current type " + value.getClass().getName() + "\n" + "Required type "
					+ discipline.getMarkMype().getName() + " for " + discipline + " discipline");
		}
		this.value = value;
		this.discipline = discipline;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Mark other = (Mark) obj;
		if (discipline != other.discipline)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mark [value=" + value + ", discipline=" + discipline + "]";
	}

	@Override
	public int compareTo(Mark<T> o) {
		return (value.doubleValue() < o.getValue().doubleValue()) ? -1
				: ((value.doubleValue() == o.getValue().doubleValue()) ? 0 : 1);
	}
}
