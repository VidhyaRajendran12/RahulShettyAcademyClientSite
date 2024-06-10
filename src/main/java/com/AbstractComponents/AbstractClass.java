package com.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.MyCart;
import com.pageobjects.OrdersPage;

public class AbstractClass {

	WebDriver driver;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement myOrdersbutton;
	
	
	
	public void waitForElementToVisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public MyCart goToCartPage() throws InterruptedException // CartHeader
	{
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("window.scrollBy(0,300)");
		 */		//Thread.sleep(4000);
		cartHeader.click();
		return new MyCart(driver);
	}
	
	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

	
	public OrdersPage myOrdersButton() throws InterruptedException {
		Thread.sleep(2000);
		myOrdersbutton.click();
		return new OrdersPage(driver);
	}
}
