package week5.day1;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGSample {

	public  ChromeDriver	driver;
	@Test
	 public void loginPage() {
		 
		 	 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("http://leaftaps.com/opentaps/control/main");
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
	       }  
}
