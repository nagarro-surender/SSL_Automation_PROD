package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.Cart_Action;
import appModules.CheckOut_Action;
import appModules.HomePage_Action;
//import pageObjects.Home_Page;
import appModules.Login_App;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
//import utility.PDFReport;
import utility.Utils;


/**
 * 
 * <h2 style="text-align:center;">SS_CheckOut_NewAddress</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies new address addition on checkout page</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr> 
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * <tr><td>firstName</td><td>First Name for the delivery address</td></tr> 
 * <tr><td>lastName</td><td>Last Name for the delivery address</td></tr>
 * <tr><td>postCode</td><td>Postal code for the delivery address</td></tr> 
 * <tr><td>address</td><td>Address field for the delivery</td></tr> 
 * <tr><td>landmark</td><td>Landmark for the delivery</td></tr> 
 * <tr><td>mobileNumber</td><td>Phone for the delivery address</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 


public class SS_ItemDelete_OneItem_CheckOut {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;


	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("Test case to be executed" + sTestCaseName);
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);

		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
//			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
//			Log.info("Product selected from Main Menu on header");
//			Utils.mouseHover(ProductListing_Page.product());
//			Utils.scrollingToPageElementAdvanced(ProductListing_Page.ProductQuickViewTag());
//			Utils.mouseHover(ProductListing_Page.product());
//			Thread.sleep(2000);
//			ProductListing_Page.ProductQuickViewTag().click();
//			//ProductListing_Page.product().click();
//			Log.info("Product clicked on PLP");
//			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
//			Thread.sleep(3000);
//			ProductDetails_Page.Product.Quick_AddToCart().click();
//			//ProductListing_Page.product().click();
//			//Log.info("Another Product clicked
//			Utils.mouseHover(ProductDetails_Page.Product.Quick_AddToCart());
//			Thread.sleep(2000);
//			PDP_Action.product_selectDifferentSize(ProductDetails_Page.Product.size_variant_buttonlist());
//			Thread.sleep(2000);
//			ProductDetails_Page.Product.Quick_AddToCart().click();
//			Log.info("Product added to cart on PDP");
//			Thread.sleep(3000);
//			MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
//			Log.info("View bag button clicked on minicart pop up");
//			Utils.verifyElement(Cart_Page.CheckoutButton());
//			Cart_Page.CheckoutButton().click();
//			Log.info("Checkout button is clicked on cart page");
//			//Utils.verifyElement(Checkout_Page.TopNavigation.CheckOutText());
//			//Log.info("User successfully reached to Checkout page");
//
//			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
			
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			ProductListing_Page.product().click();
			Log.info("Product clicked on PLP");
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(3000);
			ProductDetails_Page.Product.Product_AddToCart().click();
			Thread.sleep(3000);
			//ProductListing_Page.product().click();
			//Log.info("Another Product clicked on PLP");
			PDP_Action.product_selectDifferentSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(3000);
			ProductDetails_Page.Product.Product_AddToCart().click();
			Log.info("Product added to cart on PDP");
			Thread.sleep(2000);
			MiniCart_Page.removeBtn().click();
			MiniCart_Page.MiniCartProductDetails.MiniCartCheckOutButton().click();
			String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
			Log.info("User email id is entered successfully");
			Checkout_Page.LoginDetails.ContinueBtn().click();
			Log.info("Continue button is clicked");
			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Log.info("Checkout successful");
//			try {
//				Utils.verifyElement(Checkout_Page.Paymentinfo.PaymentClass());
//				Log.info("Payment information tab is visible");
//				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
//				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
//			} catch (Exception e) {
//				Log.error("Payment tab is not visible");
//				throw new Exception("Payment tab is not visible");
//			}

		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");

			Log.error(e.getMessage());

			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);

		Driver.close();
		Driver.quit();

	}

}
