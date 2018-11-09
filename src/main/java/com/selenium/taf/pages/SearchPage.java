package com.selenium.taf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void productSearch(String productName) {
		setTextElementText(searchTxt, productName);
		clickButton(searchBtn);
	}
	
	public void openProductDetailsPage() {
		clickButton(productTitle);
	}
	
	public void SearchProductUsingAutoSuggest(String searchText) {
			
		setTextElementText(searchTxt, searchText);
		WebDriverWait wait = new WebDriverWait(webDriver, 4);
			
		wait.until(ExpectedConditions.visibilityOf(productList.get(0)));
		
		clickButton(productList.get(0));
	}
	
	

	@FindBy(id="small-searchterms")
	private WebElement searchTxt;
	
	@FindBy(css="input.button-1.search-box-button")
	private WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	private List<WebElement> productList;
	
	@FindBy(css="h2.product-title>a")
	private WebElement productTitle;
		
}
