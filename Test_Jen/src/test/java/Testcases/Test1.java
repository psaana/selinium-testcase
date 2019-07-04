package Testcases;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

	WebDriver driver;

	Properties p=new Properties();

	@Test
	public void rajesh()
	{
		// Enter user name , password and enter login button

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(p.getProperty("username"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(p.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		System.out.println("User name::" +p.getProperty("username"));
		System.out.println("Password::" +p.getProperty("password"));
	}

	@BeforeTest
	public void chinna() throws InterruptedException
	{
		try {
			InputStream input = new FileInputStream("./src/main/resources/Properties/config.properties");
			p.load(input);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Chrome browser

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--headless");
                Options.addArguments("--no-sandbox");
		Options.addArguments("--disable-infobars");
		driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
		System.out.println("URL ::" + p.getProperty("URL"));
		Thread.sleep(6000);
	}
	 if (driver.getPageSource().contains("I'm Feeling Lucky")) {
                        System.out.println("Pass");
                } else {
                        System.out.println("Fail");
                }

	@AfterTest
	public void sudha()
	{
		// Close the browser

		driver.close();
	}
}
