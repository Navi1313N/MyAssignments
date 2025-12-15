package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class WorkOut {

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
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		  
		  driver.findElement(By.linkText("Create Lead")).click();
		  driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		  driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Demo1");
		  driver.findElement(By.id("createLeadForm_lastName")).sendKeys("DemoLead");
		  
		  WebElement src = driver.findElement(By.id("createLeadForm_dataSourceId"));
		  Select sel = new Select(src); sel.selectByIndex(4);
		  
		  WebElement marketing = driver.findElement(By.id("createLeadForm_marketingCampaignId")); 
		  Select sel1 = new Select(marketing); sel1.selectByVisibleText("Automobile");
		  
		  WebElement ownership =driver.findElement(By.id("createLeadForm_ownershipEnumId")); 
		  Select sel2 =new Select(ownership); sel2.selectByValue("OWN_CCORP");
		  
		  driver.findElement(By.className("smallSubmit")).click();
		  System.out.println(driver.getTitle()); driver.close();
		  
		 
	}

}
