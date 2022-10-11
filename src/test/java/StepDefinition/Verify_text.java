package StepDefinition;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Verify_text {
	WebDriver driver = null;;
	@Given("User is on UI Test Automation Playground")
	public void user_is_on_UITAP_Page() throws InterruptedException {
		System.out.println("Open the Chrome Browser");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("http://www.uitestingplayground.com/");
	}

	@When("user click on Verify Text link")
	public void user_clicks_verify_text_link() throws Exception {
		Thread.sleep(2000);
		String text = driver.findElement(By.linkText("Verify Text")).getText();
		driver.findElement(By.linkText("Verify Text")).click();
		System.out.println("User clicks on "+text+" link");
	}

	@And("user landed on Verify Text page")
	public void user_land_verify_text_page() throws Exception {
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		System.out.println("Title of the Page: "+pageTitle);
	}
	@Then("Validate the scenario in the Playground section")
	public void playground_verify_text() throws InterruptedException {
		String verify_text = driver.findElement(By.xpath("//span[normalize-space(.)='Welcome UserName!']")).getText();
		System.out.println("The text Value from DOM after trimming the spaces are "+verify_text);
		driver.close();
	}

}
