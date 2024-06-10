
package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCart {

	String productName = "ADIDAS ORIGINAL";

	WebDriver driver;

	public MyCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	public Boolean productNamedoCheck() {

		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public ShippingDetails clickCheckOut() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,300)");
		 Thread.sleep(4000);
		checkoutButton.click();
		return new ShippingDetails(driver);
	}

}
