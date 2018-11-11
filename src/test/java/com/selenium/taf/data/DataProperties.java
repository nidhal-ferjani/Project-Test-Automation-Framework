package com.selenium.taf.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {
 
	// Definition d'une properties
	
	private static Properties dataProperties;
	
	
	public static Properties loadProperties(String path) {
		
		dataProperties = new Properties();
		
		try {
			dataProperties.load(new FileInputStream(path));
		} catch (IOException e) {
			System.out.println("Error occurred : " + e.getMessage());
			return null;
		}
		
		return dataProperties;
	}
	
	
}
