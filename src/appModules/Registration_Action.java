package appModules;

import org.openqa.selenium.Keys;

import pageObjects.BaseClass;
import pageObjects.Registration_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class Registration_Action {

	public static void execute(int iTestCaseRow) throws Exception {

		try {

			Log.info("Registration page will be opened");

			String fName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Registration_Page.First_name().sendKeys(fName);
			Log.info("First name is entered successfully");

			String lName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Registration_Page.last_name().sendKeys(lName);
			Log.info("Last name is entered successfully");

			String emailAddress = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Registration_Page.email().sendKeys(emailAddress);
			Log.info("Email address is entered successfully");

			String password = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			Registration_Page.password().sendKeys(password);
			Log.info("Password is entered successfully");

			String cPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.confirmPassword);
			Registration_Page.Confirm_Password().sendKeys(cPassword);
			Log.info("Confirm password is entered successfully");

			String pNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Registration_Page.mobileNumber().sendKeys(pNumber);
			Log.info("Mobile number is entered successfully");

			String gender = ExcelUtils.getCellData(iTestCaseRow, Constant.gender);

			if (gender.equals("Male")) {
				Registration_Page.genderMale().sendKeys(Keys.SPACE);
			} else if (gender.equals("Female")) {
				Registration_Page.genderFemale().sendKeys(Keys.SPACE);
			}

			Log.info("Gender is selected successfully");

			Registration_Page.Register_Button().click();
			Log.info("Register button is clicked successfully");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Action | Method execute");
			Log.error("Registration is not successful");
			throw e;
		}

	}

	public static void checkErrors(int iTestCaseRow) throws Exception {

		try {
			if(Registration_Page.First_name().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid firstname \n";
			if(Registration_Page.last_name().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid lastname \n";
			if(Registration_Page.mobileNumber().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid mobile number \n";
			if(Registration_Page.email().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid email \n";
			if(Registration_Page.password().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid password \n";
			if(Registration_Page.Confirm_Password().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid confirm password \n";
			if(Registration_Page.genderMale().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid gender \n";
		} catch (Exception e) {
			Log.error("Exception in Class Registration_Action | Method checkErrors");
			throw e;
		}
	}
}