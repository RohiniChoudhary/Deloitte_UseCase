package shopping_cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Cart_Information.*;

public class LocalTest_MultipleBrowser {

	    PageElement objPageElement;
		WebDriver driver;

		@BeforeTest
		@Parameters("browser")
		public void setup(String browser) throws Exception{
			
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
			
				System.setProperty("webdriver.gecko.driver", "D:\\Users\\rohini_choudhary\\eclipse-workspace\\Rohini_usecase\\driver1\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver","D:\\Users\\rohini_choudhary\\eclipse-workspace\\Rohini_usecase\\driver1\\chromedriver.exe");
				
				driver = new ChromeDriver();
			}
			
					else if(browser.equalsIgnoreCase("Edge")){
					
						System.setProperty("webdriver.edge.driver","D:\\Users\\rohini_choudhary\\eclipse-workspace\\Rohini_usecase\\driver1\\msedgedriver.exe");
						driver = new EdgeDriver();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
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
		
		@AfterTest
		public void TearDown() {
			driver.quit();
			
		}
	}
  
