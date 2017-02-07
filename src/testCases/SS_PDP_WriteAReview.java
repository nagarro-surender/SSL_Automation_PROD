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
import appModules.Login_App;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_PDP_WriteAReview</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies review writing functionality on PDP</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr> 
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * <tr><td>reviewTitle</td><td>Title of the review</td></tr>
 * <tr><td>description</td><td>Description of the review</td></tr> 
 * <tr><td>message1</td><td>Confirmation message of successful submission of review</td></tr> 
 * </table>
 * <br>
 * <br>
 * 
 */ 

public class SS_PDP_WriteAReview {

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

			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			ProductListing_Page.product().click();
			Log.info("Product icon is clicked");
			ProductDetails_Page.Product.WriteReviewBtn().click();
			Log.info("Write a review button is clicked");

			if (Utils.CheckEnability(ProductDetails_Page.ReviewWindow.ReviewPopUp())) {
				Log.info("Review pop up window is displayed");
			} else {
				Log.error("Review pop up window is not displayed");
				throw new Exception("Review pop up window is not displayed");
			}

			ProductDetails_Page.ReviewWindow.ReviewStar_4().click();
			ProductDetails_Page.ReviewWindow.ReviewQuality_VeryGood().click();
			ProductDetails_Page.ReviewWindow.ReviewTitle()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.reviewTitle));
			ProductDetails_Page.ReviewWindow.ReviewDescription()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
			ProductDetails_Page.ReviewWindow.ReviewSubmitBtn().click();
			String message = ExcelUtils.getCellData(iTestCaseRow, Constant.message1);

			if (message.equals(ProductDetails_Page.GlobalMsg().getText())) {
				Log.info("Review added successfully");
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			}else{
				throw new Exception("Review not added");
			}

		} catch (Exception e) {
			Log.error("Issue in writing review for the product");
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
