package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void openChangePasswordPage() {
		clickButton(myAccountLink);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		setTextElementText(oldPasswordTxt, oldPassword);
		setTextElementText(newPasswordTxt, newPassword);
		setTextElementText(confirmNewPassword, newPassword);
		clickButton(changePasswordBtn);
	}
	
	public String getTextResultLabel() {
		return resultLabel.getText();
	}
	
	@FindBy(linkText="Change password")
	private WebElement myAccountLink;
	@FindBy(id="OldPassword")
	private WebElement oldPasswordTxt;
	@FindBy(id="NewPassword")
	private WebElement newPasswordTxt;
	@FindBy(id="ConfirmNewPassword")
	private WebElement confirmNewPassword;
	@FindBy(css="input.button-1.change-password-button")
	private WebElement changePasswordBtn;
	@FindBy(css="div.result")
	private WebElement resultLabel;
}
