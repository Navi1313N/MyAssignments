package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomatingFrameAndAlerts {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//switching to frame using id or name
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//accepting alert by switching
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//getting the responce text after alert action
		String verifyText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		String alertAcceptText = "You pressed OK!";
		
		//verifing the text with given string
		if (verifyText.contains(alertAcceptText)) {
			System.out.println("Alert accepted successfully");
			
		}else {
			System.out.println("Alert dismissed");
		}
		
		
	}
	

}
