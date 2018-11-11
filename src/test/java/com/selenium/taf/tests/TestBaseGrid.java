package com.selenium.taf.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium.taf.utilities.Helper;

public class TestBaseGrid {
	protected static ThreadLocal<RemoteWebDriver> webDriver;

	@BeforeClass
	@Parameters({ "browser", "baseURL" })
	public void startDriver(@Optional("chrome") String browser, @Optional("https://google.com") String URL)
			throws MalformedURLException {
		Reporter.log("TestBase ----> startDriver", true);
		webDriver = new ThreadLocal<>();

		// Set DesiredCapabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set BrowserName
		capabilities.setCapability("browserName", browser);

		// Set Browser to ThreadLocalMap
		webDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));

		getDriver().get(URL);
	}

	public WebDriver getDriver() {
		// Get driver from ThreadLocalMap
		return webDriver.get();
	}

	@AfterClass
	public void stopDriver() throws InterruptedException {
		getDriver().quit();
		webDriver.remove();
		Reporter.log("TestBase ----> stopDriver", true);
	}

	@AfterMethod
	public void screenShotOnFailure(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screen Shot.....");
			Helper.captureScreenShot(getDriver(), testResult.getMethod().getMethodName());
		}
	}
}
