package com.shopingcart;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageObjects.LandingPage;
import pageObjects.ProductCatlouge;

public class SubmitOrderTest extends BaseTest
{
	private String productName;

	@Test
	public void submitOrder () throws InterruptedException, IOException
	{
		productName ="zara coat 3";

		landingPage.loginToApplication("sandhya@123.com", "Sandy@123");
		Thread.sleep(2000);
//		Assert.assertEquals("//div[contains(text(),'Incorrect email or password.')] ","Incorrect email or password.");	
		ProductCatlouge productCatalg = new ProductCatlouge(driver);
//		productCatalg.goToCartPage();
		
		List<WebElement> product = productCatalg.getProductList();
		productCatalg.addProductT0Cart(productName);
		System.out.println("Product Name:" +productName);	
		
	}
	
	
	

}
