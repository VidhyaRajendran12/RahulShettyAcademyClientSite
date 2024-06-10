package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractClass;

public class ConfirmOrder extends AbstractClass{

	WebDriver driver;

	public ConfirmOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement toast;
	
	By findBy = By.cssSelector(".hero-primary");
	
	public String confirmationPage() throws InterruptedException {
		waitForElementToVisible(findBy);
		String confirmMessage = toast.getText();
		return confirmMessage;
	}
	
}
