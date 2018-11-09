package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;
import com.selenium.taf.pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{
	
	/*
	 * 1- Search product
	 * 2- Add Product to Cart
	 * 3- goto shopping Cart
	 * 4- update Product quantity in cart
	 * 5- remove cart List
	 */
  
	
	@Test(alwaysRun=true)
	public void testSearchProductUsingAutoSuggest() throws InterruptedException {

		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage = new SearchPage(webDriver);
		searchPage.SearchProductUsingAutoSuggest("MacB");
		Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName);
		
	}
	
	@Test(dependsOnMethods= {"testSearchProductUsingAutoSuggest"})
	public void testUserCanAddProductToShoppingCart() {
		
		productDetailsPage.addProductToCart();
		homePage = new HomePage(webDriver);
		
		homePage.selectCartMenu();
		
		shoppingCartPage = new ShoppingCartPage(webDriver);
		Assert.assertTrue(shoppingCartPage.cartListContainsProduct(productName));
	}
	
	@Test(dependsOnMethods= {"testUserCanAddProductToShoppingCart"})
	public void testUserCanUpdateProductQuantityInShoppingCart() {
		
	    shoppingCartPage.updateProductQuantityInCart("4");
		Assert.assertTrue(shoppingCartPage.getTextSubTotalLabel().contains("$7,200.00"));
	}
	
	
	@Test(priority=4,dependsOnMethods= {"testUserCanAddProductToShoppingCart"})
	public void testUserCanRemoveProductsFromShoppingCart(){
		
	    shoppingCartPage.removeProductFromCart();
		Assert.assertTrue(shoppingCartPage.getTextNoDataLabel().contains("Your Shopping Cart is empty"));
	}
	
	
	private HomePage homePage;
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;
	private String productName = "Apple MacBook Pro 13-inch";
 	private ShoppingCartPage shoppingCartPage;
}
