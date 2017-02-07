package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import appModules.Registration_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_Registration_InvalidInput</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies invalid inputs on Registration form</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>firstName</td><td>First Name of the new user</td></tr> 
 * <tr><td>lastName</td><td>Last Name of the new user</td></tr>
 * <tr><td>emailId</td><td>Email id of the new user</td></tr>
 * <tr><td>password</td><td>Password for the new user</td></tr> 
 * <tr><td>confirmPassword</td><td>Confirm password</td></tr> 
 * <tr><td>mobileNumber</td><td>Mobile number</td></tr> 
 * <tr><td>gender</td><td>Gender of the new user</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */

public class SS_Registration_InvalidInput {

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
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.SignUp().click();
			Registration_Action.execute(iTestCaseRow);
			Registration_Action.checkErrors(iTestCaseRow);

			if (!BaseClass.errorValidation.isEmpty()) {
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Log.info("Invalid input is entered for the below fields");
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
				Log.info(BaseClass.errorValidation);
			} else {

				throw new Exception("Test Case Failed because of Verification");
			}

		} catch (Exception e) {
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
