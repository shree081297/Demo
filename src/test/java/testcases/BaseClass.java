package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
public static 	WebDriver driver;
	@BeforeMethod
	public void startTest() {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fitpeo.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
