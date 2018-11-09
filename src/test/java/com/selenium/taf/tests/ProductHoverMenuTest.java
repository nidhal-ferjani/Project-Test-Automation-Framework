package com.selenium.taf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.taf.pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
 
  @Test
  public void testUserCanSelectSubCategorieFromMainMenu() {
	  homePage = new HomePage(webDriver);
	  
	  homePage.selectNotebooksMenu();
	  Assert.assertTrue(webDriver.getCurrentUrl().contains("notebooks"));
  }
  
  private HomePage homePage;  
}
