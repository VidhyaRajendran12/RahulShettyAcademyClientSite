
package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

	String productName = "ADIDAS ORIGINAL";

	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// get ProductName
	// //tbody/tr/td[2]

	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> ProdNames;

	public Boolean verifyOrderstoDisplay(String productName) {

		Boolean match = ProdNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
}