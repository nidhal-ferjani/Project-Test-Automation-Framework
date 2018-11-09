package com.selenium.taf.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void captureScreenShot(WebDriver webDriver, String screenShotName) {
        
		   Path des = Paths.get(".\\Screenshots",screenShotName + ".png");
		   try {
			Files.createDirectories(des.getParent());
			FileOutputStream out = new FileOutputStream(des.toString());
			out.write(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
		    out.close();
		} catch (IOException e) {
			System.out.println("Exception while take screen Shot : "+e.getMessage());
		}

	}
}
