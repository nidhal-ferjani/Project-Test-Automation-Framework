package com.selenium.taf.data;

import java.nio.file.Paths;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;
import com.selenium.taf.utilities.CsvUtils;
import com.selenium.taf.utilities.ExcelUtils;
import com.selenium.taf.utilities.JSONUtils;

public class DataDrivenProvider {

	public static final String INPUT_DATA_USER_PROVIDER = "inputsDataUserProvider";
	public static final String INPUT_DATA_USER_EXCEL = "inputsDataUserExcel";
	public static final String INPUT_DATA_USER_CSV = "inputsDataUserCSV";
	public static final String INPUT_DATA_USER_JSON = "inputsDataUserJSON";
	public static final String INPUT_DATA_USER_FAKER_DATA = "inputsDataUserFakerData";
	
	
	@DataProvider(name = INPUT_DATA_USER_PROVIDER)
	public Object[][] userData() {
		return new Object[][] { { "male", "Moetez", "Nabil", "XXestp911007@gmail.com", "azer1245" },
				{ "male", "Nidhal", "ferj", "XXestp2511005@gmail.com", "zer1245" },
				{ "male", "Ahmed", "ferj", "XXestp23911005@gmail.com", "zer1245" }, };

		// or

		/*
		 * Object[][] dataArray = {
		 * {"male","Moetez","Nabil","testp993347@gmail.com","azer1245" },
		 * {"male","Nidhal","ferj","testp2561325@gmail.com","zer1245" },
		 * {"male","Ahmed","ferj","testp23903125@gmail.com","zer1245" }, }; return
		 * dataArray;
		 */
	}

	@DataProvider(name = INPUT_DATA_USER_EXCEL)
	public Object[][] getExcelDataUser() {
		String filePath = Paths.get(".").toAbsolutePath() + "\\dataUser\\userdata.xlsx";
		String feuilleName = "Feuille 1";

		return ExcelUtils.getTableArray(filePath, feuilleName);

	}

	@DataProvider(name = INPUT_DATA_USER_CSV)
	public Object[][] getCSVDataUser() {
		String filePath = Paths.get(".").toAbsolutePath() + "\\dataUser\\userdata.csv";

		return CsvUtils.readDataLineByLine(filePath, ';');

	}

	@DataProvider(name = INPUT_DATA_USER_JSON)
	public Object[][] getJSONDataUser() {
		String filePath = Paths.get(".").toAbsolutePath() + "\\dataUser\\userdata.json";

		return JSONUtils.parseFileJSONReader(filePath);

	}
	
	@DataProvider(name=INPUT_DATA_USER_FAKER_DATA)
	public Object[][] getJFakerDataUser() {

		String[][] arrayTab = new String[1][5];
		
		Faker fakerData = new Faker();
		 
		arrayTab[0][0] =  "male";
		arrayTab[0][1] = fakerData.name().firstName();
		arrayTab[0][2] = fakerData.name().lastName();
		arrayTab[0][3] = fakerData.internet().emailAddress();
		arrayTab[0][4] = fakerData.internet().password();
		
		
		return arrayTab;
		
	}

}
