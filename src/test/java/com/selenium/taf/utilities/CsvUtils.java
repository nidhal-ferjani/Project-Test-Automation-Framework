package com.selenium.taf.utilities;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvUtils {

	public static Object[][]readDataLineByLine(String file, char seperator) {

		
		String[][] tabArray = null;
		
		try {

			// Create an object of file reader class with CSV file as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvParser object with
			// custom seperator semi-colon
			CSVParser parser = new CSVParserBuilder().withSeparator(seperator).build();

			// create csvReader object with parameter
			// filereader and parser
			CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();

			// Read all data at once
			List<String[]> allData = csvReader.readAll();

			// Print Data.
			tabArray = new String[allData.size()][allData.get(0).length];
			
			int i = 0,j = 0;
			
			for (String[] row : allData) {
				  j=0;
				for (String cell : row) {
                     tabArray[i][j] = cell;
                     j++;
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return tabArray;
	}
}
