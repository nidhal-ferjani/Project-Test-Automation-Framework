package com.selenium.taf.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.data.DataProperties;
import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.LoginPage;
import com.selenium.taf.pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFileTest extends TestBase{
   
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
	
	
	private String path = System.getProperty("user.dir")
			                                +"\\src\\main\\java\\com\\selenium\\taf\\properties\\userdata.properties";
	private HomePage homePage;
	private UserRegistrationPage userRegisterPage;
	private LoginPage loginPage;
	private String oldPassword = DataProperties.loadProperties(path).getProperty("password");
	private String firstName   = DataProperties.loadProperties(path).getProperty("firstname");
	private String lastName    = DataProperties.loadProperties(path).getProperty("lastname");
	private String email       = DataProperties.loadProperties(path).getProperty("email");
	private String gender      = DataProperties.loadProperties(path).getProperty("gender");
}
