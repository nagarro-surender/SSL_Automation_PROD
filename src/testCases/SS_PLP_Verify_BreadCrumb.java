package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.ProductDetails_Page;
import appModules.HomePage_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.JyperionListener;

/**
 * 
 * <h2 style="text-align:center;">SS_PLP_Verify_BreadCrumb</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies PLP bread crumb</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 *<tr><td>productCategory</td><td>Product category available on main menu</td></tr>
 *<tr><td>productSubCategory</td><td>Product sub category available under the main menu</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 
@Listeners(JyperionListener.class)
public class SS_PLP_Verify_BreadCrumb {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeSuite
	public void setSnapShotFolder() throws Exception {
		Utils.setSnapshotFolder();
	}

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info(sTestCaseName + " Test case to be executed");

		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);

		Log.info("New driver instantiated " + iTestCaseRow);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			Log.info("Verification for Breadcrumb on PLP page started");
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product Listing page displayed");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Breadcrumb on PLP page successfull");
			if (ProductDetails_Page.breadCrumb().isDisplayed()) {

				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			} else {

				throw new Exception("BreadCrumb not visible");
			}

		} catch (Exception e) {
			Log.info("Verification for Breadcrumb on PLP page failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw e;
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);

		Driver.close();
		Driver.quit();

	}

}
