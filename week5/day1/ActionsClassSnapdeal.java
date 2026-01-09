package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		// implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("URL launched");

		//hovering to mens fashion and selecting sports shoes
		WebElement mensFasion = driver.findElement(By.xpath("(//div[@class='sc-98d0cbe0-3 dXWLks'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(mensFasion).perform();
		System.out.println("Mouse Hover to Men's Fasion");		
		driver.findElement(By.xpath("//div[text()='Sports Shoes']")).click();
		//getting count of total result and extracting only numbers.
		WebElement count = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		String itemCount = count.getText().replaceAll("[^0-9]", "");
		System.out.println("Total items of sports shoes: "+ itemCount);
		//applying sort by and selecting training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[contains(.,'Low To High')]")).click();
		
		//Setting price limit using slidebar
		WebElement maxPrice = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll right-handle')]"));
		WebElement sliderBar = driver.findElement(By.xpath("//div[@class='ui-slider-range ui-widget-header ui-corner-all']"));
		//gettting size and width of the price slide 
		//setting off set location to -60 out of 100 to reduce the size.
		//hoverin to max element and click & hold and moving to the given location -60
		int sliderWidth = sliderBar.getSize().getWidth();
		int xOffset = -(sliderWidth * 60) / 100;		
		act.moveToElement(maxPrice).scrollToElement(sliderBar).clickAndHold().moveByOffset(xOffset, 0).release().perform();
		System.out.println("price limit set");
		
		//selecting color filter
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='filter-color-tile White&Blue ']"))).click();
		
		//verifing the filters applied 
		boolean colorfilter = driver.findElement(By.xpath("(//div[@class='navFiltersPill' and contains(text(),'Color:')])[1]")).isDisplayed();		
		boolean pricefilter = driver.findElement(By.xpath("(//div[@class='navFiltersPill' and contains(text(),'Price:')])[1]")).isDisplayed();		
		System.out.println("price and color filter applied " + colorfilter + pricefilter);
		//hovering to first result and clicking on Quick view
		WebElement firstResult = driver.findElement(By.xpath("//section[@class='js-section clearfix dp-widget dp-fired']/div[1]"));
		act.moveToElement(firstResult).perform();
		System.out.println("Hover to first result");
		driver.findElement(By.xpath("//section[@class='js-section clearfix dp-widget dp-fired']/div[1]/div/div/div[contains(text(),'Quick')]")).click();
		System.out.println("Quick View button clicked");
		//getting price details
		WebElement productPrice1 = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		System.out.println("Price of first product: Rs." + productPrice1.getText());
		WebElement Discount1 = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		System.out.println("Price of first product: " + Discount1.getText());
		
		//teaking screenshot of shoes
		Thread.sleep(2000);		
		TakesScreenshot tr = (TakesScreenshot) driver;
		File src = tr.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/trainingshoes.png");
		FileUtils.copyFile(src, dest);
		System.out.println("screenshot captured");
				
		driver.close();
		

	
	}

}

