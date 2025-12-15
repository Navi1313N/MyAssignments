package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment1NewAccount {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("democsr2");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		driver.findElement(By.linkText("Create Account")).click();
		System.out.println("New account creation");
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("TestDemo01");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester.");

		WebElement indus = driver.findElement(By.name("industryEnumId"));
		Select opt = new Select(indus);
		opt.selectByIndex(3);

		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select opt1 = new Select(ownership);
		opt1.selectByVisibleText("S-Corporation");

		WebElement source = driver.findElement(By.id("dataSourceId"));
		Select opt2 = new Select(source);
		opt2.selectByValue("LEAD_EMPLOYEE");

		WebElement campaign = driver.findElement(By.id("marketingCampaignId"));
		Select opt3 = new Select(campaign);
		opt3.selectByIndex(6);

		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select opt4 = new Select(state);
		opt4.selectByValue("TX");

		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		System.out.println("Account created successfully");
		String AccountName = driver.findElement(By.xpath("//td[@class][2]/span[@class='tabletext']")).getText();
		System.out.println("Account Name: "+AccountName);

		System.out.println("Window Title: "+driver.getTitle());

		driver.quit();

	}

}
