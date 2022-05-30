package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	
	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) {
		//launch url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//enter username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//click login
		driver.findElement(By.className("decorativeSubmit")).click();
		//click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		//click contacts
		driver.findElement(By.linkText("Contacts")).click();
		//click create contacts
		driver.findElement(By.linkText("Create Contact")).click();
		//enter firstname
		driver.findElement(By.id("firstNameField")).sendKeys("Sundhar");
		//enter lastname
		driver.findElement(By.id("lastNameField")).sendKeys("T M");
		//enter first name - local
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("TMS");
		//enter last name - local
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("-");
		//enter department
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("HR");
		//enter description
		driver.findElement(By.id("createContactForm_description")).sendKeys("NA");
		//enter email
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("tms@gmail.com");
		//select state
		Select selState=new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		selState.selectByValue("NY");
		//click create contact
		driver.findElement(By.className("smallSubmit")).click();
		
		//click edit
		driver.findElement(By.linkText("Edit")).click();
		//clear description
		driver.findElement(By.id("updateContactForm_description")).clear();
		//Fill Important
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Imp");
		//click on update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		//get title
		System.out.println("Title : "+driver.getTitle());
		
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreateContact newContact = new CreateContact();
		newContact.startApp(newContact.setUpDriver());

	}

}
