package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.ComparePage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;

public class AddProductToCompareTest extends TestBase{
  
  /*
   * 1- Search Product Number 1
   * 2- Search Product Number 2
   * 3- Add To Compare
   * 4- Clear Compare List
   */
	
	@Test
	public void testSearchFirstProductsAndAddToCompareList() {
			productDetailsPage = new ProductDetailsPage(webDriver);
			searchPage = new SearchPage(webDriver);
			searchPage.SearchProductUsingAutoSuggest("MacB");
			Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), firstProductName);
		    productDetailsPage.addToCompareList();	
	}
	
	@Test(dependsOnMethods= {"testSearchFirstProductsAndAddToCompareList"})
	public void testSearchSecondProductsAndAddToCompareList() {
		  
			searchPage.SearchProductUsingAutoSuggest("Asus");
			Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), secondProductName);
			productDetailsPage.addToCompareList();		
	}

  @Test(dependsOnMethods= {"testSearchSecondProductsAndAddToCompareList"})
  public void UserCanCompareProducts() {
	  comparePage = new ComparePage(webDriver);
	 
	  webDriver.get("https://demo.nopcommerce.com" + "/compareproducts");
	  Assert.assertTrue(comparePage.listContainsText(firstProductName)
			                         && comparePage.listContainsText(secondProductName));
	  
	  comparePage.compareProducts();
  }
  
  @Test(dependsOnMethods= {"UserCanCompareProducts"})
  public void userCanClearCompareList() {
	  comparePage.clearCompareList();
	  
	  Assert.assertTrue(comparePage.getTextNoDataLabel().contains("You have no items to compare"));
  }
  
  
  private String firstProductName="Apple MacBook Pro 13-inch";
  private String secondProductName="Asus N551JK-XO076H Laptop";
  private ProductDetailsPage productDetailsPage;
  private SearchPage searchPage;
  private ComparePage comparePage;
  
}
