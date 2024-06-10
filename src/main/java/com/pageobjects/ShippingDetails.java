package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.AbstractComponents.AbstractClass;

public class ShippingDetails extends AbstractClass {

	String productName = "ADIDAS ORIGINAL";

	WebDriver driver;

	public ShippingDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement enterCountry;

	@FindBy(css = ".actions a")
	WebElement placeorderButton;

	By findBy = By.cssSelector(".ta-results");
	By findBy1 = By.cssSelector(".actions a");

	public void enterShippingdetails() {
		enterCountry.sendKeys("India");
		waitForElementToVisible(findBy);
		enterCountry.sendKeys(Keys.ENTER);
	}

	public ConfirmOrder placeOrder() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		waitForElementToVisible(findBy1);
		placeorderButton.click();
		return new ConfirmOrder(driver);
	}

}
