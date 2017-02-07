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
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_PDP_ZoomIn_AddToCart</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies addition of product in the cart through Zoom in window</p>
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

public class SS_PDP_ZoomIn_AddToCart {

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
			ProductDetails_Page.Product.ZoomBtn().click();
			Log.info("Zoom In button is clicked to enlarge product");
			
			if (ProductDetails_Page.Product.ZoomInWindowDiv().isDisplayed()) {
				Log.info("Zoom In pop up window is displayed");

			} else {
				Log.error("Zoom In pop up window is not displayed");
				throw new Exception("Zoom In pop up window is not displayed");
			}
			
			ProductDetails_Page.Product.AddToCartBtn_ZoomPopUp().click();
			Log.info("Add to cart button on Zoom in pop up is clicked");
			
			try {
				Utils.verifyElement(MiniCart_Page.MiniCartWindow());
				Log.info("Zoom in pop up window is closed");
			} catch (Exception e) {
				throw new Exception("Zoom in pop up window is not closed");
			}
			
			if(Integer.parseInt(MiniCart_Page.MiniCartItemCount().getText())>0){
				Log.info("Product is added to the cart");
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			} else {
				Log.error("Product is not added to the cart");
				throw new Exception("Product is not added to the cart");
			}
		

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
