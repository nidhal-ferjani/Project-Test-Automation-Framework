package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductEmailFriendPage extends PageBase{

	public ProductEmailFriendPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void sendEmailToFriend(String emailFriend,String personalMessage) {
		setTextElementText(emailFriendTxt, emailFriend);
		//setTextElementText(yourEmailAddressTxt, yourEmail);
		setTextElementText(personalMessageAreaTxt, personalMessage);
		clickButton(sendEmailBtn);
	}
	
	public String getTextSuccessMessage() {
		return successMessage.getText();
	}

	
	@FindBy(id="FriendEmail")
	private WebElement emailFriendTxt;
	
//	@FindBy(id="YourEmailAddress")
//	private WebElement yourEmailAddressTxt;
	
	@FindBy(id="PersonalMessage")
	private WebElement personalMessageAreaTxt;
	
	@FindBy(name="send-email")
	private WebElement sendEmailBtn;
	
	@FindBy(css="div.result")
	private WebElement successMessage;
}
