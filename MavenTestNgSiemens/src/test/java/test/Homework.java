package test;

import static org.testng.Assert.assertNotNull;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Homework {
	WebDriver driver;
	WebElement searchBox;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
	}

	@Test
	public void login() {
		driver.get("http://www.google.com/");
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:
	}

	@Test(dependsOnMethods = "login")
	public void testFindSearchBox() {
		searchBox = driver.findElement(By.name("q"));

		assertNotNull(searchBox);
	}

	@Test(dependsOnMethods = "testFindSearchBox")
	public void testSendKeysToSearchBox() {
		searchBox.sendKeys("selenium");
	}

	@Test(dependsOnMethods = "testSendKeysToSearchBox")
	public void testSubmitButton() {
		searchBox.submit();
	}

	@AfterClass
	public void cleanUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
