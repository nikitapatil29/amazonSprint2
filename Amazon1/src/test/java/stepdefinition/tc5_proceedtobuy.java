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
import pageobjects.addressdetails;
import pageobjects.cart;
import pageobjects.launch;
import pageobjects.login;
import pageobjects.paymentoptions;
import pageobjects.placeorder;
public class tc5_proceedtobuy {
	public WebDriver driver= new ChromeDriver();
	launch lc= new launch(driver);
	login log=new  login(driver);
	cart cart= new cart(driver);
	addressdetails ad= new addressdetails(driver);
	paymentoptions pay=new paymentoptions(driver);
	placeorder order=new placeorder(driver);
	
	@AfterStep("@Launch6") public void addScreenshot(Scenario scenario) {
		  
		  final byte[] screenshot = ((TakesScreenshot)
		  driver).getScreenshotAs(OutputType.BYTES); scenario.attach(screenshot,
		  "image/png", "image");
		  
		  }
	@Given("when the user enter valid credentials {string},{string} is on the users home page")
	public void when_the_user_enter_valid_credentials_is_on_the_users_home_page(String string, String string2) throws InterruptedException {
		String username = string;
		String password=string2;
		lc.openapp();
		log.clicksignin();	
		log.enterdetails(username,password);log.verifytitle();
	}

	@When("The users proceeds to buy from the cart")
	public void the_users_proceeds_to_buy_from_the_cart() throws InterruptedException{
		
		cart.opencart();
	}


	@When("User select and confirms the delivery address")
	public void user_select_and_confirms_the_delivery_address() throws InterruptedException {
		ad.selectAddress();
	}

	@When("User verify payment options")
	public void user_verify_payment_options() throws InterruptedException {
		pay.verifyOptions();
	}

	@Then("User select one payment options")
	public void  user_select_one_payment_options() throws InterruptedException {
		pay.selectpaymentOption();
		pay.enterupi();
		pay.verifyupi();
		pay.continuetoplaceorder();
		
	}
	@Then("Verify  place order page")
	public void verify_place_order_page() throws InterruptedException {
	    order.verifypage();
	    //lc.exitBrowser();
	}
	@After("@Launch6") public void exitBrowser() throws InterruptedException {
		  
		  lc.exitBrowser(); }
	
}
