package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;
import com.selenium.taf.pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
  
	@Test(priority=1)
	public void testSearchProductUsingAutoSuggest() {

		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage = new SearchPage(webDriver);
		searchPage.SearchProductUsingAutoSuggest("MacB");
		Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName);
	 }
	 
	
	@Test(dependsOnMethods= {"testSearchProductUsingAutoSuggest"})
    public void testUserCanAddProductInWishList() {
	   productDetailsPage.addProductToWishList();
	   homePage = new HomePage(webDriver);
	   wishListPage = new WishListPage(webDriver);
	      
	   homePage.openWishListLink();
	   
	   Assert.assertTrue(wishListPage.isVisibleTitle());
	   Assert.assertTrue(wishListPage.getTextProductCellule().contains(productName));
	   
    }
	
	@Test(dependsOnMethods= {"testUserCanAddProductInWishList"})
    public void testUserCanRemoveProductToWishList() {
	   
		wishListPage.removeProductFromWishList();
	   
	    Assert.assertTrue(wishListPage.getTextEmptyListLabel().contains("The wishlist is empty"));	   
    }
	
	
	private HomePage homePage;
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;
	private WishListPage wishListPage;
	private String productName = "Apple MacBook Pro 13-inch";
	
}
