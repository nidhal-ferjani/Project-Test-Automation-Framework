package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void contactUs(String fullname, String email, String enquiry) {
		setTextElementText(fullNameTxt, fullname);
		setTextElementText(emailTxt, email);
		setTextElementText(enquiryAreaTxt, enquiry);
		clickButton(submitBtn);
	}
	
	public String getTextSuccessMessage() {
		return successMessage.getText();
	}
	
	
	@FindBy(id="FullName")
	private WebElement fullNameTxt;
	
	@FindBy(id="Email")
	private WebElement emailTxt;
	
	@FindBy(id="Enquiry")
	private WebElement enquiryAreaTxt;
	
    @FindBy(name="send-email")
    private WebElement submitBtn;
    
    @FindBy(css="div.result")
    private WebElement successMessage;

}
