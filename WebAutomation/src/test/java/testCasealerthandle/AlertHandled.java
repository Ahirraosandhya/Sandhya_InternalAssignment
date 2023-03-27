package testCasealerthandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertHandled {
@Test
	public  void alertpopup() throws InterruptedException {
	
		String text = "Sandhya";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sandhya.A\\eclipse-workspace\\WebAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(2000);	
		
//		AlertHandle
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
//confirm alert		
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();
		
//	Prompt alert
//		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
//		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().sendKeys(text);
//		Thread.sleep(2000);
//		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
		
	}

}
