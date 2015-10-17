package javase02.t02.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javase02.t02.lib.core.Employee;
import javase02.t02.lib.core.EmployeesManager;
import javase02.t02.lib.core.Item;
import javase02.t02.lib.core.Paper;
import javase02.t02.lib.core.Pen;
import javase02.t02.lib.core.Penñil;
import javase02.t02.lib.core.Ruler;

public class ConsoleClient {

	public static List<Employee> generateData(int employeesCount, int maxItemsPrice) {
		List<Employee> employees = new ArrayList<>();
		List<Item> items;
		Random rand = new Random();
		int itemsWeight = 15;

		for (int i = 0; i < employeesCount; i++) {
			items = new ArrayList<Item>();

			items.add(new Paper("Paper", "Belarus paper", rand.nextInt(maxItemsPrice), itemsWeight, 1000, 0.5));
			items.add(new Pen("Pen", "Parker", rand.nextInt(maxItemsPrice), itemsWeight, "Green", "Metal"));
			items.add(new Penñil("Pencil", "Pencils corp", rand.nextInt(maxItemsPrice), itemsWeight, "Gray", "Hard"));
			items.add(new Ruler("Ruler", "Ruler corp", rand.nextInt(maxItemsPrice), itemsWeight, 30, "Wood"));

			employees.add(new Employee("Employee" + i, "Ivanov", items));
		}

		return employees;
	}

	public static void main(String[] args) throws IOException {
		int employeesCount = 5;
		int maxItemsPrice = 600;

		List<Employee> employees = generateData(employeesCount, maxItemsPrice);
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
