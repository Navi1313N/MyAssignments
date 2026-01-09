package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClassBigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.bigbasket.com/");
		// implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("URL launched");
				
		//clicking on Shop By Category		
		driver.findElement(By.xpath("(//span[text()='Shop by'])[2]")).click();
		Thread.sleep(3000);
		//hovering to sub categories
		WebElement subCategory = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(subCategory).perform();
		Thread.sleep(3000);
		System.out.println("Hovered to sub category Food grains");
		
		WebElement riceProducts = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));		
		act.moveToElement(riceProducts).perform();
		System.out.println("Hovered to sub category Rice products"); 
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		
		//filtering with brand 
		driver.findElement(By.xpath("//input[@id='i-bbRoyal']")).click();
		//selecting tmail ponni rice //explict wait to find the element after page loading
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"))).click();
		
		//handling windows to switch to newly opened window
		Set<String> childWindow = driver.getWindowHandles();
		List<String> switchWindow=new ArrayList<String>(childWindow);
		driver.switchTo().window(switchWindow.get(1));
		
		//Taking screenshot using getScreenshotAs() method
		TakesScreenshot tr = (TakesScreenshot) driver;
		File src = tr.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/Rice.png");
		FileUtils.copyFile(src, dest);
		System.out.println("screenshot captured");
		
		//getting the price of the 5 kg bag
		WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[text()='5 kg']/following::span[@class='Label-sc-15v1nk5-0 sc-lnPyaJ jnBJRV gMIdyI']")));  
		System.out.println("Price of 5 kg bag is: "+ price.getText() );
		
		//adding to basket and verifing the success message.
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();		
		WebElement success = driver.findElement(By.xpath("//p[contains(text(),'added to your basket')]"));	
		String msg = success.getText();
		String expectedMsg = "added to your basket";
		
		if (msg.contains(expectedMsg)) {
			System.out.println("Item added to card successfully");
		}
		else {
			System.out.println("Item not added to cart");
		}
		
		//closing current window and main window
		driver.close();
		driver.quit();
		
		
		
		
		

	}

}
