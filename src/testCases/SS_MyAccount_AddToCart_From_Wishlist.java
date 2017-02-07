package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.HomePage_Action;
//import pageObjects.Home_Page;
import appModules.Login_App;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
//import utility.PDFReport;
import utility.Utils;


/**
 * 
 * <h2 style="text-align:center;">SS_MyAccount_AddToCart_From_Wishlist</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies adding product to the cart from wishlist</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr>
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * </table>
 * <br>
 * <br>
 * 
 */

public class SS_MyAccount_AddToCart_From_Wishlist {

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
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.MyAccount().click();
			MyAccount_Page.MyAccount_LeftMenu.Wishlist().click();
			String message = MyAccount_Page.WishList.WishListHeading().getText().trim();
			
			if (message.contains("WISHLIST")) {
			
				Log.error("Wishlist page is visible");
			} else {
				Log.error("Wishlist page is not visible");
				throw new Exception("Test Case Failed because of Verification");
			}
			
			//Utils.mouseHover(ProductDetails_Page.Product.description_tabs());
			//Utils.mouseHover(ProductDetails_Page.Product.productPicture());
			Utils.mouseHover(ProductDetails_Page.Product.WishlistProduct());
			Thread.sleep(5000);
			ProductDetails_Page.Product.WishlistQuickbtn().click();
			Thread.sleep(5000);
			ProductDetails_Page.Product.WishList_AddToCart().click();
			Log.info("Add to Wishlist button is clicked");
			
			/*Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.MyAccount().click();
			Log.info("My Shoppers stop link is clicked from the menu");
			MyAccount_Page.MyAccount_LeftMenu.Wishlist().click();
			Log.info("Wishlist menu is clicked from the left menubar");
			Utils.mouseHover(ProductListing_Page.FirstProductImage());
			Log.info("Mouse hovered over first product image");
			ProductListing_Page.ProductQuickViewTag().click();
			Log.info("Quick View tag clicked on Wishlist");
			ProductListing_Page.QuickViewDetails.QuickViewAddToBagButton().click();
			Log.info("Add to bag button is clicked");
			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			Log.info("Product is added to the cart");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");*/

		} catch (Exception e) {
			Log.error("Issue with the functionality of adding item to bag from wishlist");
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
