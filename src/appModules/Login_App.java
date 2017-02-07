package appModules;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Login_App {
	static boolean presence;

	public static void execute(int iTestCaseRow) throws Exception {

		try {

			if (ExcelUtils.getCellData(iTestCaseRow, Constant.browser).equals("IE")) {
				Utils.SecurityCertificateHandle();
			}
			
			Utils.mouseHover(Home_Page.LoginRegister());
			//Home_Page.LoginRegister().click();
			//Utils.mouseHover(Home_Page.LoginRegister());
			//Home_Page.LoginRegister().click();
	        //Thread.sleep(5000);
			Home_Page.SignIn().click();
			Log.info("Sign in button is clicked");

			Log.info("Row number containing the test case: " + iTestCaseRow);
			String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			LogIn_Page.User_Id().sendKeys(sUsername);
			Log.info(sUsername + " is entered in user id field");

			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");

			LogIn_Page.submit_bt().click();
			Log.info("Submit button is clicked");

			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Login successfull");

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method execute");
			Log.error("Login not successful");
			throw (e);

		}

	}

	public static void InvalidLoginErrorVerification(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());

			Home_Page.SignIn().click();
			Log.info("Sign in button is clicked");

			Log.info("Row number containing the test case: " + iTestCaseRow);
			String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			LogIn_Page.User_Id().sendKeys(sUsername);
			Log.info(sUsername + " is entered in user id field");

			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");

			LogIn_Page.submit_bt().click();
			Log.info("Submit button is clicked");

			Log.info("Error message found on Login Popup - " + LogIn_Page.invalidLoginError().getText());

			if ("Your username or password was incorrect".equals(LogIn_Page.invalidLoginError().getText())) {
				Log.info("Entered Username or Password is incorrect , Please Enter the correct Details");

			}

			Log.info("Verification check has been completed - Invalid Login");

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method InvalidLoginErrorVerification");
			Log.error("Verification check Failed to InValid Login");
			throw (e);

		}

	}

	public static void Login_Blank_parameter(int iTestCaseRow) throws Exception {
		try {
			Utils.mouseHover(Home_Page.LoginRegister());

			Home_Page.SignIn().click();
			Log.info("Sign in button is clicked");

			Log.info("Row number containing the test case: " + iTestCaseRow);
			String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			LogIn_Page.User_Id().sendKeys(sUsername);
			Log.info(sUsername + " is entered in user id field");

			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");

			LogIn_Page.submit_bt().click();
			Log.info("Submit button is clicked");

			Thread.sleep(2000);
			String errorMessage = LogIn_Page.ErrorElement().getText();

			if (ExcelUtils.getCellData(iTestCaseRow, Constant.message1).equals(errorMessage)) {
				Log.info("Verification Pass - error message is displayed correctly.");
			} else {
				throw new Exception("Issue with retreiving error message");
			}

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method Login_Blank_parameter");
			Log.error("Issue with retreiving error message");
			throw (e);
		}
	}

	public static void Login_ForgotPassword(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.LoginRegister().click();
			Thread.sleep(50000);
			Home_Page.SignIn().click();
			Log.info("Sign in button is clicked");
			Utils.waitForElement(LogIn_Page.User_Id());
			LogIn_Page.ForgotPwd().click();
			Log.info("Forgot password button is clicked");
			//Utils.waitForElement(LogIn_Page.ForgotPwdText());
			String UserEmailID = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Utils.waitForElement(LogIn_Page.User_ForgotCustomerIDEmail());
			LogIn_Page.User_ForgotCustomerIDEmail().sendKeys(UserEmailID);
			Log.info(UserEmailID + " is entered in user email id field");

			LogIn_Page.User_ForgotPWDSendEmailBtn().click();
			Log.info("Send email button is clicked");

			if ("You have been sent an email with a link to change your password."
					.equals(LogIn_Page.User_ForgotPasswordMessage().getText().trim())) {
				Log.info("Verification Passed for Forgot customerID: Mail sent for Password ");

			}

			Log.info("Forgot Password functionality working fine");

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method Login_ForgotPassword");
			Log.error("Verification check Failed for Forgot Password ");

			throw (e);

		}

	}

}
