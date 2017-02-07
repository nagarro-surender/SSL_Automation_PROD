package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

import utility.Log;
//import utility.Utils;

public class MiniCart_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> elementList = null;
	// private static Select sel = null;

	public MiniCart_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement MiniCartWindow() throws Exception {

		try {
			Log.info("Locating Mini Cart window on the page");
			element = Driver.findElement(
					By.xpath("//div[@class='shopping-wrap js-mini-cart-container' and contains(@style, 'block')]"));

			Log.info("Mini Cart window is found on the page");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartWindow");
			Log.error("Mini Cart window is not found on the page");
			throw e;
		}

		return element;

	}
	
	public static WebElement MiniCart() throws Exception {

		try {
			Log.info("Locating Mini Cart window on the page");
			element = Driver.findElement(
					By.xpath(".//*[@id='minicart_id']"));

			Log.info("Mini Cart window is found on the page");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartWindow");
			Log.error("Mini Cart window is not found on the page");
			throw e;
		}

		return element;

	}

	public static WebElement MiniCartItemCount() throws Exception {

		try {
			Log.info("Locating Mini Cart Item count on the mini cart");
			element = Driver.findElement(By.xpath("//span[@class='qtyHeaderMinicart']"));

			Log.info("Mini Cart Item count is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartItemCount");
			Log.error("Mini Cart Item count is not found on the mini cart");
			throw e;
		}

		return element;

	}

	public static List<WebElement> MiniCartProductCode() throws Exception {

		try {
			Log.info("Locating ProductCode element on the mini cart");

			elementList = Driver
					.findElements(By.xpath("//form[contains(@id, 'updateMiniCartForm')]/input[@name='productCode']"));

			Log.info("ProductCode element is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartProductCode");
			Log.error("ProductCode element is not found on the mini cart");
			throw e;
		}

		return elementList;

	}

	public static WebElement MiniCartNoItemText() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			element = Driver.findElement(By.xpath("//div[@class='shopping-wrap js-mini-cart-container']/p"));

			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}

	public static WebElement removeBtn() throws Exception {

		try {
			Log.info("Locating Remove button on the mini cart");
			element = Driver.findElement(By.xpath(
					"//div[@class='shopping-wrap js-mini-cart-container']/ul/li[1]//*[contains(@id,'removeEntry')]"));

			Log.info("Remove button is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method removeBtn");
			Log.error("Remove button is not found on the mini cart");
			throw e;
		}

		return element;

	}

	public static WebElement MiniCartTotalPrice() throws Exception {

		try {
			Log.info("Locating Total Cart Price value on the mini cart");
			element = Driver.findElement(
					By.xpath("//div[@class='shopping-wrap js-mini-cart-container']//span[@itemprop='price']"));

			Log.info("Total Cart Price value is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartTotalPrice");
			Log.error("Total Cart Price value is not found on the mini cart");
			throw e;
		}

		return element;

	}

	public static List<WebElement> MiniCartProductImages() throws Exception {

		try {
			Log.info("Locating Product Image on the mini cart");
			elementList = Driver
					.findElements(By.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='pic']/a"));

			Log.info("Product Image is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartProductImages");
			Log.error("Product Image is not found on the mini cart");
			throw e;
		}

		return elementList;

	}

	public static class MiniCartProductDetails {
		public static WebElement element = null;
		public static List<WebElement> elementList = null;

		public static List<WebElement> MiniCartProductBrandName() throws Exception {

			try {
				Log.info("Locating Product Brand name on the mini cart");
				elementList = Driver.findElements(
						By.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='details']/h4"));

				Log.info("Product Brand name is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductBrandName");
				Log.error("Product Brand name is not found on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MiniCartProductProductName() throws Exception {

			try {
				Log.info("Locating Product name for products on the mini cart");
				elementList = Driver.findElements(
						By.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='details']/h5/a"));

				Log.info("Product name for products is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductProductName");
				Log.error("Product name for products is not found on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MiniCartProductSpec() throws Exception {

			try {
				Log.info("Locating Product Specifications on the mini cart");
				elementList = Driver.findElements(By
						.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='details']/ul[@class='spec']"));

				Log.info("Product Specifications are found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductSpec");
				Log.error("Product Specifications are not found on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MiniCartProductPrice() throws Exception {

			try {
				Log.info("Locating Product Price tag for products on the mini cart");
				elementList = Driver.findElements(
						By.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='price']/p/span"));

				Log.info("Product Price tag is found for products on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductPrice");
				Log.error("Product Price tag is not found for products on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static WebElement MiniCartCheckOutButton() throws Exception {

			try {
				Log.info("Locating CheckOut Button on the mini cart");
				element = Driver.findElement(
						By.xpath("//div[@class= 'shopping-wrap js-mini-cart-container']//a[@class='checkout-btn']"));

				Log.info("CheckOut Button is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartCheckOutButton");
				Log.error("CheckOut Button is not found on the mini cart");
				throw e;
			}

			return element;

		}

		public static WebElement MiniCartViewBag() throws Exception {

			try {
				Log.info("Locating View bag button on the mini cart");
				element = Driver.findElement(
						By.xpath("//div[@class= 'shopping-wrap js-mini-cart-container']//a[@class='view-btn']"));

				Log.info("View bag button is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartViewBag");
				Log.error("View bag button is not found on the mini cart");
				throw e;
			}

			return element;

		}
	}

}