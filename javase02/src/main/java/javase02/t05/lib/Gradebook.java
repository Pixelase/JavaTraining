package javase02.t05.lib;

import java.util.List;
import java.util.Map;

public class Gradebook {
	private Map<Student, List<Mark<? extends Number>>> gradesMap;

	public Gradebook(Map<Student, List<Mark<? extends Number>>> gradesMap) {
		super();
		this.gradesMap = gradesMap;
	}

	public Map<Student, List<Mark<? extends Number>>> getGradesMap() {
		return gradesMap;
	}

	public void setGradesMap(Map<Student, List<Mark<? extends Number>>> gradesMap) {
		this.gradesMap = gradesMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gradesMap == null) ? 0 : gradesMap.hashCode());
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
		Gradebook other = (Gradebook) obj;
		if (gradesMap == null) {
			if (other.gradesMap != null)
				return false;
		} else if (!gradesMap.equals(other.gradesMap))
			return false;
		return true;
	}
}
