package com.selenium.taf.utilities;

import java.io.IOException;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class ExcelUtilsTest {

	@Test(enabled = false)
	public void testGetExcelFile() {

		String FilePath = Paths.get(".").toAbsolutePath() + "\\dataUser\\userdata.xlsx";
		@SuppressWarnings("unused")
		Object tabs[][] = ExcelUtils.getTableArray(FilePath, "Feuille 1");

	}

	@Test(enabled = true)
	public void testGetCSVFile() {

		String FilePath = Paths.get(".").toAbsolutePath() + "\\dataUser\\userdata.csv";
		@SuppressWarnings("unused")
		Object[][] array = CsvUtils.readDataLineByLine(FilePath, ';');

	}

	@Test(enabled=false)
	public void testGetJSONFile() {

		String FilePath = Paths.get(".").toAbsolutePath() + "\\dataUser\\userdata.json";
		@SuppressWarnings("unused")
		Object[][] array = JSONUtils.parseFileJSONReader(FilePath);

	}
	
	@Test
	public void testGeneratedAndSaveJSONFakerData() throws IOException  {
		
		String FilePath = Paths.get(".").toAbsolutePath()+"\\dataUser\\userdata.json";
		 
		JSONUtils.WriteFakerDateInJSONFile(FilePath);
		
		
	}
}
