package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.launch;

public class tc1_launch {
	public WebDriver driver= new ChromeDriver();
	launch lc= new launch(driver);
	
	
	  @AfterStep("@Launch2") public void addScreenshot(Scenario scenario) {
	  
	  final byte[] screenshot = ((TakesScreenshot)
	  driver).getScreenshotAs(OutputType.BYTES); scenario.attach(screenshot,
	  "image/png", "image");
	  
	  }
	 

  @Given("the user opens application")
  public void the_user_opens_application() {
    lc.openapp();
  }

  @When("the user verify title")
  public void the_user_verify_title() {
	  lc.verifytitle();
  }

  @Then("the user close browser")
  public void the_user_close_browser() throws InterruptedException {
	  Thread.sleep(2000);
	
  }
	
	  @After("@Launch2") public void exitBrowser() throws InterruptedException {
	  
	  lc.exitBrowser(); }
	 
}
