package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;

public class Checkout_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> element2 = null;
	private static Select option = null;
	public static String DeliveryOption;
	public static Select sel;

	public Checkout_Page(WebDriver Driver) {
		super(Driver);
	}

	public static class TopNavigation {
		public static WebElement CheckOutText() throws Exception {

			try {
				Log.info("Locating CheckOutText element");
				element = Driver
						.findElement(By.xpath("//section[@class='order-total']//h1[contains(text(), 'CHECKOUT')]"));

				Log.info(" Checkout text is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CheckOutText");
				Log.error("Checkout text is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement shoppersStopLogo() throws Exception {

			try {
				Log.info("Locating shoppersStopLogo element");
				element = Driver.findElement(By.xpath(
						"//header[@class='cp-header']/a/object[@data='/_ui/responsive/common/assets/images/shoppersstop-logo.svg']"));

				Log.info("Shoppers Stop link is found on top navigation on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method shoppersStopLogo");
				Log.error("Shoppers Stop link is not found on top navigation on the checkout page");
				throw e;
			}

			return element;

		}

		public static WebElement backToCartBtn() throws Exception {

			try {
				Log.info("Locating shoppersStopLogo element");
				element = Driver.findElement(By.xpath("//header[@class='cp-header']/div/a"));

				Log.info("Shoppers Stop link is found on top navigation on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method shoppersStopLogo");
				Log.error("Shoppers Stop link is not found on top navigation on the checkout page");
				throw e;
			}

			return element;

		}
	}
	
	

	public static class DeliveryAddress {
		public static WebElement DeliveryAddressNew() throws Exception {

			try {
				Log.info("Locating DeliveryAddressNew element");
				element = Driver.findElement(By.xpath("//div[@class='delivery-address']/div[@class='delivery-form']"));

				Log.info(" New Address form is found");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DeliveryAddressNew");
				Log.error("New Address form is not found");
				throw e;
			}

			return element;

		}

		public static WebElement AddNewAddressBtn() throws Exception {

			try {
				Log.info("Locating AddNewAddressBtn element");
				element = Driver
						.findElement(By.xpath("//div[@class='delivery-addresses']/div/a[text()= 'Add new address']"));

				Log.info("Add new address button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method AddNewAddressBtn");
				Log.error("Add new address button is not found on the checkout Page");
				throw e;

			}

			return element;

		}

		public static WebElement ProceedToPayment() throws Exception {

			try {
				Log.info("Locating ProceedToPayment element");
				element = Driver.findElement(By.xpath("//button[text()='Proceed to payment']"));

				Log.info("Proceed to Payment button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ProceedToPayment");
				Log.error("Proceed to Payment button is not found on the checkout Page");
				throw e;

			}

			return element;

		}

		public static List<WebElement> DeliveryAddressExistingList() throws Exception {

			try {
				Log.info("Locating DeliveryAddressExistingList elements");
				element2 = Driver
						.findElements(By.xpath("//div[@class='delivery-addresses']//div[@class='viewport']//li"));

				Log.info("Existing address list is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DeliveryAddressExistingList");
				Log.error("Existing address list is not found on the checkout Page");
				throw e;

			}

			return element2;

		}

		public static WebElement firstName() throws Exception {

			try {
				Log.info("Locating firstName element");
				element = Driver.findElement(By.xpath("//*[@id='addressForm']//input[@name='firstName']"));

				Log.info("First name field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method firstName");
				Log.error("First name field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement lastName() throws Exception {

			try {
				Log.info("Locating lastName element");
				element = Driver.findElement(By.xpath("//*[@id='addressForm']//input[@name='lastName']"));

				Log.info("Last name field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method lastName");
				Log.error("Last name field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement phone() throws Exception {

			try {
				Log.info("Locating phone element");
				element = Driver.findElement(By.xpath("//*[@id='phone']"));

				Log.info("Phone field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method phone");
				Log.error("Phone field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement address1() throws Exception {

			try {
				Log.info("Locating address1 element");
				element = Driver.findElement(By.xpath("//*[@id='addressForm']/input[@name='line1']"));

				Log.info("Address 1 field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method address1");
				Log.error("Address 1 field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement address2() throws Exception {

			try {
				Log.info("Locating address2 element");
				element = Driver.findElement(By.xpath("//*[@id='addressForm']/input[@name='line2']"));

				Log.info("Address 2 field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method address2");
				Log.error("Address 2 field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement Postcode() throws Exception {

			try {
				Log.info("Locating Postcode element");
				element = Driver.findElement(By.xpath("//*[@id='postcode']"));

				Log.info("Postcode field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Postcode");
				Log.error("Postcode field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement city() throws Exception {

			try {
				Log.info("Locating city element");
				element = Driver.findElement(By.xpath("//*[@id='townCity']"));

				Log.info("City field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method city");
				Log.error("City field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement TermsandConditionsCheckBox() throws Exception {

			try {
				Log.info("Locating TermsandConditionsCheckBox element");
				element = Driver.findElement(By.xpath("//*[@id='addressForm']//label[@for='saveInAddressBook']"));

				Log.info("Terms and condition checkbox is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method TermsandConditionsCheckBox");
				Log.error("Terms and condition checkbox is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement SaveandContinueBtn() throws Exception {

			try {
				Log.info("Locating SaveandContinueBtn element");
				element = Driver.findElement(By.xpath("//*[@id='addressForm']/button"));

				Log.info("Save and continue button is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SaveandContinueBtn");
				Log.error("Save and continue button is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

	}

	public static class Paymentinfo {
		public static WebElement PaymentClass() throws Exception {

			try {
				Log.info("Locating PaymentClass element");
				element = Driver.findElement(By.xpath("//div[@class='payment-information']"));

				Log.info("Payment class is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PaymentClass");
				Log.error("Payment class is not found on the checkout Page");
				throw e;

			}

			return element;

		}

		public static WebElement PromoCodeTextBox() throws Exception {

			try {
				Log.info("Locating PromoCodeTextBox element");
				element = Driver.findElement(By.xpath("//*[@id='paymentpromocode']/input[@name='voucherCode']"));

				Log.info("Promo code text field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PromoCodeTextBox");
				Log.error("Promo code text field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement PromoCodeApplyBtn() throws Exception {

			try {
				Log.info("Locating PromoCodeApplyBtn element");
				element = Driver.findElement(By.xpath("//*[@id='paymentpromocode']/input[@type='submit']"));

				Log.info("Promo code Apply button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PromoCodeApplyBtn");
				Log.error("Promo code Apply button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemGiftCard() throws Exception {

			try {
				Log.info("Locating RedeemGiftCard element");
				element = Driver.findElement(
						By.xpath("//div[@class='reedem-wrap']//h5[contains(text(),'Gift Card')]/ancestor::li"));

				Log.info("Redeem Gift Card/EGift voucher dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemGiftCard");
				Log.error("Redeem Gift Card/EGift voucher dropdown is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemedGiftCardEGVAmount() throws Exception {

			try {
				Log.info("Locating RedeemedGiftCardEGVAmount element");
				element = Driver
						.findElement(By.xpath("//div[@class='reedem-wrap']//h5[contains(text(),'Gift Card')]/span"));

				Log.info("Redeemed Gift Card/EGift voucher amount container is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemedGiftCardEGVAmount");
				Log.error("Redeemed Gift Card/EGift voucher amount container is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemFCC() throws Exception {

			try {
				Log.info("Locating First Citizen Points element");
				element = Driver.findElement(
						By.xpath("//div[@class='reedem-wrap']//h5[contains(text(),'First Citizen')]/ancestor::li"));

				Log.info("First Citizen Points dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemFCC");
				Log.error("First Citizen Points dropdown is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemCardTypeDiv() throws Exception {

			try {
				Log.info("Locating RedeemCardTypeDiv element");
				element = Driver.findElement(By.xpath("//*[@id='checkoutNewGiftCardForm']//select"));

				Log.info("Redeem card type division field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardTypeDiv");
				Log.error("Redeem card type division field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static Select RedeemCardType() throws Exception {

			try {
				Log.info("Locating RedeemCardType element");
				option = new Select(Driver.findElement(By.xpath("//*[@id='checkoutNewGiftCardForm']//select")));

				Log.info("Redeem card type field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardType");
				Log.error("Redeem card type field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement RedeemCardNumber() throws Exception {

			try {
				Log.info("Locating RedeemCardNumber element");
				element = Driver.findElement(By.xpath("//*[@id='checkout.new.giftCard.number']"));

				Log.info("Redeem Gift Card/EGift number is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardNumber");
				Log.error("Redeem Gift Card/EGift number is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemCardPin() throws Exception {

			try {
				Log.info("Locating RedeemCardPin element");
				element = Driver.findElement(By.xpath("//*[@id='checkout.new.giftCard.pin']"));

				Log.info("Redeem Gift Card/EGift pin is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardPin");
				Log.error("Redeem Gift Card/EGift pin is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemCard_AmtToRedeem() throws Exception {

			try {
				Log.info("Locating RedeemCard_AmtToRedeem element");
				element = Driver.findElement(By.xpath("//*[@id='checkout.new.giftCard.amount']"));

				Log.info("Gift Card/EGift amount to redeem is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCard_AmtToRedeem");
				Log.error("Gift Card/EGift amount to redeem is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemCardBtn() throws Exception {

			try {
				Log.info("Locating RedeemCardBtn element");
				element = Driver.findElement(
						By.xpath("//*[@id='checkoutNewGiftCardForm']/div[@class='gift-card-holder']/button"));

				Log.info("Redeem button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardBtn");
				Log.error("Redeem button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement AddCard() throws Exception {

			try {
				Log.info("Locating AddCard element");
				element = Driver.findElement(By.xpath("//div[@class='add-card']"));

				Log.info("Add card button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method AddCard");
				Log.error("Add card button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemAmount() {

			try {
				Log.info("Locating Redeem Amount field for FCC");
				element = Driver.findElement(
						By.xpath("//div[@id='firstcitizen']//form[@id='checkoutFCCForm']//input[@name='amount']"));

				Log.info("Redeem amount field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardBtn");
				Log.error("Redeem amount field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemPassword() {
			try {
				Log.info("Locating Redeem Password field for FCC");
				element = Driver.findElement(
						By.xpath("//div[@id='firstcitizen']//form[@id='checkoutFCCForm']//input[@type='password']"));

				Log.info("Redeem password field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemPassword");
				Log.error("Redeem password field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemButton() {
			try {
				Log.info("Locating Redeem Button field for FCC");
				element = Driver.findElement(By.xpath(
						"//div[@id='firstcitizen']//form[@id='checkoutFCCForm']//button[@class='continue-btn']"));

				Log.info("Redeem Button field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemButton");
				Log.error("Redeem Button field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ProceedToPaymentButton() {
			try {
				Log.info("Locating ProceedToPayment Button on checkout page ");
				element = Driver.findElement(By.xpath(
						"*//button[@class='continue-btn']"));

				Log.info("ProceedToPayment Button found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemButton");
				Log.error("Redeem Button field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemdAmountText() {
			try {
				Log.info("Locating Redeemd amount text for FCC");
				element = Driver.findElement(By.xpath(".//*[@id='firstcitizen']//div[@class='redeemed-done']"));

				Log.info("Redeem Amount text field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemdAmountText");
				Log.error("Redeemd amount text for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCAvailableAmountText() {
			try {
				Log.info("Locating Redeemd amount text for FCC");
				element = Driver.findElement(By.xpath(".//*[@id='firstcitizen']//div[@class='summary']/p[3]"));

				Log.info("FCC Available amount text is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCAvailableAmountText");
				Log.error("FCC Available amount text is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RemoveFCC() {
			try {
				Log.info("Locating Delete Icon for removing FCC");
				element = Driver.findElement(By.xpath(".//*[@id='firstcitizen']//div[@class='redeemed-done']/a/span"));

				Log.info("Delete Icon for removing FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RemoveFCC");
				Log.error("Delete Icon for removing FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement TotalAmount() {
			try {
				Log.info("Locating Total amount price element");
				element = Driver.findElement(By.xpath(
						"//div[@class='reedem-summary']//label[text()='Total Amount']//following-sibling::span"));

				Log.info("Total amount element is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method TotalAmount");
				Log.error("Total amount element is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemedAmount() {
			try {
				Log.info("Locating Redeemed Amount element");
				element = Driver.findElement(By.xpath(
						"//div[@class='reedem-summary']//label[text()='Redeemed Amount']//following-sibling::span"));

				Log.info("Redeemed Amount is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemedAmount");
				Log.error("Redeemed Amount is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement BalancePayableAmount() {
			try {
				Log.info("Locating Balance payable Amount element");
				element = Driver.findElement(By.xpath(
						"//div[@class='reedem-summary']//label[text()='Balance payable Amount']//following-sibling::span"));

				Log.info("Balance payable Amount is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method BalancePayableAmount");
				Log.error("Balance payable Amount is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement CreditCardOption() throws Exception {

			try {
				Log.info("Locating CreditCardOption element");
				element = Driver
						.findElement(By.xpath("//div[@class='payment-options']//li[contains(@class,'credit-card')]"));

				Log.info("Credit Card payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCardOption");
				Log.error("Credit Card payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement EditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				element = Driver.findElement(By.xpath("//*[@class='delivery-address']//li[1]//*[@class='edit']"));
				//element = Driver.findElement(By.xpath("a[@href='/checkout/multi/delivery-address/edit?editAddressCode=8894921408535']"));
				
				//element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[1]/ul/li[3]/a[2]"));

				Log.info("Edit Address button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the profile Page");
				throw e;
			}

			return element;

		}
		public static WebElement DebitCardOption() throws Exception {

			try {
				Log.info("Locating DebitCardOption element");
				element = Driver
						.findElement(By.xpath("//div[@class='payment-options']//li[contains(@class,'debit-card')]"));

				Log.info("Debit Card payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCardOption");
				Log.error("Debit Card payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement NetBankingOption() throws Exception {

			try {
				Log.info("Locating NetBankingOption element");
				element = Driver
						.findElement(By.xpath("//div[@class='payment-options']//li[contains(@class,'net-banking')]"));

				Log.info("NetBanking payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBankingOption");
				Log.error("NetBanking payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement CODOption() throws Exception {

			try {
				Log.info("Locating CODOption element");
				element = Driver
						.findElement(By.xpath("//div[@class='payment-options']//li[contains(@class,'codelivery')]"));

				Log.info("COD payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CODOption");
				Log.error("COD payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement CreditCard_CardNumber() throws Exception {

			try {
				Log.info("Locating CreditCard_CardNumber element");
				element = Driver.findElement(By.xpath("//*[@id='creditCardForm']//input[@class='card_number']"));

				Log.info("Credit Card number field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_CardNumber");
				Log.error("Credit Card number field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement CreditCard_CVV() throws Exception {

			try {
				Log.info("Locating CreditCard_CVV element");
				element = Driver.findElement(By.xpath("//*[@id='creditCardForm']//input[@class='password']"));

				Log.info("Credit Card CVV field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_CVV");
				Log.error("Credit Card CVV field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static Select CreditCard_ExpiryMonth() throws Exception {

			try {
				Log.info("Locating CreditCard_ExpiryMonth element");
				option = new Select(
						Driver.findElement(By.xpath("//*[@id='creditCardForm']//select[@name='expiry_month']")));

				Log.info("Credit Card expiry month field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_ExpiryMonth");
				Log.error("Credit Card expiry month field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select CreditCard_ExpiryYear() throws Exception {

			try {
				Log.info("Locating CreditCard_ExpiryYear element");
				option = new Select(
						Driver.findElement(By.xpath("//*[@id='creditCardForm']//select[@name='expiry_year']")));

				Log.info("Credit Card expiry year field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_ExpiryYear");
				Log.error("Credit Card expiry year field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select CreditCard_Name() throws Exception {

			try {
				Log.info("Locating CreditCard_Name element");
				option = new Select(
						Driver.findElement(By.xpath("//*[@id='creditCardForm']//select[@name='card_name']")));

				Log.info("Credit Card name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_Name");
				Log.error("Credit Card name field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement CreditCard_PlaceOrderBtn() throws Exception {

			try {
				Log.info("Locating CreditCard_PlaceOrderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='creditCardButton']"));

				Log.info("Credit Card place order button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_PlaceOrderBtn");
				Log.error("Credit Card place order button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement DebitCard_CardNumber() throws Exception {

			try {
				Log.info("Locating DebitCard_CardNumber element");
				element = Driver.findElement(By.xpath("//*[@id='debitCardForm']//input[@class='card_number']"));

				Log.info("Debit Card number field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_CardNumber");
				Log.error("Debit Card number field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement DebitCard_CVV() throws Exception {

			try {
				Log.info("Locating DebitCard_CVV element");
				element = Driver.findElement(By.xpath("//*[@id='debitCardForm']//input[@class='password']"));

				Log.info("Debit Card CVV field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_CVV");
				Log.error("Debit Card CVV field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static Select DebitCard_ExpiryMonth() throws Exception {

			try {
				Log.info("Locating DebitCard_ExpiryMonth element");
				option = new Select(
						Driver.findElement(By.xpath("//*[@id='debitCardForm']//select[@name='expiry_month']")));

				Log.info("Debit Card expiry month field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_ExpiryMonth");
				Log.error("Debit Card expiry month field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select DebitCard_ExpiryYear() throws Exception {

			try {
				Log.info("Locating DebitCard_ExpiryYear element");
				option = new Select(
						Driver.findElement(By.xpath("//*[@id='debitCardForm']//select[@name='expiry_year']")));

				Log.info("Debit Card expiry year field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_ExpiryYear");
				Log.error("Debit Card expiry year field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select DebitCard_Name() throws Exception {

			try {
				Log.info("Locating DebitCard_Name element");
				option = new Select(
						Driver.findElement(By.xpath("//*[@id='debitCardForm']//select[@name='card_name']")));

				Log.info("Debit Card name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_Name");
				Log.error("Debit Card name field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement DebitCard_PlaceOrderBtn() throws Exception {

			try {
				Log.info("Locating DebitCard_PlaceOrderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='debitform']"));

				Log.info("Debit Card place order button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_PlaceOrderBtn");
				Log.error("Debit Card place order button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement NetBanking_SelectFromVisibleList(String bankName) throws Exception {

			try {
				Log.info("Locating NetBanking_SelectFromVisibleList element");
				element = Driver.findElement(By.xpath("//*[@id='netBankingForm']//label[text()='" + bankName + "']"));

				Log.info("Entered bank option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_SelectFromVisibleList");
				Log.error("Entered bank option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement NetBanking_SelectFromDropdownDiv() throws Exception {

			try {
				Log.info("Locating NetBanking_SelectFromDropdownDiv element");
				element = Driver.findElement(By.xpath("//*[@id='netBankingForm']//select"));

				Log.info("All banks dropdown division element is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_SelectFromDropdownDiv");
				Log.error("All banks dropdown division element is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static Select NetBanking_SelectFromDropdown() throws Exception {

			try {
				Log.info("Locating NetBanking_SelectFromDropdown element");
				option = new Select(Driver.findElement(By.xpath("//*[@id='netBankingForm']//select")));

				Log.info("All banks dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_SelectFromDropdown");
				Log.error("All banks dropdown is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement NetBanking_PlaceOrderBtn() throws Exception {

			try {
				Log.info("Locating NetBanking_PlaceOrderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='orderSubmitNetbanking']"));

				Log.info("NetBanking place order button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_PlaceOrderBtn");
				Log.error("NetBanking place order button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static List<WebElement> PaymentAlerts() throws Exception {

			try {
				Log.info("Locating Payment related alert element");
				element2 = Driver.findElements(By.xpath(".//*[@id='globalMessages']/div[@class='global-alerts']"));

				Log.info("Payment related alert is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PaymentAlerts");
				Log.error("Payment related alert is not found on the checkout Page");
				throw e;
			}

			return element2;

		}

	}

	public static class LoginDetails {

		public static WebElement LoginEmailGuest() throws Exception {

			try {
				Log.info("Locating LoginEmailGuest element");
				element = Driver.findElement(By.xpath("//div[@class='login-guest']//input[@id='email']"));

				Log.info("LoginEmail field is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method LoginEmailGuest");
				Log.error("LoginEmail field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement LoginEmailRegisteredUser() throws Exception {

			try {
				Log.info("Locating LoginEmailRegisteredUser element");
				element = Driver.findElement(By.xpath("//div[@class='login']//*[@id='j_username']"));

				Log.info("LoginEmail field is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method LoginEmailRegisteredUser");
				Log.error("LoginEmail field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement LoginPwdRegisteredUser() throws Exception {

			try {
				Log.info("Locating LoginPwdRegisteredUser element");
				element = Driver.findElement(By.xpath("//div[@class='login']//*[@id='j_password']"));

				Log.info("Login Password field is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method LoginPwdRegisteredUser");
				Log.error("Login Password field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement Optionbtn_RegisteredUser() throws Exception {

			try {
				Log.info("Locating Optionbtn_RegisteredUser element");
				element = Driver.findElement(By.xpath("//label[@for='signin-radio']"));

				Log.info("Option button for registered user having password is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Optionbtn_RegisteredUser");
				Log.error("Option button for registered user having password is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement ContinueBtn() throws Exception {

			try {
				Log.info("Locating ContinueBtn element");
				element = Driver.findElement(By.xpath("//*[@id='checkout-login']"));

				Log.info("Continue button is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ContinueBtn");
				Log.error("Continue button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement DoNotHaveAccountBtn() throws Exception {

			try {
				Log.info("Locating DoNotHaveAccountBtn element");
				element = Driver.findElement(By.xpath("//div[contains(@class,'non-account')]/a"));

				Log.info("DoNotHaveAccountBtn is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DoNotHaveAccountBtn");
				Log.error("DoNotHaveAccountBtn is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement First_name() throws Exception {

			try {
				Log.info("Locating First_name element");
				element = Driver.findElement(By.xpath("//div[@class='signup']//*[@id='firstName']"));

				Log.info("First Name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method First_name");
				Log.error("First Name link is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement last_name() throws Exception {

			try {
				Log.info("Locating last_name element");
				element = Driver.findElement(By.xpath("//div[@class='signup']//*[@id='lastName']"));

				Log.info("Last Name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method last_name");
				Log.error("Last Name link is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement email() throws Exception {

			try {
				Log.info("Locating email element");
				element = Driver.findElement(By.xpath("//div[@class='signup']//*[@id='email']"));

				Log.info("Email field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method email");
				Log.error("Email field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement password() throws Exception {

			try {
				Log.info("Locating password element");
				element = Driver.findElement(By.id("pwd"));

				Log.info("password field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method password");
				Log.error("password field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement Confirm_Password() throws Exception {

			try {
				Log.info("Locating Confirm_Password element");
				element = Driver.findElement(By.xpath("//div[@class='signup']//*[@id='checkPwd']"));

				Log.info("Confirm_Password field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Confirm_Password");
				Log.error("Confirm_Password field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement mobileNumber() throws Exception {

			try {
				Log.info("Locating mobileNumber element");
				element = Driver.findElement(By.xpath("//div[@class='signup']//*[@id='mobileNumber']"));

				Log.info("MobileNumber field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method mobileNumber");
				Log.error("MobileNumber field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement genderMale() throws Exception {

			try {
				Log.info("Locating genderMale element");
				element = Driver.findElement(By.xpath("//*[@id='sslRegisterForm']//label[text()='Male']"));

				Log.info("Male gender option is found on the checkbox Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method genderMale");
				Log.error("Male gender option is not found on the checkbox Page");
				throw e;
			}

			return element;

		}

		public static WebElement genderFemale() throws Exception {

			try {
				Log.info("Locating genderFemale element");
				element = Driver.findElement(By.xpath("//*[@id='sslRegisterForm']//label[text()='Female']"));

				Log.info("Female gender option is found on the checkbox Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method genderFemale");
				Log.error("Female gender option is not found on the checkbox Page");
				throw e;
			}

			return element;

		}

		public static WebElement SignUpBtn() throws Exception {

			try {
				Log.info("Locating SignUpBtn element");
				element = Driver.findElement(By.xpath("//*[@id='sslRegisterForm']//button[@class='continue-btn']"));

				Log.info("Sign up button is found on the checkbox Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
				Log.error("Sign up button is not found on the checkbox Page");
				throw e;
			}

			return element;

		}
	}
	
	public static WebElement DropDownBtn() throws Exception {

		try {
			Log.info("Locating DropDownButton element");
			element = Driver.findElement(By.xpath("//*[@class='order-summary']//*[@class='summary']//*[@class='toggle-summary']"));

			Log.info("Shoppers Stop link is found on top navigation on the checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method shoppersStopLogo");
			Log.error("DropDownButton is not found on top navigation on the checkout page");
			throw e;
		}

		return element;

	}
}
