package shopping_cart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Mobile_IOS {

	
	public static final String USERNAME = "rohini_vXFNxe";
	public static final String AUTOMATE_KEY = "mqzQbBFJ8s1yqtNkMywv";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	public static void IPhone() throws Exception {
			
			DesiredCapabilities caps = new DesiredCapabilities();
			
			  // Set URL of the application under test
			  caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
			 
			  // Specify device and os_version for testing
		      caps.setCapability("device", "iPhone XS");
		      caps.setCapability("os_version", "12");
		       
		      // Set other BrowserStack capabilities
		      caps.setCapability("project", "First Java Project");
		      caps.setCapability("build", "Java iOS");
		      caps.setCapability("name", "first_test");
			 
		      IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
		              new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
		          
		 	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  
		
			
			
		}
		
		
		
	}


