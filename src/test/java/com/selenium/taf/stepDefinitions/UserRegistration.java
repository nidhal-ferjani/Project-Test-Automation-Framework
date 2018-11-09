package com.selenium.taf.stepDefinitions;

import org.junit.Assert;

import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.UserRegistrationPage;
import com.selenium.taf.tests.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistration extends TestBase {

	
	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() throws Throwable {
	  homePage = new HomePage(webDriver);
	  homePage.openRegistrationPage();;
	}

	@When("^I click on register link$")
	public void i_click_on_register_link() throws Throwable {
	  Assert.assertTrue(webDriver.getCurrentUrl().contains("register"));
	}

	/*@When("^I entred the user data$")
	public void i_entred_the_user_data() throws Throwable {
	   userPage = new UserRegistrationPage(webDriver);	
	   userPage.userRegistration("male", "laswed", "labyeth",
			        "nkisoremfilholem@gmail.com", "asdvgyu12");
	}*/

	@When("^I entred \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entred(String gender, String firstName, String lastName, String email, String passwd) throws Throwable {
		userPage = new UserRegistrationPage(webDriver);	
		userPage.userRegistration(gender,firstName,lastName,email,passwd); 
	}
	
	
	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() throws Throwable {
	   Assert.assertTrue(userPage.getTextRegisterResult().contains("Your registration completed"));
       userPage.userLogout();
	}
	
	
	private HomePage homePage;
	private UserRegistrationPage userPage;
	
}
