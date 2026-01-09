package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahooWebTable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://finance.yahoo.com/");
		// implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("URL launched");

		// using Actions class hovering to the More opion to select the submenu under more
		Thread.sleep(2000);
		WebElement moreOption = driver.findElement(By.xpath("//span[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(moreOption).perform();
		System.out.println("Mouse Hover to More Option");
	
		// selecting crypto tab
		WebElement crypto = driver.findElement(By.xpath("(//a[contains(text(),'Crypto')])[3]"));
		
		//clicking on crypto using Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", crypto);
			
		System.out.println("Crypto tab clicked");
		System.out.println("-----------");
		Thread.sleep(2000);
		// Finding the row size using webtable xpath for /tbody/tr
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@class='yf-1uayyp1 bd']/tbody/tr"));
		int noOfRows = rowCount.size();
		System.out.println("Size of the table row: " + noOfRows);

		System.out.println("Crypto Currency names:");
		System.out.println("");

		// using for loop iterating the each row and 2nd column data till the last row.
		// used for loop to iterate because the table is dynamic.
		for (int i = 1; i <= rowCount.size(); i++) {
			WebElement cryptoNames = driver
					.findElement(By.xpath("//table[@class='yf-1uayyp1 bd']/tbody/tr[" + i + "]/td[2]"));
			System.out.println(cryptoNames.getText());

		}
		driver.quit();
		

	}

}
