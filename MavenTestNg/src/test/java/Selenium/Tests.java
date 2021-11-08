package Selenium;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tests {

	WebDriver driver;
	WebElement searchBox;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testConnection() {
		driver.get("http://www.google.com/");
	}

	@Test(dependsOnMethods = "testConnection")
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
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
