package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.LoginPage;
import com.selenium.taf.pages.MyAccountPage;
import com.selenium.taf.pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
   
	
	@Test(alwaysRun=true)
	public void userCanRegisterSuccessfully() {
	   homePage = new HomePage(webDriver);
	   userRegisterPage = new UserRegistrationPage(webDriver);
	   
	   homePage.openRegistrationPage();
	   userRegisterPage.userRegistration(gender,firstName , lastName, email, oldPassword);
	   Assert.assertTrue(userRegisterPage.getTextRegisterResult().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"userCanRegisterSuccessfully"})
	public void RegisteredUserCanChangePassword() {
		myAccountPage = new MyAccountPage(webDriver);
		userRegisterPage.OpenMyAccountPage();
		myAccountPage.openChangePasswordPage();
		myAccountPage.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountPage.getTextResultLabel().contains("Password was changed"));
	}
	
	@Test(dependsOnMethods= {"RegisteredUserCanChangePassword"})
	public void registeredUserCanLogout() {
		userRegisterPage.userLogout();
	}
	                                                    
	@Test(dependsOnMethods= {"registeredUserCanLogout"})
	public void registeredUserCanLogin() {
		
		loginPage = new LoginPage(webDriver);
		homePage.openLoginPage();
		loginPage.userLogin(email, newPassword);
		Assert.assertTrue(userRegisterPage.isDisplayedLogoutLink());
		
		System.out.println("webDriver MyAccount : "+webDriver);
		
	}
	
	private HomePage homePage;
	private UserRegistrationPage userRegisterPage;
	private MyAccountPage myAccountPage;
	private LoginPage loginPage;
	private String oldPassword = "azertyuiop";
	private String newPassword = "azertyui";
	private String firstName = "ferjani";
	private String lastName = "nidhal";
	private String email = "nidhouh120098@gmail.com";
	private String gender = "male";
}
