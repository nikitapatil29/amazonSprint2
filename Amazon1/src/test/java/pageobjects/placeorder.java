package pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class placeorder {
	WebDriver driver;

	public placeorder(WebDriver driver) {
		this.driver = driver;
	}


	public void verifypage() throws InterruptedException {
		Thread.sleep(3000);
		String expect=driver.getTitle();
		String actual = "Place Your Order - Amazon.in Checkout";
		assertTrue(expect.equals(actual));
	}
}
