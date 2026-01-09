package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		//implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement from = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		from.clear();
		from.sendKeys("MAS", Keys.ENTER);
		WebElement to = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		to.clear();
		to.sendKeys("MDU", Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		//driver.findElement(By.xpath("//input[@id='buttonFromTo']")).click();
		List<WebElement> row = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]/tbody/tr"));
		//List<WebElement> row = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]/tbody/tr/th"));
		System.out.println("List of Trains:");
		for (int i =2; i < row.size(); i++) {
			WebElement trainNames = driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList')]/tbody/tr["+i+"]/td[2]"));
			System.out.println(trainNames.getText());
			
		}
	}

}
