package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2FacebookForm {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		//implicit wait to load the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("New account creation");
		driver.findElement(By.xpath("//a[contains(text(),'new account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("democfn");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("demoln");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("demo1234@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Welcome@123");
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select dobDay = new Select(day);
		dobDay.selectByIndex(11);
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select dobMonth = new Select(month);
		dobMonth.selectByValue("3");
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select dobYear = new Select(year);
		dobYear.selectByValue("1999");
		//selecting male raido button
		driver.findElement(By.xpath("//label[text()='Male']/input")).click();
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		System.out.println("SignUp form filled and submitted");
		driver.quit();

	}

}
