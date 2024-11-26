package Santo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Driver {

	WebDriver driver;
 
	@BeforeSuite
	public void StartBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize(); 
		
	}
    
	@AfterSuite
	public void CloseBrowser() {
		
		driver.quit();

	}

}
