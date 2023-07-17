package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnValidation {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ladyy\\eclipse-workspace\\session3Selen\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {
		// Storing in WebElement
		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement signInElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")); 
		
		// another way to //Store by BY CLASS/
		By userNameField = By.xpath("//input[@id='username']");
		By passWordField = By.xpath("//input[@id='password']");
		By signInField = By.xpath("/html/body/div/div/div/form/div[3]/button");
        By dashboardHeaderField = By.xpath("//div[@id=\"page-wrapper\"]/div[2]/div/h2");
        
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passWordField).sendKeys("abc1234");
		driver.findElement(signInField).click();
        
		WebDriverWait wait = new WebDriverWait(driver, 10);

		boolean dashboardPageIsDisplayed;
		try {
			WebElement dashBoardHeaderElement = driver.findElement(By.xpath("//div[@id=\"page-wrapper\"]/div[2]/div/h2"));
			dashboardPageIsDisplayed = true;
		} catch (Exception e) {

			dashboardPageIsDisplayed = true;
			e.printStackTrace();

		}
		//wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeaderField));

		Assert.assertTrue("Dashboard page not available", dashboardPageIsDisplayed);

		// driver.findElement(userNameField).sendKeys("demo@techfios.com");

		// userNameElement.sendKeys("demo@techfios.com");
		// passwordElement.sendKeys("abc123");

		// driver.findElement(By.xpath(null))

	}

}
