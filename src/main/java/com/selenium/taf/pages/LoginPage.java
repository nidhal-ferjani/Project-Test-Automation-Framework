package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}
    
	public void userLogin(String email, String password) {
		setTextElementText(emailTxt, email);
		setTextElementText(passwordTxt, password);
		clickButton(loginBtn);
	}
	
	
	@FindBy(id="Email")
	private WebElement emailTxt;
	@FindBy(id="Password")
	private WebElement passwordTxt;
	@FindBy(css="input.button-1.login-button")
	private WebElement loginBtn;
	
}
