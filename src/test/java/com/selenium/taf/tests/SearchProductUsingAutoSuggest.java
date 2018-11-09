package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {
  
	@Test
	public void testSearchProductUsingAutoSuggest() {
	
			productDetailsPage = new ProductDetailsPage(webDriver);
			searchPage = new SearchPage(webDriver);
			searchPage.SearchProductUsingAutoSuggest("MacB");
			Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName);
		
		
	}
	
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;
	private String productName="Apple MacBook Pro 13-inch";
}
