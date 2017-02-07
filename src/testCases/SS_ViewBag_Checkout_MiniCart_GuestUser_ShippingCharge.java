package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
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
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;


/**
 * 
 * <h2 style="text-align:center;">SS_PDP_AddToCart</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies addition of product in the cart through PDP</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */

public class SS_ViewBag_Checkout_MiniCart_GuestUser_ShippingCharge {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;


	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("Test case to be executed: " + sTestCaseName);
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
	
 	     	HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			ProductListing_Page.product().click();
			Log.info("Product icon is clicked");
			
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(5000);
			
			ProductDetails_Page.Product.Product_AddToCart().click();
			Log.info("Add to cart button is clicked on the PDP");

			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			Log.info("Product is added to the cart and mini cart is displayed");

			MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
			Log.info("View bag button is clicked on Mini cart window");
			Cart_Action.CheckMiniCartShippingCost(iTestCaseRow);
			
			Cart_Page.CheckoutButtonOnCart().click();
			String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
			Log.info("User email id is entered successfully");
			Checkout_Page.LoginDetails.ContinueBtn().click();
			Log.info("Continue button is clicked");
			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
			Checkout_Page.DropDownBtn().click();
			Thread.sleep(5000);
			Cart_Action.CheckMiniCartShippingCostFinal(iTestCaseRow);
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Log.info("Verification for Applying Coupon on cart page successfull");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Apply Coupan Screenshot");
			
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			Log.info("Payment successful using netbanking after login at checkout");
			

		} catch (Exception e) {
			Log.error("Issue in adding product into the cart");
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

