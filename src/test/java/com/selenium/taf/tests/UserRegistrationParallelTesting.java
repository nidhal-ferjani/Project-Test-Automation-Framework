package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.LoginPage;
import com.selenium.taf.pages.UserRegistrationPage;

public class UserRegistrationParallelTesting extends TestBaseGrid{
	
	
	public UserRegistrationParallelTesting(String gender, String firstName, 
            String lastName, String email, String oldPassword) {
		
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.oldPassword = oldPassword;
		
	}


	@Test(alwaysRun=true)
	public void userCanRegisterSuccessfully() {
		
	   homePage = new HomePage(getDriver());
	   userRegisterPage = new UserRegistrationPage(getDriver());
	   
	   
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
		
		loginPage = new LoginPage(getDriver());
		homePage.openLoginPage();
		loginPage.userLogin(email,oldPassword);
		Assert.assertTrue(userRegisterPage.isDisplayedLogoutLink());
		userRegisterPage.userLogout();
	}
	
	
	
	private HomePage homePage;
	private UserRegistrationPage userRegisterPage;
	private LoginPage loginPage;
	private String oldPassword;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
}
