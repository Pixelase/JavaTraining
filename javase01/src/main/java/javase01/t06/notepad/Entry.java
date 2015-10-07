package javase01.t06.notepad;

public class Entry {
	private String data;

	/**
	 * Class constructor
	 * 
	 * @param data
	 *            the content of entry
	 * 
	 */
	public Entry(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data;
	}

	/**
	 * Get current content of the entry
	 * 
	 * @return the current content of entry
	 * 
	 */
	public String getData() {
		return data;
	}

	/**
	 * Change content of the entry
	 * 
	 * @param data
	 *            the new content of entry
	 * 
	 */
	public void setData(String data) {
		this.data = data;
	}

}
