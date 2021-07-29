package variousConcepts;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropDown {
   
	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
	    
	    
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
		
	@Test
	public void login() {
		Assert.assertEquals("login page not found!!!", "Login - iBilling", driver.getTitle());
	
		
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement USERPASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SINGIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		//WebElement DASHBOARD_BUTTON_ELEMENT =driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		//WebElement DASHBOARD_BUTTON_ELEMENT =driver.findElement(By.linkText("Dashboard"));
		//WebElement DASHBOARD_BUTTON_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
		
		
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		USERPASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SINGIN_BUTTON_ELEMENT.click();
		
		WebElement DASHBOARD_BUTTON_ELEMENT =driver.findElement(By.linkText("Dashboard"));
		WebElement CUSTOMERS_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
		WebElement ADDCUSTOMERS_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
		
		
		
		
		
		String actualDasgboardElement = DASHBOARD_BUTTON_ELEMENT.getText();
		
		//we are identfing the element and we are using gettext methods to get the text out of this element.
		System.out.println("=================" + actualDasgboardElement);
		Assert.assertEquals("deshboard page not found!!!", "Dashboard", actualDasgboardElement);
		
		CUSTOMERS_BUTTON_ELEMENT.click();
		ADDCUSTOMERS_BUTTON_ELEMENT.click();
		
		WebElement FULLNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"account\"]"));
		WebElement DROPDOWN_FIELD_ELEMENT = driver.findElement(By.xpath("//select[@id='cid']"));
		
		FULLNAME_FIELD_ELEMENT.sendKeys("LIKHON");
		Select sel = new Select(DROPDOWN_FIELD_ELEMENT);
		sel.selectByVisibleText("Techfios");
	//=====================================================================	
		//sel.getOptions();//it will bring all the dropdown options.
		//List<WebElement> options = sel.getOptions();
	//for(WebElement i: options){
	//	System.out.println(i.getText());
		//by doing this code you will get the all dropdown element is there it will print everthing
	//=============================================================================
	}

	
	
	
	
	
//	
//	@After
//	public void teardown() {
//		//driver.close();
//		driver.quit();
//	}
}
