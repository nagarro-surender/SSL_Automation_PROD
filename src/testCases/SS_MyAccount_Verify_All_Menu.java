package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
//import pageObjects.Home_Page;
import appModules.Login_App;
import appModules.MyAccount_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
//import utility.PDFReport;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_MyAccount_Verify_All_Menu</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies all options/menu items present on My Shoppers stop page</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */


public class SS_MyAccount_Verify_All_Menu {

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
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.MyAccount().click();
			Log.info("My Shoppers stop link is clicked");
			MyAccount_Action.Verify_MyAccountLinks(iTestCaseRow);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);

		} catch (Exception e) {
			Log.error("Issue in verifying all the links present on my account page");
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
