package pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class register {
	WebDriver driver;

	public register(WebDriver driver) {
		this.driver = driver;
	}

	public void clickregister() {
		WebElement list = driver.findElement(By.id("nav-link-accountList"));
		Actions action = new Actions(driver);
		action.moveToElement(list).build().perform();

		WebElement starthere = driver.findElement(By.linkText("Start here."));
		boolean b = starthere.isDisplayed();
		if (b = true) {
			starthere.click();
		}
	}

	public void enterName(String name) {
		WebElement yourname = driver.findElement(By.name("customerName"));
		boolean b = yourname.isDisplayed();
		if (b = true) {
			yourname.sendKeys(name);
		}
	}

	public void enterMobileNumber(String mobile) {
		WebElement phone = driver.findElement(By.id("ap_phone_number"));
		boolean b = phone.isDisplayed();
		if (b = true) {
			phone.sendKeys(mobile);
		}
	}

	public void enterEmail(String email) {

		WebElement ap_email = driver.findElement(By.id("ap_email"));
		boolean b1 = ap_email.isDisplayed();

		if (b1 == true) {
			ap_email.sendKeys(email);
		}
	}

	public void enterPassword(String password) throws InterruptedException {
		WebElement pass = driver.findElement(By.id("ap_password"));
		assertTrue(pass.isDisplayed());
			pass.sendKeys(password);
			Thread.sleep(3000);
		

		WebElement continue1 =driver.findElement(By.id("continue"));
		assertTrue(continue1.isDisplayed());
			continue1.click();
		Thread.sleep(3000);
	}

	public void assertcheck(String msg) {
		String expect = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText();
		String actual = "There was a problem";
		assertTrue(expect.equals(actual));
		
	}

}
