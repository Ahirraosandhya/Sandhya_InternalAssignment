package com.WebAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_StaticPageForm {
	@Test
	public  void launchDriver() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sandhya.A\\eclipse-workspace\\WebAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("sandhya");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Patil");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9970700873");
		driver.findElement(By.xpath("(//input[@name='radiooptions'])[2]")).click();
		driver.findElement(By.id("checkbox1")).click();
//		Select dropOption = new Select(driver.findElement(By.id("countries")));
		driver.findElement(By.id("countries")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("h1")).getText());
//	Validation using Assert	
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Automation Demo Site");
//Static dropdown handle	
		
		WebElement staticdrpDown = driver.findElement(By.id("country"));
		Select dropDwn = new Select(staticdrpDown);
		dropDwn.selectByValue("India");
		System.out.println(dropDwn.getFirstSelectedOption().getText());	
		dropDwn.selectByIndex(4);
		System.out.println(dropDwn.getFirstSelectedOption().getText());	
		dropDwn.selectByVisibleText("Denmark");
		System.out.println(dropDwn.getFirstSelectedOption().getText());			
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
		driver.close();				

	}

}
