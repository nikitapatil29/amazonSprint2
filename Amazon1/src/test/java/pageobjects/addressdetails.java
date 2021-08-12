package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addressdetails {
	WebDriver driver;

	public addressdetails(WebDriver driver) {
		this.driver = driver;
	}

	public void selectAddress() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"address-book-entry-1\"]/div[2]/span")).click();
		Thread.sleep(3000);

	}

}
