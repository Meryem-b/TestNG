package Google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	WebDriver driver;
	WebElement searchBox;
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	@When("Hit Google on the browser")
	public void hit_google_on_the_browser() {
		driver.get("https://www.google.com/");
		WebElement cookieAcceptBtn = driver.findElement(By.id("L2AGLb"));
		cookieAcceptBtn.click();
	}
	@Then("Enter {string} in the search  box")
	public void enter_in_the_search_box(String string) {
		searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(string);
		
	}
	@Then("Search it")
	public void search_it() {
		searchBox.submit();
	}
	
}