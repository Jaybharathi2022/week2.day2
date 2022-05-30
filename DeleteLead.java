package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		// Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		// Enter phone number
		driver.findElement(By.xpath("//div[@class='x-plain-bwrap']//input[@name='phoneNumber']")).sendKeys("99");
		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		// Capture lead ID of First Resulting lead
		WebElement eleFirstLead = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]"));
		String firstLead = eleFirstLead.getText();

		// Click First Resulting lead
		eleFirstLead.click();
		// Click Delete
		driver.findElement(By.linkText("Delete")).click();
		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		// Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(firstLead);
		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// Verify message "No records to display" in the Lead List
		Thread.sleep(3000);
		String displayedText = driver.findElement(By.xpath("//div[@class ='x-paging-info']")).getText();

		verifyDelete(displayedText);

		// close browser
		driver.close();
	}

	private void verifyDelete(String displayedText) {
		// TODO Auto-generated method stub
		if (displayedText.equals("No records to display"))
			System.out.println("Deleted successfully");

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		DeleteLead delLead = new DeleteLead();
		delLead.startApp(delLead.setUpDriver());
	}

}
