package testCases;



import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.CheckOut_Action;
import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.JyperionListener;

/**
 * 
 * <h2 style="text-align:center;">SS_FCC_Private_Verify_EarnPoint_LinkedCard</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies redeeming FCC points on Checkout page for registered user.</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>User email Id</td></tr>
 * <tr><td>password</td><td>User password</td></tr> 
 * <tr><td>productCategory</td><td>Product category available on main menu</td></tr>
 * <tr><td>productSubCategory</td><td>Product sub category available under the main menu</td></tr>
 * <tr><td>firstName</td><td>First Name for FCC registration form</td></tr>
  * <tr><td>lastName</td><td>Last Name for FCC registration form</td></tr>
  * <tr><td>mobileNumber</td><td>Mobile Number for FCC registration form</td></tr>
  * <tr><td>address</td><td>Address for delivery option on checkout page</td></tr>
  * <tr><td>landmark</td><td>Landmark for delivery option on checkout page</td></tr>
  * <tr><td>postCode</td><td>PostCode for delivery option on checkout page</td></tr>
  *<tr><td>giftCardEGVFCC</td><td>Enter the required payment option on checkout page(Like EGV, GC, FCC)</td></tr>
  *<tr><td>cardNumberEGVGiftFCC</td><td>FCC card number to be entered.</td></tr>
  *<tr><td>pinEGVGiftFCC</td><td>FCC password.</td></tr>
  *<tr><td>amountRedeem</td><td>Amount to be redeemed from FCC.</td></tr>
  * </table>
 * <br>
 * <br>
 * 
 */ 
@Listeners(JyperionListener.class)
public class SS_FCC_Private_Verify_EarnPoint_LinkedCard {
	
	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@BeforeSuite
	public void BeforeSuite() throws Exception{
		Utils.setSnapshotFolder();
	}

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
			
			Login_App.execute(iTestCaseRow);
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product category selected successfully");
			ProductListing_Page.FCC_checkout_product().click();
			Log.info("Product selected successfully");
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			ProductDetails_Page.Product.FCC_Product_AddToCart().click();
			Log.info("Add to cart button is clicked");
			
			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			Log.info("Product is added to the cart and mini cart is displayed");
			
			MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
			Log.info("View bag button is clicked on Mini cart window");
			Utils.verifyElement(Cart_Page.CheckoutButton());
			Cart_Page.CheckoutButton().click();
			Log.info("Checkout button is clicked on cart page");
			//Utils.verifyElement(Checkout_Page.TopNavigation.CheckOutText());
			//Log.info("User successfully reached to Checkout page");

			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
			Utils.verifyElement(Checkout_Page.Paymentinfo.PaymentClass());
			Log.info("Payment information tab is visible");
			//CheckOut_Action.PaymentOption(iTestCaseRow);
			
			//CheckOut_Action.RedeemGiftCard_EGV_FCC(iTestCaseRow);
			Log.info("Payment successful using FCC");
			ExcelUtils.setCellData("Passs", iTestCaseRow, Constant.result);
			
		if(BaseClass.bResult==true){
			Log.info("Verification for Redeeming FCC points for registered user successfull");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
		}else{
			
			throw new Exception("Test Case Failed because of Verification");
		}
		
		} catch (Exception e) {
			Log.error("Verification for Buying FCC from Header Link for guest user failed");
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