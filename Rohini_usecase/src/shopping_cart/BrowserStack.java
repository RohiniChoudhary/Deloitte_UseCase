package shopping_cart;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Cart_Information.*;



public class BrowserStack {

	
	WebDriver driver;
	
	PageElement objPageElement;
	
	public static final String USERNAME = "rohini_vXFNxe";
	public static final String AUTOMATE_KEY = "mqzQbBFJ8s1yqtNkMywv";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	@Parameters({"browser" ,"browser_version" , "os" ,"os_version" })
	@BeforeMethod
	public  void SetUp(String browser , String browser_version , String os , String os_version) throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browser", browser);
		caps.setCapability("os", os);
		caps.setCapability("Browser_version", browser_version);
		caps.setCapability("os_version", os_version);
		
	    driver = new RemoteWebDriver(new URL(URL) , caps);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    	
		
	}
	
	// Use Case 1
	
	@SuppressWarnings({ "restriction" })
	@Test(priority=1)
	public void Scenario1() {
	
		objPageElement = new PageElement(driver);
		objPageElement.URL();
		objPageElement.AddItem();
		objPageElement.GoToCart();
		String IteminCart = objPageElement.ItemInCart();
		assertNotNull(IteminCart);
		
		String Total_Item = objPageElement.TotalItem();
		System.out.println(Total_Item);
		
		String Total_Price = objPageElement.TotalPrice();
		System.out.println(Total_Price);

		Boolean DeleteButton =objPageElement.DeleteButton();
		System.out.println("Delete Button in Cart is Visible " +DeleteButton);
		assertEquals(DeleteButton, true);
		
	    objPageElement.ClearCart();
		
		String CartMessage = objPageElement.CartMessage();
		System.out.println(CartMessage);
	}
	
	
	// Use Case 2
	
	@Test(priority=2)
	public void Scenario2() {
		
		
		objPageElement = new PageElement(driver);
		objPageElement.URL();
		objPageElement.AddTwoItems();
		objPageElement.GoToCart();
		objPageElement.AddItemsToCart();
		String Total_Item = objPageElement.TotalItem();
		System.out.println(Total_Item);
		
		String Total_Price = objPageElement.TotalPrice();
		System.out.println(Total_Price);
		
		boolean ReduceButton = objPageElement.ReduceButton();
		assertEquals(ReduceButton, true);
		System.out.println("Reduce Button is visible");
		
		boolean DeleteButton = objPageElement.DeleteButton();
		assertEquals(DeleteButton, true);
		System.out.println("Delete Button is visible");
		
		objPageElement.ReduceItemsFromCart();
		
		String Total_Item1 = objPageElement.TotalItem();
		System.out.println(Total_Item1);
		
		String Total_Price1 = objPageElement.TotalPrice();
		System.out.println(Total_Price1);
		
	    objPageElement.ItemRemove();
	    objPageElement.Checkout();
		
		String Message_Displayed = objPageElement.MessageDisplayed();
		System.out.println(Message_Displayed);
		
		String CartClear = objPageElement.CartMessage();
		System.out.println(CartClear);
		
	}
	
	// Closing the Browser
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	  
}


