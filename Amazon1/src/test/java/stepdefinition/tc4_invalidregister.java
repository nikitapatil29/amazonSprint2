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
import pageobjects.register;

public class tc4_invalidregister {
	
	public WebDriver driver= new ChromeDriver();
	launch lc= new launch(driver);
	register r= new register(driver);
	@AfterStep("@Launch5") public void addScreenshot(Scenario scenario) {
		  
		  final byte[] screenshot = ((TakesScreenshot)
		  driver).getScreenshotAs(OutputType.BYTES); scenario.attach(screenshot,
		  "image/png", "image");
		  
		  }
	@Given("when the the user is in the registration page")
	public void when_the_the_user_is_in_the_registration_page() throws InterruptedException {
		lc.openapp();
		r.clickregister();
	}

	@When("the user enters in the Your name field {string}")
	public void the_user_enters_in_the_Your_name_field(String string) {
		String name = string;
		r.enterName(name);
	}

	@When("the user enters in the  Mobile number field\"{int}\"")
	public void the_user_enters_in_the_Mobile_number_field(int int1){
		String mobile=Integer.toString(int1);
		r.enterMobileNumber(mobile);
	}

	@When("the user enters in the  Email field {string}")
	public void the_user_enters_in_the_email_field(String string) {
		String email = string;
		r.enterEmail(email);
	}

	@When("the user enters in the  Password field {string}")
	public void the_user_enters_in_the_password_field(String string) throws InterruptedException {
		String password = string;
		r.enterPassword(password);

	}

	@Then("the System gives error message as expected {string}")
	public void the_system_gives_error_message_as_expected(String string) {
		String msg = string;
		 r.assertcheck(msg);
		//lc.exitBrowser();
	}
	@After("@Launch5") public void exitBrowser() throws InterruptedException {
		  
		  lc.exitBrowser(); }
}
