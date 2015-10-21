package javase02.t05.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javase02.t05.lib.Discipline;
import javase02.t05.lib.Gradebook;
import javase02.t05.lib.Group;
import javase02.t05.lib.GroupManager;
import javase02.t05.lib.IncorrectMarkTypeException;
import javase02.t05.lib.Mark;
import javase02.t05.lib.Student;

public class ConsoleClient {

	private static Random rand = new Random();

	private static List<Mark<? extends Number>> generateMarks(int maxMarksCount, int maxMarkRange,
			Discipline discipline) throws IncorrectMarkTypeException {
		List<Mark<? extends Number>> marks = new ArrayList<>();

		for (int i = 0; i < rand.nextInt(maxMarksCount); i++) {
			Number markValue = null;
			switch (discipline) {
			case java:
				markValue = new Integer(rand.nextInt(maxMarkRange));
				break;
			case android:
				markValue = new Integer(rand.nextInt(maxMarkRange));
				break;
			case ios:
				markValue = new Double(rand.nextInt(maxMarkRange));
				break;
			case markup:
				markValue = new Double(rand.nextInt(maxMarkRange));
				break;
			}

			marks.add(new Mark<Number>(markValue, discipline));
		}

		return marks;
	}

	private static Group generateGroup(int maxStudentsCount, int maxMarksCount, int maxMarkRange, Discipline discipline)
			throws IncorrectMarkTypeException {

		Map<Student, List<Mark<? extends Number>>> gradesMap = new HashMap<>();

		for (int i = 0; i < rand.nextInt(maxStudentsCount); i++) {
			Student student = new Student("Student" + i, "Ivanov");
			gradesMap.put(student, generateMarks(maxMarksCount, maxMarkRange, discipline));
		}

		// The one we're looking for
		Student student = new Student("Ivan", "Ivanov");
		gradesMap.put(student, generateMarks(maxMarksCount, maxMarkRange, discipline));

		Gradebook gradebook = new Gradebook(gradesMap);
		Group group = new Group(discipline + " group", discipline, gradebook);

		return group;
	}

	public static List<Group> generateGroups(int maxStudentsCount, int maxMarksCount, int maxMarkRange)
			throws IncorrectMarkTypeException {

		List<Group> groups = new ArrayList<>();
		groups.add(generateGroup(maxStudentsCount, maxMarksCount, maxMarkRange, Discipline.java));
		groups.add(generateGroup(maxStudentsCount, maxMarksCount, maxMarkRange, Discipline.android));
		groups.add(generateGroup(maxStudentsCount, maxMarksCount, maxMarkRange, Discipline.ios));
		groups.add(generateGroup(maxStudentsCount, maxMarksCount, maxMarkRange, Discipline.markup));

		return groups;
	}

	public static void main(String[] args) throws IncorrectMarkTypeException {
		int maxStudentsCount = 16;
		int maxMarksCount = 15;
		int maxMarkRange = 10;

		GroupManager grManager = new GroupManager(generateGroups(maxStudentsCount, maxMarksCount, maxMarkRange));

		// The one we're looking for
		Student student = new Student("Ivan", "Ivanov");

		/*
		 * Find all groups that include student "Ivan Ivanov"
		 */
		System.out.println("> The list of groups that include " + student);
		for (Group group : grManager.findGroupsOfStudent(student)) {
			System.out.println(group);
		}
		System.out.println();

		/*
		 * Find student's marks from all disciplines
		 */
		System.out.println("> The list of all student's marks: ");
		for (Mark<? extends Number> mark : grManager.findMarksOfStudent(student)) {
			System.out.println(mark);
		}
		System.out.println();

		/*
		 * Find student's marks from one discipline
		 */
		System.out.println("> The list of student's marks from " + Discipline.android + " discipline: ");
		for (Mark<? extends Number> mark : grManager.findMarksOfStudent(student, Discipline.android)) {
			System.out.println(mark);
		}
		System.out.println();
	}

}
