package javase05.t02.app;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	public static void main(String[] args) {
		try {
			String propFilePath = ".\\src\\main\\resources\\server.properties";
			Properties props = new Properties();
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(propFilePath)));

			props.load(bis);
			bis.close();

			System.out.println(props.getProperty("token"));
			System.out.println(props.getProperty("updatesFetchDelay"));
			System.out.println(props.getProperty("taskDelay"));
			System.out.println(props.getProperty("taskDelay"));
			System.out.println(props.getProperty("moduleTaskDelay"));
			System.out.println(props.getProperty("userTaskDelay"));
			System.out.println(props.getProperty("userTaskTimeout"));

			String key = "Some_key";
			if (!props.containsKey(key)) {
				throw new IllegalArgumentException("Could not find key " + "\"" + key + "\"");
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
