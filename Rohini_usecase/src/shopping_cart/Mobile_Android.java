package shopping_cart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Mobile_Android {

	
	public static final String USERNAME = "rohini_vXFNxe";
	public static final String AUTOMATE_KEY = "mqzQbBFJ8s1yqtNkMywv";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	public static void Android() throws Exception {
			
			DesiredCapabilities caps = new DesiredCapabilities();
			
			 // Set URL of the application under test
		      caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
		      
		      // Specify device and os_version for testing
		      caps.setCapability("device", "Google Pixel 3");
		      caps.setCapability("os_version", "9.0");
		        
		      // Set other BrowserStack capabilities
		      caps.setCapability("project", "First Java Project");
		      caps.setCapability("build", "Java Android");
		      caps.setCapability("name", "first_test");
		        
			      
		      AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
		              new URL("http://hub.browserstack.com/wd/hub"), caps);
		      
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		
			
			
		}
		
		
		
	}


