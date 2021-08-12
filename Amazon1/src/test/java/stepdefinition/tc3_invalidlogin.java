package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.launch;
import pageobjects.login;

public class tc3_invalidlogin {
	public WebDriver driver= new ChromeDriver();

	launch lc= new launch(driver);
	login log = new login(driver);
	@AfterStep("@Launch4") public void addScreenshot(Scenario scenario) {
		  
		  final byte[] screenshot = ((TakesScreenshot)
		  driver).getScreenshotAs(OutputType.BYTES); scenario.attach(screenshot,
		  "image/png", "image");
		  
		  }
	@Given("when the user on the login page")
	public void when_the_user_on_the_login_page() {
	    lc.openapp();
	    log.clicksignin();
	 
	}
	@When("the user enters the valid username {string} and invalid password {string}")
	public void the_user_enters_the_valid_username_and_invalid_password(String string, String string2)  throws InterruptedException {
		String username = string;
		String password= string2;
		log.enterinvaliddetails(username,password);
	}
	@Then("the system gives error message")
	public void the_system_gives_error_message() {
	    log.verifyerrormessage();
	  //  lc.exitBrowser();
	}
	@After("@Launch4") public void exitBrowser() throws InterruptedException {
		  
		  lc.exitBrowser(); }

}
