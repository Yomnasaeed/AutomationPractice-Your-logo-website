package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static WebDriver driver;
	
	
	public String email = "tessstttt51654@gmail.com";
	public String password = "12345678";
	
	@BeforeSuite
	public void startDriver()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		
	}

	
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
}
