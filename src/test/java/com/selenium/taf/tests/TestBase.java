package com.selenium.taf.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium.taf.utilities.Helper;
import com.selenium.taf.utilities.SingletonWebDriver;

import cucumber.api.testng.AbstractTestNGCucumberTests;

 

public class TestBase extends AbstractTestNGCucumberTests{
	
	protected static WebDriver webDriver;
  
	
	@BeforeSuite
	@Parameters({"browser","baseURL"})
	public void startDriver(@Optional("chrome") String browser,@Optional("https://google.com") String URL) {
		Reporter.log("TestBase ----> startDriver",true);		
	    webDriver = SingletonWebDriver.getInstance(browser).getWebDriver();
				
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.get(URL); 
	}
	
	
	@AfterSuite
	public void stopDriver() throws InterruptedException {
		Thread.sleep(6000);
		webDriver.quit();
		Reporter.log("TestBase ----> stopDriver",true);	
	}
	
	@AfterMethod
	public void screenShotOnFailure(ITestResult testResult) {
		if(testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screen Shot.....");
			Helper.captureScreenShot(webDriver, testResult.getMethod().getMethodName());
		}
	}
	
}
