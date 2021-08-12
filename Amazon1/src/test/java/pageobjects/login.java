package pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login {
	WebDriver driver;

	public login(WebDriver driver) {
		this.driver = driver;
	}

	public void clicksignin() {
		WebElement signin = driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a"));
		boolean b1 = signin.isDisplayed();
		if (b1 == true) {
			signin.click();
		}
	}

	public void enterdetails(String string, String string2) throws InterruptedException {

		WebElement email = driver.findElement(By.name("email"));
		boolean b1 = email.isDisplayed();
		if (b1 == true) {
			email.sendKeys(string);
		}

		WebElement continue1 = driver.findElement(By.id("continue"));
		boolean b2 = continue1.isDisplayed();
		if (b2 == true) {
			continue1.click();
		}
		WebElement password = driver.findElement(By.name("password"));
		boolean b3 = password.isDisplayed();
		if (b3 == true) {
			password.sendKeys(string2);
		}
		WebElement signin = driver.findElement(By.id("signInSubmit"));
		boolean b4 = signin.isDisplayed();
		if (b4 == true) {
			signin.click();

		}

		Thread.sleep(3000);
	}

	public void verifytitle() {
		String expect = driver.getCurrentUrl();
		String actual = "https://www.amazon.in/?ref_=nav_custrec_signin&";
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		assertTrue(expect.equals(actual));

	}

	public void enterinvaliddetails(String username, String password2) throws InterruptedException {

		WebElement email = driver.findElement(By.name("email"));
		assertTrue(email.isDisplayed());
			email.sendKeys(username);

		WebElement continue1 = driver.findElement(By.id("continue"));
		assertTrue(continue1.isDisplayed());
			continue1.click();
	
		WebElement password = driver.findElement(By.name("password"));
		assertTrue(password.isDisplayed());	
			password.sendKeys("password2");
			Thread.sleep(3000);
		WebElement signin = driver.findElement(By.id("signInSubmit"));
		assertTrue(signin.isDisplayed());
			signin.click();

		Thread.sleep(3000);

	}

	public void verifyerrormessage() {

		String expect = driver.findElement(By.xpath("//*[@id=\"auth-warning-message-box\"]/div/h4")).getText();
		String actual = "Important Message!";
		assertTrue(expect.equals(actual));

	}

}
