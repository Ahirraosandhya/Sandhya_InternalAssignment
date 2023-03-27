package com.WebAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutosuggestionHandle {

	@Test
		public void autosuggestive() {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Sandhya.A\\eclipse-workspace\\WebAutomation\\Drivers\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				driver.manage().window().maximize();
				
				driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
				
				List<WebElement> options = driver.findElements(By.xpath(" //a[text()='India']"));
				for(WebElement option :options) {
					if(option.getText().equalsIgnoreCase("India"))
					{
						option.click();
						break;
					}
					
				}
	}

}
