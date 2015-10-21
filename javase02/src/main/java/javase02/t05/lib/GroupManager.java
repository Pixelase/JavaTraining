package javase02.t05.lib;

import java.util.ArrayList;
import java.util.List;

public class GroupManager {

	private List<Group> groups;

	public GroupManager() {
		super();
		groups = new ArrayList<>();
	}

	public GroupManager(List<Group> groups) {
		super();
		this.groups = groups;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Group> findGroupsOfStudent(Student student) {
		List<Group> studentsGroups = new ArrayList<>();

		for (Group group : groups) {
			if (group.getGradebook().getGradesMap().containsKey(student)) {
				studentsGroups.add(group);
			}
		}

		return studentsGroups;
	}

	public List<Mark<? extends Number>> findMarksOfStudent(Student student) {

		List<Mark<? extends Number>> marks = new ArrayList<>();

		for (Group group : findGroupsOfStudent(student)) {
			marks.addAll(group.getGradebook().getGradesMap().get(student));
		}
		return marks;
	}

	public List<Mark<? extends Number>> findMarksOfStudent(Student student, Discipline discipline) {

		List<Mark<? extends Number>> marks = new ArrayList<>();

		for (Group group : findGroupsOfStudent(student)) {
			if (group.getDiscipline().equals(discipline)) {
				marks.addAll(group.getGradebook().getGradesMap().get(student));
			}
		}
		return marks;
	}
}
