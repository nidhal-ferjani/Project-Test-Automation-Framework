package com.selenium.taf.utilities;

import java.nio.file.Paths;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class SingletonWebDriver {

  // static variable single_instance of type Singleton 
	    private static SingletonWebDriver single_instance ; 
	    static {
	    	single_instance = null;
	    }
	  
	    private String downloadPath = Paths.get(".").toAbsolutePath()+"\\Downloads";
	    // variable of type WebDriver
	    
	    private WebDriver webDriver ; 
	  
	    // private constructor restricted to this class itself 
	    private SingletonWebDriver(String browser) 
	    { 
	    	if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						            Paths.get(".").toAbsolutePath()+"\\Drivers\\chromedriver.exe");
				
				webDriver = new ChromeDriver(chromeOptions());
				
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
			            System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
				
				webDriver = new FirefoxDriver(fireFoxOptions());
			}else if(browser.equalsIgnoreCase("internet explorer")) {
				
				// Even if you have windows 64-bit version, please download IEDriverServer 32-bit version
				// All protected zones settings should be same (Disabled / Enabled)
				// Zoom Level should be 100%
				// Use Desired Capabilities class to set IE properties

				    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
					caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
					caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
					caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

				System.setProperty("webdriver.ie.driver",
			            System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
				
				webDriver = new InternetExplorerDriver();
			}else if(browser.equalsIgnoreCase("safari")) {
				// it is no exist server Driver safari just pluging add in safari
				
				// no setProperty for safari
				   
				 webDriver = new SafariDriver();
			}
			
	    } 
	  
	    // static method to create instance of Singleton class 
	    public static SingletonWebDriver getInstance(String browser) 
	    { 
	        if (single_instance == null) 
	            single_instance = new SingletonWebDriver(browser); 
	  
	        return single_instance; 
	    }

		public WebDriver getWebDriver() {
			return webDriver;
		} 
	    
		
		// pour plus d'options voire fireFoxOptions sur googole
		// methode qui personnalise la methode de download de firefox
		private FirefoxOptions fireFoxOptions() {
		    FirefoxOptions option = new FirefoxOptions();
			option.addPreference("browser.download.folderList", 2);// 0 : default floder download FireFox || 2 : custom folder
			option.addPreference("browser.download.dir", downloadPath);
			option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream"); // directement enregistrer sans ouverture de fichier
			option.addPreference("browser.download.manager.showWhenStarting",false);
			option.addPreference("pdfjs.disabled", true);
			
			return option;
		}    	    
	    
		
		
		// pour plus d'options voire chromeOptions sur googole
		
		private ChromeOptions chromeOptions() {
			ChromeOptions option = new ChromeOptions();
			HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
			
			chromePreferences.put("profile.default.content_settings.popups",0);
			chromePreferences.put("download.default_directory",downloadPath);
			option.setExperimentalOption("prefs",chromePreferences);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			return option;
		}    	   
} 
	