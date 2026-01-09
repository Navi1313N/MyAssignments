package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsClassAmazon {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		// implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("URL launched");
		//search for a product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);
		
		//Getting the price of the first result and extracting only numbers from price
		WebElement price = driver.findElement(By.xpath("(//span[@class='a-price'])[1]"));
		String mobilePrice = price.getText().replaceAll("[^0-9]", "");		
		System.out.println("Price of the first listed mobile: " + mobilePrice );
		
		//Number of customer rating count printed
		WebElement rating = driver.findElement(By.xpath("(//span[@class='a-size-mini puis-normal-weight-text s-underline-text'])[1]"));
		String custRating = rating.getText();
		System.out.println("No of customers rating: " + custRating);
		
		//clicking on first link to open in new window
		driver.findElement(By.xpath("(//a[contains(@class,'a-link-normal s-line-clamp-2')])[1]")).click();

		// switching to child window to see the product details
		Set<String> childWindow = driver.getWindowHandles();
		List<String> switchWindow = new ArrayList<String>(childWindow);
		driver.switchTo().window(switchWindow.get(1));
		System.out.println("child window address: " + driver.getWindowHandle());
		
		//taking screenshot using getScreeshotAs() method
		TakesScreenshot tr = (TakesScreenshot) driver;
		File src = tr.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/mobileProduct.png");
		FileUtils.copyFile(src, dest);
		System.out.println("screenshot captured");
		
		//item added to cardd and verifing the sub total amount and actual product price
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		WebElement subtotal = driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']/span[2]/span[2]"));
		String totalPrice = subtotal.getText().replaceAll("[^0-9]", "");
		System.out.println("Sub total of Cart: " + totalPrice);

		if (totalPrice.equalsIgnoreCase(mobilePrice)) {
			System.out.println("Cart sub total and product price matching");
		} else {
			System.out.println("Totals does not match");
		}

		driver.close();
		driver.quit();
		
	}

}
