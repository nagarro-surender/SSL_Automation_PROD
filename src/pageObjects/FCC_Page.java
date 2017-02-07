package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class FCC_Page extends BaseClass {
	private static WebElement element = null;
	
	public FCC_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement AddToBag() throws Exception {

		try {
			Log.info("Locating Add to Bag button on FCC page");
			
			element = Driver.findElement(By.xpath("//button[contains(@class,'btn-addtocart')]"));
			Log.info("Add to Bag button found on FCC page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method AddToBag");
			Log.error("Add to Bag button does not exist on FCC page");
			throw e;
		}

		return element;

	}

	public static WebElement AddToBagBottomButton() throws Exception {

		try {
			Log.info("Locating Add to Bag button on FCC page");
			element = Driver.findElement(By.xpath(".//*[@id='fccRegForm']/div[2]/button[1]"));
			Log.info("Add to Bag button found on FCC page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method AddToBag");
			Log.error("Add to Bag button does not exist on FCC page");
			throw e;
		}

		return element;

	}

	public static WebElement QuickBuyGuestUser() throws Exception {

		try {
			Log.info("Locating Quick Buy button for guest user on FCC page");
			element = Driver.findElement(By.xpath("//button[@class='cancel-button']"));
			Log.info("Quick Buy button for guest user found on FCC page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method QuickBuyGuestUser");
			Log.error("Quick Buy button for guest user does not exist on FCC page");
			throw e;
		}

		return element;

	}

	public static WebElement QuickBuyRegisteredUser() throws Exception {

		try {
			Log.info("Locating Quick Buy button for registered user on FCC page");
		//	element = Driver.findElement(By.xpath("//button[@class='cancel-button btn-qbuy']"));
			element = Driver.findElement(By.cssSelector("button.cancel-button.btn-qbuy"));
			Log.info("Quick Buy button for registered user found on FCC page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method QuickBuyRegisteredUser");
			Log.error("Quick Buy button for registered user does not exist on FCC page");
			throw e;
		}

		return element;

	}
	
	public static WebElement QuickBuyRegisteredUserBottomButton() throws Exception {

		try {
			Log.info("Locating Quick Buy button for registered user on FCC page");
			element = Driver.findElement(By.xpath("//button[@class='cancel-button btn-qbuy qbuy']"));
			Log.info("Quick Buy button for registered user found on FCC page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method QuickBuyRegisteredUser");
			Log.error("Quick Buy button for registered user does not exist on FCC page");
			throw e;
		}

		return element;

	}

	public static WebElement FCCGuestUserSignUp() throws Exception {

		try {
			Log.info("Locating Sign Up link on Sign In pop up");
			//element = Driver.findElement(
					//By.xpath("//form[@id='loginForm']//a[@class='register-tag']/span[@class='signin-color']"));
			Thread.sleep(5000);
			element = Driver.findElement(
					By.xpath(".//*[@id='member-scroller']/div/div[1]/p/a/span"));
			
			Log.info("Sign Up link found on Sign In pop up");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method FCCGuestUserSignUp");
			Log.error("Sign Up link does not exist on Sign In pop up");
			throw e;
		}

		return element;

	}
	public static WebElement FCCEditCardProfile() throws Exception {

		try {
			Log.info("Locating Edit link on FCC profile page");
			element = Driver.findElement(
					By.xpath("//section[@class='my-account-wpr']//div[@class='first-citizen-wpr']//a"));
			Log.info("Edit link found on FCC profile page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method FCCEditCardProfile");
			Log.error("Edit link does not exist on FCC profile page");
			throw e;
		}

		return element;

	}

	public static WebElement FCCUpdateCardProfile() throws Exception {

		try {
			Log.info("Locating Update button on FCC profile page");
			element = Driver.findElement(
					By.xpath(".//*[@id='fccRegForm']/div[@class='action-btns center']/button[@type='submit']"));
			Log.info("Update button found on FCC profile page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method FCCUpdateCardProfile");
			Log.error("Update button does not exist on FCC profile page");
			throw e;
		}

		return element;

	}

	public static WebElement FCCCanncelUpdateCardProfile() throws Exception {

		try {
			Log.info("Locating Cancel button on FCC profile page");
			element = Driver.findElement(
					By.xpath(".//*[@id='fccRegForm']/div[@class='action-btns center']/button[@type='button']"));
			Log.info("Cancel button found on FCC profile page");

		} catch (Exception e) {
			Log.error("Exception in Class FCC_Page | Method FCCCanncelUpdateCardProfile");
			Log.error("Cancel button does not exist on FCC profile page");
			throw e;
		}

		return element;

	}
	public static class FCC_Form {
		public static WebElement element = null;
		public static Select selectElement = null;

		public static Select FCCForm_Title() throws Exception {

			try {
				Log.info("Locating Title field on FCC Form");
				// selectElement = new
				// Select(Driver.findElement(By.xpath("//select[@id='register.title']")));
				selectElement = new Select((new WebDriverWait(Driver, 20)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='register.title']"))));
				Log.info("Title field found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCC_Form");
				Log.error("Title field does not exist on FCC Form");
				throw e;
			}

			return selectElement;

		}

		public static WebElement FCCForm_NameOnCard() throws Exception {

			try {
				Log.info("Locating Name on Card field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='register.nameOnCard']"));
				Log.info("Name on Card field found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_NameOnCard");
				Log.error("Name on Card field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_NameOnCardSame() throws Exception {

			try {
				Log.info("Locating Name on Card  field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='nameOnCardSame']"));
				Log.info("Name on Card field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_NameOnCardSame");
				Log.error("Name on Card  field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_DateOfBirth() throws Exception {

			try {
				Log.info("Locating DOB field on FCC Form");
				System.out.println(Driver.findElement(By.xpath("//input[@id='register.dateOfBirth']")).getLocation());
				
				element = Driver.findElement(By.xpath("//input[@id='register.dateOfBirth']"));
				Log.info("DOB field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_DateOfBirth");
				Log.error("DOB field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_HomeSTDCode() throws Exception {

			try {
				Log.info("Locating Home STD code field on FCC Form");
				element = Driver.findElement(
						By.xpath("//input[@id='register.fccContactDetails.landLine' and @placeholder='STD']"));
				Log.info("Home STD code field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_HomeSTDCode");
				Log.error("Home STD code field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_HomeLandline() throws Exception {

			try {
				Log.info("Locating Home Landline number field on FCC Form");
				element = Driver.findElement(By.xpath(
						"//input[@id='register.fccContactDetails.landLine' and @placeholder='Home Landline Number']"));
				Log.info("Home Landline number field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_HomeLandline");
				Log.error("Home Landline number field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_OfficeSTDCode() throws Exception {

			try {
				Log.info("Locating Office STD code field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@name='fccContactDetails.officeStd']"));
				Log.info("Office STD code field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_OfficeSTDCode");
				Log.error("Office STD code field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_OfficeLandline() throws Exception {

			try {
				Log.info("Locating Office Landline no. field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='register.fccContactDetails.office']"));
				Log.info("Office Landline no. field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_OfficeLandline");
				Log.error("Office Landline no. field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_FirstName() throws Exception {

			try {
				Log.info("Locating First Name field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='register.firstName']"));
				Log.info("First Name field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_FirstName");
				Log.error("First Name field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_LastName() throws Exception {

			try {
				Log.info("Locating Last Name field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='register.lastName']"));
				Log.info("Last Name field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_LastName");
				Log.error("Last Name field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_Email() throws Exception {

			try {
				Log.info("Locating Email field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='register.email']"));
				Log.info("Email field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_Email");
				Log.error("Email field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_MobileNo() throws Exception {

			try {
				Log.info("Locating Mobile no. field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='register.fccContactDetails.mobile']"));
				Log.info("Mobile no. field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_MobileNo");
				Log.error("Mobile no. field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

		public static WebElement FCCForm_Gender() throws Exception {

			try {
				Log.info("Locating Gender field on FCC Form");
				element = Driver.findElement(By.xpath("//input[@id='gender1']"));
				Log.info("Gender field  found on FCC Form");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FCCForm_Gender");
				Log.error("Gender field does not exist on FCC Form");
				throw e;
			}

			return element;

		}

	}

	public static class FCC_Links_Footer {
		public static WebElement element = null;

		public static WebElement FirstCitizenLink() throws Exception {

			try {
				Log.info("Locating Be a First Citizen link FC non member page");
				element = Driver.findElement(By.xpath("//a[text()='Be a First Citizen']"));
				Log.info("Be a First Citizen link found on FC non member page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method FirstCitizenLink");
				Log.error("Be a First Citizen link does not exist on FC non member page");
				throw e;
			}

			return element;

		}

		public static WebElement LinkYourCard() throws Exception {

			try {
				Log.info("Locating Link your card link FC non member page");
				element = Driver.findElement(
						By.xpath("//div[@class='slider-heading']/following-sibling::a[text()='Link your card']"));
				Log.info("Link your card link found FC non member page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Links_Footer|FCC_Page | Method LinkYourCard");
				Log.error("Link your card link does not exist on FC non member page");
				throw e;
			}

			return element;

		}

		public static WebElement CitiBankCitizenCard() throws Exception {

			try {
				Log.info("Locating Citi Bank Citizen Card link on FC non member page");
				element = Driver.findElement(By.xpath(
						"//div[@class='slider-heading']/following-sibling::a[text()='Be First Citizen Citibank Credit Card']"));
				Log.info("Citi Bank Citizen Card link found on FC non member page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Form|FCC_Page | Method CitiBankCitizenCard");
				Log.error("Citi Bank Citizen Card link does not exist on FC non member page");
				throw e;
			}

			return element;

		}
	}

	public static class FCC_User_Registration {
		public static WebElement element = null;

		public static WebElement First_name() throws Exception {

			try {
				Log.info("Locating First_name element");
				element = Driver.findElement(By.id("firstName"));

				Log.info("First Name field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method First_name");
				Log.error("First Name link is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement last_name() throws Exception {

			try {
				Log.info("Locating lastName element");
				element = Driver.findElement(By.id("lastName"));

				Log.info("Last Name field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method last_name");
				Log.error("Last Name link is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement email() throws Exception {

			try {
				Log.info("Locating email element");
				element = Driver.findElement(By.id("email"));

				Log.info("Email field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method email");
				Log.error("Email field is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement password() throws Exception {

			try {
				Log.info("Locating password element");
				element = Driver.findElement(By.id("password"));

				Log.info("password field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method password");
				Log.error("password field is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement Confirm_Password() throws Exception {

			try {
				Log.info("Locating Confirm_Password element");
				element = Driver.findElement(By.id("checkPwd"));

				Log.info("Confirm_Password field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method Confirm_Password");
				Log.error("Confirm_Password field is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement mobileNumber() throws Exception {

			try {
				Log.info("Locating mobileNumber element");
				element = Driver.findElement(By.id("mobileNumber"));

				Log.info("PhoneNumber field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method mobileNumber");
				Log.error("PhoneNumber field is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement genderMale() throws Exception {

			try {
				Log.info("Locating genderMale element");
				element = Driver.findElement(By.id("men"));

				Log.info("PhoneNumber field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method genderMale");
				Log.error("PhoneNumber field is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement genderFemale() throws Exception {

			try {
				Log.info("Locating genderFemale element");
				element = Driver.findElement(By.id("women"));

				Log.info("PhoneNumber field is found on the Registration Page");

			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method genderFemale");
				Log.error("PhoneNumber field is not found on the Registration Page");
				throw e;
			}

			return element;

		}

		public static WebElement Register_Button() throws Exception {

			try {
				Log.info("Locating Register_Button element");
				element = Driver.findElement(By.id("registerajax"));
				Log.info("Register button is found on the Registration page");
			} catch (Exception e) {
				Log.error("Exception in Class FCC_Page|FCC_User_Registration | Method Register_Button");
				Log.error("Register button is not found on the Registration page");
				throw e;
			}
			return element;

		}
	}
}