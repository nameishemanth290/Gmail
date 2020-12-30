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
//the added product is displayed in the ODP Page
public class TC001 extends BaseTest {
	@Test(description="Test case to verify if the added product is displayed in ODP page")
	public void testAddingProductToKart() {
		
		String path="";
		String tcName="TC001";
		
		ExtentTest test = extentReports.createTest(tcName);
		
		HomePage hp = new HomePage(driver,webActionUtil);
		test.log(Status.PASS, "Home Page Displayed");
		Utillity.addPicToER(test, driver, tcName, path);
		
		//Getting testdata from XL
		String sheetName = "TC001";
		String menuName = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 0);
		String productId = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 1);
		productId = Utillity.split(productId);
		String increaseQuantity = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 2);
		int inQ=Integer.parseInt(Utillity.split(increaseQuantity));
		String decreaseQuantity = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 3);
		int deQ=Integer.parseInt(Utillity.split(decreaseQuantity));
		String size = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 4);
		String color = GenericXLLIbrary.getData(XL_PATH, sheetName, 1, 5);
		
		test.log(Status.PASS, "Captured all data from Excel Sheet");
		Utillity.addPicToER(test, driver, tcName, path);
		
		ProductsListPage productListPage = hp.clickOnMenu(menuName);
		test.log(Status.PASS, "Clicked On "+menuName);
		Utillity.addPicToER(test, driver, tcName, path);
		
		ProductDetailsPage pdp = productListPage.selectProduct(productId);
		test.log(Status.PASS, "Clicked On Product with Product ID "+productId);
		Utillity.addPicToER(test, driver, tcName, path);
		
		OrderDetailPage odp = pdp.addSelectedItemToKart(inQ, deQ, size, color);
		test.log(Status.PASS, "Adding the Product to Kart Success "+productId);
		Utillity.addPicToER(test, driver, tcName, path);
		
		Assert.assertEquals(odp.isProductDisplayed(productId), true);
		test.log(Status.PASS, "Added the Product is Displayed "+productId);
		Utillity.addPicToER(test, driver, tcName, path);
	}
}
