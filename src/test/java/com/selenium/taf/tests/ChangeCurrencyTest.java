package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	@Test(priority=1)
	public void testUserCanChangeCurrency() {
		homePage = new HomePage(webDriver);
		homePage.changeCurrency();
		
	}

	@Test(priority=2)
	public void testSearchProductUsingAutoSuggest() {

		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage = new SearchPage(webDriver);
		searchPage.SearchProductUsingAutoSuggest("MacB");
		Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName);
	}
	
	@Test(dependsOnMethods= {"testSearchProductUsingAutoSuggest"})
	public void testCurrencyIsChanged() {

		Assert.assertTrue(productDetailsPage.getTextProductPriceLabel().contains("Ђ"));
	}
	
	private HomePage homePage;
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;
	private String productName="Apple MacBook Pro 13-inch";
}
