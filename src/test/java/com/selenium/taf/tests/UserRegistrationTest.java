package com.selenium.taf.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.LoginPage;
import com.selenium.taf.pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
   
	@Test(priority=1,alwaysRun=true)
	public void userCanRegisterSuccessfully() {
	   homePage = new HomePage(webDriver);
	   userRegisterPage = new UserRegistrationPage(webDriver);
	   
	   
	   homePage.openRegistrationPage();
	   userRegisterPage.userRegistration(gender,firstName , lastName, email, oldPassword);
	   Assert.assertTrue(userRegisterPage.getTextRegisterResult().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"userCanRegisterSuccessfully"})
	public void registeredUserCanLogout() {
		userRegisterPage.userLogout();
	}
	
	@Test(dependsOnMethods= {"registeredUserCanLogout"})
	public void registeredUserCanLogin() {
		
		loginPage = new LoginPage(webDriver);
		homePage.openLoginPage();
		loginPage.userLogin(email, oldPassword);
		Assert.assertTrue(userRegisterPage.isDisplayedLogoutLink());
		
	}
	
	
	
	private HomePage homePage;
	private UserRegistrationPage userRegisterPage;
	private LoginPage loginPage;
	private String oldPassword = "azertyuiop";
	private String firstName = "ferjani";
	private String lastName = "nidhal";
	private String email = "nidhoch1282@gmail.com";
	private String gender = "male";
}
