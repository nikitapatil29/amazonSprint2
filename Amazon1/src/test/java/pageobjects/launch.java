package pageobjects;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class launch {
	WebDriver driver;
	public launch(WebDriver driver) {
		this.driver=driver;
	}

	public void openapp() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	public void exitBrowser() {
		  driver.quit();
		
	}

	public void verifytitle() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expect=driver.getTitle();
		String actual="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		assertTrue(expect.equals(actual)) ;
			//assert.fail(e.printStackTrace());
			//System.out.println("exception caught");	
	}
}
