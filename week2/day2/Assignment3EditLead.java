package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment3EditLead {

	public static void main(String[] args) throws InterruptedException {

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
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Demo07");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("DemoLead07");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Navii");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.name("description")).sendKeys("Automation Testing TestLeaf");
		driver.findElement(By.xpath("//input[contains(@id,'primaryEmail')]")).sendKeys("naveenn8000@gmail.com");
		
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select opt = new Select(state);
		opt.selectByValue("NY");
		
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("New lead added");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("Adding note after editing");
		System.out.println("Description removed and Note field added");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Lead details updated");
		Thread.sleep(2000);
		System.out.println("Title of the screen: " + driver.getTitle());
		driver.quit();
	
	}

}
