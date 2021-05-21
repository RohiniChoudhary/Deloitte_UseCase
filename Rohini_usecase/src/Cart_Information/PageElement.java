package Cart_Information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageElement {
	
	 WebDriver driver;
	  
	 public PageElement(WebDriver driver) {
		 this.driver= driver;
		 }
	 
	 
	public void URL() {
		
		driver.get("https://react-shooping-cart.netlify.app/");	
		
	}

	public void AddItem() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div[1]/div/button")).click();
	}

	
	public void GoToCart() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/header/a[3]")).click();
	}
	
	public String ItemInCart() {
		
		String IteminCart = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div/div[2]/h5")).getText();
		System.out.println(IteminCart);
		return IteminCart;
	}
	
	public String TotalItem() {
		
		String Total_Item = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/h4")).getText();
		return Total_Item;
	}
	
	public String TotalPrice() {
		
		String Total_Price = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/h3")).getText();
		return Total_Price;
		}
	
	public boolean DeleteButton() {
		Boolean DeleteButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div/div[4]/button[2]")).isDisplayed();
		return DeleteButton;
	}
	
	public void ClearCart() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/button[2]")).click();
	}
	
	public String CartMessage() {
		
		String CartMessage=driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div/div")).getText();
		return CartMessage;
	}
	
	public boolean ReduceButton() {
		
		Boolean ReduceButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div[1]/div[4]/button[2]")).isDisplayed();
		return ReduceButton;
	}
	
	
	public String MessageDisplayed() {
		
		String MessageDisplayed = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div/div[2]/p")).getText();
		return MessageDisplayed;
	}
	
	public void AddItemsToCart() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div[1]/div[4]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div[1]/div[4]/button[1]")).click();
	}
	
	public void AddTwoItems() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div[4]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div[3]/div/button")).click();
	}
	
	public void ReduceItemsFromCart() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div[1]/div[4]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div[1]/div[4]/button[2]")).click();
	}
	
	public void ItemRemove() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div/div/div[2]/div[4]/button[2]")).click();
	}
	
	public void Checkout() {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/button[1]")).click();
	}
}


