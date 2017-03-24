package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Log;

public class Static_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> webElements = null;
	private static Select selectElement = null;

	public Static_Page(WebDriver Driver) {
		super(Driver);
	}

	public static Select StoreLocator_SelectCity()throws Exception {
		try {
			Log.info("Locating StoreLocator_SelectCity element");
			selectElement = new Select(Driver.findElement(By.id("city-name")));

			Log.info("City Name drop down present on Store Locator page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method StoreLocator_SelectCity");
			Log.error("City Name drop down is not present on Store Locator page");

			throw (e);

		}
		return selectElement;

	}
	public static Select StoreLocator_SelectStore()throws Exception {
		try {
			Log.info("Locating StoreLocator Select Store element");
			selectElement = new Select(Driver.findElement(By.xpath(".//*[@id='storeFinderForm']//div[@class='store-lists']//select[@class='selected-store ex-select-menu']")));

			Log.info("Select Store drop down present on Store Locator page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method StoreLocator_SelectStore");
			Log.error("Select Store drop down is not present on Store Locator page");

			throw (e);
		}
		return selectElement;

	}

	public static class TrackOrder {

		static WebElement element;

		public static WebElement TrackOrder_Email_Id()throws Exception {
			try {
				Log.info("Locating TrackOrder_Email_Id element");
				element = Driver.findElement(By.id("emailAddress"));
				Log.info("Email Address Field found under Track Your Order Section");
			} catch (Exception e) {
				Log.error("Exception in Class Static_Page | Method TrackOrder_Email_Id");
				Log.error("Email Address Field is not found under Track Your Order Section");
				throw (e);
			}
			return element;
		}

		public static WebElement Order_Number()throws Exception {
			try {
				Log.info("Locating Order_Number element");
				element = Driver.findElement(By.id("orderCode"));
				Log.info("Order Number Field found under Track Your Order Section");

			} catch (Exception e) {
				Log.error("Exception in Class Static_Page | Method Order_Number");
				Log.error("Order Number Field is not found under Track Your Order Section");
				throw (e);
			}
			return element;
		}

		public static WebElement Submit_Button()throws Exception {
			try {
				Log.info("Locating Submit_Button element");
				element = Driver.findElement(By.xpath("//input[@class='sbt-button' and @type='submit']"));
				Log.info("Submit button found under Track Your Order Section");

			} catch (Exception e) {
				Log.error("Exception in Class Static_Page | Method Submit_Button");
				Log.error("Submit button is not found under Track Your Order Section");
				throw (e);
			}
			return element;
		}
	}

	public static WebElement HeaderContainer()throws Exception {
		try {
			Log.info("Locating HeaderContainer element");
			element = Driver.findElement(By.xpath("//header//div[@class='col-md-12 col-lg-12 col-mobile padzero']"));
			Log.info("Header Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method HeaderContainer");
			Log.error("Header Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement MainSlider()throws Exception {
		try {
			Log.info("Locating MainSlider element");
			element = Driver.findElement(By.xpath("//section[@class='main-slider']"));
			Log.info("Main Slider Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method MainSlider");
			Log.error("Main Slider Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement ShippingContainer()throws Exception {
		try {
			Log.info("Locating ShippingContainer element");
			element = Driver.findElement(By.xpath("//section[@class='shipping']"));
			Log.info("Shipping Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method ShippingContainer");
			Log.error("Shipping Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement StyleInspirationContainer()throws Exception {
		try {
			Log.info("Locating StyleInspirationContainer element");
			element = Driver.findElement(By.xpath("//section[@class='style-inspiration']"));
			Log.info("Style Inspiration Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method StyleInspirationContainer");
			Log.error("Style Inspiration Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement latestContainer()throws Exception {
		try {
			Log.info("Locating latestContainer element");
			element = Driver.findElement(By.xpath("//section[@class='latest']"));
			Log.info("Latest From Shoppers Stop Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method latestContainer");
			Log.error("Latest From Shoppers Stop Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement NewArrivalsContainer()throws Exception {
		try {
			Log.info("Locating NewArrivalsContainer element");
			element = Driver.findElement(By.xpath("//section[@class='new-arrivals']"));
			Log.info("New Arrivals Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method NewArrivalsContainer");
			Log.error("New Arrivals Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement OfferZoneContainer() throws Exception {
		try {
			Log.info("Locating OfferZoneContainer element");
			element = Driver.findElement(By.xpath("//section[@class='offer-zone']"));
			Log.info("Offer Zone Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method OfferZoneContainer");
			Log.error("Offer Zone Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement BrandsContainer()throws Exception {
		try {
			Log.info("Locating BrandsContainer element");
			element = Driver.findElement(By.xpath("//section[@class='brands']"));
			Log.info("Brands Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method BrandsContainer");
			Log.error("Brands Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement FavouritesContainer()throws Exception {
		try {
			Log.info("Locating FavouritesContainer element");
			element = Driver.findElement(By.xpath("//section[@class='favourites']"));
			Log.info("Favourites Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method FavouritesContainer");
			Log.error("Favourites Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement SocialHubContainer()throws Exception {
		try {
			Log.info("Locating SocialHubContainer element");
			element = Driver.findElement(By.xpath("//section[@class='social-hub']"));
			Log.info("Social Hub Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method SocialHubContainer");
			Log.error("Social Hub Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement FooterContainer() throws Exception {
		try {
			Log.info("Locating FooterContainer element");
			element = Driver.findElement(By.xpath("//footer[@class='main-footer clearfix']"));
			Log.info("Footer Container found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method FooterContainer");
			Log.error("Footer Container is not found on Home Page");
			throw (e);
		}
		return element;

	}

	public static List<WebElement> MainMenuBarTitle() throws Exception {
		try {
			Log.info("Locating MainMenuBarTitle elements");
			webElements = Driver.findElements(By.xpath(".//div[@id='scroller']/div[1]/ul/li/a"));
			Log.info("Main Menu Bar Title found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method MainMenuBarTitle");
			Log.error("Main Menu Bar Title is not found on Home Page");
			throw (e);
		}
		return webElements;
	}
	public static WebElement MainMenuBarText(int i) throws Exception {
		try {
			Log.info("Locating MainMenuBarTitle elements");
			element = Driver.findElement(By.xpath(".//div[@id='scroller']/div[1]/ul/li["+i+"]/a"));
			Log.info("Main Menu Bar text found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method MainMenuBarText");
			Log.error("Main Menu Bar text does not exist on Home Page");
			throw (e);
		}
		return element;
	}

	public static List<WebElement> SortByInfo()throws Exception {

		try {
			Log.info("Locating sort By information on PLP ");
			webElements = Driver.findElements(By
					.xpath(".//*[@class='plpHeader hidden-sm hidden-xs']/div[3]/ul/li"));
			Log.info("Sort by element is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SortByInfo");
			Log.error("Sort by element is not found on PLP");
			throw (e);
		}

		return webElements;

	}
	public static WebElement SortByInfoText(int i) throws Exception {
		try {
			Log.info("Locating sort by elements information on PLP");
			element = Driver.findElement(By.xpath(".//*[@class='plpHeader hidden-sm hidden-xs']/div[3]/ul/li["+i+"]"));
			Log.info("sort by elementsfound on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method SortByInfoText");
			Log.error("SortByInfoText does not exist on Home Page");
			throw (e);
		}
		return element;
	}
	public static List<WebElement> SubMenuLinks(String title)throws Exception {
		try {
			Log.info("Locating SubMenuLinks elements");
			webElements = Driver.findElements(
					By.xpath("//a[@title='" + title + "']/following-sibling::div/ul/li/div/ul/li/div/ul/li"));
			Log.info("SubMenuLinks found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method SubMenuLinks");
			Log.error("SubMenuLinks is not found on Home Page");
			throw (e);
		}
		return webElements;
	}

	public static List<WebElement> SubMenuCategory(String title) throws Exception {
		try {
			Log.info("Locating SubMenuCategory elements");
			webElements = Driver.findElements(
					By.xpath("//a[@title='" + title + "']/following-sibling::div/ul/li/div/ul/li/div/span"));
			Log.info("SubMenuCategory found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method SubMenuCategory");
			Log.error("SubMenuCategory is not found on Home Page");
			throw (e);
		}
		return webElements;
	}

	public static class GridBox {
		static WebElement element;

		public static WebElement Shipping() throws Exception {
			try {
				Log.info("Locating Shipping element");
				element = Driver.findElement(By.xpath("//ancestor::section[@class='shipping']//a[contains(@href,'shipping')]"));
				Log.info("Shipping link found on Grid Box on Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class Static_Page | Method Shipping");
				Log.error("Shipping link is not found on Grid Box on Home Page");
				throw (e);
			}
			return element;

		}

		public static WebElement ExchangeAndReturns()throws Exception {
			try {
				Log.info("Locating ExchangeAndReturns element");
				element = Driver.findElement(By.xpath("//ancestor::section[@class='shipping']//a[contains(@href,'returns')]"));
				Log.info("Exchange and Returns link found on Grid Box on Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class Static_Page | Method ExchangeAndReturns");
				Log.error("Exchange and Returns link is not found on Grid Box on Home Page");
				throw (e);
			}
			return element;

		}

		public static WebElement CashOnDelivery() throws Exception {
			try {
				Log.info("Locating CashOnDelivery element");
				element = Driver
						.findElement(By.xpath("//ancestor::section[@class='shipping']//a[contains(@href,'how-do-i-pay')]"));
				Log.info("COD link is found on Grid Box Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class Static_Page | Method CashOnDelivery");
				Log.error("COD link is not found on Grid Box Home Page");
				throw (e);
			}
			return element;

		}
	}

	public static WebElement NewsletterEmail() throws Exception {
		try {
			Log.info("Locating NewsletterEmail element");
			element = Driver.findElement(By.id("newsletterEmail"));
			Log.info("Newsletter Email subscribe field is found on Grid Box Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method NewsletterEmail");
			Log.error("Newsletter Email subscribe is not found on Grid Box Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement NewsLetterButton() throws Exception {
		try {
			Log.info("Locating NewsLetterButton element");
			element = Driver.findElement(By.id("newLetterButton"));
			Log.info("Newsletter Subscribe Button is found on Grid Box Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method NewsLetterButton");
			Log.error("Newsletter Subscribe Button is not found on Grid Box Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement NewsLetterAlert() throws Exception {
		try {
			Log.info("Locating NewsLetterAlert element");
			element = Driver.findElement(By.xpath("//form[@id='newsletterSubmitForm']//span[@class='txt-error']"));

			Log.info("NewsLetter Subscription alert is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method NewsLetterAlert");
			Log.error("NewsLetter Subscription alert is not found on the Home Page");
			throw e;
		}

		return element;
	}
}