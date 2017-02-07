package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;


/**
 * 
 * <h2 style="text-align:center;">SS_Forgot_Password_Verify_Fields</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies various fields present on Forgot password form</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:20px">Parameter List</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr></table>
 * <br>
 * <br>
 * 
 */
public class SS_Forgot_Password_Verify_Fields {

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
			Home_Page.SignIn().click();
			Log.info("Sign in button is clicked");
			Utils.waitForElement(LogIn_Page.User_Id());
			LogIn_Page.ForgotPwd().click();
			Log.info("Forgot password link is clicked");
			Utils.waitForElement(LogIn_Page.User_ForgotCustomerIDEmail());
			Utils.waitForElement(LogIn_Page.User_ForgotPWDSendEmailBtn());
			Log.info("All fields/buttons are visible on Forgot Password form correctly");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");

		} catch (Exception e) {
			Log.error("Issue in verifying fields on Forget password form");
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
