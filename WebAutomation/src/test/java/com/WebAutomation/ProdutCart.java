package com.WebAutomation;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utilities.BaseClass;

public class ProdutCart extends BaseClass {
//	public WebDriver driver = BaseClass.driver;
@Test
	public  void addProduct()  {

			driver.findElement(By.xpath("//input[@id='userEmail'])")).sendKeys("sandhya@123.com");
			driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Sandy@123");
			driver.findElement(By.xpath("//input[@id='login']")).click();
			
//			List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
			
//			products.stream().filter(product->
//			product.findElement(By.xpath("")).getText().equals("");
		}



}
