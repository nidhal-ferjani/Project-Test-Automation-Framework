package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.LoginPage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.ProductReviewPage;
import com.selenium.taf.pages.SearchPage;
import com.selenium.taf.pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{
	
	/*
	 * 1- User Can login
	 * 2- User search Product
	 * 3- User Add Product Review
	 * 4- User Log out
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

	@Test(dependsOnMethods = { "registeredUserCanLogin" })
	public void testSearchProductUsingAutoSuggest() {

		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage = new SearchPage(webDriver);
		searchPage.SearchProductUsingAutoSuggest("MacB");
		Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName);
	}

	// 3- User add review for Product

	@Test(dependsOnMethods = { "testSearchProductUsingAutoSuggest" })
	public void testRegistredUserCanAddReview() {
		productReviewPage = new ProductReviewPage(webDriver);

		productDetailsPage.openAddReviewPage();
		productReviewPage.addProductReview("My Review for Mac Pro", "it's a best Product");
		Assert.assertTrue(
				productReviewPage.getTextReviewNotification().contains("Product review is successfully added"));
	}

	// 4- User Log out

	@Test(priority = 4)
	public void registeredUserCanLogout() {
		userRegisterPage.userLogout();
	}

	private HomePage homePage;
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;
	private ProductReviewPage productReviewPage;
	private String productName = "Apple MacBook Pro 13-inch";
	private UserRegistrationPage userRegisterPage;
	private LoginPage loginPage;
	private String password = "azertyui";
	private String email = "nidhouh120098@gmail.com";
}
