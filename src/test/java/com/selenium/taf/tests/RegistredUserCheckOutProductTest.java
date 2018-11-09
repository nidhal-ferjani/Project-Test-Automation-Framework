package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.CheckOutPage;
import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.LoginPage;
import com.selenium.taf.pages.OrderDetailsPage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;
import com.selenium.taf.pages.ShoppingCartPage;
import com.selenium.taf.pages.UserRegistrationPage;

public class RegistredUserCheckOutProductTest extends TestBase {
	/*
	 * 1- Register User
	 * 2- Search Product
	 * 3- Add to cart
	 * 4- checkOut Product
	 * 5 -Logout User 
	 */

	
	// 1- User Login
	
		@Test(alwaysRun = true)
		public void registeredUserCanLogin() {
			homePage = new HomePage(webDriver);
			loginPage = new LoginPage(webDriver);
			userRegisterPage = new UserRegistrationPage(webDriver);
			homePage.openLoginPage();
			loginPage.userLogin(email, password);
			Assert.assertTrue(userRegisterPage.isDisplayedLogoutLink());
		}

		// 2- User search product

		@Test(dependsOnMethods = {"registeredUserCanLogin"})
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
		public void UserRegistredCanCheckOutProduct() throws InterruptedException {
			checkOutPage = new CheckOutPage(webDriver);
			orderDetailsPage = new OrderDetailsPage(webDriver);
			
			shoppingCartPage.openCheckOutPage();
			checkOutPage.selectBbillingAddressFromList("New Address");
			checkOutPage.registredUserCheckOutProduct(country, city, addressTxt, codePostal, phoneNumber);
			
			Assert.assertTrue(checkOutPage.getTextProductName().contains(productName));
			
			checkOutPage.confirmOrder();
		    Thread.sleep(2000);
			Assert.assertTrue(checkOutPage.getTextSuccessMessageLabel()
					          .contains("Your order has been successfully processed!"));
			checkOutPage.viewOrderDetails();
			orderDetailsPage.downloadPDFInvoice();
			orderDetailsPage.printOrderDetails();
		}
		
		// 5 - User Logout
		
		@Test(priority = 5)
		public void registeredUserCanLogout() {
			userRegisterPage.userLogout();
		}
		
		
		
		private HomePage homePage;
		private ProductDetailsPage productDetailsPage;
		private SearchPage searchPage;
		private ShoppingCartPage shoppingCartPage;
		private String productName = "Apple MacBook Pro 13-inch";
		private UserRegistrationPage userRegisterPage;
		private LoginPage loginPage;
		private String password = "azertyui";
		private String email = "nidhouh120098@gmail.com";
		private CheckOutPage checkOutPage;
		private String country = "Tunisia";
		private String city = "City ElNour Essaida";
		private String addressTxt = "15 rue liberte Manouba";
		private String codePostal = "1001578";
		private String phoneNumber = "10109124";
		private OrderDetailsPage orderDetailsPage;
		
}
