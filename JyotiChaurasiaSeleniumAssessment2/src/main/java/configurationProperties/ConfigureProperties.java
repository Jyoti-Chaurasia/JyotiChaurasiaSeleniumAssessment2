package configurationProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ConfigureProperties {
	Properties properties;
	String directoryPath= "C:\\Users\\jyochaur\\Desktop\\Selenium Assessments\\Jyoti Chaurasia Assessment 2\\JyotiChaurasiaSeleniumAssessment2\\src\\test\\resources\\configuration\\config.properties";

	public ConfigureProperties() {
		properties = new Properties();
		File file = new File(directoryPath);

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getProperty(String property) {
		return properties.getProperty(property);
	}

	public void displayAllProperties() {
		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
