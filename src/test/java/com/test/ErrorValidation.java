package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pageobjects.ProductCateglogue;
import TestCompoents.BaseTest;
import java.io.IOException;

public class ErrorValidation extends BaseTest {

	@Test(groups = {"ErrorHandling"})
	public void LoginErrorvalidation() throws IOException, InterruptedException {

		landingPage.enterCred("navid.nv1812@gmail.com", "Navdi@2017");
		landingPage.doLogin();
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorToast());
	}

	@Test
	public void ProductErrorValidation() throws InterruptedException {

		String productName = "ADIDAS ORIGINAL";
		landingPage.enterCred("navi.nv1812@gmail.com", "Navi@2017");
		ProductCateglogue productCatalogue = landingPage.doLogin();
		productCatalogue.getProductList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
	}

}
