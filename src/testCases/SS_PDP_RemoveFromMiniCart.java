package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.HomePage_Action;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_PDP_RemoveFromMiniCart</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies removing of product from the mini cart</p>
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

public class SS_PDP_RemoveFromMiniCart {

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
			String productCode = ProductDetails_Page.Product.Product_Code().getText();
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			ProductDetails_Page.Product.Product_AddToCart().click();
			Log.info("Add to cart button is clicked");
			
			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			Log.info("Mini cart window is displayed");
			
			MiniCart_Page.removeBtn().click();
			Log.info("Remove button is clicked on the mini cart");
			Thread.sleep(3000);
			if(!PDP_Action.productcode_MatchinMiniCart(MiniCart_Page.MiniCartProductCode(), productCode)){
				Log.info("Product is removed from the mini cart window");
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			}else{
				throw (new Exception("Product is not removed from the mini cart window"));
			}
	

		} catch (Exception e) {
			Log.error("Issue in removing product from the mini cart");
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
