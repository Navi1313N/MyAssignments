package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment2DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://leaftaps.com/opentaps/");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("democsr2");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//creating new lead data
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Demo07");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("DemoLead07");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Navii");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.name("description")).sendKeys("Automation Testing TestLeaf");
		driver.findElement(By.xpath("//input[contains(@id,'primaryEmail')]")).sendKeys("naveenn8000@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'primaryPhoneNumber')]")).sendKeys("7815408482");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("New Lead created");
		
		//Finding lead data using mobile number
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7815408482");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		WebElement lead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));		
		String leadId = lead.getText();
		System.out.println("Lead ID: "+ leadId);		
		lead.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(5000);
		System.out.println("Lead record deleted");
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		String result = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(result);
		String expectedMessage = "No records to display";
		if(result.equals(expectedMessage)) {
			System.out.println("No record found after deleted the Lead record");
		}else {
			driver.findElement(By.linkText(leadId)).isDisplayed();
			System.out.println("Lead data still available");
		}
		
		driver.quit();
		
	}

}
