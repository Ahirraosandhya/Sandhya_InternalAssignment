package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.LandingPage;

public class BaseTest {
	public static WebDriver driver;
	public LandingPage landingPage;

	public WebDriver intializeDriver() throws IOException {

//		Properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Resources//GlobalData.properties");
//		this method will extract all the key values pair from properties file .load() which expects arguments where we sending the file
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Sandhya.A\\eclipse-workspace\\WebAutomation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/client");

		}
//		else if (browserName.equalsIgnoreCase("firefox")) {
//			// firfoxbrowser
//		} else if (browserName.equalsIgnoreCase("edge")) {
////			Edgedriver
//			System.setProperty("webdriver.edge.driver", "edge.exe");
//			driver = new EdgeDriver();
//		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshots\\" +testcaseName + ".png ";
		File desti = new File(path);
		FileUtils.copyFile(source, desti);
		return path;
	}
	
//	method to prepare common driver for all TC
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver = intializeDriver();
		landingPage = new LandingPage(driver);
//		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
