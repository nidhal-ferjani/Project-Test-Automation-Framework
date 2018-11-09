package com.selenium.taf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver webDriver) {
		super(webDriver);
	}

	public void clearCompareList() {
		clickButton(clearListLink);
	}
	
	public boolean listContainsText(String text) {
		for (WebElement row : allRows) {
			if(row.getText().contains(text)) {
				return true;
			}
		}
		return false;
	}
	
    public String getTextNoDataLabel() {
    	return noDataLabel.getText();
    }
	
	public void compareProducts() {
		
		//Get allRows size		
		System.out.println(allRows.size());
        
		// get data  form for Each 
		
		for (WebElement row : allRows) {
			System.out.println("Row ===> "+row.getText() +" : ");
		    for (WebElement col : allCols) {
				System.out.println("Col ===> "+col.getText());
			}
		}
	}
	
	@FindBy(css="table.compare-products-table")
	private WebElement compareTable;
	
	@FindBy(tagName="tr")
	private List<WebElement> allRows;
	
	@FindBy(tagName="td")
	private List<WebElement> allCols;
	
	@FindBy(css="a.clear-list")
	private WebElement clearListLink;
	
	@FindBy(css="div.no-data")
	private WebElement noDataLabel;	
}
