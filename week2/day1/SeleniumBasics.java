package week2.day1;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBasics {

	public static void main(String[] args) {

		//ChromeDriver driver=new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		System.out.println(driver.getTitle());
		
		//driver.close();
		
	}

}
