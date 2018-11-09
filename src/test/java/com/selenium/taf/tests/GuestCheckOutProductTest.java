package com.selenium.taf.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.selenium.taf.pages.CheckOutPage;
import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.OrderDetailsPage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;
import com.selenium.taf.pages.ShoppingCartPage;

public class GuestCheckOutProductTest extends TestBase {

	
	@Test(alwaysRun=true)
	public void testSearchProductUsingAutoSuggest() {

		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage = new SearchPage(webDriver);
		searchPage.SearchProductUsingAutoSuggest("MacB");
		Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName);
	}

	// 3- User add Product to Shopping Cart

	@Test(dependsOnMethods = {"testSearchProductUsingAutoSuggest"})
	public void testUserCanAddProductToShoppingCart() {
		
		productDetailsPage.addProductToCart();
		homePage = new HomePage(webDriver);
		
		homePage.selectCartMenu();
		
		shoppingCartPage = new ShoppingCartPage(webDriver);
		Assert.assertTrue(shoppingCartPage.cartListContainsProduct(productName));
	}
	
	// 4 -CheckOut Product 
	
	@Test(dependsOnMethods = {"testUserCanAddProductToShoppingCart"})
	public void testGuestCanCheckOutProduct() throws InterruptedException {
		checkOutPage = new CheckOutPage(webDriver);
			
		shoppingCartPage.openCheckOutPage();
	    checkOutPage.checkOutAsGuset();
		checkOutPage.registredUserCheckOutProduct(firstName,lastName,email,country, city, addressTxt, codePostal, phoneNumber);
		
		Assert.assertTrue(checkOutPage.getTextProductName().contains(productName));
		
		checkOutPage.confirmOrder();
	    Thread.sleep(2000);
		Assert.assertTrue(checkOutPage.getTextSuccessMessageLabel()
				          .contains("Your order has been successfully processed!"));
		
	}
	
	@Test(dependsOnMethods = {"testGuestCanCheckOutProduct"})
	public void testUserCanViewOrderDetails() {
		orderDetailsPage = new OrderDetailsPage(webDriver);
		checkOutPage.viewOrderDetails();
		
		Assert.assertTrue(webDriver.getCurrentUrl().contains("orderdetails"));
		
		orderDetailsPage.downloadPDFInvoice();
		orderDetailsPage.printOrderDetails();
	}
	

	
	
	private HomePage homePage;
	private ProductDetailsPage productDetailsPage;
	private SearchPage searchPage;
	private ShoppingCartPage shoppingCartPage;
	private String productName = "Apple MacBook Pro 13-inch";
	private CheckOutPage checkOutPage;
	private String country = "Tunisia";
	private String city = "City ElNour Essaida";
	private String addressTxt = "15 rue liberte Manouba";
	private String codePostal = "1001578";
	private String phoneNumber = "10109124";
	private String lastName = "aouini";
	private String firstName = "Ahmed";
	private String email = "nidh@gmail.com";
	private OrderDetailsPage orderDetailsPage;
}
