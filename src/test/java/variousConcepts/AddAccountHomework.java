package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAccountHomework {

	WebDriver driver;

	By userNameField = By.xpath("//input[@id='username']");
	By passWordField = By.xpath("//input[@id='password']");
	By signInButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By customerMenuField = By.xpath("//span[contains(text(), 'Customers')]");
	By addCustomerField = By.xpath("//a[contains(text(),'Add Customer')]");
//	By addContactHeaderField = By.xpath("//div[@id='page-wrapper']/div[3]/div[1]/div/div/div/div[1]/h5");
	By nameField = By.xpath("//input[@id='account']");
	By emailField = By.xpath("//div[@class='ibox float-e-margins']/div[2]/descendant::div/div[1]/descendant::div[6]/input");
	By phoneNumberField = By.xpath("//input[@id='phone']");
	By addressField = By.xpath("//input[@id='address']");
	By cityField = By.xpath("//input[@id='city']");
	By stateField = By.xpath("//input[@id='state']");
	By zipCodeField = By.xpath("//input[@id='zip']");
	By tagField = By.xpath("//ul[@class='select2-selection__rendered']");
	By submitButton = By.xpath("//button[@id='submit']");
	// Last step to verify info is there on List Of customers
	By listCustomerElementField = By.xpath("//a[contains(text(), 'List Customers')]");
	By verifyingName = By.xpath("//div[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/table/tbody/tr[1]/td[3]/a");

	@Before

	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ladyy\\eclipse-workspace\\session3Selen\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void AddAccount() throws InterruptedException {
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passWordField).sendKeys("abc123");
		driver.findElement(signInButtonField).click();
		Thread.sleep(2000);
		driver.findElement(customerMenuField).click();
		driver.findElement(addCustomerField).click();
		driver.findElement(nameField).sendKeys("Vannessa");

		// Storing Select element in WebELement class
		WebElement selectCompanyOptionsField = driver.findElement(By.xpath(("//select[@id='cid']")));
		Select sel = new Select(selectCompanyOptionsField);
		sel.selectByVisibleText("Bank Of America");

		driver.findElement(emailField).sendKeys("Demo12345@techfios.com");
		driver.findElement(phoneNumberField).sendKeys("888-112-2223");
		driver.findElement(addressField).sendKeys("1550 Griffin ln");
		driver.findElement(cityField).sendKeys("Dallas");
		driver.findElement(stateField).sendKeys("Texas");
		driver.findElement(zipCodeField).sendKeys("75024");
		// Select Option using WebElement Class
		WebElement selectCountriesOption = driver.findElement(By.xpath("//select[@id='country']"));
		Select sel2 = new Select(selectCountriesOption);
		sel2.selectByVisibleText("Uruguay");

		driver.findElement(submitButton).click();
		Thread.sleep(2000);
		driver.findElement(listCustomerElementField).click();
		driver.findElement(By.xpath("//input[@id='foo_filter']")).sendKeys("Vannessa");

	}

//	@After
	public void tearDown() {

		driver.close();
		driver.quit();
	}
}
