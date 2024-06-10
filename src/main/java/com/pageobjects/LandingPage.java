package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractClass;

public class LandingPage extends AbstractClass{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userName;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "[class*='flyInOut']")
	  WebElement errorMessage;
	 
	
	//WebElement errorToast = driver.findElement(By.cssSelector("[class*='flyInOut']"));
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public void enterCred(String emailID, String passWord) {
		userName.sendKeys(emailID);
		password.sendKeys(passWord);
	}

	public ProductCateglogue doLogin() {
		submit.click();
		return new ProductCateglogue(driver);
	}
	
	public String getErrorToast() throws InterruptedException {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
