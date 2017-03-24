package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;


public class Cart_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public Cart_Page(WebDriver Driver) {
		super(Driver);
	}

	/**
	 * =========================================================================
	 * =
	 **/
	public static WebElement ContinueShoppingButton() throws Exception {

		try {
			Log.info("Locating ContinueShoppingButton element");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='continue-shopping-btn hidden-xs hidden-sm']//button[@class='btn-continue-shop']"));

			Log.info("Continue Shopping Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ContinueShoppingButton");
			Log.error("Continue Shopping Button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement ShoppingBagItemCountDetails() throws Exception {

		try {
			Log.info("Locating ShoppingBagItemCountDetails element");
			element = Driver
					.findElement(By.xpath("//section[@class='shopping-bag-wpr']//div['pro-list-heading']//h1/span"));

			Log.info("Shopping Bag Item Count Details exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ShoppingBagItemCountDetails");
			Log.error("Shopping Bag Item Count Details does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement TotalCartPrice() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			//element = Driver.findElement(By.xpath(
					//"//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			element = Driver.findElement(By.xpath("//*[@class='order-total']//div[@class='order-summary']//div[@class='total']"));
			//element = Driver.findElement(By.xpath(//*[@class='order-total'//div[@class='order-summary']//]		
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static WebElement TotalCartPriceCheckout() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			
			element = Driver.findElement(By.xpath("//*[@class='order-total']//div[@class='order-summary']//div[@class='total']//strong"));
			//element = Driver.findElement(By.xpath("html/body/main/section[1]/div[1]/div/div/div/div[2]/strong"));
	
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPriceDropDown() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			
			element = Driver.findElement(By.xpath("//*[@class='summary']//*[@class='toggle-summary active']"));
	
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPriceViewPage() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
				
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPriceViewPagePrice() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
				
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPricecart() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			//element = Driver.findElement(By.xpath("//*[@class='order-total']//div[@class='order-summary']//div[@class='total']"));
			//element = Driver.findElement(By.xpath(//*[@class='order-total'//div[@class='order-summary']//]		
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalMiniCartPrice() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			//element = Driver.findElement(By.xpath(
					//"//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			element = Driver.findElement(By.xpath("//*[@class='order-total']//div[@class='order-summary']//div[@class='total']"));
			//element = Driver.findElement(By.xpath(//*[@class='order-total'//div[@class='order-summary']//]		
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	
	
	public static WebElement TotalCartPriceMain() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			
			//element = Driver.findElement(By.xpath("//*[@class='shopping-wrap js-mini-cart-container']//div[@class='total']"));
			
			element = Driver.findElement(By.xpath("//*[@class='shopping-wrap js-mini-cart-container']//*[@class='total']"));
				
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement MiniCart() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			
			element = Driver.findElement(By.xpath("//*[@class='shopping-wrap js-mini-cart-container']"));
				
					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> ProductImage() throws Exception {

		try {
			Log.info("Locating ProductImage elements");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']//ul[@class='shop-listing']//div[@class='pro-img']//a[2]"));

			Log.info("Product Image elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductImage");
			Log.error("Product Image elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> ProductBrandName() throws Exception {

		try {
			Log.info("Locating ProductBrandName elements");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']//ul[@class='shop-listing']//div[@class='pro-info-shop']/div[@class='mat-name']/a"));

			Log.info("Product Brand Name exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductBrandName");
			Log.error("Product Brand Name does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> ProductName() throws Exception {

		try {
			Log.info("Locating ProductName elements");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']//ul[@class='shop-listing']//div[@class='pro-info-shop']/div[@class='pro-name']/a"));

			Log.info("Product Name exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductName");
			Log.error("Product Name does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> CartInfo() throws Exception {

		try {
			Log.info("Locating Cart Product info elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li"));

			Log.info("Cart Product info elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartInfo");
			Log.error("Cart Product info elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> ProductCode() throws Exception {

		try {

			Log.info("Locating product code info elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[4]/input[@name='productCode']"));

			Log.info("Product code info elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductCode");
			Log.error("Product code info elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> EditCartLink() throws Exception {

		try {
			Log.info("Locating Edit Cart Link elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[4]/a"));

			Log.info("Edit Cart Link elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EditCartLink");
			Log.error("Edit Cart Link does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> UpdateSizeDropDown() throws Exception {

		try {
			Log.info("Locating Update Size DropDown elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[2]//select[contains(@id,'sizeProductCode')]"));

			Log.info("Update Size DropDown elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateSizeDropDown");
			Log.error("Update Size DropDown does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> UpdateQuantity() throws Exception {

		try {
			Log.info("Locating Update Quantity Field elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[3]//input[@class='qt']"));

			Log.info("Update Quantity Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateQuantity");
			Log.error("Update Quantity Field does not exist on the cart page");
			throw e;
		}

		return elements;

	}
	public static List<WebElement> UpdateProductSize() throws Exception {

		try {
			Log.info("Locating Update ProductSize Field elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[2]//*[contains(@id,'sizeProductCode')]"));

			Log.info("Update Quantity Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateQuantity");
			Log.error("Update Quantity Field does not exist on the cart page");
			throw e;
		}

		return elements;

	}
	public static List<WebElement> IncreaseQuantity() throws Exception {

		try {
			Log.info("Locating Increase quantity Link eleemnts on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[3]//div[@class='qt-plus']"));

			Log.info("Increase Quantity Link elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method IncreaseQuantity");
			Log.error("Increase Link elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> DecreaseQuantity() throws Exception {

		try {
			Log.info("Locating Decrease Quantity Link elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[3]//div[@class='qt-minus']"));

			Log.info("Decrease Quantity Link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method DecreaseQuantity");
			Log.error("Decrease Quantity Link elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> UpdateCartItem() throws Exception {

		try {
			Log.info("Locating Update cart link elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[@class='formButtons']//button[@class='update-optn']"));

			Log.info("Update cart link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateCartItem");
			Log.error("Update cart link elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement CheckoutButton() throws Exception {

		try {
			Log.info("Locating Checkout button on the cart page");
			element = Driver
					.findElement(By.xpath("//section[@class='shopping-bag-wpr']//button[@class='btn-place-order']"));
			
			//element = Driver
				//	.findElement(By.xpath("html/body/main/section[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/form/button"));

			Log.info("Checkout button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckoutButton");
			Log.error("Checkout button does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement CheckoutButtonOnCart() throws Exception {

		try {
			Log.info("Locating Checkout button on the cart page");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//button[@class='btn-place-order']"));
			


			Log.info("Checkout button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckoutButton");
			Log.error("Checkout button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> MoveToWishlist() throws Exception {

		try {
			Log.info("Locating Move to wishlist button elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']//ul[@class='shop-listing']//div[@class='product-actions']//div[@class='wishlist-acn']/a"));

			Log.info("Move to wishlist button elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method MoveToWishlist");
			Log.error("Move to wishlist button elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> RemoveProductOnCartPage() throws Exception {

		try {
			Log.info("Locating Remove product icon elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[contains(@id,'removeEntry_')]/a[@id='removeFromCartID']"));

			Log.info("Remove product icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveProductOnCartPage");
			Log.error("Remove product icon elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement CartPageAlertsuccess() throws Exception {

		try {
			Log.info("Locating Cart Page alert on the cart page");
			
			element = Driver.findElement(By.xpath("//*[@id='globalMessages']//*[@class='alert alert-info alert-dismissable']"));
			Log.info("Cart Page alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartPageAlert");
			Log.error("Cart Page alert does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement CartPageAlert() throws Exception {

		try {
			Log.info("Locating Cart Page alert on the cart page");
			//element = Driver.findElement(By.xpath("//div[@class='global-alerts']/div"));
			element = Driver.findElement(By.xpath("//*[@id='globalMessages']//*[@class='alert alert-danger alert-dismissable']"));
			Log.info("Cart Page alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartPageAlert");
			Log.error("Cart Page alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static List<WebElement> ProductPriceInfo() throws Exception {

		try {
			Log.info("Locating Product Price Info field elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']//ul[@class='shop-listing']//div[@class='prod-price hidden-xs hidden-sm']"));
			Log.info("Product Price Info field elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductPriceInfo");
			Log.error("Product Price Info field does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement CoupanCodeField() throws Exception {

		try {
			Log.info("Locating Coupan Code field on the cart page");
			//element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//input[@id='cpnid']"));
			element = Driver.findElement(By.xpath("//*[@id='paymentpromocode']//*[@type='text']"));
			Log.info("Coupan Code field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CoupanCodeField");
			Log.error("Coupan Code field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement CoupanCodeFieldcart() throws Exception {

		try {
			Log.info("Locating Coupan Code field on the cart page");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//input[@id='cpnid']"));

			Log.info("Coupan Code field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CoupanCodeField");
			Log.error("Coupan Code field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement ApplyCoupanButton() throws Exception {

		try {
			Log.info("Locating Apply Coupan Button on the cart page");
			//element = Driver.findElement(By.xpath(
				//	"//section[@class='shopping-bag-wpr']//input[@id='cpnid']/following-sibling::input[@class='btn-applycpn']"));
			
			element = Driver.findElement(By.xpath(
					"//*[@id='paymentpromocode']//*[@class='submit']"));
			Log.info("Apply Coupan Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ApplyCoupanButton");
			Log.error("Apply Coupan Button does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement ApplyCoupanButtoncart() throws Exception {

		try {
			Log.info("Locating Apply Coupan Button on the cart page");
			element = Driver.findElement(By.xpath(
				"//section[@class='shopping-bag-wpr']//input[@id='cpnid']/following-sibling::input[@class='btn-applycpn']"));
			
		
			Log.info("Apply Coupan Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ApplyCoupanButton");
			Log.error("Apply Coupan Button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement InvalidCoupanAlert() throws Exception {

		try {
			Log.info("Locating Invalid Coupan Alert on the cart page");
			//element = Driver.findElement(
					//By.xpath("//section[@class='shopping-bag-wpr']//div[@id='user-coupons-id']/following-sibling::p"));
			
			element = Driver.findElement(
					By.xpath("//*[@id='paymentpromocode']//*[@id='voucherCode-error']"));
			Log.info("Invalid Coupan Alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Invalid Coupan Alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement InvalidCoupanAlertViewBag() throws Exception {

		try {
			Log.info("Locating Invalid Coupan Alert on the cart page");
		
			
			element = Driver.findElement(
					By.xpath("//*[@class='global-alerts']//*[@class='alert alert-danger alert-dismissable']"));
			Log.info("Invalid Coupan Alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Invalid Coupan Alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static WebElement FirstNameFieldAlert() throws Exception {

		try {
			Log.info("Locating Invalid Coupan Alert on the cart page");
		
			
			element = Driver.findElement(
					By.xpath(".//*[@class='ui-tooltip-content']"));
			Log.info("first name field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Invalid Coupan Alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	

	

	public static WebElement BacktoCartPageButton() throws Exception {

		try {
			Log.info("Locating Cart page Back button on the Checkout page");
			
			element = Driver.findElement(
					By.xpath("//*[@class='cp-header']//*[@class='cp-back']"));
			Log.info("Cart page Back button exist on the Checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Cart page Back button does not exist on the Checkout page");
			throw e;
		}

		return element;

	}

	public static WebElement RemoveCouponCode() throws Exception {

		try {
			Log.info("Locating Remove Coupan icon on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='coupon-code']//div[@id='submit-cpn-id']//a"));
			Log.info("Remove Coupan icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveCouponCode");
			Log.error("Remove Coupan icon does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement RemoveCouponCodeCartPage() throws Exception {

		try {
			Log.info("Locating Remove Coupan icon on the cart page");
			element = Driver.findElement(By.xpath("//div[@id='submit-cpn-id']//div[@class='submit-cpn']//a"));
			Log.info("Remove Coupan icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveCouponCode");
			Log.error("Remove Coupan icon does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement SubTotalField() throws Exception {

		try {
			Log.info("Locating Sub Total Field on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='order-summary-box']//div[@class='sub-total']/ul/li[1]"));
			Log.info("Sub Total Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method SubTotalField");
			Log.error("Sub Total Field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	


	public static WebElement DeliveryCahrgesField() throws Exception {

		try {
			Log.info("Locating Delivery Cahrges Field on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='order-summary-box']//div[@class='sub-total']/ul/li[2]"));
			Log.info("Delivery Cahrges Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method DeliveryCahrgesField");
			Log.error("Delivery Cahrges Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement GiftPackingField() throws Exception {

		try {
			Log.info("Locating Gift Packing Field on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='order-summary-box']//div[@class='sub-total']/ul/li[3]"));
			Log.info("Gift Packing Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method GiftPackingField");
			Log.error("Gift Packing Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement CoupanDiscountField() throws Exception {

		try {
			Log.info("Locating Coupan Discount Field on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='order-summary-box']//div[@class='sub-total']/ul/li[4]"));
			Log.info("Coupan Discount Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CoupanDiscountField");
			Log.error("Coupan Discount Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement PayableAmountContainer() throws Exception {

		try {
			Log.info("Locating Payable Amount section on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='order-summary-box']//div[@class='shopping-grand-total']/ul/li[1]"));
			Log.info("Payable Amount section exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method PayableAmountContainer");
			Log.error("Payable Amount section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement YouHaveSavedContainer() throws Exception {

		try {
			Log.info("Locating You have saved section exist on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='order-summary-box']//div[@class='shopping-grand-total']/ul/li[2]"));
			Log.info("You have saved section exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method YouHaveSavedContainer");
			Log.error("You have saved section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement UseGiftCard_Vouchar_Info() throws Exception {

		try {
			Log.info("Locating 'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='order-summary-box']//div[@class='shop-info']"));
			Log.info("'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UseGiftCard_Vouchar_Info");
			Log.error(
					"'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement PinCodeField() throws Exception {

		try {
			Log.info("Locating Pin Code Field on the cart page");
			//element = Driver.findElement(By.xpath(
					//"//section[@class='shopping-bag-wpr']//div[@class='col-md-3 col-lg-3 col-mobile pad-push order-summary']/descendant::form[@id='delivery_pincode_id']//input[@class='delivery_address_input']"));
			
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='col-md-9 col-lg-9 col-mobile shopping-bag-left']//*[@class='delivery-optn hidden-xs hidden-sm']/descendant::form[@id='delivery_pincode_id']//input[@class='delivery_address_input']"));

			Log.info("Pin Code Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method PinCodeField");
			Log.error("Pin Code Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement CheckPinCodeButton() throws Exception {

		try {
			Log.info("Locating Check Pin Code button on the cart page");
		//	element = Driver.findElement(By.xpath(
		//			"//section[@class='shopping-bag-wpr']//div[@class='col-md-3 col-lg-3 col-mobile pad-push order-summary']/descendant::form[@id='delivery_pincode_id']//input[@value='CHECK PINCODE']"));
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='col-md-9 col-lg-9 col-mobile shopping-bag-left']//*[@class='delivery-optn hidden-xs hidden-sm']/descendant::form[@id='delivery_pincode_id']//*[@Value='CHECK']"));

			Log.info("Check Pin Code button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckPinCodeButton");
			Log.error("Check Pin Code button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement InvalidPinCodeAlert() throws Exception {

		try {
			Log.info("Locating Invalid Pin code alert on the cart page");
			//element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='col-md-3 col-lg-3 col-mobile pad-push order-summary']//p[@id='invalidPinID']"));
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='col-md-9 col-lg-9 col-mobile shopping-bag-left']//*[@class='delivery-optn hidden-xs hidden-sm']//p[@id='invalidPinID']"));

			Log.info("Invalid Pin code alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidPinCodeAlert");
			Log.error("Invalid Pin code alert does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement ChangePinCode() throws Exception {

		try {
			Log.info("Locating Change Pin code link on the cart page");
			//element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='col-md-3 col-lg-3 col-mobile pad-push order-summary']/descendant::div[@class='pincode_display']/a"));
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='col-md-9 col-lg-9 col-mobile shopping-bag-left']//*[@class='delivery-optn hidden-xs hidden-sm']/descendant::div[@class='pincode_display']/a"));

			Log.info("Change Pin code link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ChangePinCode");
			Log.error("Change Pin code link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> DeliveryDetails() throws Exception {

		try {
			Log.info("Locating Delivery details for product on the cart page");
			//elements = Driver.findElements(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//form[contains(@id,'updateCartForm')]/following-sibling::div[@class='delivary-time']"));
			elements = Driver.findElements(By.xpath(
					"//*[@class='shopping-bag-wpr']//*[@class='shop-listing']//*[@class='col-md-3 col-sm-12 delivery-options']//ul"));

			Log.info("Delivery details for product exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method DeliveryDetails");
			Log.error("Check Pin Code button does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement FreeDeliveryIcon() throws Exception {

		try {
			Log.info("Locating Free Delivery Icon on the cart page");
		//	element = Driver.findElement(By.xpath(
		//			"//section[@class='shopping-bag-wpr']//div[@class='user-static-info hidden-xs hidden-sm']/ul/li[1]"));
			element = Driver.findElement(By.xpath(
					"//*[contains(@href,'delivery')]"));

			Log.info("Free Delivery Icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FreeDeliveryIcon");
			Log.error("Free Delivery Icon does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement InStoreReturnsLink() throws Exception {

		try {
			Log.info("Locating Free In Store returns link on the cart page");
			//element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='user-static-info hidden-xs hidden-sm']/ul/li[2]/span/a"));
			element = Driver.findElement(By.xpath(
					"//*[contains(@href,'returns')]"));

			Log.info("Free In Store returns link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InStoreReturnsLink");
			Log.error("Free In Store returns link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement AnyQuestionsContainer() throws Exception {

		try {
			Log.info("Locating Any Questions? section exist on the cart page");
		//	element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='user-static-info hidden-xs hidden-sm']/ul/li[3]"));
			element = Driver.findElement(By.xpath(
					"   //div[@class='cp-footer']//*[@class='container container-responsive checkout-container']//*[@class='questions-call']"));

			Log.info("Any Questions? section exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method AnyQuestionsContainer");
			Log.error("Any Questions? section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement EnterFCCNumber() throws Exception {

		try {
			Log.info("Locating First Citizen Card Number Field on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::div[@class='eran-points']//input[@type='text' and @name='CardNumber']"));
			Log.info("First Citizen Card Number Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EnterFCCNumber");
			Log.error("First Citizen Card Number Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement EarnPointsButton() throws Exception {

		try {
			Log.info("Locating Earn Points Button on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::div[@class='eran-points']//input[@class='earn-btn' and @type='submit']"));
			Log.info("Earn Points Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EarnPointsButton");
			Log.error("Earn Points Button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement FirstCitizenLoyalityProgramBanner() throws Exception {

		try {
			Log.info("Locating First Citizen Promotion Banner on the cart page");
			element = Driver.findElement(
					By.xpath("//section[@class='shopping-bag-wpr']/descendant::div[@class='promotion-ad-banner']/a"));
			Log.info("First Citizen Promotion Banner exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FirstCitizenLoyalityProgramBanner");
			Log.error("First Citizen Promotion Banner does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> FromYourWishlistImages() throws Exception {

		try {
			Log.info("Locating From Your Wishlist Images on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::div[@class='recommends-wpr']/descendant::div[@class='product-wpr']//ul"));
			Log.info("From Your Wishlist Images exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FromYourWishlistImages");
			Log.error("From Your Wishlist Images does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement GiftWrapIcon() throws Exception {

		try {
			Log.info("Locating Gift Wrap Icon on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//form[@id='giftWrapFormID']//div[@class='gift-tab']/h2"));
			Log.info("Gift Wrap Icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method GiftWrapIcon");
			Log.error("Gift Wrap Icon does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement AddMessageOnGiftWrapLink() throws Exception {

		try {
			Log.info("Locating Add Message link on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//form[@id='giftWrapFormID']//div[@class='gift-tab']/span/a"));
			Log.info("Add Message link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method AddMessageOnGiftWrapLink");
			Log.error("Add Message link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement AddMessageDropDown() throws Exception {

		try {
			Log.info("Locating Add Message Drop Down on the cart page");
			element = Driver.findElement(By
					.xpath("//section[@class='shopping-bag-wpr']//form[@id='giftWrapFormID']//div[@class='gift-tab']"));
			Log.info("Add Message Drop Down exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method AddMessageDropDown");
			Log.error("Add Message Drop Down does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement RemoveMessageLink() throws Exception {

		try {
			Log.info("Locating Remove Message Link on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//form[@id='giftWrapFormID']//div[@class='gift-tab']/span/a[@class='gift-wrap-remove']"));
			Log.info("Remove Message Link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveMessageLink");
			Log.error("Remove Message Link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement EditMessageLink() throws Exception {

		try {
			Log.info("Locating Edit Message Link on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//form[@id='giftWrapFormID']//div[@class='gift-tab']/span/a[@class='gift-wrap-edit']"));
			Log.info("Edit Message Link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EditMessageLink");
			Log.error("Edit Message Link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static class AddMessageForm {
		public static WebElement element = null;

		public static List<WebElement> GiftPaperImages() throws Exception {

			try {
				Log.info("Locating Gift Paper Images elements on the Add message Form");
				elements = Driver.findElements(By.xpath(
						"//section[@class='shopping-bag-wpr']/descendant::div[@class='gift-wpr-slider']//ul[@class='gift-paper']/li"));
				Log.info("Gift Paper Images elements exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftPaperImages");
				Log.error("Gift Paper Images does not exist on the Add message Form");
				throw e;
			}

			return elements;

		}

		public static WebElement GiftRecipientName() throws Exception {

			try {
				Log.info("Locating Gift Recipient Name on the Add message Form");
				element = Driver.findElement(
						By.xpath("//section[@class='shopping-bag-wpr']/descendant::input[@id='giftRecipientName']"));
				Log.info("Gift Recipient Name exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftRecipientName");
				Log.error("Gift Recipient Name does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftMessage() throws Exception {

			try {
				Log.info("Locating Gift Message on the Add message Form");
				element = Driver.findElement(
						By.xpath("//section[@class='shopping-bag-wpr']/descendant::textarea[@id='giftMessage']"));
				Log.info("Gift Message exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftMessage");
				Log.error("Gift Message does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftSenderName() throws Exception {

			try {
				Log.info("Locating Gift Sender Name Field on the Add message Form");
				element = Driver.findElement(
						By.xpath("//section[@class='shopping-bag-wpr']/descendant::input[@id='giftSenderName']"));
				Log.info("Gift Sender Name Field exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftSenderName");
				Log.error("Gift Sender Name Field does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftMessageApplyButton() throws Exception {

			try {
				Log.info("Locating Gift Message Apply Button on the Add message Form");
				element = Driver.findElement(By.xpath(
						"//section[@class='shopping-bag-wpr']/descendant::div[@class='action-btns']/button[@class='btn-apply' and @type='submit']"));
				Log.info("Gift Message Apply Button exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftMessageApplyButton");
				Log.error("Gift Message Apply Button does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftMessageCancelButton() throws Exception {

			try {
				Log.info("Locating Gift Message Cancel Button on the Add message Form");
				element = Driver.findElement(By.xpath(
						"//section[@class='shopping-bag-wpr']/descendant::div[@class='action-btns']/button[contains(@class,'btn-cancel gift-wrap') and @type='submit']"));
				Log.info("Gift Message Cancel Button exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftMessageCancelButton");
				Log.error("Gift Message Cancel Button does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

	}

	public static WebElement CheckoutButtonOnCart1() {
		try {
			Log.info("Locating Checkout button on the cart page");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//button[@class='btn-place-order']"));
			


			Log.info("Checkout button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckoutButton");
			Log.error("Checkout button does not exist on the cart page");
			throw e;
		}

		return element;
	}

	public static WebElement ShippingCostText() {
		try {
			Log.info("Locating ShippingCost on the cart page");
			//element = Driver.findElement(By.xpath(
					//"//div[@class='sub-total']/ul/li[2]//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			
			element = Driver.findElement(By.xpath(
					"//div[@class='sub-total']/ul/li[2]//span[@itemprop='price']"));
			Log.info("Shipping cost field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method SubTotalField");
			Log.error("Sub Total Field does not exist on the cart page");
			throw e;
		}

		return element;
	}
	
	public static WebElement ShippingCostTip() {
		try {
			Log.info("Locating ShippingCostTip on the cart page");
			element = Driver.findElement(By.xpath(
					"//div[@class='shippingTip']"));
			Log.info("Shipping cost Tip exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ShippingCostTip");
			Log.error("Shipping cost Tip does not exist on the cart page");
			throw e;
		}

		return element;
	}

}