package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearniFrame {
WebDriver driver;
	
	@Test
	public void launchBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/8/docs/api/"); 
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt")).click();
		
		
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Composite")).click();
		
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("AlphaComposite")).click();
	}
	 
}
