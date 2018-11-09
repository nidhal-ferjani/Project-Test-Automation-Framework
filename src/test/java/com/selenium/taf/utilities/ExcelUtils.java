package com.selenium.taf.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet excelWSheet;

	private static XSSFWorkbook excelWBook;

	private static XSSFCell cell;

	private static XSSFRow row;

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			// Open the Excel file le document Excel en total
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet : overture de feuille de calcul
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(SheetName);

		} catch (Exception e) {
			System.out.println("Error to open File Excel : " + e.getMessage());
		}
	}

	
	  public static Object[][] getTableArray(String FilePath, String SheetName) {

		String[][] tabArray = null;

		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet

			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(SheetName);


			int totalRows = excelWSheet.getLastRowNum()+1;//1;
		
			tabArray = new String[totalRows][ excelWSheet.getRow(0).getLastCellNum()];
			for (int i=0; i<totalRows; i++ ){
	            row = excelWSheet.getRow(i);
	            int colnumber = row.getLastCellNum();
	            for (int j=0; j<colnumber; j++ )
	            {
	                cell = row.getCell(j);
	                System.out.print(cell.getStringCellValue() + "  ");
	                tabArray[i][j] = cell.getStringCellValue();
	            }
	            System.out.println("");
	        }
			excelWBook.close();
		}catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
        
		return (tabArray);
	}

	// This method is to read the test data from the Excel cell,
	// in this we are passing parameters as Row num and Col num

	


}
