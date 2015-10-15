package javase02.t02.lib.core;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Comparable<Employee> {

	private String firstName;
	private String lastName;

	private List<Item> items;

	public Employee() {
		super();
		firstName = "FirstName";
		lastName = "LastName";
		items = new ArrayList<Item>();
	}

	public Employee(String firstName, String lastName, List<Item> items) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.items = items;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public boolean addItem(Item item) {
		return items.add(item);
	}

	public boolean removeItem(Item item) {
		return items.remove(item);
	}

	public Item removeItem(int index) {
		return items.remove(index);
	}

	public Item setItem(int index, Item item) {
		return items.set(index, item);
	}

	public Item getItem(int index) {
		return items.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getFullName();
	}

	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return getFirstName().compareToIgnoreCase(o.getFirstName());
	}

	public int getTotalPriceOfItems() {
		int totalPriceOfItems = 0;
		for (Item item : items) {
			totalPriceOfItems += item.getPrice();
		}

		return totalPriceOfItems;
	}

}
