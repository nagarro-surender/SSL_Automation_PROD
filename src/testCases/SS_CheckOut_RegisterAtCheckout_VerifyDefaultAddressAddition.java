package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.CheckOut_Action;
import appModules.HomePage_Action;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;


/**
 * 
 * <h2 style="text-align:center;">SS_CheckOut_RegisterAtCheckout_VerifyDefaultAddressAddition</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies if the customer has created the account from the checkout flow, then the delivery address entered during the checkout flow is added to the Address book as default address</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the new user</td></tr>
 * <tr><td>password</td><td>Password for the new user</td></tr>
 * <tr><td>alternativeFirstName</td><td>First Name of the new user</td></tr> 
 * <tr><td>alternativeLastName</td><td>Last Name of the new user</td></tr>
 * <tr><td>confirmPassword</td><td>Confirm password</td></tr> 
 * <tr><td>alternativeMobile</td><td>Mobile number</td></tr> 
 * <tr><td>gender</td><td>Gender of the new user</td></tr> 
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * <tr><td>firstName</td><td>First Name for the delivery address</td></tr> 
 * <tr><td>lastName</td><td>Last Name for the delivery address</td></tr>
 * <tr><td>postCode</td><td>Postal code for the delivery address</td></tr> 
 * <tr><td>address</td><td>Address field for the delivery</td></tr> 
 * <tr><td>landmark</td><td>Address2 field for the delivery</td></tr> 
 * <tr><td>mobileNumber</td><td>Phone for the delivery address</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 

public class SS_CheckOut_RegisterAtCheckout_VerifyDefaultAddressAddition {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	
	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("Test case to be executed: "+ sTestCaseName);
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
			Log.info("Product category selected successfully");
			ProductListing_Page.product().click();
			Log.info("Product selected successfully");
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			ProductDetails_Page.Product.Product_AddToCart().click();
			Log.info("Add to cart button is clicked");
			
			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			Log.info("Product is added to the cart and mini cart is displayed");
			
			MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
			Log.info("View bag button is clicked on Mini cart window");
			Utils.verifyElement(Cart_Page.CheckoutButton());
			Cart_Page.CheckoutButton().click();
			Log.info("Checkout button is clicked on cart page");
			Utils.verifyElement(Checkout_Page.TopNavigation.CheckOutText());
			Log.info("User successfully reached to Checkout page");
			
			CheckOut_Action.RegisterAtCheckout(iTestCaseRow);
			Log.info("Registration successful at checkout");
			
			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
			Checkout_Page.TopNavigation.backToCartBtn().click();
			Log.info("Shoppers stop logo is clicked from the checkout page");
			
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Utils.waitForElement(MyAccount_Page.ProfilePage.PersonalInfoText());
			MyAccount_Page.ProfilePage.Addresses().click();

			if (MyAccount_Page.ProfilePage.DefaultShippingAddresstext().size() == 1) {

				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
				Log.info("Address added at checkout is set as default shipping address");

			} else {

				throw new Exception("No address is set as default shipping address");
			}

		} catch (Exception e) {
			Log.error("Issue in setting default shipping address");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);

			Utils.captureScreenshot(sTestCaseName, "Fail", "Failure");

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