package javase01.t06.main;

import javase01.t06.notepad.Entry;
import javase01.t06.notepad.Notepad;

public class NotepadExample {
	public static void main(String[] args) {
		Notepad notepad = new Notepad();

		notepad.add(new Entry("Go to the training on Friday"));
		notepad.add(new Entry("Go to the gym today"));
		notepad.add(new Entry("Some important note"));
		notepad.add(new Entry("Bus schedule"));

		System.out.println("Origin entries of our notepad: ");
		notepad.printEntries();

		notepad.editEntry(2, new Entry("Edited entry"));
		notepad.remove(1);

		System.out.println("\nCurrent entries of our notepad: ");
		notepad.printEntries();

		notepad.clear();
	}
}
