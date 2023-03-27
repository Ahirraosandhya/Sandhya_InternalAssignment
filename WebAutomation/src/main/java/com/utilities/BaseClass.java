package com.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pageObjects.LandingPage;


public class BaseClass {
	
	public static WebDriver driver;

	@BeforeClass
//	public WebDriver browserLaunch() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Sandhya.A\\eclipse-workspace\\WebAutomation\\Drivers\\chromedriver.exe");
//
//		driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		driver.manage().window().maximize();
//		return driver;
//		code is shited into BaseTest class

//	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshots\\" +testcaseName + ".png ";
		File desti = new File(path);
		FileUtils.copyFile(source, desti);
		return path;
	}
	
//	@BeforeMethod(alwaysRun=true)
//	public LandingPage launchApplication() throws InterruptedException
//	{
//		driver = browserLaunch();
//		LandingPage loginpg = new LandingPage(driver);
//		return loginpg;
//		
//	}
	


}
