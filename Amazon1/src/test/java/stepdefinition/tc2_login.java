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

public class tc2_login {
	public WebDriver driver = new ChromeDriver();

	launch lc = new launch(driver);
	login log = new login(driver);

	@AfterStep("@Launch3")
	public void addScreenshot(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");

	}

	@Given("when the user is in the login page")
	public void when_the_user_is_in_the_login_page() {
		lc.openapp();
		log.clicksignin();

	}

	@When("the user enters the valid username {string} and password {string}")
	public void the_user_enters_the_valid_username_and_password(String string, String string2)
			throws InterruptedException {
		String username = string;
		String password= string2;
		log.enterdetails(username, password);
	}

	@Then("the system allows the user to navigate to the HOME page")
	public void the_system_allows_the_user_to_navigate_to_the_HOME_page() {
		log.verifytitle();
		// lc.exitBrowser();
	}

	@After("@Launch3")
	public void exitBrowser() throws InterruptedException {

		lc.exitBrowser();
	}

}
