package javase02.t05.lib;

public class Group implements Comparable<Group> {
	private String name;
	private Discipline discipline;
	private Gradebook gradebook;

	public Group(String name, Discipline discipline, Gradebook gradebook) {
		super();
		this.name = name;
		this.discipline = discipline;
		this.gradebook = gradebook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public Gradebook getGradebook() {
		return gradebook;
	}

	public void setGradebook(Gradebook gradebook) {
		this.gradebook = gradebook;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", discipline=" + discipline + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + ((gradebook == null) ? 0 : gradebook.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Group other = (Group) obj;
		if (discipline != other.discipline)
			return false;
		if (gradebook == null) {
			if (other.gradebook != null)
				return false;
		} else if (!gradebook.equals(other.gradebook))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Group o) {
		return name.compareToIgnoreCase(o.name);
	}
}
