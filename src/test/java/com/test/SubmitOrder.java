package com.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.AbstractComponents.AbstractClass;
import com.pageobjects.ConfirmOrder;
import com.pageobjects.MyCart;
import com.pageobjects.OrdersPage;
import com.pageobjects.ProductCateglogue;
import com.pageobjects.ShippingDetails;
import TestCompoents.BaseTest;
import java.io.IOException;
import java.util.HashMap;

public class SubmitOrder extends BaseTest {

	SoftAssert softassert = new SoftAssert();
	String productName = "ADIDAS ORIGINAL";

	@Test
	public void PurchaseOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		landingPage.enterCred("Adhi@gmail.com", "Adhi@123");
		ProductCateglogue productCatalogue = landingPage.doLogin();

		productCatalogue.getProductList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
		AbstractClass abstractClass = new AbstractClass(driver);
		MyCart cartDetails = abstractClass.goToCartPage();

		// Boolean match = cartDetails.productNamedoCheck();
		// softassert.assertTrue(match);
		ShippingDetails shippingDetails = cartDetails.clickCheckOut();

		shippingDetails.enterShippingdetails();
		ConfirmOrder confirmOrder = shippingDetails.placeOrder();
		String confirmMessage = confirmOrder.confirmationPage();

		System.out.println(confirmMessage);
		// softassert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE
		// ORDER."));
		// softassert.assertAll();
	}

	@Test(dependsOnMethods = { "PurchaseOrder" })
	public void OrderHistoryTest() throws InterruptedException {

		// ADIDAS ORIGINAL ->
		landingPage.enterCred("navi.nv1812@gmail.com", "Navi@2017");
		landingPage.doLogin();
		AbstractClass abstractClass = new AbstractClass(driver);
		OrdersPage ordersPage = abstractClass.myOrdersButton();
		Assert.assertFalse(ordersPage.verifyOrderstoDisplay(productName));
	}

}
