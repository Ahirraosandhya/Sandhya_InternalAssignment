package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import abstractComponents.AbstractComponent;

public class ProductCatlouge extends AbstractComponent {

	WebDriver driver;

	public ProductCatlouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='card']")
	List<WebElement> products;

	By productsBy = By.xpath("//div[@class='card']");
//	By addToCart = By.xpath("//*[contains(text(),'" + productName
//	+ "')]/parent::h5/following-sibling::button[contains(normalize-space(),'Add To Cart')]");

	public List<WebElement> getProductList() throws InterruptedException {
//		waitForElementToAppear(productsBy);
		Thread.sleep(2000);
		return products;
	}

	public WebElement getProductByName(String productName) throws InterruptedException {
		WebElement prod = getProductList().stream().filter(product -> product
				.findElement(By.xpath("//b[contains(text(),'zara coat 3')]")).getText().equals(productName)).findFirst()
				.orElse(null);
		Thread.sleep(3000);
		return prod;

	}
//used prod here th used initelment again
	public void addProductT0Cart(String productName) throws InterruptedException {
//		WebElement prod = getProductByName(productName);
//		prod.findElement(addToCart).click();
		WebElement prod = driver.findElement(By.xpath("//*[contains(text(),'" + productName
				+ "')]/parent::h5/following-sibling::button[contains(normalize-space(),'Add To Cart')]"));
		prod.click(); //click Add To Product
//		prod.findElement(addToCart).click(); or to above line and from 20 line number
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();//button[@routerlink='/dashboard/cart']
		Thread.sleep(2000);
		
//		 code to validation of item in cart//*[@class='cartSection']/h3
		List <WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		Thread.sleep(3000);
		
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equals(productName));
		Assert.assertFalse(match);
		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();//checkoutbutton
		Thread.sleep(1000);
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();

		Thread.sleep(2000);
	}

}
