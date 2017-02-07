package testCases;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import appModules.HomePage_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.JyperionListener;


/**
 * 
 * <h2 style="text-align:center;">SS_HomePage_Public_Verify_NewsLetterSubscribe_Functionality</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies Newsletter subscribe field functionality on Home Page</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>email id for newsletter subscription</td></tr>
 * <tr><td>invalidEmailId</td><td>Invalid email id to check newsletter subscription validation</td></tr>
 * <tr><td>message1</td><td>To check empty email id field message</td></tr>
 * <tr><td>message2</td><td>to check invalid email id field message</td></tr>
 * <tr><td>message3</td><td>To check successful subscription of newsletter message</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */
@Listeners(JyperionListener.class)
public class SS_HomePage_Public_Verify_NewsLetterSubscribe_Functionality {

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
		Log.info(sTestCaseName + " Test case to be excuted");
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

			Utils.waitForLoad("firefox");
			HomePage_Action.HomePage_Verify_NewsLetterSubscribe_Functionality(iTestCaseRow);
			Log.error("Verification check for home page News letter subscribe functionality successfull");
			if (BaseClass.bResult == true) {

				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			} else {

				throw new Exception("Test Case Failed because of Verification");
			}

		} catch (Exception e) {
			Log.error("Verification check for home page News letter subscribe functionality failed");
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
	}

}
