package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cart {
	WebDriver driver;

	public cart(WebDriver driver) {
		this.driver = driver;
	}

	public void opencart() {

		WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[5]"));
	boolean b= cart.isDisplayed();
	if(b==true) {
		cart.click();
	}
		
	WebElement proceedtoBuy = driver.findElement(By.name("proceedToRetailCheckout"));
	boolean b1= proceedtoBuy.isDisplayed();
			if(b1==true) {
				proceedtoBuy.click();
			}
	}
}
