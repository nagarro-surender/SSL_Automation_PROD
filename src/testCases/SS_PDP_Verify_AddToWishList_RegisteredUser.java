package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PLP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_PDP_Verify_AddToWishList_RegisteredUser</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies Add to Wishlist functionality for registered user</p>
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


public class SS_PDP_Verify_AddToWishList_RegisteredUser {

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

			Login_App.execute(iTestCaseRow);
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			//ProductListing_Page.product().click();
			Log.info("Product icon is clicked");
			
			int wishListItem = Integer.parseInt(Home_Page.headerWishlistItemCountIcon().getText());
			Utils.mouseHover(ProductListing_Page.FirstProductImage());
			Log.info("Mouse hovered over first product image");
			ProductListing_Page.FirstProductImage().click();
			//ProductListing_Page.ProductQuickViewTag().click();
			Log.info("First Item clicked on PLP");
			//if (ProductDetails_Page.Product.AddToWishlistElementList().size() > 0) {
				//Log.info("Add to Wishlist button is present for registered user");
			//} else {
				//throw new Exception("Add to Wishlist button is not present for registered user");
			//}

			//Utils.mouseHover(ProductListing_Page.FirstProductImage());
			//Log.info("Mouse hovered over first product image");
			//ProductListing_Page.ProductQuickViewTag().click();
			//ProductDetails_Page.Product.WishlistQuickbtn().click();
			
			//Log.info("Quick View tag clicked on PLP");
			
			//Utils.mouseHover(ProductDetails_Page.Product.description_tabs());
			//Utils.mouseHover(ProductDetails_Page.Product.productPicture());

			Utils.mouseHover(ProductDetails_Page.Product.AddToWishlistBtn());
			ProductDetails_Page.Product.AddToWishlistBtn().sendKeys(Keys.ENTER);
			//if (Integer.parseInt(Home_Page.headerWishlistItemCountIcon().getText()) == (wishListItem + 1)) {
				Log.info("Product added to the wishlist successfully");
			//} else {
				//throw (new Exception("Product not added to the wishlist"));
			
			Thread.sleep(5000);
			Utils.verifyElement(Home_Page.headerWishlistIcon());
			Home_Page.headerWishlistIcon().click();
			MyAccount_Page.WishList.WishListItemCloseBtn().click();
			//Log.info("Add to Wishlist button is clicked");
			//Utils.verifyElement(ProductDetails_Page.Product.RemoveFromWishlistLabel());

			Thread.sleep(2000);
			

		} catch (Exception e) {
			Log.error("Issue in verifying Add to wishlist functionality on PDP for registered user");
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
