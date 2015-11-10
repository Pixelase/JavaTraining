package javase06.t01.app;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesReader {
	public static void main(String[] args) {
		try {
			String propFilePath = ".\\src\\main\\resources\\server.properties";
			Properties props = new Properties();
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(propFilePath)));

			props.load(bis);
			bis.close();

			// Using Hashtable (implements Map interface)
			for (Entry<?, ?> entry : props.entrySet()) {
				System.out.println(entry);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Property file not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Something goes wrong with I/O: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Unknown key: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}
	}
}
