package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.ContactUsPage;
import com.selenium.taf.pages.HomePage;
 

public class ContactUsTest extends TestBase {
	
	@Test
	public void testContactUs() {
		homePage = new HomePage(webDriver);
		contactUsPage = new ContactUsPage(webDriver);
		
		homePage.openContactLinkPage();
		contactUsPage.contactUs(fullName, email, enquiry);
		
		Assert.assertTrue(contactUsPage.getTextSuccessMessage()
				                        .contains("Your enquiry has been successfully sent"));
	}
	
	private HomePage homePage;
	private ContactUsPage contactUsPage;
	private String fullName = "ferjani";
	private String email = "nidhouh120098@gmail.com";
	private String enquiry = "I'm here here and I test";
  
}
