package com.google.gmail.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gmail.generic.GenericXLLIbrary;
import com.google.gmail.generic.Utillity;
import com.google.gmail.pom.HomePage;
import com.google.gmail.pom.OrderDetailPage;
import com.google.gmail.pom.ProductDetailsPage;
import com.google.gmail.pom.ProductsListPage;
//Taking Data From ExcelSheet and Verifying whether
//the deleted product from ODP is not displayed in the ODP Page
public class TC002 extends BaseTest {
	@Test(description="Test case to verify if the deleted product is not displayed in ODP page")
	public void testToDeletAddedProductFromODP() {
		
		String path="";
		String tcName="TC002";
		ExtentTest test = extentReports.createTest(tcName);
		HomePage hp = new HomePage(driver,webActionUtil);
		test.log(Status.PASS, "Home Page Displayed");
		Utillity.addPicToER(test, driver, tcName, path);

		//Getting testdata from XL
		String sheetName = "TC002";
		String menuName = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 0);
		String productId = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 1);
		productId = Utillity.split(productId);
		String increaseQuantity = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 2);
		int inQ=Integer.parseInt(Utillity.split(increaseQuantity));
		String decreaseQuantity = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 3);
		int deQ=Integer.parseInt(Utillity.split(decreaseQuantity));
		String size = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 4);
		String color = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 5);		
		
		
		
		ProductsListPage productListPage = hp.clickOnMenu(menuName);
		test.log(Status.PASS, "Clicked on "+menuName);
		Utillity.addPicToER(test, driver, tcName, path);
		
		ProductDetailsPage pdp = productListPage.selectProduct(productId);
		test.log(Status.PASS, "Clicked on Product with PID "+productId);
		Utillity.addPicToER(test, driver, tcName, path);
		
		OrderDetailPage odp = pdp.addSelectedItemToKart(inQ, deQ, size, color);
		test.log(Status.PASS, "Added Items to Cart");
		Utillity.addPicToER(test, driver, tcName, path);
		
		Assert.assertEquals(odp.isProductDisplayed(productId), true);	
		test.log(Status.PASS, "Product is displayed in ODP");
		Utillity.addPicToER(test, driver, tcName, path);
		
		odp.deleteProduct(productId);
		test.log(Status.PASS, "Deleted Product");
		Utillity.addPicToER(test, driver, tcName, path);
		
		Utillity.sleepInSeconds(5);
		Assert.assertEquals(odp.isProductDisplayed(productId), false);
		test.log(Status.PASS, "Prodcuct is not Displayed");
		Utillity.addPicToER(test, driver, tcName, path);
	}
}
