package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class paymentoptions {
	WebDriver driver;

	public paymentoptions(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyOptions() throws InterruptedException {
		List<WebElement> radio = driver.findElements(By.name("ppw-instrumentRowSelection"));

		radio.get(0).click();
		Thread.sleep(2000);
		radio.get(1).click();
		Thread.sleep(2000);
		radio.get(2).click();
		Thread.sleep(2000);
		radio.get(3).click();
		Thread.sleep(2000);
	}

	public void selectpaymentOption() {
		List<WebElement> radio = driver.findElements(By.name("ppw-instrumentRowSelection"));
		boolean b = radio.get(2).isDisplayed();
		if (b == true) {
			radio.get(2).click();
		}
	}

	public void enterupi() {
		WebElement upi = driver.findElement(By.cssSelector("input[placeholder=\"Ex: MobileNumber@upi\"]"));
		boolean b = upi.isDisplayed();
		if (b == true) {
			upi.sendKeys("MobileNumber@upi");
		}
	}

	public void verifyupi() throws InterruptedException {
		WebElement verifybutton =driver.findElement(By.name("ppw-widgetEvent:ValidateUpiIdEvent"));
		boolean b = verifybutton.isDisplayed();
		if (b == true) {
			verifybutton.click();
		}
		
		Thread.sleep(3000);
	}

	public void continuetoplaceorder() throws InterruptedException {
		WebElement continue1 = driver.findElement(By.name("ppw-widgetEvent:SetPaymentPlanSelectContinueEvent"));
		boolean b2 = continue1.isDisplayed();
		if (b2 == true) {
			continue1.click();
		}
		Thread.sleep(3000);
	}

}
