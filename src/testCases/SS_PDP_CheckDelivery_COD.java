package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.HomePage_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
/**
 * 
 * <h2 style="text-align:center;">SS_PDP_CheckDelivery_COD</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies COD check functionality</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * <tr><td>postCode</td><td>Valid Pin code</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 


public class SS_PDP_CheckDelivery_COD {

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
			ProductDetails_Page.Product.Product_CODBtn().click();
			Log.info("Check for COD button is clicked");
			ProductDetails_Page.Product.PinCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
			Log.info("Pin is entered into the text field");
			ProductDetails_Page.Product.PinCodeCheckBtn().click();
			Log.info("Check button is clicked");

			if (ProductDetails_Page.Product.PinCodeSuccessMsg().size() >= 1) {
				Log.info("Product can be deliver to this pincode");
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			} else {
				Log.error("Product cannot be deliver to this Pincode");
				throw (new Exception("Product cannot be deliver to this Pincode"));
			}

		} catch (Exception e) {
			Log.error("Issue in COD checking functionality");
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
