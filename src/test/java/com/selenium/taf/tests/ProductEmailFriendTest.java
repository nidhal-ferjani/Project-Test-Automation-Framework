package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.LoginPage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.ProductEmailFriendPage;
import com.selenium.taf.pages.SearchPage;
import com.selenium.taf.pages.UserRegistrationPage;

public class ProductEmailFriendTest extends TestBase {

	@Test(alwaysRun=true)
	public void registeredUserCanLogin() {
		homePage = new HomePage(webDriver);
		loginPage = new LoginPage(webDriver);
		userRegisterPage = new UserRegistrationPage(webDriver);
		homePage.openLoginPage();
		loginPage.userLogin(email, password);
		Assert.assertTrue(userRegisterPage.isDisplayedLogoutLink());		
	}
	
	
	@Test(dependsOnMethods= {"registeredUserCanLogin"})
	public void testSearchProductUsingAutoSuggest() {

		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage = new SearchPage(webDriver);
		searchPage.SearchProductUsingAutoSuggest("MacB");
		Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName);
	}

	@Test(dependsOnMethods = {"testSearchProductUsingAutoSuggest"})
	public void testUserCanSendProductlFriend() {
		 
		productEmailFriendPage = new ProductEmailFriendPage(webDriver);
		productDetailsPage.sendEmailFriendLink();
		productEmailFriendPage.sendEmailToFriend("nidhalf@gmail.com","This is best Product My Friend");
		
		Assert.assertTrue(productEmailFriendPage.getTextSuccessMessage()
				                                .contains("Your message has been sent"));

	}
	
	@Test(dependsOnMethods= {"testUserCanSendProductlFriend"})
	public void registeredUserCanLogout() {
		userRegisterPage.userLogout();
	}

	private HomePage homePage;
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;
	private ProductEmailFriendPage productEmailFriendPage;
	private String productName="Apple MacBook Pro 13-inch";
	private UserRegistrationPage userRegisterPage;
	private LoginPage loginPage;
	private String password = "azertyui";
	private String email = "nidhouh120098@gmail.com";

}
