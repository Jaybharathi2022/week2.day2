package week2.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnRadioButtons {
	
	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) throws InterruptedException {
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Are you enjoying the classes?
		driver.findElement(By.xpath("//input[@id='yes']")).click();
		
		//Find default selected radio button
		List<WebElement> eleRadio = driver.findElements(By.name("news"));
		for(WebElement e : eleRadio ) {
			if(e.isSelected())
				System.out.println("Default selected" + " "+ e.toString());
	
		}
		
		
		//System.out.println(driver.findElement(By.xpath("//label[contains(text(),'default')]/parent::div")).getText());
		
		
		//Select your age group (Only if choice wasn't selected)
				WebElement eleAge = driver.findElement(By.xpath("//label[contains(text(),'age')]/following-sibling::input[@value='1']"));
				if(eleAge.isSelected()!=true)
					eleAge.click();
				else
					System.out.println("Already selected");
					
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		LearnRadioButtons radio=new LearnRadioButtons();
		radio.startApp(radio.setUpDriver());
	}

}
