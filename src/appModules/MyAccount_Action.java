package appModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.MyAccount_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class MyAccount_Action {
	public static String sTAGNAME;
	public static boolean cResult;

	public static void ProfileUpdateOptions(int iTestCaseRow) throws Exception {

		try {

			MyAccount_Page.ProfilePage.EditProfileBtn().click();
			Thread.sleep(2000);
			Log.info("Edit profile button is clicked");
			
			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.Profile_update_User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");
			Thread.sleep(2000);
			LogIn_Page.Profile_upt_submit_bt().click();
			Log.info("Button is entered in user password field");
			Thread.sleep(5000);

			if ("FirstName".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				// Selecting the link profile from Home Page under Top
				// Navigation

				String FirstName = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedFirstName);
				MyAccount_Page.ProfilePage.FirstName().clear();
				MyAccount_Page.ProfilePage.FirstName().sendKeys(FirstName);

				Log.info("First Name is entered on Profile Page");

			}

			if ("LastName".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				// Selecting the link profile from Home Page under Top
				// Navigation

				String LastName = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedLastName);
				MyAccount_Page.ProfilePage.LastName().clear();
				MyAccount_Page.ProfilePage.LastName().sendKeys(LastName);

				Log.info("Last Name is entered on Profile Page");

			}

			if ("MobileNumber".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				String MobileNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMobile);
				MyAccount_Page.ProfilePage.MobileNumber().clear();
				MyAccount_Page.ProfilePage.MobileNumber().sendKeys(MobileNumber);

				Log.info("MobileNumber is entered on Profile Page");
			}

			if ("HomeStore".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				String HomeStore = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedHomeStore);

				Select store = new Select(MyAccount_Page.ProfilePage.HomeStore());
				store.selectByVisibleText(HomeStore);

				Log.info("HomeStore is selected on Profile Page");
			}

			if ("DOB".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				MyAccount_Page.ProfilePage.DOBCalanderBtn().click();
				String year = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedYear);
				String monthvalue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMonth);
				String date = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedDate);

				if (!year.equals("")) {
					Select DOBYear = new Select(MyAccount_Page.ProfilePage.Calender.Year());
					DOBYear.selectByValue(year);
					Log.info("Year value is selected on Profile Page");
				}

				if (!monthvalue.equals("")) {
					Select DOBmonth = new Select(MyAccount_Page.ProfilePage.Calender.Month());
					DOBmonth.selectByVisibleText(monthvalue);
					Log.info("Month value is selected on Profile Page");
				}

				if (!date.equals("")) {
					WebElement dateWidget = MyAccount_Page.ProfilePage.Calender.DateTable();
					List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

					// comparing the text of cell with today's date and clicking
					// it.
					for (WebElement cell : columns) {
						if (cell.getText().equals(date)) {
							Utils.mouseHover(cell);
							cell.click();
							Log.info("Date value is selected on Profile Page");
							break;
						}
					}
				}

				Log.info("DOB is entered on Profile Page");
			}

			if ("".equals(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField))) {

				Log.error("Value for profile page updation attribute is Blank");
				throw new Exception("Value for profile page updation attribute is Blank");

			}

			Utils.mouseHover(MyAccount_Page.ProfilePage.ProfileUpdateDetails_Button());
			MyAccount_Page.ProfilePage.ProfileUpdateDetails_Button().sendKeys(Keys.ENTER);
			Log.info("Profile update button is clicked");
			Thread.sleep(2000);
			String UpdateMsg = MyAccount_Page.GlobalMsg().getText().trim();

			if (ExcelUtils.getCellData(iTestCaseRow, Constant.message1).equals(UpdateMsg)) {
				Log.info("Verfication Passed :Profile page has been updated successfully");

			} else {
				Log.error("Verfication Failed :Profile page not been been updated successfully");
			}

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method ProfileUpdateOptions");
			Log.error("Issue with Profile updation");
			throw (e);

		}

	}

	public static void Change_Password(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Log.info("Profile menu is clicked");
			MyAccount_Page.ProfilePage.Settings().click();
			Log.info("Settings link is clicked");
			MyAccount_Page.ProfilePage.ChangePassword().click();
			Log.info("Change password button is clicked");
			String CurrentPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			MyAccount_Page.ProfilePage.ChangePassword_CurrentPassword().sendKeys(CurrentPassword);
			Log.info("Current password value is entered");
			String NewPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedPassword);
			MyAccount_Page.ProfilePage.ChangePassword_NewPassword().sendKeys(NewPassword);
			Log.info("New password value is entered");
			MyAccount_Page.ProfilePage.ChangePassword_NewPasswordConfirm().sendKeys(NewPassword);
			Log.info("Confirm New password value is entered");
			MyAccount_Page.ProfilePage.UpdatePassword_Btn().click();
			Log.info("Update password button is clicked");
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword());
			
			// Log.info(MyAccount_Page.ProfilePage.ProfileUpdateMeessage);
			Log.info(MyAccount_Page.GlobalMsg().getText());
			if (ExcelUtils.getCellData(iTestCaseRow, Constant.message1).equals(MyAccount_Page.GlobalMsg().getText().trim())) {
				Log.info("Verfication Passed :Profile page has been updated successfully");

			} else {
				Log.info("Verfication Failed :Profile page not been been updated successfully");
				throw new Exception("Profile page not been been updated successfully");
			}

			Log.info("Password changed successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Change_Password");
			Log.error("Password has not been changed");
			throw (e);

		}

	}

	public static void Change_Password_Verify_Fields(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Log.info("Profile menu link is clicked");
			MyAccount_Page.ProfilePage.Settings().click();
			Log.info("Settings link is clicked");
			MyAccount_Page.ProfilePage.ChangePassword().click();
			Log.info("Change password button is clicked");
			Log.info("Veifying presence of all the fields - Current pwd, New pwd and Confirm new pwd");
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword_CurrentPassword());
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword_NewPassword());
			Utils.waitForElement(MyAccount_Page.ProfilePage.ChangePassword_NewPasswordConfirm());

			Log.info("Verification Passed: All fields are present.");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Change_Password_Verify_Fields");
			Log.error("Fields Verification failed");
			throw (e);
		}

	}

	public static void Change_Password_Verify_buttons(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			Log.info("Profile menu link is clicked");
			MyAccount_Page.ProfilePage.Settings().click();
			Log.info("Settings link is clicked");
			MyAccount_Page.ProfilePage.ChangePassword().click();
			Log.info("Change password button is clicked");
			Log.info("Veifying presence of all the buttons - Update password and Cancel");
			Utils.waitForElement(MyAccount_Page.ProfilePage.UpdatePassword_Btn());
			Utils.waitForElement(MyAccount_Page.ProfilePage.Cancel_Btn());

			Log.info("Verification Passed: All buttons are present.");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Change_Password_Verify_buttons");
			Log.error("Button Verification failed");
			throw (e);
		}

	}

	public static void Verify_MyAccountLinks(int iTestCaseRow) throws Exception {

		try {

			MyAccount_Page.MyAccount_LeftMenu.MyShoppersStop().click();
			Log.info("MyShoppersStop button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Orders().click();
			Log.info("Orders button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Alerts().click();
			Log.info("Alerts button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Wishlist().click();
			Log.info("Wishlist button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Profile().click();
			Log.info("Profile button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.FirstCitizenProfile().click();
			Log.info("FirstCitizenProfile button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Personalization().click();
			Log.info("Personalization button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.ReviewsRatings().click();
			Log.info("ReviewsRatings button is clicked");
			MyAccount_Page.MyAccount_LeftMenu.Feedback().click();
			Log.info("Feedback button is clicked");

			Log.info("Verification check has been completed for all the present links on the Accounts Menu");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Verify_MyAccountLinks");
			Log.info("Verification check Failed to check presence of links on the Account Menu");

			throw (e);

		}

	}

	public static void Profile_Add_Address(int iTestCaseRow) throws Exception {

		try {
			MyAccount_Page.ProfilePage.AddNewAddress().click();
			Log.info("Add new address button is clicked");

			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			MyAccount_Page.ProfilePage.Address.FirstName().sendKeys(firstName);
			Log.info("First name value is entered");

			String postCode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			MyAccount_Page.ProfilePage.Address.PostCode().sendKeys(postCode);
			Log.info("PostCode value is entered");

			String address = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			MyAccount_Page.ProfilePage.Address.Address1().sendKeys(address);
			Log.info("Address value is entered");

			String city = ExcelUtils.getCellData(iTestCaseRow, Constant.city);
			MyAccount_Page.ProfilePage.Address.City().sendKeys(city);
			Log.info("City value is entered");

			String landmark = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			MyAccount_Page.ProfilePage.Address.Landmark().sendKeys(landmark);
			Log.info("Landmark value is entered");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			MyAccount_Page.ProfilePage.Address.Phone().sendKeys(phone);
			Log.info("Phone value is entered");

			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
			Log.info("Add address button is clicked");

			Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Profile_Add_Address");
			Log.error("Address is not entered successfully");
			throw (e);

		}

	}

	public static void Profile_Add_Multiple_Address(int iTestCaseRow) throws Exception {

		try {
			//MyAccount_Action.Profile_Add_Address(iTestCaseRow);

			MyAccount_Page.ProfilePage.AddNewAddress().click();
			Log.info("Add new address button is clicked");

			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName);
			MyAccount_Page.ProfilePage.Address.FirstName().sendKeys(firstName);
			Log.info("First name value is entered");
			
			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeLastName);
			MyAccount_Page.ProfilePage.Address.LastName().sendKeys(lastName);
			Log.info("First name value is entered");

			String postCode = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode);
			MyAccount_Page.ProfilePage.Address.PostCode().sendKeys(postCode);
			Log.info("PostCode value is entered");

			String address = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeAddress);
			MyAccount_Page.ProfilePage.Address.Address1().sendKeys(address);
			Log.info("Address value is entered");

			String city = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeCity);
			MyAccount_Page.ProfilePage.Address.City().sendKeys(city);
			Log.info("City value is entered");

			String landmark = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeLandmark);
			MyAccount_Page.ProfilePage.Address.Landmark().sendKeys(landmark);
			Log.info("Landmark value is entered");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeMobile);
			MyAccount_Page.ProfilePage.Address.Phone().sendKeys(phone);
			Log.info("Phone value is entered");

			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
			Log.info("Add address button is clicked");

			Log.info("Second Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Profile_Add_Multiple_Address");
			Log.error("Second Address is not entered successfully");
			throw (e);

		}

	}

	public static void Profile_Edit_Address(int iTestCaseRow) throws Exception {

		try {
			MyAccount_Page.ProfilePage.EditAddressBtn().click();

			String updateField = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField);
			String updateValue = "";

			if ("FirstName".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.FirstName().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedFirstName);
				MyAccount_Page.ProfilePage.FirstName().sendKeys(updateValue);

				Log.info("First Name is entered on Profile Page");

			}

			if ("PostCode".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.PostCode().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedPostCode);
				MyAccount_Page.ProfilePage.Address.PostCode().sendKeys(updateValue);

				Log.info("PostCode is entered on Address Page");

			}

			if ("Address".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.Address1().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedAddress);
				MyAccount_Page.ProfilePage.Address.Address1().sendKeys(updateValue);

				Log.info("Address is entered on Address Page");

			}

			if ("City".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.City().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedCity);
				MyAccount_Page.ProfilePage.Address.City().sendKeys(updateValue);

				Log.info("City is entered on Address Page");

			}

			if ("Landmark".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.Landmark().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedLandmark);
				MyAccount_Page.ProfilePage.Address.Landmark().sendKeys(updateValue);

				Log.info("Landmark is entered on Address Page");

			}

			if ("Phone".equals(updateField)) {

				MyAccount_Page.ProfilePage.Address.Phone().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMobile);
				MyAccount_Page.ProfilePage.Address.Phone().sendKeys(updateValue);

				Log.info("Phone is entered on Address Page");

			}

			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
			Log.info("Update address button is clicked");
			Log.info("Address is updated successfully");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Profile_Edit_Address");
			Log.error("Address is not updated successfully");
			throw (e);

		}

	}

	

	public static void verifyRecentOrder_MyAccountPage(int iTestCaseRow) throws Exception {

		try {

			Utils.verifyElement(MyAccount_Page.MyAccount.RecentOrderbox());
			Utils.verifyElement(MyAccount_Page.MyAccount.RecentOrderText());

			if (MyAccount_Page.MyAccount.myAccount_OrderId().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Failed: Order ID not present \n";
			}
			if (MyAccount_Page.MyAccount.myAccount_OrderDate().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Date not present \n";
			}
			if (MyAccount_Page.MyAccount.myAccount_AmountPaid().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Amount Paid not present \n";
			}
			if (MyAccount_Page.MyAccount.myAccount_Status().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Status not present \n";
			}

			if (!BaseClass.errorValidation.equals("")) {
				throw new Exception(BaseClass.errorValidation);
			}

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method verifyRecentOrder_MyAccountPage");
			Log.error("Issue in verifying recent order details on My Account page");
			throw (e);
		}
	}

	public static void verifyOrderDetails_OrderHistoryPage(int iTestCaseRow) throws Exception {

		try {

			if (MyAccount_Page.OrderHistory.OrderId().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Failed: Order ID not present \n";
			}
			if (MyAccount_Page.OrderHistory.OrderDate().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Date not present \n";
			}
			if (MyAccount_Page.OrderHistory.AmountPaid().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Amount Paid not present \n";
			}
			if (MyAccount_Page.OrderHistory.Tracking().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Tracking number not present \n";
			}
			if (MyAccount_Page.OrderHistory.OrderAction().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Action not present \n";
			}
			if (MyAccount_Page.OrderHistory.Status().size() < 1) {
				BaseClass.errorValidation = BaseClass.errorValidation
						+ "Verification Failed: Order Status not present \n";
			}

			if (!BaseClass.errorValidation.equals("")) {
				throw new Exception(BaseClass.errorValidation);
			}

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method verifyOrderDetails_OrderHistoryPage");
			Log.error("Issue in verifying order details on Order history page");
			throw (e);
		}
	}
}
