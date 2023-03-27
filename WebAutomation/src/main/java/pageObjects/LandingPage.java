package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	public  LandingPage(WebDriver driver)
	{
//		this.driver = driver;
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userid;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement passwordEle;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	
	public void loginToApplication(String email, String password) 
	{
		userid.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
//	public void goTo()
//	{
//		driver.get("https://rahulshettyacademy.com/client");
//	}
//	
}
