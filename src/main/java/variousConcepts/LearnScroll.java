package variousConcepts;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LearnScroll {
WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login/"); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
		//STORING WEB ELEMENT
		//ELEMENT LIBERARY
		
		//STORING WEB ELEMENT USING WEBELEMENT CLASS OR INTERFACE
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement USERPASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SINGIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		
		//driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys("demo@techfios.com");
	   
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		USERPASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SINGIN_BUTTON_ELEMENT.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,200)");
		
		Thread.sleep(2000);
		js.executeScript("scroll(0,50)");

	}
	
	
}