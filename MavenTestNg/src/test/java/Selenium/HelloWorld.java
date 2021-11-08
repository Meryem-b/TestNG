package Selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorld {
	
  @Test
  public void test1() {
	  assertEquals(false, false);
  }
  
  @Test
  public void test2() {
	  WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:

  }
}