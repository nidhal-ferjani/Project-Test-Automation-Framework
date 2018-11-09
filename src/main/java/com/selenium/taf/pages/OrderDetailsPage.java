package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void printOrderDetails() {
		clickButton(printLink);
	}
	
	public void downloadPDFInvoice() {
		clickButton(pdfInvoiceLink);
	}
	
	@FindBy(linkText="Print")
	private WebElement printLink;
	
	@FindBy(linkText="PDF Invoice")
	private WebElement pdfInvoiceLink;

}
