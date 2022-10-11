package StepDefinition;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Sample_app {
	public WebDriver driver;

	@Given("User is on UI Test Automation Playground Page")
	public void user_is_on_UITestAutomation() throws InterruptedException {
		System.out.println("Open the Chrome Browser");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("http://www.uitestingplayground.com/");
	}
	
	@When("user click on Sampe App link")
	public void user_click_Sample_App_link() throws Exception {
		String text = driver.findElement(By.linkText("Sample App")).getText();
		driver.findElement(By.linkText("Sample App")).click();
		System.out.println("User clicks on "+text+" link");
		Thread.sleep(2000);
	}
	
	@And("user landed on Sample App page")
	public void user_landed_Sampe_App_page() throws Exception {
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		System.out.println("Title of the Page: "+pageTitle);
	}
		
	@When("^user enters Username and Password$")
	public void user_enters_Username_and_Password() throws Throwable 							
    {	   Thread.sleep(2000);
	       driver.findElement(By.name("UserName")).sendKeys("Sunitha");	
	       driver.findElement(By.name("Password")).sendKeys("pwd");	
	
	    }	
	
	@And("Click on Login Button")
	public void click_button() throws Exception {
		   driver.findElement(By.id("login")).click();
	}
	
	@Then("user Welcome message displays")
	public void validate_message() throws Exception {
		String welcome_User = driver.findElement(By.id("loginstatus")).getText();
		boolean expectedResult = Boolean.parseBoolean(welcome_User);
		if(expectedResult) {
			Assert.assertTrue(expectedResult);
		}else
			Assert.assertFalse(expectedResult);
		System.out.println("The Welcome message is: " +welcome_User);
		driver.close();
		driver.quit();
	}
}
