package appModules;

import org.openqa.selenium.Keys;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.FCC_Page;
import pageObjects.Home_Page;
import pageObjects.MyAccount_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class FCC_Action {

	public static void FCC_Verify_BuyFCC_RegisteredUserFlow(int iTestCaseRow) throws Exception {

		Log.info("Verifying the pre populated details for registered user on FCC form");
		/*try {
			System.out.println(FCC_Page.FCC_Form.FCCForm_NameOnCard().getAttribute("value"));
			System.out.println(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName));
			if (!(FCC_Page.FCC_Form.FCCForm_NameOnCard().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName)))) {

				BaseClass.errorValidation += "Name on card is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_DateOfBirth().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.DOB)))) {

				BaseClass.errorValidation += "DOB is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_FirstName().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.firstName)))) {

				BaseClass.errorValidation += "First Name is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_LastName().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.lastName)))) {
				BaseClass.errorValidation += "Last Name is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_Email().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.emailId)))) {
				BaseClass.errorValidation += "Email is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_MobileNo().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber)))) {
				BaseClass.errorValidation += "Mobile Number is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_Gender().isSelected())) {
				BaseClass.errorValidation += "Gender is either not selected or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
*/
	/*	try {
			Log.info("Filling the FCC form as per the user details");
			FCC_Page.FCC_Form.FCCForm_Title().selectByVisibleText(ExcelUtils.getCellData(iTestCaseRow, Constant.title));
			Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_HomeSTDCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeSTD));
			Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_HomeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeLandline));
			Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_OfficeSTDCode()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeSTD));
			FCC_Page.FCC_Form.FCCForm_OfficeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeLandline));
			Thread.sleep(5000);
			//Utils.scrollingToPageElementByCordinate(265, 750);
			// Utils.scrollingToPageElementAdvanced(FCC_Page.AddToBag());

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_BuyFCC_RegisteredUserFlow");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_BuyFCC_RegisteredUserFlow");
			throw new Exception(BaseClass.errorValidation);

		}*/
		
		try {
			//Utils.scrollingToPageElementByelement(FCC_Page.FCC_Form.FCCForm_DateOfBirth());
			Log.info("Filling the FCC form as per the user details for new user");
			Thread.sleep(1000);
			//Utils.verifyElement(FCC_Page.FCC_Form.FCCForm_DateOfBirth());
			//Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_Title().selectByVisibleText(ExcelUtils.getCellData(iTestCaseRow, Constant.title));
			Log.info("Title is selected");
			//Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_DateOfBirth().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.DOB));
			Thread.sleep(2000);
			Log.info("Dateofbirth is selected");
			FCC_Page.FCC_Form.FCCForm_HomeSTDCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeSTD));
			Log.info("homestd is selected");
			Thread.sleep(1000);
			
			FCC_Page.FCC_Form.FCCForm_HomeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeLandline));
			Thread.sleep(1000);
			FCC_Page.FCC_Form.FCCForm_OfficeSTDCode()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeSTD));
			Thread.sleep(1000);
			FCC_Page.FCC_Form.FCCForm_OfficeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeLandline));
			
			Thread.sleep(10000);
			//Utils.scrollingToPageElementByCordinate(936, 386);
			//Utils.verifyElement(FCC_Page.FCC_Form.FCCForm_Email());
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_BuyFCC_GuestUserFlow");
			throw e;
		}
	}

	public static void FCC_Verify_BuyFCC_GuestUserFlow(int iTestCaseRow) throws Exception {
		try {
			Utils.verifyElement(FCC_Page.FCCGuestUserSignUp());
			FCC_Page.FCCGuestUserSignUp().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_BuyFCC_GuestUserFlow");
			throw e;
		}
		try {
			Log.info("Registring the guest user to buy FCC");
			FCC_Page.FCC_User_Registration.First_name()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.firstName));
			FCC_Page.FCC_User_Registration.last_name()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.lastName));
			FCC_Page.FCC_User_Registration.email().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.emailId));
			FCC_Page.FCC_User_Registration.mobileNumber()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber));
			FCC_Page.FCC_User_Registration.password().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.password));
			FCC_Page.FCC_User_Registration.Confirm_Password()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.confirmPassword));
			FCC_Page.FCC_User_Registration.genderMale().sendKeys(Keys.SPACE);

			FCC_Page.FCC_User_Registration.Register_Button().click();
			Log.info("Registration of guest user successfull");
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_BuyFCC_GuestUserFlow");
			throw e;
		}
		try {
			//Utils.scrollingToPageElementByelement(FCC_Page.FCC_Form.FCCForm_DateOfBirth());
			Log.info("Filling the FCC form as per the user details for new user");
			Thread.sleep(5000);
			//Utils.verifyElement(FCC_Page.FCC_Form.FCCForm_DateOfBirth());
			//Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_Title().selectByVisibleText(ExcelUtils.getCellData(iTestCaseRow, Constant.title));
			Log.info("Title is selected");
			//Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_DateOfBirth().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.DOB));
			Thread.sleep(5000);
			Log.info("Dateofbirth is selected");
			FCC_Page.FCC_Form.FCCForm_HomeSTDCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeSTD));
			Log.info("homestd is selected");
			Thread.sleep(5000);
			
			FCC_Page.FCC_Form.FCCForm_HomeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeLandline));
			Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_OfficeSTDCode()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeSTD));
			Thread.sleep(5000);
			FCC_Page.FCC_Form.FCCForm_OfficeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeLandline));
			
			Thread.sleep(20000);
			//Utils.scrollingToPageElementByCordinate(936, 386);
			//Utils.verifyElement(FCC_Page.FCC_Form.FCCForm_Email());
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_BuyFCC_GuestUserFlow");
			throw e;
		}
	}

	public static void FCC_Verify_AddToBag_FCC_ViaHeaderLink(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(FCC_Page.AddToBag());
			FCC_Page.AddToBag().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBag_FCC_ViaHeaderLink");
			throw e;
		}
		
		try {
			FCC_Verify_BuyFCC_RegisteredUserFlow(iTestCaseRow);
			Utils.mouseHover(FCC_Page.AddToBagBottomButton());
			FCC_Page.AddToBagBottomButton().sendKeys(Keys.ENTER);
			//Utils.verifyElement(FCC_Page.AddToBagBottomButton());
			//FCC_Page.AddToBagBottomButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBag_FCC_ViaFooterLink");
			throw e;
		}
	}

	public static void FCC_Verify_AddToBag_FCC_ViaFooterLink(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(FCC_Page.FCC_Links_Footer.FirstCitizenLink());
			FCC_Page.FCC_Links_Footer.FirstCitizenLink().click();

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBag_FCC_ViaFooterLink");
			Log.error(e.getMessage());
			throw e;
		}

		try {
			Utils.verifyElement(FCC_Page.AddToBag());
			FCC_Page.AddToBag().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBag_FCC_ViaFooterLink");
			throw e;
		}
		
		//try {
			//FCC_Verify_BuyFCC_GuestUserFlow(iTestCaseRow);
			//Thread.sleep(5000);
			//Utils.verifyElement(FCC_Page.AddToBagBottomButton());
			//Utils.mouseHover(Home_Page.headerSoppersStopLogo());
			//Utils.mouseHover(FCC_Page.AddToBagBottomButton());
			//FCC_Page.AddToBagBottomButton().sendKeys(Keys.ENTER);
		//} catch (Exception e) {
		//	Log.error(e.getMessage());
			//Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_GuestUser_ViaHeaderLink_on click button");
			//throw e;
		//}

	
		try {
			FCC_Verify_BuyFCC_RegisteredUserFlow(iTestCaseRow);
			Utils.mouseHover(FCC_Page.AddToBagBottomButton());
			FCC_Page.AddToBagBottomButton().sendKeys(Keys.ENTER);
			//Utils.verifyElement(FCC_Page.AddToBagBottomButton());
			//FCC_Page.AddToBagBottomButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBag_FCC_ViaFooterLink");
			throw e;
		}
	}

	public static void FCC_Verify_AddToBagFCC_ViaMyAccountPage(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(MyAccount_Page.MyAccount_LeftMenu.FirstCitizenProfile());
			MyAccount_Page.MyAccount_LeftMenu.FirstCitizenProfile().click();
		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_ViaMyAccountPage");
			Log.error(e.getMessage());
			throw e;
		}
	try {
			Utils.verifyElement(MyAccount_Page.FirstCitizen_Profile.FirstCitizenButton());
			MyAccount_Page.FirstCitizen_Profile.FirstCitizenButton().click();
		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_ViaMyAccountPage");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(FCC_Page.AddToBag());
			FCC_Page.AddToBag().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_ViaMyAccountPage");
			throw e;
		}
		

		try {
			FCC_Verify_BuyFCC_RegisteredUserFlow(iTestCaseRow);
			Utils.mouseHover(FCC_Page.AddToBagBottomButton());
			FCC_Page.AddToBagBottomButton().sendKeys(Keys.ENTER);
			//Utils.verifyElement(FCC_Page.AddToBagBottomButton());
			//FCC_Page.AddToBagBottomButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBag_FCC_ViaFooterLink");
			throw e;
		}
	}

	public static void FCC_Verify_AddToBagFCC_GuestUser_ViaHeaderLink(int iTestCaseRow) throws Exception {
		try {
			Utils.verifyElement(FCC_Page.AddToBag());
			FCC_Page.AddToBag().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_GuestUser_ViaHeaderLink");
			throw e;
		}
		
		try {
			FCC_Verify_BuyFCC_GuestUserFlow(iTestCaseRow);
			Thread.sleep(5000);
			//Utils.verifyElement(FCC_Page.AddToBagBottomButton());
			//Utils.mouseHover(Home_Page.headerSoppersStopLogo());
			Utils.mouseHover(FCC_Page.AddToBagBottomButton());
			FCC_Page.AddToBagBottomButton().sendKeys(Keys.ENTER);
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_GuestUser_ViaHeaderLink_on click button");
			throw e;
		}
	}
	
	public static void FCC_Verify_AddToBagFCC_GuestUser_ViaFooterLink(int iTestCaseRow) throws Exception {
		
		try {
			Utils.verifyElement(FCC_Page.FCC_Links_Footer.FirstCitizenLink());
			FCC_Page.FCC_Links_Footer.FirstCitizenLink().click();

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaFooterLink");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(FCC_Page.AddToBag());
			FCC_Page.AddToBag().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_GuestUser_ViaHeaderLink");
			throw e;
		}
		
		try {
			FCC_Verify_BuyFCC_GuestUserFlow(iTestCaseRow);
			Thread.sleep(5000);
			//Utils.verifyElement(FCC_Page.AddToBagBottomButton());
			//Utils.mouseHover(Home_Page.headerSoppersStopLogo());
			Utils.mouseHover(FCC_Page.AddToBagBottomButton());
			FCC_Page.AddToBagBottomButton().sendKeys(Keys.ENTER);
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_AddToBagFCC_GuestUser_ViaHeaderLink_on click button");
			throw e;
		}
	}
	public static void FCC_Verify_QuickBuyFCC_ViaHeaderLink(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(FCC_Page.QuickBuyRegisteredUser());
			FCC_Page.QuickBuyRegisteredUser().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaHeaderLink");
			throw e;
		}
		
		try {
			FCC_Verify_BuyFCC_RegisteredUserFlow(iTestCaseRow);
			Utils.verifyElement(FCC_Page.QuickBuyRegisteredUserBottomButton());
			FCC_Page.QuickBuyRegisteredUserBottomButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaHeaderLink");
			throw e;
		}
	}

	public static void FCC_Verify_QuickBuyFCC_ViaFooterLink(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(FCC_Page.FCC_Links_Footer.FirstCitizenLink());
			FCC_Page.FCC_Links_Footer.FirstCitizenLink().click();

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaFooterLink");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(FCC_Page.QuickBuyRegisteredUser());
			FCC_Page.QuickBuyRegisteredUser().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaFooterLink");
			throw e;
		}
		
		try {
			FCC_Verify_BuyFCC_RegisteredUserFlow(iTestCaseRow);
			Utils.verifyElement(FCC_Page.QuickBuyRegisteredUserBottomButton());
			FCC_Page.QuickBuyRegisteredUserBottomButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaFooterLink");
			throw e;
		}

	}
	
		

	public static void FCC_Verify_QuickBuyFCC_ViaMyAccountPage(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(MyAccount_Page.MyAccount_LeftMenu.FirstCitizenProfile());
			MyAccount_Page.MyAccount_LeftMenu.FirstCitizenProfile().click();
		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaMyAccountPage");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(MyAccount_Page.FirstCitizen_Profile.FirstCitizenButton());
			MyAccount_Page.FirstCitizen_Profile.FirstCitizenButton().click();
		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaMyAccountPage");
			Log.error(e.getMessage());
			throw e;
		}

		try {
			Utils.verifyElement(FCC_Page.QuickBuyRegisteredUser());
			FCC_Page.QuickBuyRegisteredUser().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaMyAccountPage");
			throw e;
		}


		try {

			FCC_Verify_BuyFCC_RegisteredUserFlow(iTestCaseRow);
			Utils.verifyElement(FCC_Page.QuickBuyRegisteredUserBottomButton());
			FCC_Page.QuickBuyRegisteredUserBottomButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaMyAccountPage");
			throw e;
		}
	}

	public static void FCC_Verify_QuickBuyFCC_GuestUser_ViaHeaderLink(int iTestCaseRow) throws Exception {
		
		try {
			Utils.verifyElement(FCC_Page.FCC_Links_Footer.FirstCitizenLink());
			FCC_Page.FCC_Links_Footer.FirstCitizenLink().click();

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_ViaFooterLink");
			Log.error(e.getMessage());
			throw e;
		}
		
		
		try {
			Utils.verifyElement(FCC_Page.QuickBuyGuestUser());
			FCC_Page.QuickBuyGuestUser().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_GuestUser_ViaHeaderLink");
			throw e;
		}
		

		try {
			FCC_Verify_BuyFCC_GuestUserFlow(iTestCaseRow);
			Utils.verifyElement(FCC_Page.QuickBuyRegisteredUserBottomButton());
			FCC_Page.QuickBuyRegisteredUserBottomButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_QuickBuyFCC_GuestUser_ViaHeaderLink");
			throw e;
		}
	}

	public static void FCC_Verify_EarnPoint_UnlinkedCard_Functionality(int iTestCaseRow) throws Exception {

		try {
			Cart_Page.EnterFCCNumber().sendKeys(ExcelUtils.getCellData(iTestCaseRow,Constant.cardNumberEGVGiftFCC));
			Cart_Page.EarnPointsButton().click();
			if (!(Cart_Page.CartPageAlert().getText().equals("Your Points will be added to your card."))) {
				BaseClass.errorValidation += "Alert message - 'Your Points will be added to your card.' not displayed on cart page.";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_EarnPoint_UnlinkedCard_Functionality");
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_BuyFCC_ViaHeaderLink");
			throw new Exception(BaseClass.errorValidation);

		}
	}
	public static void FCC_Verify_Update_FCCProfile_Functionality(int iTestCaseRow) throws Exception {


		try {
			Utils.verifyElement(FCC_Page.FCCEditCardProfile());
			FCC_Page.FCCEditCardProfile().click();
			
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_Update_FCCProfile_Functionality");
			throw e;
		}
		Log.info("Verifying the pre populated details for registered user on FCC profile");
		try {
			/*System.out.println(FCC_Page.FCC_Form.FCCForm_NameOnCard().getAttribute("value"));
			System.out.println(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName));*/
			if (!(FCC_Page.FCC_Form.FCCForm_NameOnCard().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName)))) {

				BaseClass.errorValidation += "Name on card is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_DateOfBirth().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.DOB)))) {

				BaseClass.errorValidation += "DOB is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_FirstName().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.firstName)))) {

				BaseClass.errorValidation += "First Name is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_LastName().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.lastName)))) {
				BaseClass.errorValidation += "Last Name is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_Email().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidEmailId)))) {
				BaseClass.errorValidation += "Email is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_MobileNo().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber)))) {
				BaseClass.errorValidation += "Mobile Number is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_HomeSTDCode().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.homeSTD)))) {
				BaseClass.errorValidation += "Home STD code is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_HomeLandline().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.homeLandline)))) {
				BaseClass.errorValidation += "Home Landline no. is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_OfficeSTDCode().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.officeSTD)))) {
				BaseClass.errorValidation += "Office STD no. is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_OfficeLandline().getAttribute("value")
					.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.officeLandline)))) {
				BaseClass.errorValidation += "Office Landline no. is either not populated or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		try {
			if (!(FCC_Page.FCC_Form.FCCForm_Gender().isSelected())) {
				BaseClass.errorValidation += "Gender is either not selected or does not match with records \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

		try {
			/*Log.info("Updating the FCC profile as per the user details");
			FCC_Page.FCC_Form.FCCForm_Title().selectByVisibleText(ExcelUtils.getCellData(iTestCaseRow, Constant.title));
			FCC_Page.FCC_Form.FCCForm_HomeSTDCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeSTD));
			FCC_Page.FCC_Form.FCCForm_HomeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.homeLandline));
			FCC_Page.FCC_Form.FCCForm_OfficeSTDCode()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeSTD));
			FCC_Page.FCC_Form.FCCForm_OfficeLandline()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.officeLandline));*/
			Utils.scrollingToPageElementByCordinate(265, 750);
			FCC_Page.FCCUpdateCardProfile().click();

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_Update_FCCProfile_Functionality");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class FCC_Action | Method FCC_Verify_Update_FCCProfile_Functionality");
			throw new Exception(BaseClass.errorValidation);

		}

}
	}