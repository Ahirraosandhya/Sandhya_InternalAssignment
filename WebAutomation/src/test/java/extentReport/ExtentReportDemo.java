package extentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
//to consolidates the report
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Sandhya Patil");
		
	}
	
@Test
public void intialDemo()
{
	ExtentTest test = extent.createTest("First Demo");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sandhya.A\\eclipse-workspace\\WebAutomation\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Register.html");
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("sandhya");
	test.fail("Result not match");//explicitly fail to check fail report also
	extent.flush();
	
	
}

}
