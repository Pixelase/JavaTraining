package javase02.t02.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javase02.t02.lib.core.Employee;
import javase02.t02.lib.core.EmployeesManager;
import javase02.t02.lib.core.Item;

public class ConsoleClient {

	public static List<Employee> generateData(int employeesCount, int maxItemsCount, int maxItemsPrice) {
		List<Employee> employees = new ArrayList<>();
		List<Item> items;
		Random rand = new Random();
		int itemsCount;
		int itemsWeight = 15;

		for (int i = 0; i < employeesCount; i++) {
			itemsCount = rand.nextInt(maxItemsCount);
			items = new ArrayList<>();

			for (int j = 0; j < itemsCount; j++) {
				items.add(new Item("Item" + j, "Producer" + j, rand.nextInt(maxItemsPrice), itemsWeight));
			}

			employees.add(new Employee("Employee" + i, "Ivanov", items));
		}

		return employees;
	}

	public static void main(String[] args) throws IOException {
		int employeesCount = 5;
		int maxItemsCount = 20;
		int maxItemsPrice = 600;

		List<Employee> employees = generateData(employeesCount, maxItemsCount, maxItemsPrice);
		String dbPath = "employees.json";
		EmployeesManager manager = new EmployeesManager();

		if (!manager.readBase()) {
			manager.setEmployees(employees);
			manager.setDbPath(dbPath);
		}

		for (Employee employee : manager.getEmployees()) {
			System.out.println(
					employee + "   < -- >   " + "Total price of employees items: " + employee.getTotalPriceOfItems());
		}

		manager.updateOrCreateBase();
	}

}
