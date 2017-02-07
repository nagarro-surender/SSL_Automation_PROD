package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Registration_Page extends BaseClass {
	private static WebElement element = null;

	// public static String thankYouMail;

	public Registration_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement First_name() throws Exception {

		try {
			Log.info("Locating First_name element");
			element = Driver.findElement(By.id("firstName"));

			Log.info("First Name field is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method First_name");
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
			Log.error("Exception in Class Registration_Page | Method last_name");
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
			Log.error("Exception in Class Registration_Page | Method email");
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
			Log.error("Exception in Class Registration_Page | Method password");
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
			Log.error("Exception in Class Registration_Page | Method Confirm_Password");
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
			Log.error("Exception in Class Registration_Page | Method mobileNumber");
			Log.error("PhoneNumber field is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement genderMale() throws Exception {

		try {
			Log.info("Locating genderMale element");
			element = Driver.findElement(By.xpath(".//*[@id='men']"));
           
			Log.info("Male option is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method genderMale");
			Log.error("Male option is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement genderFemale() throws Exception {

		try {
			Log.info("Locating genderFemale element");
			element = Driver.findElement(By.id("women"));

			Log.info("Female option is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method genderFemale");
			Log.error("Female option is not found on the Registration Page");
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
			Log.error("Exception in Class Registration_Page | Method Register_Button");
			Log.error("Register button is not found on the Registration page");
			throw e;
		}
		return element;

	}

}
