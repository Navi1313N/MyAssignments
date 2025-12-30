package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertInteraction {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml");
		//implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Testing alert");
		alert.dismiss();
		String text = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		
		if (text.equalsIgnoreCase("Testing alert")) {
			System.out.println("Alert closed and typed text verified "+ text);
			
		}else {
			System.out.println("Text not matched becaused alert dismissed without accepting with typed text");
		}
		driver.quit();

	}

}
