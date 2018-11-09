package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;

public class SearchProductTest extends TestBase {
   
	@Test
	public void userCanSearchProduct() {
		searchPage = new SearchPage(webDriver);
		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage.productSearch(productName);
		searchPage.openProductDetailsPage();
		
		Assert.assertTrue(productDetailsPage.getTextBreadcrumb().equalsIgnoreCase(productName));
	
	}
	
	
	
	private String productName="Apple MacBook Pro 13-inch";
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;
}
