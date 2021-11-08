package pages;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JustSearch {

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
		Boolean pageControl = driver.findElement(By.cssSelector("img[title='kitapla buluşmanın en kolay yolu!']"))
				.isDisplayed();

		assertTrue(pageControl);
		System.out.println("test00");
	}

	@Given("Click Search Box")
	public void click_search_box() {
		searchBox = driver.findElement(By.cssSelector("input#search-input"));
	}

	@When("Enter the search true word")
	public void enter_the_search_true_word() {
		searchBox.sendKeys("yüz yıllık yalnızlık");
	}

	@When("Click the search button")
	public void click_the_search_button() {
		driver.findElement(By.cssSelector("span.button-search")).click();
	}

	@Then("Happen Show Product")
	public void happen_show_product() {
		Boolean outcomeText = driver.findElement(By.className("ribbon-text")).isDisplayed();
		assertTrue(outcomeText);
		System.out.println("test20");
	}

	@When("Enter the search false word")
	public void enter_the_false_search_word() {
		searchBox.sendKeys("yüz yıllık yalnızlık1");
	}

	@Then("Don't Happen Show Product")
	public void don_t_happen_show_product() {
		
		String warnıng = driver.findElement(By.className("no-result")).getText();

		assertTrue(warnıng.startsWith("Üzgünüz, aramanıza "));
		System.out.println("test21");
	}
	
	@After
	public void closed() {
		driver.close();
	}
}
