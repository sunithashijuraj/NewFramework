package StepDefinition;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Dynamic_id {
	WebDriver driver = null;
	@Given("^User is on UITAP Page$")
	public void user_is_on_UITAP() throws InterruptedException {
		System.out.println("Open the Chrome Browser");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("http://www.uitestingplayground.com/");
	
	}

    @When("^User click on Dynamic ID link$")
	public void user_click_on_Dynamic_ID() throws InterruptedException {
		String text = driver.findElement(By.linkText("Dynamic ID")).getText();
		driver.findElement(By.linkText("Dynamic ID")).click();
		System.out.println("User clicks on "+text+" link");
	}

	
	@Then("^user landed on Dynamic ID Page$")
	public void user_land_Dynamic_ID_page() throws Exception {
		String pageTitle = driver.getTitle();
		System.out.println("Title of the Page: "+pageTitle);
	}
	@Then("^Validate the button in the Playground section having dynaic id value$")
	public void playground_Dynamic_ID1() throws InterruptedException {
		String verify_text = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary')]")).getText();
		System.out.println("The Button name in the Dynamic id is "+verify_text);
		driver.close();
	}

}