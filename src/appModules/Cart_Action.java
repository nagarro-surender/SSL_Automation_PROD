package appModules;

import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;

import org.openqa.selenium.Keys;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;
import utility.Log;



public class Cart_Action {
	static String ProductN;
	public static String ProductUnit;
	public static String ProductCase;
	public static String ShoppingListN;


	public static void CheckMiniCartItemCount(int iTestCaseRow) throws Exception {
		int shoppingCartItemCount;

		Log.info("Verification for minicart product count for guest user");
		try {

			shoppingCartItemCount = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
			if (shoppingCartItemCount != 0) {
				BaseClass.errorValidation += "Product count is not correct in mini cart should be zero when no product in cart\n";
			}
			Log.info("Verification for minicart product count for guest user successful");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartItemCount");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void CheckMiniCartShippingCost(int iTestCaseRow) throws Exception {
		int ShippingCost;
		String TipText;

		Log.info("Verification for shipping cost for item");
		try {

			
			//ShippingCost = Integer.parseInt(Cart_Page.ShippingCostText().getText());
			//Cart_Page.ShippingCostText().getText();
			System.out.println(Cart_Page.ShippingCostText().getText());
			if (!(Cart_Page.ShippingCostText().getText().startsWith("Rs"))) {
				BaseClass.errorValidation += "ShippingCost not inculded for item\n";
			}
			Log.info("Verification for ShippingCost successful done");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartShippingCost");
			Log.error(e.getMessage());
			throw e;
		}
		
		try {

			 System.out.println(Cart_Page.ShippingCostTip().getText());
			if (!(Cart_Page.ShippingCostTip().getText().startsWith("TIP:"))) {
				BaseClass.errorValidation += "ShippingCost Tip not inculded for item\n";
			}
			Log.info("Verification for ShippingCost successful done");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartShippingCost");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

public static void CheckMiniCartShippingCostFinal(int iTestCaseRow) throws Exception {
		

		Log.info("Verification for shipping cost for item");
		try {

			
			//ShippingCost = Integer.parseInt(Cart_Page.ShippingCostText().getText());
			//Cart_Page.ShippingCostText().getText();
			//System.out.println(Cart_Page.ShippingCostText().getText());
			if (!(Cart_Page.ShippingCostText().getText().startsWith("Rs"))) {
				BaseClass.errorValidation += "ShippingCost not inculded for item\n";
			}
			Log.info("Verification for ShippingCost successful done");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartShippingCostFinal");
			Log.error(e.getMessage());
			throw e;
		}
		
		
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}
	public static void CheckMiniCartItemCountRegisteredUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for minicart product count for Registered user");
		int shoppingCartItemCountBefore;
		int shoppingCartItemCountAfter;
		
		//Utils.mouseHover(MiniCart_Page.MiniCart());
		//MiniCart_Page.MiniCart().sendKeys(Keys.ENTER);
		//Thread.sleep(10000);
		
		//Utils.verifyElement(MiniCart_Page.MiniCartWindow());
		shoppingCartItemCountBefore = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		ProductDetails_Page.Product.Product_AddToCart().click();
		Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
		Log.info("Product added to cart on PDP");
		try {
			shoppingCartItemCountAfter = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
			if (shoppingCartItemCountBefore>=shoppingCartItemCountAfter) {
				BaseClass.errorValidation += "Product count does not change when item added to cart \n";
			}
			MiniCart_Page.removeBtn().click();
			Log.info("Remove product button is clicked on minicart");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartItemCountRegisteredUser");
			Log.error(e.getMessage());
			throw e;

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void CheckMiniCartRemoveFunctionality(int iTestCaseRow) throws Exception {
		Log.info("Verification for removing product in minicart for registered user");
		int shoppingCartItemCountAfter;
		try {
			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			int shoppingCartItemCountBefore = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
			System.out.println(shoppingCartItemCountBefore);
			MiniCart_Page.removeBtn().click();
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow,Constant.browser));
			Log.info("Remove product buton clicked on minicart");
			shoppingCartItemCountAfter=Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
			System.out.println(shoppingCartItemCountAfter);
			if ( shoppingCartItemCountAfter>=shoppingCartItemCountBefore) {
				BaseClass.errorValidation += "Product count is not correct in mini cart should decrease when product removed from cart\n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartRemoveFunctionality");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void CheckMinicartDetails(int iTestCaseRow) throws Exception {
		Log.info("Verification for minicart details started");
		try {
			Utils.verifyElement(MiniCart_Page.MiniCartTotalPrice());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Total Price is not present in mini cart\n";
		}
		try {
			if (!(MiniCart_Page.MiniCartProductImages().size() > 0)) {
				BaseClass.errorValidation += "Product Image is not present in mini cart\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(MiniCart_Page.MiniCartProductDetails.MiniCartProductBrandName().size() > 0)) {
				BaseClass.errorValidation += "Product Brand name is not present in mini cart\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(MiniCart_Page.MiniCartProductDetails.MiniCartProductProductName().size() > 0)) {
				BaseClass.errorValidation += "Product name is not present in mini cart\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(MiniCart_Page.MiniCartProductDetails.MiniCartProductSpec().size() > 0)) {
				BaseClass.errorValidation += "Product Specifications is not present in mini cart\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(MiniCart_Page.MiniCartProductDetails.MiniCartProductPrice().size() > 0)) {
				BaseClass.errorValidation += "Product Price is not present in mini cart\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add to Bag button is not present in mini cart\n";
		}
		try {
			Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartCheckOutButton());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Checkout button is not present in mini cart\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method CheckMinicartDetails");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void Check_NavigationTo_Checkout_GuestUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for navigation to checkout page for guest user started");
		try {
			Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "View Bag button is not present in mini cart\n";
		}
		MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
		Log.info("View Bag button is cliccked in minicart pop up");
		try {
			Utils.verifyElement(Cart_Page.CheckoutButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "CheckOut button is not present on cart page\n";
		}
		Cart_Page.CheckoutButton().click();
		Log.info("Checkout button is clicked on cart page");
		try {
			Utils.PageHeaderCheck("Proceed to Checkout | Shoppers Stop");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Check_NavigationTo_Checkout_GuestUser");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_ShoppingBag_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for cart page details for registered user started ");
		try {
			Utils.verifyElement(Cart_Page.ShoppingBagItemCountDetails());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Shopping Bag Item Count Details does not exist on the cart page \n";
		}
		try {
			if (!(Cart_Page.ProductImage().size() > 0)) {
				BaseClass.errorValidation += "Shopping Bag Item Count Details does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductImage().size() > 0)) {
				BaseClass.errorValidation += "Product Image does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductBrandName().size() > 0)) {
				BaseClass.errorValidation += "Product Brand name does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductName().size() > 0)) {
				BaseClass.errorValidation += "Product name does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}

		try {
			if (!(Cart_Page.CartInfo().size() > 0)) {
				BaseClass.errorValidation += "Product Specific Information does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.EditCartLink().size() > 0)) {
				BaseClass.errorValidation += "Edit cart link does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.MoveToWishlist().size() > 0)) {
				BaseClass.errorValidation += "Move To Wishlist icon does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.RemoveProductOnCartPage().size() > 0)) {
				BaseClass.errorValidation += "Remove product link does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductPriceInfo().size() > 0)) {
				BaseClass.errorValidation += "Prodcut Price field does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ShoppingBag_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_OrderSummary_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for order summary section on cart page for registered user started");
		try {
			Utils.verifyElement(Cart_Page.ContinueShoppingButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Continue Shopping button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.CoupanCodeFieldcart());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Coupan code field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.ApplyCoupanButtoncart());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Apply Coupan button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.SubTotalField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Sub Totoal field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.DeliveryCahrgesField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Delivery Cahrges Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.GiftPackingField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Gift Packing Field is not present on cart page\n";
		}

		try {
			Utils.verifyElement(Cart_Page.CoupanDiscountField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Coupan Discount Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.PayableAmountContainer());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Payable Amount Container is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.YouHaveSavedContainer());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "You Have Saved Container is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.CheckoutButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Checkout button is not present on cart page\n";
		}

		try {
			Utils.verifyElement(Cart_Page.UseGiftCard_Vouchar_Info());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section is not present on cart page\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_OrderSummary_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_GiftWrap_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for Gift wrap and message drop down on cart page for registered user started");
		try {
			Utils.verifyElement(Cart_Page.GiftWrapIcon());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "gift Wrap icon is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageDropDown());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Gift Wrap message drop down is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageOnGiftWrapLink());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Gift Wrap message link is not present on cart page\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_GiftWrap_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_Other_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for other links on cart page for registered user started");
		try {
			Utils.verifyElement(Cart_Page.FirstCitizenLoyalityProgramBanner());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "First Citizen Loyality Program Banner is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.EnterFCCNumber());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Enter FCC Number field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.EarnPointsButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Earn Points Button is not present on cart page\n";
		}
		try {
			if (!(Cart_Page.FromYourWishlistImages().size() > 0)) {
				BaseClass.errorValidation += "From Your Wishlist Images does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(Cart_Page.PinCodeField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Pin Code Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.CheckPinCodeButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Check Pin Code Button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.FreeDeliveryIcon());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Free Delivery Icon is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.InStoreReturnsLink());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "In Store Returns Link is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AnyQuestionsContainer());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Any Questions Container is not present on cart page\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_Other_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Public_Edit_Cart_Page(int iTestCaseRow) throws Exception {
		Log.info("Verification for edit cart functionality on cart page for guest user started");
		String productQuantity = "";
		try {
			productQuantity = Cart_Page.UpdateQuantity().get(0).getAttribute("value");
			Cart_Page.EditCartLink().get(0).click();
			Log.info("Edit cart link clicked successfully");
			Cart_Page.IncreaseQuantity().get(0).click();
			Log.info("Increase quantity link clicked successfully");
			Cart_Page.UpdateCartItem().get(0).click();
			Log.info("Update cart link clicked successfully");
			System.out.println(Cart_Page.UpdateQuantity().get(0).getAttribute("value"));
			if (Cart_Page.UpdateQuantity().get(0).getAttribute("value").equals(productQuantity)) {
				BaseClass.errorValidation += "Product quantity increase functionality not working\n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Public_Edit_Cart_Page");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Public_Edit_Cart_Page");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Public_Edit_Cart_Page_sameproduct(int iTestCaseRow) throws Exception {
		Log.info("Verification for edit cart functionality on cart page for guest user started");
		String productQuantity = "";
		String productSize = "";
		try {
			productQuantity = Cart_Page.UpdateQuantity().get(0).getAttribute("value");
			Thread.sleep(3000);
			Cart_Page.EditCartLink().get(0).click();
			Log.info("Edit cart link clicked successfully");
			Thread.sleep(5000);
			Utils.SelectDropdownUpdated(Cart_Page.UpdateProductSize().get(0));
			Thread.sleep(3000);
			Cart_Page.UpdateCartItem().get(0).sendKeys(Keys.ENTER);
			Log.info("Update cart link clicked successfully");
			Thread.sleep(3000);
			if (Cart_Page.UpdateQuantity().get(0).getAttribute("value").equals(productQuantity)) {
				BaseClass.errorValidation += "Product quantity increase functionality not working\n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Public_Edit_Cart_Page");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Public_Edit_Cart_Page");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	public static void Verify_Private_Cart_Page_RemoveProduct(int iTestCaseRow) throws Exception {
		Log.info("Verification for removing product from cart page started");
		int productCountBefore;
		int productCountAfter;
		String productCode = "";
		try {
			productCountBefore = Cart_Page.ProductPriceInfo().size();
			Log.info("Product count before removing product obtained successfully");
			productCode = Cart_Page.ProductCode().get(0).getAttribute("value");
			Log.info("Product code obtained successfully");
			Cart_Page.RemoveProductOnCartPage().get(0).click();
			Log.info("Remove product link clicked successfully");
			try {
				Utils.verifyElement(Cart_Page.CartPageAlert());
				if (!(Cart_Page.CartPageAlert().getText().equals("Product has been removed from your cart."))) {
					BaseClass.errorValidation += "Product remove alert not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_RemoveProduct");
				Log.error(e.getMessage());
				throw e;
			}

			productCountAfter = Cart_Page.ProductPriceInfo().size();
			Log.info("Product count after removing product obtained successfully");
			if (productCountAfter == productCountBefore) {
				BaseClass.errorValidation += "Product remove functionality not working. \n";
			}

			for (int i = 0; i < productCountAfter; i++) {
				if (Cart_Page.ProductCode().get(i).getAttribute("value").equals(productCode)) {
					BaseClass.errorValidation += "Product remove functionality not working product code found.\n";
					break;
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_RemoveProduct");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_RemoveProduct");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void Verify_Private_Cart_Page_ApplyCoupan(int iTestCaseRow) throws Exception {
		Log.info("Verification for Applying Coupon on cart page started");
		String totalCartPrice = "";
		String totalCartPrice1 = "";

		totalCartPrice = Cart_Page.TotalCartPrice().getText();
		Log.info("Total cart price obtained successfully");
		try {
			Cart_Page.ApplyCoupanButton().click();
			Log.info("EApply Coupan link clicked successfully");
			if (!(Cart_Page.InvalidCoupanAlert().getText().equals("This field is required."))) {
				BaseClass.errorValidation += "Invalid Coupon alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPromoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			if (!(Cart_Page.CartPageAlert().getText().equals("Please enter the Valid Coupon Code!"))) {
				BaseClass.errorValidation += "'Please enter the Valid Coupon Code!' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.promoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			System.out.println(totalCartPrice);
			//totalCartPrice1=Cart_Page.TotalCartPrice().getText();
			if (Cart_Page.TotalCartPrice().getText().equals(totalCartPrice)) {
				BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {

			Cart_Page.RemoveCouponCode().click();
			Thread.sleep(5000);
			Log.info("Remove Coupon code link clicked successfully");
			if (!(Cart_Page.TotalCartPrice().getText().equals(totalCartPrice))) {
				BaseClass.errorValidation += "Coupon coded discount not removed. \n";
			}
			if (!(Cart_Page.CartPageAlertsuccess().getText().equals("Voucher removed successfully!"))) {
				BaseClass.errorValidation += "'Voucher removed successfully!'- alert present on cart page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void Verify_Private_Cart_Page_ApplyCoupanOnCartPage(int iTestCaseRow) throws Exception {
		Log.info("Verification for Applying Coupon on cart page started");
		String totalCartPrice = "";
		String totalCartPrice1 = "";
		String totalCartPrice3 = "";
		String totalCartPrice4 = "";

		
		totalCartPrice = Cart_Page.TotalCartPriceViewPage().getAttribute("content");
		
		Log.info("Total cart price obtained successfully");
		try {
			Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPromoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButtoncart().click();
			Log.info("Apply Coupon code link clicked successfully");
			if (!(Cart_Page.InvalidCoupanAlertViewBag().getText().equals("Please enter the Valid Coupon Code!"))) {
				BaseClass.errorValidation += "'Please enter the Valid Coupon Code!' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.promoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButtoncart().click();
			Log.info("Apply Coupon code link clicked successfully");
			//totalCartPrice3=Cart_Page.TotalCartPriceViewPagePrice().getAttribute("content");
			//System.out.println(totalCartPrice3);
			//totalCartPrice1=Cart_Page.TotalCartPriceViewPage().getText();
			
			
			if (Cart_Page.TotalCartPriceViewPage().getAttribute("content").equals(totalCartPrice)) {
				BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
		Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void Verify_Private_Cart_Page_CheckPriceFinal(int iTestCaseRow) throws Exception {
		
	
		try {
			Log.info("Verification for Applying Coupon on cart page started");
			
			String totalCartPrice4 = "";
			String totalCartPrice3 = "";

		
			totalCartPrice3=Cart_Page.TotalCartPriceViewPagePrice().getAttribute("content");
			System.out.println(totalCartPrice3);
			totalCartPrice4=Cart_Page.TotalCartPriceCheckout().getAttribute("content");
			System.out.println(totalCartPrice4);
			Log.info("Total cart price obtained successfully");
			
			
			//if (Cart_Page.TotalCartPriceViewPage().getText().equals(totalCartPrice)) {
				//BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			//}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		
		//System.out.println(Cart_Page.TotalCartPriceViewPage().getText());
		//System.out.println(Cart_Page.TotalCartPriceViewPagePrice().getAttribute("content"));
		//try {

		//	//Utils.mouseHover(Cart_Page.RemoveCouponCodeCartPage());
		//	Cart_Page.RemoveCouponCodeCartPage().click();
			//Thread.sleep(5000);
			//Log.info("Remove Coupon code link clicked successfully");
			//if (!(Cart_Page.TotalCartPriceViewPage().getText().equals(totalCartPrice))) {
				//BaseClass.errorValidation += "Coupon coded discount not removed. \n";
			//}
			//if (!(Cart_Page.InvalidCoupanAlertViewBag().getText().equals("Voucher removed successfully!"))) {
				//BaseClass.errorValidation += "'Voucher removed successfully!'- alert present on cart page. \n";
			//}
		//} catch (Exception e) {
		//	Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
		//	Log.error(e.getMessage());
		//	throw e;
		//}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_RemoveCoupanOnCartPage(int iTestCaseRow) throws Exception {

		try {
            Utils.mouseHover(Cart_Page.RemoveCouponCodeCartPage());
			Cart_Page.RemoveCouponCodeCartPage().sendKeys(Keys.ENTER);
		
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void Verify_Private_Cart_Page_CheckoutButtonOnCart(int iTestCaseRow) throws Exception {

		try {
                 Cart_Page.CheckoutButtonOnCart().click();
		
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}



	public static void Verify_Private_Cart_Page_ApplyCoupan_noremove(int iTestCaseRow) throws Exception {
		Log.info("Verification for Applying Coupon on cart page started");
		String totalCartPrice = "";
		String totalCartPrice1 ="";
		String totalCartPrice2 ="";

		//totalCartPrice = Cart_Page.TotalCartPrice().getText();
		//totalCartPrice1 = Cart_Page.TotalCartPrice1().getText()
		Log.info("Total cart price obtained successfully");
		try {
			Cart_Page.ApplyCoupanButton().click();
			Log.info("EApply Coupan link clicked successfully");
			if (!(Cart_Page.InvalidCoupanAlert().getText().equals("This field is required."))) {
				BaseClass.errorValidation += "Invalid Coupon alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPromoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			if (!(Cart_Page.CartPageAlert().getText().equals("Please enter the Valid Coupon Code!"))) {
				BaseClass.errorValidation += "'Please enter the Valid Coupon Code!' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.promoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			totalCartPrice1 = Cart_Page.TotalCartPrice().getText();
			System.out.println(totalCartPrice1);
			if (Cart_Page.TotalCartPrice().getText().equals(totalCartPrice)) {
				BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		
		try {
			Cart_Page.BacktoCartPageButton().click();
			Thread.sleep(5000);
			Log.info("BacktoCart button clicked successfully");
			
			Utils.verifyElement(Home_Page.headerMiniCartIcon());
			//Utils.mouseHover(Home_Page.headerMiniCartIcon());
			//Home_Page.headerMiniCartIcon().click();
			Thread.sleep(5000);
			
			totalCartPrice2=Cart_Page.TotalCartPriceMain().getText();
			System.out.println(totalCartPrice2);
			
			//if (Cart_Page.TotalCartPriceMain().getText().equals(BeforePrice)) {
				//BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	

	public static void Verify_Private_Cart_Page_MoveToWishlist(int iTestCaseRow) throws Exception {
		Log.info("Verification for moving product to wishlist on cart page started");
		String totalCartPrice = "";
		String productCode = "";
		int productCountAfter;

		totalCartPrice = Cart_Page.TotalCartPrice().getAttribute("content");
		Log.info("Total cart price obtained successfully");
		productCode = Cart_Page.ProductCode().get(0).getAttribute("value");
		Log.info("Product code obtained successfully");
		try {
			Cart_Page.MoveToWishlist().get(0).click();
			Log.info("Move to wishlist link clicked successfully");
			if (!(Cart_Page.CartPageAlert().getText().equals("Product added to the wishlist successfully"))) {
				BaseClass.errorValidation += "'Product added to the wishlist successfully' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_MoveToWishlist");
			Log.error(e.getMessage());
			throw e;
		}
		try {

			if (Cart_Page.TotalCartPrice().getAttribute("content").equals(totalCartPrice)) {
				BaseClass.errorValidation += "Total cart price not updated after wishlist update.\n";
			}

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_MoveToWishlist");
			Log.error(e.getMessage());
			throw e;
		}

		try {
			productCountAfter = Cart_Page.ProductPriceInfo().size();
			for (int i = 0; i < productCountAfter; i++) {
				if (Cart_Page.ProductCode().get(i).getAttribute("value").equals(productCode)) {
					BaseClass.errorValidation += "Product remove functionality not working product code found.\n";
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_MoveToWishlist");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_MoveToWishlist");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void Cart_Page_GiftWrapMessageForm(int iTestCaseRow) throws Exception {
		Log.info("Gift message form opened");
		try {
			Utils.verifyElement(Cart_Page.AddMessageDropDown());
			Cart_Page.AddMessageDropDown().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Message Drop Down is not present on Cart Page \n";
		}
		//try {
		//	Utils.verifyElement(Cart_Page.AddMessageForm.GiftPaperImages().get(2));
			//Cart_Page.AddMessageForm.GiftPaperImages().get(2).click();
		//} catch (Exception e) {
			//Log.error(e.getMessage());
			//BaseClass.errorValidation += "Gift Wrap product images are not present on Add Message form \n";

		//}
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftRecipientName());
			Cart_Page.AddMessageForm.GiftRecipientName()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.firstName));
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Recipient name field is not present on Add Message form \n";

		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftMessage());
			Cart_Page.AddMessageForm.GiftMessage().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Gift message field is not present on Add Message form \n";

		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftSenderName());
			Cart_Page.AddMessageForm.GiftSenderName()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.receiver));
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Sender name field is not present on Add Message form \n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftMessageApplyButton());
			Cart_Page.AddMessageForm.GiftMessageApplyButton().sendKeys(Keys.PAGE_DOWN);
			Cart_Page.AddMessageForm.GiftMessageApplyButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Gift Message apply button not present on Add Message form \n";

		}

	}

	public static void Cart_Page_EditGiftWrapMessageForm(int iTestCaseRow) throws Exception {
		try {
			Utils.verifyElement(Cart_Page.EditMessageLink());
			Cart_Page.EditMessageLink().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void Cart_Page_CancelGiftWrapMessageForm(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftMessageCancelButton());
			Cart_Page.AddMessageForm.GiftMessageCancelButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void Verify_Public_Cart_Page_GiftWrapMessage(int iTestCaseRow) throws Exception {
		Log.info("Verification for adding gift message started");
		try {
			Cart_Action.Cart_Page_GiftWrapMessageForm(iTestCaseRow);
			Log.info("Gift message form filled successfully");
			Cart_Action.Cart_Page_EditGiftWrapMessageForm(iTestCaseRow);
			Log.info("Edit gift message link clicked successfully");
			Cart_Action.Cart_Page_CancelGiftWrapMessageForm(iTestCaseRow);
			Log.info("Cancel button on gift message form clicked successfully");
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void Verify_Public_Cart_Page_RemoveGiftWrapMessage(int iTestCaseRow) throws Exception {
		Log.info("Verification for removing gift message started");
		try {
			Cart_Action.Cart_Page_GiftWrapMessageForm(iTestCaseRow);
			Log.info("Gift message form filled successfully");
			Cart_Action.Cart_Page_EditGiftWrapMessageForm(iTestCaseRow);
			Log.info("Edit gift message link clicked successfully");
			Cart_Page.AddMessageForm.GiftSenderName()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName));
			Cart_Page.AddMessageForm.GiftRecipientName()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedReceiver));
			Cart_Page.AddMessageForm.GiftMessage()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMessage));
			Log.info("Gift form updated with new entries");
			Cart_Page.AddMessageForm.GiftMessageApplyButton().click();
			Log.info("Apply gift message link clicked successfully");
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(Cart_Page.RemoveMessageLink());
			Cart_Page.RemoveMessageLink().click();
			Log.info("Remove gift message link clicked successfully");
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.AddMessageDropDown().click();
			Log.info("Gift message drop down clicked successfully");
			String sender = Cart_Page.AddMessageForm.GiftSenderName().getText();
			String recipient = Cart_Page.AddMessageForm.GiftRecipientName().getText();
			String Message = Cart_Page.AddMessageForm.GiftMessage().getText();
			if (!(sender.isEmpty() && recipient.isEmpty() && Message.isEmpty())) {
				BaseClass.errorValidation += "Remove gift message functionality not working. \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_DeliveryOptions(int iTestCaseRow) throws Exception {
		Log.info("Verification for checking pin code for delivery options started");
		try {
			Utils.scrollingToPageElementByCordinate(1100, 550);
			Log.info("Mouse pointer moved to pin code field");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.InvalidPinCodeAlert().getText().equals("Invalid Pincode"))) {
				BaseClass.errorValidation += "Invalid pin code alert does not exist. \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
			Log.info("Pin code entered successfully");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.DeliveryDetails().size() > 0)) {
				BaseClass.errorValidation += "Delivery Details does not exist for product. \n";
			}
			System.out.println(Cart_Page.DeliveryDetails().get(0).getText());
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.scrollingToPageElementByCordinate(1100, 550);
			Log.info("Mouse pointer moved to pin code field");
			Cart_Page.ChangePinCode().click();
			Log.info("Change Pin Code link clicked successfully");
			Cart_Page.PinCodeField().clear();
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode));
			Log.info("Pin Code entered successfully");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.DeliveryDetails().size() > 0)) {
				BaseClass.errorValidation += "Delivery Details does not exist for product. \n";
			}
			if (Cart_Page.DeliveryDetails().get(0).getText().isEmpty()) {
				BaseClass.errorValidation += "'Shipping related message not displayed under product for Pincode - '"+Constant.alternativePostCode+"\n";
				Log.info("Pin Code entered successfully");
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.scrollingToPageElementByCordinate(1100, 550);
			Log.info("Mouse pointer moved to pin code field");
			Cart_Page.ChangePinCode().click();
			Log.info("Change Pin Code link clicked successfully");
			Cart_Page.PinCodeField().clear();
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPostCode));
			Log.info("Pin Code entered successfully");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.DeliveryDetails().size() > 0)) {
				BaseClass.errorValidation += "Delivery Details does not exist for product. \n";
			}
			if (!(Cart_Page.DeliveryDetails().get(0).getText()
					.equals("Product cannot be delivered in this location."))) {
				BaseClass.errorValidation += "'Product cannot be delivered in this location'- is not displayed. \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_FromYourWishList(int iTestCaseRow) throws Exception {
		Log.info("Verification for checking From Your Wishlist section on cart page started");
		try {

			if (!(Cart_Page.FromYourWishlistImages().size() > 0)) {
				BaseClass.errorValidation += "From your wishlist section is empty \n";
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}
}