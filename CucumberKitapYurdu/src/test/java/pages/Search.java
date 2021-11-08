package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Search {
	
	WebDriver driver;
	WebElement searchBox;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		driver = new ChromeDriver();
		driver.get("https://www.kitapyurdu.com/");
		driver.manage().window().maximize(); 
	}
	
	@Given("Found pages")
	public void found_pages() {
		  driver.findElement(By.xpath("//*[@id=\'mainNav\']/div[1]/ul/li[1]/div[2]/ul/li[1]/span")).click();
	
		   driver.findElement(By.xpath("//li/span[contains(text(), 'Tüm Kitaplar')]")).click();

		   driver.findElement(By.xpath("//*[contains(text(), 'Orjinal Dil')]")).click();
	}

	@When("Click the book")
	public void click_the_book(){
		  driver.findElement(By.xpath("//*[contains(text(),'Şeker Portakalı (Ciltsiz)')]")).click();
		 
	}


	@Then("Navigate back")
	public void navigate_back() throws InterruptedException {
		   String url = "https://img.kitapyurdu.com/v1/getImage/fn:11462950/wh:true/wi:220";
		   driver.get(url);
		 
	       driver.navigate().back();  //sayfada geri gider
	 }
	
	
	@When("Rate star")
	public void rate_star(){
		driver.findElement(new By.ByCssSelector(".pr_rating-stars")).click();
	       
		 
	}


	@Then("Cart button")
	public void cart_button() throws InterruptedException {
	       driver.findElement(By.xpath("//*[@id=\"button-cart\"]/span")).click();
	       
	       driver.findElement(By.xpath("//*[@id=\"cart\"]/div[1]/div[2]/h4")).click();
	       
	       driver.findElement(new By.ByCssSelector(" .button[id='js-cart']")).click();
	 }
	
	@When("Buy ")
	public void buy(){
		 driver.findElement(new By.ByCssSelector("input[type='checkbox'][class='cart-select']")).click();
		   driver.findElement(By.linkText("Satın Al")).click();
		   
	}


	@After
	public void cleanUp() throws InterruptedException {
		Thread.sleep(300);
	    driver.quit();
	}
	
}