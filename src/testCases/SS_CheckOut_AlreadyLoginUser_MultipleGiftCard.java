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
 * <h2 style="text-align:center;">SS_CheckOut_AlreadyLoginUser_OrderUsingEGV</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies checkout flow using EGV for already logged in user</p>
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
 * <tr><td>landmark</td><td>Address2 field for the delivery</td></tr> 
 * <tr><td>mobileNumber</td><td>Phone for the delivery address</td></tr>
 * <tr><td>giftCardEGV</td><td>GiftCard</td></tr>
 * <tr><td>cardNumberEGVGift</td><td>Card number</td></tr> 
 * <tr><td>pinEGVGift</td><td>Pin number</td></tr> 
 * <tr><td>amountRedeem</td><td>Amount to be redeemed</td></tr>
 * <tr><td>alternativeGiftCardEGV</td><td>GiftCard</td></tr>
 * <tr><td>alternativeCardNumberEGVGift</td><td>Card number</td></tr> 
 * <tr><td>alternativePinEGVGift</td><td>Pin number</td></tr> 
 * <tr><td>alternativeAmountRedeem</td><td>Amount to be redeemed</td></tr>  
 * </table>
 * <br>
 * <br>
 * 
 */ 

public class SS_CheckOut_AlreadyLoginUser_MultipleGiftCard {

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
			Login_App.execute(iTestCaseRow);
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

			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
			Utils.verifyElement(Checkout_Page.Paymentinfo.PaymentClass());
			Log.info("Payment information tab is visible");
			
			Double RedeemAmount = Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.RedeemedAmount().getText());
			
			CheckOut_Action.RedeemGiftCard_EGV_FCC(iTestCaseRow);
			Utils.verifyElement(Checkout_Page.Paymentinfo.AddCard());

			RedeemAmount = Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.RedeemedAmount().getText());

			
			if(RedeemAmount==Double.parseDouble(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem))){
				Log.info("Amount redeemed is equal to the data entered from the data sheet");
			}else{
				Log.error("Redeem amount on the site mismatches with the amount entered from the data sheet");
				throw new Exception("Redeem amount on the site mismatches with the amount entered from the data sheet");
			}
			
			Log.info("Redemption successful using GiftCard");
			Checkout_Page.Paymentinfo.AddCard().click();
			Log.info("Add card button is clicked");
			CheckOut_Action.MultipleRedeemGift_EGV(iTestCaseRow);
			Utils.verifyElement(Checkout_Page.Paymentinfo.AddCard());
			
			RedeemAmount = Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.RedeemedAmount().getText());
			
			if(RedeemAmount==(Double.parseDouble(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem))+Double.parseDouble(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeAmountRedeem)))){
				Log.info("Amount redeemed is equal to the total amount entered for the two cards");
			}else{
				Log.error("Redeem amount on the site mismatches with the amount entered from the data sheet");
				throw new Exception("Redeem amount on the site mismatches with the amount entered from the data sheet");
			}

			Log.info("Redemption successful using second GiftCard");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);


		} catch (Exception e) {
			Log.error("Issue in making payment using GiftCard");
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
