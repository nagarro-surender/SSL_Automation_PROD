package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.MyAccount_Page;
import appModules.Login_App;
import appModules.MyAccount_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_ProfilePage_EditAddress_ChangeDefaultAddress</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies changing default delivery address functionality</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr> 
 * <tr><td>firstName</td><td>First Name for the first delivery address</td></tr> 
 * <tr><td>postCode</td><td>Postal code for the first delivery address</td></tr> 
 * <tr><td>address</td><td>Address field for the first delivery</td></tr> 
 * <tr><td>city</td><td>City for the first delivery address</td></tr>
 * <tr><td>landmark</td><td>Landmark for the first delivery</td></tr> 
 * <tr><td>mobileNumber</td><td>Phone for the first delivery address</td></tr>  
 * <tr><td>alternativeFirstName</td><td>First Name for the second delivery address</td></tr> 
 * <tr><td>alternativePostCode</td><td>Postal code for the second delivery address</td></tr> 
 * <tr><td>alternativeAddress</td><td>Address field for the second delivery</td></tr> 
 * <tr><td>alternativeCity</td><td>City for the second delivery address</td></tr>
 * <tr><td>alternativeLandmark</td><td>Landmark for the second delivery</td></tr> 
 * <tr><td>alternativeMobileNumber</td><td>Phone for the second delivery address</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */


public class SS_ProfilePage_EditAddress_ChangeDefaultAddress {

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
			Home_Page.profileLink().click();
			Utils.waitForElement(MyAccount_Page.ProfilePage.PersonalInfoText());
			MyAccount_Page.ProfilePage.Addresses().click();
			MyAccount_Action.Profile_Add_Multiple_Address(iTestCaseRow);
			Utils.mouseHover(MyAccount_Page.ProfilePage.MakeItAsDefaultShippingAddresstext().get(0).findElement(By.xpath("ancestor::li")));
			MyAccount_Page.ProfilePage.MakeItAsDefaultShippingAddresstext().get(0).click();
			
			String UpdateMsg = MyAccount_Page.GlobalMsg().getText().trim();
			if (ExcelUtils.getCellData(iTestCaseRow, Constant.message1).equals(UpdateMsg)) {
				Log.info("Verfication Passed : Default Address updated successfully");
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");

			} else {
				Log.error("Verification Failed :Default Address not updated successfully");
				throw (new Exception("Verification Failed :Default Address not updated successfully"));
			}

		} catch (Exception e) {
			Log.error("Issue in changing default delivery address functionality");
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
