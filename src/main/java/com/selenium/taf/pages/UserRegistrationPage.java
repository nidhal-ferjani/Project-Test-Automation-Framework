package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void userRegistration(String gender, String firstName, String lastName, String email, String password) {

		if (gender.equalsIgnoreCase("male")) {
			clickButton(genderMaleRadioBtn);
		}

		if (gender.equalsIgnoreCase("female")) {
			clickButton(genderFemaleRadioBtn);
		}

		setTextElementText(firstNameTxt,firstName);
		setTextElementText(lastNameTxt,lastName);
		setTextElementText(emailTxt,email);
		setTextElementText(passwordTxt,password);
		setTextElementText(confirmPasswordTxt,password);
		clickButton(registerBtn);

	}
	
	public String getTextRegisterResult() {
		return registerResultLabel.getText();
	}
   
	public void userLogout() {
		clickButton(logoutLink);
	}
	
	public void OpenMyAccountPage() {
		clickButton(accountLink);
	}
	
	public boolean isDisplayedLogoutLink() {
		return logoutLink.isDisplayed();
	}
	
	
	// par defaut la visibilité est friendly = private
	
	@FindBy(id="gender-male")
	private WebElement genderMaleRadioBtn;
	
	@FindBy(id="gender-female")
	private WebElement genderFemaleRadioBtn;
	
	@FindBy(id="FirstName")
	private WebElement firstNameTxt;
	
	@FindBy(id="LastName")
	private WebElement lastNameTxt;
	
	@FindBy(id="Email")
	private WebElement emailTxt;
	
	@FindBy(id="Password")
	private WebElement passwordTxt;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTxt;
	
	@FindBy(id="Newsletter")
	private WebElement newsletterCheckBox;
	
	@FindBy(id="register-button")
	private WebElement registerBtn;
	
	@FindBy(css="div.result")
	private WebElement registerResultLabel;
	
	@FindBy(linkText="Log out")
    private WebElement logoutLink;
	
	@FindBy(linkText="My account")
	private WebElement accountLink;
	
	
	
}
