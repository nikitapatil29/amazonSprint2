package stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import pageobjects.login;
import util.ExcelReader;

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
	@When("the user enters the valid username and invalid password {string},{int}")
	public void the_user_enters_the_valid_username_and_invalid_password(String string, Integer int1)  throws InterruptedException, InvalidFormatException, IOException {
		
		String sheetName = string;
		int rowNumber= int1;
		ExcelReader reader = new ExcelReader();

        List<Map<String,String>> testData = 

                reader.getData("C:\\Users\\npatil5\\Documents\\eclipseforcucumber\\workspace-new\\dataApache.xlsx", sheetName);

       String username = testData.get(rowNumber).get("username");
       String password = testData.get(rowNumber).get("password");
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
