package javase02.t02.lib.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javase02.t02.lib.utils.JsonFileSerializer;
import javase02.t02.lib.utils.Serializer;

public class EmployeesManager {

	private List<Employee> employees;
	private Serializer serializer;
	private String dbPath;

	public EmployeesManager() {
		employees = new ArrayList<>();
		serializer = new JsonFileSerializer();
		dbPath = "employees.json";
	}

	public EmployeesManager(List<Employee> employees, Serializer serializer, String dbPath) {
		super();
		this.employees = employees;
		this.serializer = serializer;
		this.dbPath = dbPath;
	}

	public boolean readBase() throws IOException {
		boolean isReaded = false;

		if (new File(dbPath).exists()) {
			employees = Arrays.asList(serializer.Deserialize(dbPath, Employee[].class));
			isReaded = true;
		} else {
			isReaded = false;
		}

		return isReaded;
	}

	public void updateOrCreateBase() throws IOException {
		serializer.Serialize(employees.toArray(), dbPath);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getDbPath() {
		return dbPath;
	}

	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}
}
