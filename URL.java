package Santo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class URL extends Base_Driver {

	@Test
	public void OpenURL() {

		driver.get("https://www.daraz.com.bd/");

		driver.getCurrentUrl();
		driver.getTitle();

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		// flash sale Heading text

		WebElement HeadingText = driver.findElement(By.xpath("//*[@id=\"J_FlashSale\"]/div[1]/p"));
		HeadingText.isDisplayed();
		System.out.println(HeadingText.getText());

		// Verify LoginButton

		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"anonLogin\"]/a"));
		LoginButton.isDisplayed();
		LoginButton.click();

	}

	@Test
	public void PageNavigation() {

		// HomePage

		driver.get("https://www.daraz.com.bd/");

		// Verify LOGIN button

		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"anonLogin\"]/a"));
		LoginButton.isDisplayed();
		LoginButton.click();

		// Navigation

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

	}

	@Test
	public void FillupInput() throws InterruptedException {

		// Home Page
		driver.get("https://evaly.com.bd/");

		// Verify Sign in Button
		WebElement LoginButton = driver.findElement(By.xpath("//span[@class='hidden md:inline-block']"));
		LoginButton.isDisplayed();
		LoginButton.click();

		// Sign in Button Page
		driver.get("https://evaly.com.bd/auth/login");

		// Taking Input Field
		WebElement Email = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
		WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		WebElement Login_Button = driver.findElement(By.xpath("//button[@type='submit']"));

		// Typing Input
		Email.sendKeys("devil315400@gmail.com");
		Password.sendKeys("Santo315");
		Thread.sleep(3000);
		Login_Button.click();

	}

	@Test
	public void JSAlerts() throws InterruptedException {

		// HomePage

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// Handling JSAlert

		WebElement JSAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		JSAlert.click();
		Thread.sleep(3000);
		Alert alertOne = driver.switchTo().alert();
		System.out.println(alertOne.getText());
		alertOne.accept();

		// Handling JSConfirm

		WebElement JSConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		JSConfirm.click();
		Thread.sleep(3000);
		Alert alertTwo = driver.switchTo().alert();
		System.out.println(alertTwo.getText());
		//alertTwo.accept();
		//WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
		//System.out.println(result.getText());
		alertTwo.dismiss();
		WebElement resulttwo = driver.findElement(By.xpath("//p[@id='result']"));
		System.out.println(resulttwo.getText());
		
		//JSPrompt
		
		WebElement JSPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		JSPrompt.click();
		Thread.sleep(3000);
		Alert alertThree = driver.switchTo().alert();
		System.out.println(alertThree.getText());
		alertThree.sendKeys("Santo");
		Thread.sleep(3000);
		alertThree.accept();
		
	}
	
	@Test
	public void dropdown() throws InterruptedException {
		
		//HomePage		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		//Handling DropDown
		Select dropdown = new Select (driver.findElement(By.xpath("//select[@id='dropdown']")));
		dropdown.selectByVisibleText("Option 1");
		Thread.sleep(3000);
		dropdown.selectByVisibleText("Option 2");
		Thread.sleep(3000);
	}
	
	//Window Handle
	@Test
	public void windowhandle() throws InterruptedException {
		
		driver.get("https://www.daraz.com.bd/#?");
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://evaly.com/");
		Thread.sleep(2000);
	}
	
	//FrameHandle
	@Test
	public void frameHandle() throws InterruptedException {
		//HomePage
		driver.get("https://jqueryui.com/checkboxradio/");
		//HeadingText
		WebElement HeadingText = driver.findElement(By.xpath("//h1[@class='entry-title']"));
		System.out.println(HeadingText.getText());
		
		//iframeHandle
		WebElement iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);
		
		//Click on radio button
		WebElement RadioButton = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]"));
		RadioButton.click();
		Thread.sleep(2000);
		
		//Click on radio button2
		WebElement RadioButton2 = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[2]"));
		RadioButton2.click();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		//Text Message
		WebElement TextMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/p"));
		System.out.println(TextMessage.getText());
		Thread.sleep(2000);
		
		
	}

}
