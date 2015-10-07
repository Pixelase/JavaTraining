package javase01.t06.notepad;

import java.util.Arrays;

public class Notepad {
	private Entry[] entries;
	private int size;

	/**
	 * Get all entries from this notepad
	 * 
	 * @return the current array of entries
	 * 
	 */
	public Entry[] getEntries() {
		return entries;
	}

	/**
	 * Class constructor
	 * 
	 * @param initialCapacity
	 *            the value of initial size of entries array
	 * 
	 */
	public Notepad(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		entries = new Entry[initialCapacity];
	}

	/**
	 * Class constructor
	 */
	public Notepad() {
		this(10);
	}

	/**
	 * Number of entries
	 * 
	 * @return the current number of entries in the notepad.
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if the notepad is empty.
	 *
	 * @return true if there are no elements
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Retrieves the entry at the user-supplied index.
	 *
	 * @param index
	 *            the index of the entry we are fetching
	 * @throws IndexOutOfBoundsException
	 *             if index &lt; 0 || index &gt;= size()
	 */
	public Entry getEntry(int index) {
		rangeCheck(index);
		return entries[index];
	}

	/**
	 * Allows you to change an entry at the user-supplied index.
	 *
	 * @param index
	 *            the index of the entry we are editing
	 * @throws IndexOutOfBoundsException
	 *             if index &lt; 0 || index &gt;= size()
	 */
	public void editEntry(int index, Entry entry) {
		rangeCheck(index);
		entries[index] = entry;
	}

	/**
	 * Appends the supplied entry to the end of this notepad.
	 * 
	 * @param entry
	 *            the entry to be appended to this notepad
	 * 
	 */
	public void add(Entry entry) {
		ensureCapacity(size + 1);
		entries[size++] = entry;
	}

	/**
	 * Removes the entry at the user-supplied index.
	 *
	 * @param index
	 *            the index of the entry to be removed
	 * @throws IndexOutOfBoundsException
	 *             if index &lt; 0 || index &gt;= size()
	 */
	public void remove(int index) {
		rangeCheck(index);

		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(entries, index + 1, entries, index, numMoved);
		entries[--size] = null; // Let gc do its work
	}

	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private void ensureCapacity(int minCapacity) {

		int oldCapacity = entries.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			// minCapacity is usually close to size, so this is a win:
			entries = Arrays.copyOf(entries, newCapacity);
		}
	}

	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	/**
	 * Removes all entries from this notepad
	 */
	public void clear() {
		// Let gc do its work
		for (int i = 0; i < size; i++)
			entries[i] = null;

		size = 0;
	}

	/**
	 * Show all entries from this notepad
	 */
	public void printEntries() {
		for (int i = 0; i < size; i++) {
			System.out.println(entries[i]);
		}
	}

}
