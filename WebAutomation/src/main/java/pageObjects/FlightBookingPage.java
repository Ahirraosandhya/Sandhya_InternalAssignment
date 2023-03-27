package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.utilities.BaseClass;

public class FlightBookingPage extends BaseClass {

	public void autoSuggestiveDropdwn() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				System.out.println(option.getText());
				break;
			}
		}
	}

	public void selectChkBox() throws InterruptedException {
		System.out.println(driver.findElement(By.xpath("//label[text()=' Senior Citizen']")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()=' Senior Citizen']")).click();
//		System.out.println(driver.findElement(By.xpath("//label[text()=' Senior Citizen']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[text()=' Senior Citizen']")).isSelected());
		Thread.sleep(2000);

//count number of chkbox
		System.out.println("Number of checkbox:" + driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}

	public void dropDwnSelectPassenger() throws InterruptedException {
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

	public void dynamicDropDwnFromTo() throws InterruptedException {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='PNQ']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@value='BLR'])[2]"));
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.click();
		String city = driver
				.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.getText();
		Assert.assertEquals(city, "Bengaluru (BLR)");
		System.out.println(driver
				.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.getText());
		Thread.sleep(3000);
//		Calender select current date //tbody//td[@data-handler='selectDay']/a[@class='ui-state-default ui-state-highlight']
		driver.findElement(By.xpath("//tbody//td[contains(@class,'today')]/a")).click();
		driver.findElement(By.xpath("//span[@class='btn-find-flight-home']//input[@type='submit']")).click();
	}

}
