package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import appModules.Login_App;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;



/**
 * 
 * <h2 style="text-align:center;">SS_Forgot_Password</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies forgot password functionality</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">Parameter List</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the user</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */


public class SS_Forgot_Password {
	
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
		Login_App.Login_ForgotPassword(iTestCaseRow);
		
		
		if(BaseClass.bResult==true){
			Log.info("Forget password functionality is working fine");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
		}else{
			
			throw new Exception("Test Case Failed because of Verification");
		}
		
		} catch (Exception e) {
			Log.error("Issue in resetting password using forget password link");
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