package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplementingListInterface {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		//implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//searching for bags and applying filter based on requirement.
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags",Keys.ENTER);
		driver.findElement(By.xpath("//ul[@class='gender-list']//label[text()='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='categories-list']//label[text()='Laptop Bag']")).click();
		Thread.sleep(2000);
		
		//Getting the total result count and extracting only numbers using replaceAll() method.
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String totalCount = count.replaceAll("[^0-9]", "");
		System.out.println("Total product count: " + totalCount);
		
		//storing all the webelements in the given xpath in List webelement.
		List<WebElement> brand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		
		/* 
		 * created empty list and using for each loop iterating each webelement stored and using getText extracted the text inside the element.
		 * adding the text into collection list 
		 */
		List<String> brandNames = new ArrayList<String>();		
		
		for (WebElement string : brand) {
			String text = string.getText();
			brandNames.add(text);
			
		}
		//printing the stored brand list
		System.out.println("Brand Names List: "+ brandNames);
		
		/* 
		 * created empty list and using for each loop iterating each webelement stored and using getText extracted the text inside the element.
		 * adding the text into collection list 
		 */
		List<WebElement> elements = driver.findElements(By.xpath("//h4[@class='product-product']"));
		List<String> bagNames = new ArrayList<String>();
		for (WebElement bag : elements) {
			String bags = bag.getText();
			bagNames.add(bags);
		}
		//printing the bag names list.
		System.out.println("Bag Names List: "+ bagNames);
		
		driver.close();
	} 

}
