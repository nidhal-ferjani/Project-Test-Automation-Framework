package com.selenium.taf.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver webDriver;
	protected JavascriptExecutor jsExec;
	protected Actions action;


	// create Constructor
	public PageBase(WebDriver webDriver) {
        this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	protected  void clickButton(WebElement button) {
		button.click();
	}
	
	protected void setTextElementText(WebElement FieldTxt, String value) {
		FieldTxt.sendKeys(value);
	}
	
	protected void scrollToBottom() {
				
		jsExec.executeScript("scroll(0,3000)");
	}
	
	protected void dropDownSelectByVisibileText(WebElement select, String text) {
		new Select(select).selectByVisibleText(text);
	}
	
    protected void clearText(WebElement FieldTxt) {
    	FieldTxt.clear();
    }
}
