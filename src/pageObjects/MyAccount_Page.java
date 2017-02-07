package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class MyAccount_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> elementList = null;

	public MyAccount_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement GlobalMsg() throws Exception {

		try {
			Log.info("Locating GlobalMsg element");
			element = Driver.findElement(By.xpath("//*[@class='global-alerts']/div"));

			Log.info(" Message field is found on the Page");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method GlobalMsg");
			Log.error("Message field is not found on the Page");
			throw e;
		}

		return element;

	}

	public static class MyAccount {
		public static WebElement FirstCitizenLink() throws Exception {

			try {
				Log.info("Locating First Citizen link element");
				element = Driver.findElement(By.xpath("//a[text()= 'Be a First Citizen']"));

				Log.info("First Citizen link is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenLink");
				Log.error("First Citizen link is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrderbox() throws Exception {

			try {
				Log.info("Locating Recent Order box element");
				element = Driver.findElement(By.xpath("//section[@class='my-account-wpr']//div[@class='recent-order-box']"));

				Log.info("Recent Order box is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrderbox");
				Log.error("Recent Order box is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrderText() throws Exception {

			try {
				Log.info("Locating RecentOrderText element");
				element = Driver.findElement(By.xpath("//section[@class='my-account-wpr']//div[@class='recent-order-box']/h2[contains(text(),'Recent Order')]"));

				Log.info("Recent Order text is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrderText");
				Log.error("Recent Order text is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static List<WebElement> myAccount_OrderId() throws Exception {

			try {
				Log.info("Locating OrderId elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Order ID']"));

				Log.info("Order Id elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_OrderId");
				Log.error("Order Id elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> myAccount_OrderDate() throws Exception {

			try {
				Log.info("Locating Order Date elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Order Date']"));

				Log.info("Order Date elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_OrderDate");
				Log.error("Order Date elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		
		public static List<WebElement> myAccount_AmountPaid() throws Exception {

			try {
				Log.info("Locating Amount paid elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Amount paid']"));

				Log.info("Amount paid elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_AmountPaid");
				Log.error("Amount paid elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> myAccount_Status() throws Exception {

			try {
				Log.info("Locating Status elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Status']"));

				Log.info("Status elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_Status");
				Log.error("Status elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
	}

	public static class FirstCitizen_Profile {
		public static WebElement FirstCitizenButton() throws Exception {

			try {
				Log.info("Locating First Citizen button element");
				element = Driver.findElement(By.xpath("//button[text()= 'BECOME A FIRST CITIZEN']"));

				Log.info("First Citizen button is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenButton");
				Log.error("First Citizen button is not found on the Home Page");
				throw e;
			}

			return element;

		}
	}

	public static class WishList {

		static WebElement mainElement;

		public static WebElement WishListHeading() throws Exception {

			try {
				Log.info("Locating WishListHeading element");
				element = Driver.findElement(By.xpath("//div[@class='wishlist-heading']/div/h1"));

				Log.info("WishListHeading is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListHeading");
				Log.error("WishListHeading is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItems() throws Exception {

			try {
				Log.info("Locating WishListItems element");
				element = Driver.findElement(By.xpath("//div[@class='wishlist-heading']/div/h1/span"));

				Log.info("WishList Item is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItems");
				Log.error("WishList Item is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemCloseBtn() throws Exception {

			try {
				Log.info("Locating WishListItemCloseBtn element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/a/div"));

				Log.info("WishList Item Close button is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemCloseBtn");
				Log.error("WishList Item Close button is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemImg() throws Exception {

			try {
				Log.info("Locating WishListItemImg element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/div[@class='pro-img']"));

				Log.info("Item image is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemImg");
				Log.error("Item image is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemURL() throws Exception {

			try {
				Log.info("Locating WishListItemURL element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/div[@class='pro-img']/a"));

				Log.info("Item URL is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemURL");
				Log.error("Item URL is not found on the Home Page");
				throw e;
			}

			return element;

		}

	}

	public static class ProfilePage {

		static WebElement mainElement;
		static WebElement subElement;
		static String element1;

		public static WebElement PersonalInfoText() throws Exception {

			try {
				Log.info("Locating PersonalInfoText element");
				element = Driver.findElement(By.xpath("//div[@class='my-acc-heading']/div/h1"));

				Log.info("PersonalInfoText field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method PersonalInfoText");
				Log.error("PersonalInfoText field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement EditProfileBtn() throws Exception {

			try {
				Log.info("Locating EditProfileBtn element");
				element = Driver.findElement(By.xpath("//a[contains(text(), 'Edit Profile')]"));

				Log.info("EditProfileBtn is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditProfileBtn");
				Log.error("EditProfileBtn is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement FirstName() throws Exception {

			try {
				Log.info("Locating FirstName element");
				element = Driver.findElement(By.id("profile.firstName"));

				Log.info("FirstName field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstName");
				Log.error("FirstName field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement LastName() throws Exception {

			try {
				Log.info("Locating LastName element");
				element = Driver.findElement(By.id("profile.lastName"));

				Log.info("LastName field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method LastName");
				Log.error("LastName field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Email_Address() throws Exception {

			try {
				Log.info("Locating Email_Address element");
				element = Driver.findElement(By.xpath("profile.email"));

				Log.info("Email_Address field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Email_Address");
				Log.error("Email_Address field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement MobileNumber() throws Exception {

			try {
				Log.info("Locating MobileNumber element");
				element = Driver.findElement(By.id("profile.moibile"));

				Log.info("MobileNumber field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MobileNumber");
				Log.error("MobileNumber field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement HomeStore() throws Exception {

			try {
				Log.info("Locating HomeStore element");
				element = Driver.findElement(By.id("profile.homeStore.name"));

				Log.info("HomeStore field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method HomeStore");
				Log.error("HomeStore field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement DOBCalanderBtn() throws Exception {

			try {
				Log.info("Locating DOBCalanderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='profile.dob']/following-sibling::button"));

				Log.info("DOB calender button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DOBCalanderBtn");
				Log.error("DOB calender button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static class Calender {

			public static WebElement Year() throws Exception {

				try {
					Log.info("Locating Year element");
					element = Driver.findElement(
							By.xpath("//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-year']"));

					Log.info("Year dropdown is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Year");
					Log.error("Year dropdown is not found on the profile Page");
					throw e;
				}

				return element;

			}

			public static WebElement Month() throws Exception {

				try {
					Log.info("Locating Month element");
					element = Driver.findElement(
							By.xpath("//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-month']"));

					Log.info("Month dropdown is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Month");
					Log.error("Month dropdown is not found on the profile Page");
					throw e;
				}

				return element;

			}

			public static WebElement DateTable() throws Exception {

				try {
					Log.info("Locating DateTable element");
					element = Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));

					Log.info("DateTable is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method DateTable");
					Log.error("DateTable is not found on the profile Page");
					throw e;
				}

				return element;

			}

		}

		public static WebElement ProfileUpdateDetails_Button() {

			try {
				Log.info("Locating ProfileUpdateDetails_Button element");
				element = Driver.findElement(By.xpath("//button[contains(text(), 'Save Updates')]"));

				Log.info("Profile UpdateDetails Button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ProfileUpdateDetails_Button");
				Log.error("Profile UpdateDetails Button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Settings() throws Exception {

			try {
				Log.info("Locating Settings element");
				element = Driver.findElement(By.linkText("Settings"));

				Log.info("Settings Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Settings");
				Log.error("Settings Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Addresses() throws Exception {

			try {
				Log.info("Locating Addresses element");
				element = Driver.findElement(By.linkText("Addresses"));

				Log.info("Addresses Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Addresses");
				Log.error("Addresses Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement AddNewAddress() throws Exception {

			try {
				Log.info("Locating AddNewAddress element");
				element = Driver.findElement(By.linkText("Add a new address"));

				Log.info("New Address Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AddNewAddress");
				Log.error("New Address Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static List<WebElement> DefaultShippingAddresstext() throws Exception {

			try {
				Log.info("Locating DefaultShippingAddresstext elements");
				elementList = Driver.findElements(By.xpath("//p[starts-with(text(), 'Default Shipping')]"));

				Log.info("Default shipping list element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DefaultShippingAddresstext");
				Log.error("Default shipping list element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> AddressList() throws Exception {

			try {
				Log.info("Locating AddressList elements");
				elementList = Driver.findElements(By.xpath("//div[@class='list_address']/ul/li"));

				Log.info("Address list element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AddressList");
				Log.error("Address list element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MakeItAsDefaultShippingAddresstext() throws Exception {

			try {
				Log.info("Locating MakeItAsDefaultShippingAddresstext elements");
				elementList = Driver
						.findElements(By.xpath("//a[starts-with(text(), 'Make this my default shipping')]"));

				Log.info("Make this my default shipping element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MakeItAsDefaultShippingAddresstext");
				Log.error("Make this my default shipping element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static WebElement EditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				//element = Driver.findElement(By.xpath("//div[@class='list_address']/ul/li[1]//a[@class='edit']"));
				element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[1]/ul/li[3]/a[2]"));

				Log.info("Edit Address button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement CheckoutEditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				element = Driver.findElement(By.xpath("//div[@class='checkoutAddressID']decendent::a[@class='edit']"));
				//element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[1]/ul/li[3]/a[2]"));

				Log.info("Edit Address button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement DeleteAddressBtn() throws Exception {

			try {
				Log.info("Locating DeleteAddressBtn element");
				//element = Driver.findElement(By.xpath("//div[@class='list_address']/ul/li[1]//a[@class='remove']"));
				element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[2]/ul/li[3]/a[1]"));
				Log.info("Delete address button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DeleteAddressBtn");
				Log.error("Delete address button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static class Address {

			public static WebElement FirstName() throws Exception {

				try {
					Log.info("Locating FirstName element");
					element = Driver.findElement(By.id("address.firstName"));

					Log.info("FirstName field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method FirstName");
					Log.error("FirstName field is not found on the address Page");
					throw e;
				}

				return element;
			}
				
				public static WebElement LastName() throws Exception {

					try {
						Log.info("Locating LastName element");
						element = Driver.findElement(By.id("address.lastName"));

						Log.info("LastName field is found on the address Page");

					} catch (Exception e) {
						Log.error("Exception in Class MyAccount_Page | Method LastName");
						Log.error("FirstName field is not found on the address Page");
						throw e;
					}

					return element;

			}

			public static WebElement PostCode() throws Exception {

				try {
					Log.info("Locating PostCode element");
					element = Driver.findElement(By.id("address.postcode"));

					Log.info("PostCode field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method PostCode");
					Log.error("PostCode field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Address1() throws Exception {

				try {
					Log.info("Locating Address1 element");
					element = Driver.findElement(By.id("address.line1"));

					Log.info("Address field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Address1");
					Log.error("Address field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement City() throws Exception {

				try {
					Log.info("Locating City element");
					element = Driver.findElement(By.id("address.townCity"));

					Log.info("City field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method City");
					Log.error("City field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Phone() throws Exception {

				try {
					Log.info("Locating Phone element");
					element = Driver.findElement(By.id("address.phone"));

					Log.info("Phone field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Phone");
					Log.error("Phone field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Landmark() throws Exception {

				try {
					Log.info("Locating Landmark element");
					element = Driver.findElement(By.id("address.line2"));

					Log.info("Landmark field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Landmark");
					Log.error("Landmark field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement DefaultAddressCheckbox() throws Exception {

				try {
					Log.info("Locating DefaultAddressCheckbox element");
					element = Driver.findElement(By.id("myShippingAddress"));

					Log.info("DefaultAddress Checkbox is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method DefaultAddressCheckbox");
					Log.error("DefaultAddress Checkbox is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement AddAddressBtn() throws Exception {

				try {
					Log.info("Locating AddAddressBtn element");
					element = Driver.findElement(By.id("accountAddAddress"));

					Log.info("AddAddress Button is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method AddAddressBtn");
					Log.error("AddAddress Button is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement CancelBtn() throws Exception {

				try {
					Log.info("Locating CancelBtn element");
					element = Driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));

					Log.info("Cancel Button is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method CancelBtn");
					Log.error("Cancel Button is not found on the address Page");
					throw e;
				}

				return element;

			}

		}

		public static WebElement NewsletterandSubscription() throws Exception {

			try {
				Log.info("Locating NewsletterandSubscription element");
				element = Driver.findElement(By.linkText("Newsletters & Subscriptions"));

				Log.info(" NewsletterandSubscription Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterandSubscription");
				Log.error("NewsletterandSubscription Link is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterServices(String category) throws Exception {

			try {
				Log.info("Locating NewsletterServices element");
				element = Driver.findElement(By.xpath("//*[@class='catergies']//*[@id='"+category+"']"));

				Log.info(" NewsletterServices "+category+ " option is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterServices");
				Log.error("NewsletterServices "+category+ " option is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterFrequency(String freq) throws Exception {

			try {
				Log.info("Locating NewsletterFrequency element");
				element = Driver.findElement(By.xpath("//*[@class='weekly_main']//*[@id='"+freq+"']"));

				Log.info(" NewsletterFrequency "+freq+ " option is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterFrequency");
				Log.error("NewsletterFrequency "+freq+ " option is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterUpdateBtn() throws Exception {

			try {
				Log.info("Locating NewsletterUpdate Button element");
				element = Driver.findElement(By.id("updateBtnId"));

				Log.info(" NewsletterUpdate button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterUpdateBtn");
				Log.error("NewsletterUpdate button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword() throws Exception {

			try {
				Log.info("Locating ChangePassword element");
				element = Driver.findElement(By.id("chngbtn"));

				Log.info(" Change password Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword");
				Log.error("Change password Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_CurrentPassword() throws Exception {

			try {
				Log.info("Locating ChangePassword_CurrentPassword element");
				element = Driver.findElement(By.id("profile.currentPassword"));

				Log.info("Profile currentPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_CurrentPassword");
				Log.error("Profile currentPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_NewPassword() throws Exception {

			try {
				Log.info("Locating ChangePassword_NewPassword element");
				element = Driver.findElement(By.id("profile-newPassword"));

				Log.info("NewPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_NewPassword");
				Log.error("NewPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_NewPasswordConfirm() throws Exception {

			try {
				Log.info("Locating ChangePassword_NewPasswordConfirm element");
				element = Driver.findElement(By.id("profile.checkNewPassword"));

				Log.info(" ChangePassword Confirm NewPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_NewPasswordConfirm");
				Log.error(" ChangePassword Confirm NewPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement UpdatePassword_Btn() throws Exception {

			try {
				Log.info("Locating UpdatePassword_Btn element");
				element = Driver.findElement(By.xpath("//button[@class='sbt-button']"));

				Log.info("Update button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method UpdatePassword_Btn");
				Log.error("Update button  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Cancel_Btn() throws Exception {

			try {
				Log.info("Locating Cancel_Btn element");
				element = Driver.findElement(By.xpath("//button[@id='canclbtn']"));

				Log.info("Cancel button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Cancel_Btn");
				Log.error("Cancel button is not found on the profile Page");
				throw e;
			}

			return element;

		}

	}

	public static class OrderHistory {

		public static WebElement NoOrderText() throws Exception {

			try {
				Log.info("Locating NoOrderText element");
				element = Driver.findElement(By.xpath("//div[@class='content-wpr']/h3"));

				Log.info("No Order message found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NoOrderText");
				Log.error("No Order message not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrdersTab() throws Exception {

			try {
				Log.info("Locating RecentOrdersTab element");
				element = Driver.findElement(By.xpath("//a[text()='Recent Orders']"));

				Log.info("Recent Orders tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrdersTab");
				Log.error("Recent Orders tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement OldOrdersTab() throws Exception {

			try {
				Log.info("Locating OldOrdersTab element");
				element = Driver.findElement(By.xpath("//a[text()='Old Orders']"));

				Log.info("Old Orders tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OldOrdersTab");
				Log.error("Old Orders tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static List<WebElement> OrderId() throws Exception {

			try {
				Log.info("Locating OrderId elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Order ID']"));

				Log.info("Order Id elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderId");
				Log.error("Order Id elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> OrderDate() throws Exception {

			try {
				Log.info("Locating Order Date elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Order Date']"));

				Log.info("Order Date elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderDate");
				Log.error("Order Date elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> TotalQuantity() throws Exception {

			try {
				Log.info("Locating TotalQuantity elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Total Quantity']"));

				Log.info("Total Quantity elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method TotalQuantity");
				Log.error("Total Quantity elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> AmountPaid() throws Exception {

			try {
				Log.info("Locating Amount paid elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Amount paid']"));

				Log.info("Amount paid elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AmountPaid");
				Log.error("Amount paid elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> Status() throws Exception {

			try {
				Log.info("Locating Status elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Status']"));

				Log.info("Status elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Status");
				Log.error("Status elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> Tracking() throws Exception {

			try {
				Log.info("Locating Tracking elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[contains(text(),'Tracking')]"));

				Log.info("Tracking elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Tracking");
				Log.error("Tracking elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> OrderAction() throws Exception {

			try {
				Log.info("Locating OrderAction elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//a[contains(@class, 'sbt-button')]"));

				Log.info("Order Action elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderAction");
				Log.error("Order Action elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static class orderDetails{
			
			public static WebElement orderDetailsSection() throws Exception {

				try {
					Log.info("Locating orderDetailsSection element");
					element = Driver.findElement(By.xpath("//section[@class='my-account-wpr order-detail-page']"));
					Log.info("Order details section is found on Orders page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method orderDetailsSection");
					Log.error("Order details section is not found on Orders page");

					throw (e);

				}

				return element;
			}
		}

	}

	public static class MyAccount_LeftMenu {

		static WebElement mainElement;

		public static WebElement MyShoppersStop() throws Exception {

			try {
				Log.info("Locating MyShoppersStop element");
				mainElement = Driver.findElement(By.xpath("//a[@title='My Shoppers Stop']"));
				Log.info("My Shoppers Stop link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MyShoppersStop");
				Log.error("My Shoppers Stop link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Orders() throws Exception {

			try {
				Log.info("Locating Orders element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Orders']"));
				Log.info("Orders link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Orders");
				Log.error("Orders link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Alerts() throws Exception {

			try {
				Log.info("Locating Alerts element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Alerts']"));
				Log.info("Orders link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Alerts");
				Log.error("Orders link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Wishlist() throws Exception {

			try {
				Log.info("Locating Wishlist element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Wishlist']"));
				Log.info("Wishlist link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Wishlist");
				Log.error("Wishlist link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Profile() throws Exception {

			try {
				Log.info("Locating Profile element");
				mainElement = Driver.findElement(By.xpath("//div[@class='my-menu']/ul/li[5]/a"));
				Log.info("Profile link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Profile");
				Log.error("Profile link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Personalization() throws Exception {

			try {
				Log.info("Locating Personalization element");
				mainElement = Driver.findElement(By.xpath("//div[@class='my-menu']/ul/li[7]/a"));
				Log.info("Personal link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Personalization");
				Log.error("Personal link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement FirstCitizenProfile() throws Exception {

			try {
				Log.info("Locating FirstCitizenProfile element");
				mainElement = Driver.findElement(By.xpath("//a[@title='First Citizen Profile']"));
				Log.info("First Citizen Profile link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenProfile");
				Log.error("First Citizen Profile link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Feedback() throws Exception {

			try {
				Log.info("Locating Feedback element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Feedback']"));
				Log.info("Feedback link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Feedback");
				Log.error("Feedback link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement ReviewsRatings() throws Exception {

			try {
				Log.info("Locating ReviewsRatings element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Reviews & Ratings']"));
				Log.info("Reviews & Ratings link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReviewsRatings");
				Log.error("Reviews & Ratings link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement ShoppingList() throws Exception {

			try {
				Log.info("Locating ShoppingList element");
				mainElement = Driver.findElement(By.linkText("Saved Shopping Lists"));
				Log.info("ShoppingList link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ShoppingList");
				Log.error("ShoppingList link is not found on MyAccount left menu");

				throw (e);

			}
			return mainElement;
		}

	}
}
