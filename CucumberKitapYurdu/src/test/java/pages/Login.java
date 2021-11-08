package pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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

public class Login {

	WebDriver driver;

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

	@Given("Click Giris Yap Button")
	public void click_giris_yap_button() {
		driver.findElement(By.linkText("GiriÅŸ Yap")).click();
	}

	// Scenario: Kitap Yurdu Successful Login Test
	@When("Hit the email box and Write true email address in the email box")
	public void hit_the_email_box_and_write_true_email_address_in_the_email_box() {
		driver.findElement(By.id("login-email")).sendKeys("msemaa1@hotmail.com");
	}

	@And("Hit the password box and Write true password in the password box")
	public void hit_the_password_box_and_write_true_password_in_the_password_box() {
		driver.findElement(By.id("login-password")).sendKeys("Meryem12345");
	}

	@And("Click login button")
	public void click_login_button() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.className("ky-login-btn")).click();
	}

	@Then("Happen Successful Login")
	public void happen_successful_login() {
		WebElement recaptchaEnable = driver.findElement(By.xpath("/html/body/div[7]/div[1]"));
		assertNotNull(recaptchaEnable);
		System.out.println("test10");
	}

	// Scenario: Kitap Yurdu Unsuccessful Login Test
	@When("Hit the email box and Write false {} in the email box")
	public void hit_the_email_box_and_write_false_email_address_in_the_email_box(String emailaddress) {
		driver.findElement(By.id("login-email")).sendKeys(emailaddress);
	}

	@And("Hit the password box and Write false {} in the password box")
	public void hit_the_password_box_and_write_false_password_in_the_password_box(String password) {
		driver.findElement(By.id("login-password")).sendKeys(password);
	}

	@Then("Happen UnSuccessful Login")
	public void happen_un_successful_login() {
		WebElement userInfo = driver.findElement(By.cssSelector("a.common-sprite"));
		assertNotNull(userInfo);
		System.out.println("test11");
	}

	@After
	public void closed() {
		driver.close();
	}
}
