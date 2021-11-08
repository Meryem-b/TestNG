package pages;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CantFindProduct {

	WebDriver driver;
	WebElement searchBox;

	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);

		driver.get("https://www.kitapyurdu.com/");
		
	}


	@Given("Enter the search word3")
	public void enter_the_search_word2() {
		searchBox = driver.findElement(By.cssSelector("input#search-input"));
		searchBox.sendKeys("yüz yıllık yalnızlık1");
	}

	@And("Click the search button3")
	public void click_the_search_button2() {
		driver.findElement(By.cssSelector("span.button-search")).click();
	}

	@When("Find Aradim Bulamadim Button Click it")
	public void find_aradim_bulamadim_button_click_it() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/a[2]")).click();
	}

	@Then("Control Page")
	public void control_page() {
		assertTrue(driver.findElement(By.linkText("İletişim")).isDisplayed());
		System.out.println("test50");
	}
	
	@After
	public void closed() {
		driver.close();
	}
}
