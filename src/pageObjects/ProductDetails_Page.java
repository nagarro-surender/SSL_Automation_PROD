package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class ProductDetails_Page extends BaseClass {

	private static WebElement element;
	private static List<WebElement> element2;
	static String element1;
	public static String ProductName;

	public ProductDetails_Page(WebDriver driver) {

		super(driver);

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

	public static WebElement breadCrumb() throws Exception {

		try {
			Log.info("Locating breadCrumb element");
			element = Driver.findElement(By.xpath("//ol[@class='breadcrumb']"));

			Log.info("BreadCrumb is found on PDP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductDetails_Page | Method breadCrumb");
			Log.error("BreadCrumb is not found on PDP");
			throw (e);

		}

		return element;

	}

	public static class PersistenceProduct {

		public static WebElement persistentHeader() throws Exception {

			try {
				Log.info("Locating persistentHeader element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky' and contains(@style, 'block')]"));

				Log.info("Persistent Product Header is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method persistentHeader");
				Log.error("Persistent Product Header is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement productPicture() throws Exception {

			try {
				Log.info("Locating productPicture element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//div[@class='pic']"));

				Log.info("Product picture is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productPicture");
				Log.error("Product picture is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productName() throws Exception {

			try {
				Log.info("Locating productName element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//h4"));

				Log.info("Product name is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productName");
				Log.error("Product name is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productSize() throws Exception {

			try {
				Log.info("Locating productSize element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//div[@class='size-guide']"));

				Log.info("Product size is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productSize");
				Log.error("Product size is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productAddToCart() throws Exception {

			try {
				Log.info("Locating productAddToCart element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//*[@id='addToCartButton']"));

				Log.info("Product add to cart button is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productAddToCart");
				Log.error("Product add to cart button is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productQty() throws Exception {

			try {
				Log.info("Locating productQty element");
				//element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//*[@class='qty']"));
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//div[@class='qty clearfix']"));

				Log.info("Product quantity is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productQty");
				Log.error("Product quantity is not found on Persistent header");

				throw (e);

			}

			return element;

		}
	}

	public static class Product {

		public static WebElement Product_Code() throws Exception {

			try {
				Log.info("Locating Product_Code element");
				element = Driver.findElement(
						By.xpath("//*[@class='product_details']//li[@class='product_inner_content']//span"));

				Log.info("Product code found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Code");
				Log.error("Product code not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement txt_Price() throws Exception {

			try {
				Log.info("Locating txt_Price element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']/descendant::div[@class='product_rightside']//div[@class='price_div']/span"));

				Log.info("Product price found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method txt_Price");
				Log.error("Product price not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement color_variant() throws Exception {

			try {
				Log.info("Locating color_variant element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']/descendant::div[@class='product_rightside']//div[@class='variant-selector']"));

				Log.info("Product color variant found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method color_variant");
				Log.error("Product color variant not found on PDP");

				throw (e);

			}

			return element;

		}

		
		public static WebElement size_variant() throws Exception {

			try {
				Log.info("Locating size_variant element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']//div[@class='size_width size_button']"));

				Log.info("Product size variant found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method size_variant");
				Log.error("Product size variant not found on PDP");

				throw (e);

			}

			return element;

		}
		
		public static List<WebElement> size_variant_buttonlist() throws Exception {

			try {
				Log.info("Locating size variant button list element");
				element2 = Driver.findElements(By.xpath(
						"//section[@class='product_details_main']/descendant::div[@class='product_rightside']//button[contains(@class, 'variant-size-button')]"));

				Log.info("Product size variant button list found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method size_variant_buttonlist");
				Log.error("Product size variant button list not found on PDP");

				throw (e);

			}

			return element2;

		}

		public static WebElement productPicture() throws Exception {

			try {
				Log.info("Locating productPicture element");
				element = Driver.findElement(
						By.xpath("//section[@class='product_details_main']//div[@class='slider productslider']"));
				Log.info("Product image found on PDP");

			} catch (Exception e) {

				Log.error("Product image not found on PDP");
				Log.error("Exception in Class ProductDetails_Page | Method productPicture");
				throw (e);

			}

			return element;

		}

		public static WebElement description_tabs() throws Exception {

			try {
				Log.info("Locating description_tabs element");
				element = Driver.findElement(By.xpath("//*[@class='Des_tabs']"));

				Log.info("Product description tabs found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method description_tabs");
				Log.error("Product description tabs not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement description_content() throws Exception {

			try {
				Log.info("Locating description_content element");
				element = Driver.findElement(By.xpath("//*[@class='Des_wrap']"));

				Log.info("Product description content found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method description_content");
				Log.error("Product description content not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement product_thumbnails() throws Exception {

			try {
				Log.info("Locating product_thumbnails element");
				element = Driver.findElement(By.xpath("//*[@id='carousel']"));

				Log.info("Product Thumbnails are found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method product_thumbnails");
				Log.error("Product Thumbnails are not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement ZoomBtn() throws Exception {

			try {
				Log.info("Locating ZoomBtn element");
				element = Driver.findElement(By.xpath("//span[@class='zoom_icon zoom_product']"));

				Log.info("Product Zoom buton is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ZoomBtn");
				Log.error("Product Zoom buton is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement ZoomInWindowDiv() throws Exception {

			try {
				Log.info("Locating ZoomInWindowDiv element");
				element = Driver.findElement(By.xpath("//div[@class='product_zooming' and contains(@style, 'block')]"));

				Log.info("Product Zoom in window div is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ZoomInWindowDiv");
				Log.error("Product Zoom in window div is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement ZoomInWindowCloseBtn() throws Exception {

			try {
				Log.info("Locating ZoomInWindowCloseBtn element");
				element = Driver.findElement(By.xpath("//span[@class='zoom_close']"));

				Log.info("Zoom in window close button is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ZoomInWindowCloseBtn");
				Log.error("Zoom in window close button is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement AddToCartBtn_ZoomPopUp() throws Exception {

			try {
				Log.info("Locating AddToCartBtn_ZoomPopUp element");
				element = Driver.findElement(By.xpath("//div[@class='product_zooming']//*[@id='addToCartButton']"));

				Log.info("Add to cart button is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToCartBtn_ZoomPopUp");
				Log.error("Add to cart button is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_Unit() throws Exception {

			try {
				Log.info("Locating Product_Unit element");
				element = Driver.findElement(By.xpath("//section[@class='product_details_main']//*[@id='qty']"));

				Log.info("Product Unit field found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Unit");
				Log.error("Product Unit field not found");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_Name() throws Exception {

			try {
				Log.info("Locating Product_Name element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']/descendant::div[@class='product_description']/*[@itemprop='name']"));

				Log.info("Product name field is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Name");
				Log.error("Product name field is not found");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_Star_Rating() throws Exception {

			try {
				Log.info("Locating Product_Star_Rating element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']/descendant::div[@class='product_description']/*[@class='star_rating_main']"));

				Log.info("Rating field is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Star_Rating");
				Log.error("Rating field is not found");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_AddToCart() throws Exception {

			try {
				Log.info("Locating Product_AddToCart element");
				element = Driver
						.findElement(By.xpath("//section[@class='product_details_main']//*[@id='addToCartButton']"));

				Log.info("Add to cart button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
				Log.error("Add to cart button is not found on page");

				throw (e);

			}

			return element;

		}
		
		public static WebElement FCC_Product_AddToCart() throws Exception {

			try {
				Log.info("Locating Product_AddToCart element");
				element = Driver
						.findElement(By.xpath(".//*[@id='addToCartButton']"));

				Log.info("Add to cart button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
				Log.error("Add to cart button is not found on page");

				throw (e);

			}

			return element;

		}
		
		
		
		public static WebElement WishList_AddToCart() throws Exception {

			try {
				Log.info("Locating WishList_AddToCart element");
				element = Driver
						.findElement(By.xpath(".//*[@id='addToCartButtonCart_id']"));

				Log.info("Add to cart button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
				Log.error("Add to cart button is not found on page");

				throw (e);

			}

			return element;
		}
			public static WebElement WishlistQuickbtn() throws Exception {

				try {
					Log.info("Locating WishlistQuickbtn element");
					element = Driver
							.findElement(By.xpath(".//*[@id='HashPosition']/div[1]"));

					Log.info("WishlistQuickbtn is found on page");

				} catch (Exception e) {
					Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
					Log.error("Add to cart button is not found on page");

					throw (e);

				}

				return element;

		}

			public static WebElement WishlistProduct() throws Exception {

				try {
					Log.info("Locating WishlistProduct element");
					element = Driver
							.findElement(By.xpath(".//*[@id='HashPosition']"));

					Log.info("WishlistProduct");

				} catch (Exception e) {
					Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
					Log.error("Add to cart button is not found on page");

					throw (e);

				}

				return element;

		}
		public static List<WebElement> AddToWishlistElementList() throws Exception {

			try {
				Log.info("Locating AddToWishlistElementList elements");
				element2 = Driver.findElements(By.xpath("//*[@id='addwishlistId']"));
			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToWishlistElementList");
			}
			return element2;

		}

		public static WebElement AddToWishlistBtn() throws Exception {

			try {
				Log.info("Locating AddToWishlistBtn element");

				element = Driver.findElement(By.xpath("//*[@id='addwishlistId']"));
				
				//element = Driver.findElement(By.xpath("html/body/main/header/div/div/div/div[5]/ul/li[3]/a"));

				Log.info("Add to wishlist button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToWishlistBtn");
				Log.error("Add to wishlist button is not found on page");

				throw (e);

			}

			return element;

		}
		
		public static WebElement AddToWishlistBtnProduct() throws Exception {

			try {
				Log.info("Locating AddToWishlistBtn element");

				element = Driver.findElement(By.xpath("//*[@id='addwishlistId']"));
				

				Log.info("Add to wishlist button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToWishlistBtn");
				Log.error("Add to wishlist button is not found on page");

				throw (e);

			}

			return element;

		}

		public static WebElement RemoveFromWishlistLabel() throws Exception {

			try {
				Log.info("Locating RemoveFromWishlistLabel element");
				//element = Driver.findElement(By.xpath("//*[@id='addwishlistId']/label[text()='Remove from WishList']"));
				element = Driver.findElement(By.xpath(".//*[@id='qv-drop']/li[1]/a/div"));
				

				Log.info("Remove from wishlist text is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method RemoveFromWishlistLabel");
				Log.error("Remove from wishlist text is not found on page");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_CODBtn() throws Exception {

			try {
				Log.info("Locating Product_CODBtn element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//*[@id='cashon']"));

				Log.info("COD link is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_CODBtn");
				Log.error("COD link is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement WriteReview() throws Exception {

			try {
				Log.info("Locating WriteReview element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//a[@class='scroll']"));

				Log.info("Write review link is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method WriteReview");
				Log.error("Write review link is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement PinCode() throws Exception {

			try {
				Log.info("Locating PinCode element");
				element = Driver.findElement(By.xpath("//*[@id='dpincodetxt']"));

				Log.info("PinCode field is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCode");
				Log.error("PinCode field is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement PinCodeChange() throws Exception {

			try {
				Log.info("Locating PinCodeChange element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//*[@id='pincodetxt']"));

				Log.info("PinCode field is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCodeChange");
				Log.error("PinCode field is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement PinCodeCheckBtn() throws Exception {

			try {
				Log.info("Locating PinCodeCheckBtn element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//*[@class='codbtn']"));

				Log.info("PinCode check button is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCodeCheckBtn");
				Log.error("PinCode check button is not present on the page");

				throw (e);

			}

			return element;

		}

		public static List<WebElement> PinCodeSuccessMsg() throws Exception {

			try {
				Log.info("Locating PinCodeSuccessMsg element");
				element2 = Driver.findElements(By.xpath("//div[@class='product_description']//p[@class='pinsuccess']"));

				Log.info("PinCode success message is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCodeSuccessMsg");
				Log.error("PinCode success message is not present on the page");

				throw (e);

			}

			return element2;

		}

		public static WebElement InvalidPinCodeMsg() throws Exception {

			try {
				Log.info("Locating InvalidPinCodeMsg element");
				element = Driver.findElement(By.xpath(
						"//div[@class='product_description']/*[@id='invalidPinID' and contains(@style, 'block')]"));

				Log.info("Invalid pincode message is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method InvalidPinCodeMsg");
				Log.error("Invalid pincode message is present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement InvalidDeliveryAddMsg() throws Exception {

			try {
				Log.info("Locating InvalidDeliveryAddMsg element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//p[@class='pinwrong']"));

				Log.info("Invalid delivery address message is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method InvalidDeliveryAddMsg");
				Log.error("Invalid delivery address message is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement ChangePinBtn() throws Exception {

			try {
				Log.info("Locating ChangePinBtn element");
				element = Driver.findElement(By.xpath("//*[@id='chngbtn']"));

				Log.info("Change pincode button is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ChangePinBtn");
				Log.error("Change pincode button is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement Social_TwitterLink() throws Exception {

			try {
				Log.info("Locating Social_TwitterLink element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']//div[@class='product_description']//a[contains(@title,'Twitter')]"));

				Log.info("Twitter link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_TwitterLink");
				Log.error("Twitter link is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}

		public static WebElement Social_FacebookLink() throws Exception {

			try {
				Log.info("Locating Social_FacebookLink element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']//div[@class='product_description']//a[contains(@title,'Facebook')]"));

				Log.info("Facebook link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_FacebookLink");
				Log.error("Facebook link is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}

		public static WebElement Social_GooglePlusLink() throws Exception {

			try {
				Log.info("Locating Social_GooglePlusLink element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']//div[@class='product_description']//a[contains(@title,'Google Plus')]"));

				Log.info("Google Plus link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_GooglePlusLink");
				Log.error("Google Plus link is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}

		public static WebElement Social_PinterestLink() throws Exception {

			try {
				Log.info("Locating Social_PinterestLink element");
				element = Driver.findElement(By.xpath(
						"//section[@class='product_details_main']//div[@class='product_description']//a[contains(@title,'Pinterest')]"));

				Log.info("Pinterest link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_PinterestLink");
				Log.error("Pinterest link is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}

		public static WebElement WriteReviewBtn() throws Exception {

			try {
				Log.info("Locating WriteReviewBtn element");
				element = Driver.findElement(
						By.xpath("//div[@class='overall_rating_main']//a[@class='sbt-button zoom_write']"));

				Log.info("Write a Review button is present on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method WriteReviewBtn");
				Log.error("Write a Review button is not present on PDP");
				throw e;
			}

			return element;

		}

	}

	public static class ReviewWindow {
		public static WebElement ReviewPopUp() throws Exception {

			try {
				Log.info("Locating ReviewPopUp element");
				element = Driver.findElement(By.xpath("//*[@id='write_review' and contains(@style, 'visible')]"));

				Log.info("Review pop up window is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewPopUp");
				Log.error("Review pop up window is not found");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewTitle() throws Exception {

			try {
				Log.info("Locating ReviewTitle element");
				element = Driver.findElement(By.xpath("//*[@id='reviewHeadline_id']"));

				Log.info("Review title textbox is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewTitle");
				Log.error("Review title textbox is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewDescription() throws Exception {

			try {
				Log.info("Locating ReviewDescription element");
				element = Driver.findElement(By.xpath("//*[@id='reviewComment_id']"));

				Log.info("Review comments textbox is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewDescription");
				Log.error("Review comments textbox is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewSubmitBtn() throws Exception {

			try {
				Log.info("Locating ReviewSubmitBtn element");
				element = Driver.findElement(By.xpath("//*[@id='button']"));

				Log.info("Review submit button is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewSubmitBtn");
				Log.error("Review submit button is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewQuality_VeryGood() throws Exception {

			try {
				Log.info("Locating ReviewQuality_VeryGood element");
				element = Driver.findElement(By.xpath("//*[@class='write_range']//a[text()='4']"));

				Log.info("Review star rating Very Good is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewQuality_VeryGood");
				Log.error("Review star rating Very Good is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewStar_4() throws Exception {

			try {
				Log.info("Locating ReviewStar_4 element");
				element = Driver.findElement(By.xpath("//*[@class='star-rating']/label[@class='star rb8l']"));

				Log.info("Review star rating 4 is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewStar_4");
				Log.error("Review star rating 4 is not found on write review pop up");
				throw e;
			}

			return element;

		}
	}
}