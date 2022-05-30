package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) throws InterruptedException {

		// launch url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// enter username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		// enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// click login
		driver.findElement(By.className("decorativeSubmit")).click();
		// click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		// Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		// click find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//Click on Email xpath
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		//Enter Email 
		driver.findElement(By.name("emailAddress")).sendKeys("b");
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		//Capture name of First Resulting lead
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
		String leadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		//Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(3000);
		//Verify the title as 'Duplicate Lead'
		String titleText = driver.getTitle();
		
		verifyTitle(titleText);
		
		//Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(3000);
		//Confirm the duplicated lead name is same as captured name
		String dupLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		verifyDuplicateLeadName(leadName,dupLeadName);
		
		//Close the browser
		driver.close();
	}

	private void verifyDuplicateLeadName(String leadName, String dupLeadName) {
		// TODO Auto-generated method stub
		if(leadName.equals(dupLeadName))
			System.out.println("Duplicated lead name is same as captured name");
	}

	private void verifyTitle(String titleText) {
		// TODO Auto-generated method stub
		
		if(titleText.contains("Duplicate Lead"))
			System.out.println("Title verified as : "+titleText);
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DuplicateLead dupLead = new DuplicateLead();
		dupLead.startApp(dupLead.setUpDriver());

	}

}
