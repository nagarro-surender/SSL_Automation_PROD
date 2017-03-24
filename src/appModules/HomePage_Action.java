package appModules;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.Static_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class HomePage_Action {

	public static void HomePage_Verify_Menu_Category_Links(int iTestCaseRow) throws Exception {
		String title = null;

		for (int i = 0; i < Static_Page.MainMenuBarTitle().size(); i++) {
			title = Static_Page.MainMenuBarTitle().get(i).getAttribute("title").toString();
			if (!(Static_Page.SubMenuCategory(title).size() > 0)) {
				BaseClass.errorValidation += "No Sub Menu Categaries found for - " + title + " - Categary. \n";
			}
			if (!(Static_Page.SubMenuLinks(title).size() > 0)) {
				Log.info("No product link found under sub menu categaries");
			}
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_Menu_Category_Links");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void HomePage_Verify_MainMenu_ToolTip(int iTestCaseRow) throws Exception {
		String title = null;
		List<String> testData=Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow,Constant.productCategory));	
		System.out.println(Static_Page.MainMenuBarTitle().size());
		System.out.println(testData.size());
		try{
		for (int i = 0; i < Static_Page.MainMenuBarTitle().size(); i++) {
			title = Static_Page.MainMenuBarText(i+1).getAttribute("title").toString();
			System.out.println(Static_Page.MainMenuBarText(i+1).getAttribute("title").toString());
			if (!(title.equals(testData.get(i)))) {
				BaseClass.errorValidation += "Tool Tip for - " + title + " - does not match with expected values. \n";
			}
			else{
				Log.info("Tool Tip for - " + title + " - match with expected values.");
			}
		}
		}
		catch(Exception e){
			Log.error(e.getMessage());
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_MainMenu_ToolTip");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void HomePage_Verify_GridBox_Links(int iTestCaseRow) throws Exception {

		try {
			Log.info("Verification for Free Shipping Link on Grid Box");
			Static_Page.GridBox.Shipping().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Shipping | Shoppers Stop");
			Utils.driverNavigation("backword");
			Log.info("Verification check has been completed for Free Shipping Link on Grid Box");

		} catch (Exception e) {

			Log.error("Verification check Failed for Free Shipping Link");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Free Shipping Link is not present in the Grid Box on Home Page \n";
		}
		try {
			Log.info("Verification for Easy Exchange and Returns Link on Grid Box");
			Static_Page.GridBox.ExchangeAndReturns().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Returns | Shoppers Stop");
			Utils.driverNavigation("backword");
			Log.info("Verification check has been completed for Easy Exchange and Returns Link on Grid Box");

		} catch (Exception e) {

			Log.error("Verification check Failed for Easy Exchange and Returns Link");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Easy Exchange and Returns Link is not present in the Grid Box on Home Page \n";
		}
		try {
			Log.info("Verification for COD Link on Grid Box");
			Static_Page.GridBox.CashOnDelivery().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("How do I pay Template | Shoppers Stop");
			Utils.driverNavigation("backword");
			Log.info("Verification check has been completed for COD Link on Grid Box");

		} catch (Exception e) {

			Log.error("Verification check Failed for COD Link on Grid Box");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The COD Link is not present in the Grid Box on Home Page \n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_GridBox_Links");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void HomePage_Verify_Header_Banner_Footer_Containers(int iTestCaseRow) throws Exception {

		try {
			Log.info("Verification for Header Container");
			Utils.verifyElement(Static_Page.HeaderContainer());
			Log.info("Verification check has been completed for Header Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Header Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Header container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Main Slider Container");
			Utils.verifyElement(Static_Page.MainSlider());
			Log.info("Verification check has been completed for Main Slider Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Main Slider Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Main Slider container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Shipping Container");
			Utils.verifyElement(Static_Page.ShippingContainer());
			Log.info("Verification check has been completed for Shipping Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Shipping Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Shipping container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Style Inspiration Container");
			Utils.verifyElement(Static_Page.StyleInspirationContainer());
			Log.info("Verification check has been completed for Style Inspiration Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Style Inspiration Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Style Inspiration container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for latest from Shoppers Stop Container");
			Utils.verifyElement(Static_Page.latestContainer());
			Log.info("Verification check has been completed for latest from Shoppers Stop Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Latest from Shoppers Stop Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Latest from Shoppers Stop container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for New Arrival Container");
			Utils.verifyElement(Static_Page.NewArrivalsContainer());
			Log.info("Verification check has been completed for New-Arrival Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for New Arrival Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The New Arrival container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Offer Zone Container");
			Utils.verifyElement(Static_Page.OfferZoneContainer());
			Log.info("Verification check has been completed for Offer Zone Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Offer Zone Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Offer Zone container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Brands Container");
			Utils.verifyElement(Static_Page.BrandsContainer());
			Log.info("Verification check has been completed for Brands Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Brands Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Brands container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Favourites Container");
			Utils.verifyElement(Static_Page.FavouritesContainer());
			Log.info("Verification check has been completed for Favourites Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Favourites Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Favourites container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Social Hub Container");
			Utils.verifyElement(Static_Page.SocialHubContainer());
			Log.info("Verification check has been completed for Social Hub Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Social Hub Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Social Hub container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Footer Container");
			Utils.verifyElement(Static_Page.FooterContainer());
			Log.info("Verification check has been completed for Footer Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Footer Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Footer container is not present on Home Page \n";

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_Header_Banner_Footer_Containers");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void HomePage_Verify_NewsLetterSubscribe_Field(int iTestCaseRowiTestCaseRow) throws Exception {
		try {
			Log.info("Verification for NewsLetter Subscribe Email Field");
			Utils.verifyElement(Static_Page.NewsletterEmail());
		} catch (Exception e) {

			Log.error("Verification check Failed for NewsLetter Subscribe Email Field");
			BaseClass.errorValidation += "NewsLetter Subscribe Email Field not present in Home Page \n";
		
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_NewsLetterSubscribe_Field");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void HomePage_Verify_NewsLetterSubscribe_Functionality(int iTestCaseRow) throws Exception {
		//Utils.scrollingToPageElementByCordinate(0, 6364);
		//Home_Page.NewsletterEmail().click();
		try {
			
			Log.info("Verification for NewsLetter Subscribe Email Functionality for Empty field");
			Utils.mouseHover(Home_Page.NewsLetterButton());
			Home_Page.NewsLetterButton().sendKeys(Keys.ENTER);
			Utils.performAssertEquals(Home_Page.NewsLetterAlert(),
					ExcelUtils.getCellData(iTestCaseRow, Constant.message1));
		} catch (Exception e) {
			Log.error("Verification check Failed for NewsLetter Subscribe Email Field for Empty field");
			BaseClass.errorValidation += "Newsletter subscribe button not clicked on Home Page\n";
		}
		try {
			Log.info("Verification for NewsLetter Subscribe Email Functionality for invalid mail address");
			Home_Page.NewsletterEmail().clear();
			Home_Page.NewsletterEmail().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidEmailId));
			//Thread.sleep(10000);
			//Utils.scrollingToPageElementByCordinate(1275, 5500);
			Utils.mouseHover(Home_Page.NewsLetterButton());
			Home_Page.NewsLetterButton().sendKeys(Keys.ENTER);
			Utils.performAssertEquals(Home_Page.NewsLetterAlert(),
					ExcelUtils.getCellData(iTestCaseRow, Constant.message2));
		} catch (Exception e) {

			Log.error("Verification check Failed for NewsLetter Subscribe Email Field for invalid email address");
			BaseClass.errorValidation += "Newsletter subscribe button not clicked on Home Page\n";
		

		}
		try {
			Log.info("Verification for NewsLetter Subscribe Email Functionality for Valid email address");
			Home_Page.NewsletterEmail().clear();
			Home_Page.NewsletterEmail().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.emailId));
			Utils.mouseHover(Home_Page.NewsLetterButton());
			Home_Page.NewsLetterButton().sendKeys(Keys.ENTER);
			Utils.performAssertEquals(Home_Page.NewsLetterAlert(),
					ExcelUtils.getCellData(iTestCaseRow, Constant.message3));
		} catch (Exception e) {

			Log.error("Verification check Failed for NewsLetter Subscribe Email Field for Valid email address");
			BaseClass.errorValidation += "Newsletter subscribe button not clicked on Home Page\n";
			

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_NewsLetterSubscribe_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_StoreLocator_Link_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header store locator icon");
			Utils.verifyElement(Home_Page.headerStoreLocatorIcon());
		} catch (Exception e) {

			Log.error("Verification check Failed for store locator icon in Header");
			BaseClass.errorValidation += "Store locator icon not present in Header \n";

		}

		try {
			Log.info("Verification for store locator icon functionality in Header");
			Home_Page.headerStoreLocatorIcon().click();
			Log.info("Store locator icon clicked successfully");
			Utils.NewWindowPageHeaderValidation("StoreFinder | Shoppers Stop");
			Log.info("Verification check done for store locator icon functionality");
		} catch (Exception e) {

			Log.error("Verification check Failed for store locator icon functionality");

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error(
					"Exception in Class HomePage_Action | Method Header_Public_Verify_StoreLocator_Link_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_StoreLocator_Page_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for store locator icon page functionality in Header");
			Home_Page.headerStoreLocatorIcon().click();
			Log.info("Store locator icon clicked successfully");
			
			Static_Page.StoreLocator_SelectCity().selectByValue(ExcelUtils.getCellData(iTestCaseRow, Constant.city));
			Log.info("Store City name entered successfully");

			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow,Constant.browser));
			Select storeName=Static_Page.StoreLocator_SelectStore();
			
			if(storeName.getOptions().isEmpty()){
				BaseClass.errorValidation+="The store name list is empty for selcted city\n";
			}
			Log.info("Verification check done for store locator page functionality");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_StoreLocator_Page_Functionality");
			Log.error("Verification check Failed for store locator icon functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_StoreLocator_Page_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_TrackOrder_Page_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Track Order icon page functionality in Header");
			Home_Page.headerTrackOrder().click();
			Log.info("Track Order icon clicked successfully");
			Utils.NewWindowAction();
			Utils.verifyElement(Static_Page.TrackOrder.TrackOrder_Email_Id());
			Utils.verifyElement(Static_Page.TrackOrder.Order_Number());
			Utils.verifyElement(Static_Page.TrackOrder.Submit_Button());
			Log.info("Verification check done for Track Order icon page functionality");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_TrackOrder_Page_Functionality");
			Log.error("Verification check Failed for Track Order icon page functionality");
			throw e;
		}
	}

	public static void SS_Header_Public_Verify_TrackOrder_Link_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header track order icon");
			Utils.verifyElement(Home_Page.headerTrackOrder());
			Log.info("Verification check has been completed for header track order icon");

		} catch (Exception e) {

			Log.error("Verification check Failed for header track order icon");
			BaseClass.errorValidation = BaseClass.errorValidation + "The header track order icon is not present";
			// throw (e);

		}
		try {
			Log.info("Verification for Track Order icon functionality in Header");
			Home_Page.headerTrackOrder().click();
			Log.info("Track Order icon clicked successfully");
			Utils.NewWindowPageHeaderValidation("Shoppers Stop");
			Log.info("Verification check done for Track Order icon functionality");

		} catch (Exception e) {

			Log.error("Verification check Failed for Track Order icon functionality");
			// throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method SS_Header_Public_Verify_TrackOrder_Link_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_SSL_Logo_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Shoppers Stop logo");
			Utils.verifyElement(Home_Page.headerSoppersStopLogo());
			Log.info("Verification check has been completed for Header Shoppers Stop logo");

		} catch (Exception e) {

			Log.error("Verification check Failed for Header Shoppers Stop logo");
			BaseClass.errorValidation = BaseClass.errorValidation + "The Header Shoppers Stop logo is not present";
			// throw (e);

		}
		try {
			Log.info("Verification for SSL icon functionality in Header");
			Home_Page.headerSoppersStopLogo().click();
			Log.info("SSL clicked successfully");
			Utils.waitForLoad("Firefox");
			Utils.PageHeaderCheck("Online Shopping India - Shop for clothes, shoes, Bags, watches @ Shoppersstop.com");
			Log.info("Verification check done for SSL functionality");

		} catch (Exception e) {

			Log.error("Verification check Failed for SSL functionality");
			BaseClass.errorValidation = BaseClass.errorValidation + "The Header Shoppers Stop logo is not present";
			// throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_SSL_Logo_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_Wishlist_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Wishlist icon functionality in Header");
			Utils.mouseHover(Home_Page.headerWishlistIcon());
			Log.info("Wishlist icon hovered successfully");
			System.out.println(Home_Page.headerWishlistMenuHeading().getText());
			Utils.performAssertEquals(Home_Page.headerWishlistMenuHeading(), "Your Saved Items Are Empty");

			System.out.println(Home_Page.headerWishlistMenuText().getText());
			Utils.performAssertEquals(Home_Page.headerWishlistMenuText(), "Please LOGIN or REGISTER to add products");

			Log.info("Verification check done for Wishlist Alert functionality");

		} catch (Exception e) {

			Log.error("Verification check Failed for Wishlist Alert functionality");
			// throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Wishlist_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Private_Verify_Wishlist_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Wishlist icon functionality in Header");
			Utils.mouseHover(Home_Page.headerWishlistIcon());
			Log.info("Wishlist icon hovered successfully");
			if (Home_Page.headerWishlistUserMenu().size() > 0) {
				Log.info("Verification check done for User specific Wishlist ");
			} else {
				BaseClass.errorValidation += "Wishlist image does not exist \n";
			}
			Log.info("Verification check done for Wishlist functionality for logged in User");

		} catch (Exception e) {

			Log.error("Verification check Failed for Wishlist Alert functionality");
			Log.error("Exception in Class HomePage_Action | Method Header_Private_Verify_Wishlist_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Private_Verify_Wishlist_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_Wishlist_Link(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Wishlist Icon");
			Utils.verifyElement(Home_Page.headerWishlistIcon());
			Log.info("Verification check has been completed for Header Wishlist Icon");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Wishlist_Link");
			Log.error("Verification check Failed for Header Wishlist Icon");
			throw (e);

		}

	}

	public static void Header_Public_Verify_Notification_Alert_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Notification icon functionality in Header");
			Utils.mouseHover(Home_Page.headerNotificationIcon());
			Log.info("Notification icon hovered successfully");
			System.out.println(Home_Page.headerNotificationAlert().getText());
			Utils.performAssertEquals(Home_Page.headerNotificationAlert(), "No Alerts Available");

			Log.info("Verification check done for Notification Alert functionality");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Notification_Alert_Functionality");
			Log.error("Verification check Failed for Notification Alert functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Notification_Alert_Functionality");
			Log.error("Verification check Failed for Notification Alert functionality");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void Header_Public_Verify_Notification_Alert_Link(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Notification Icon");
			Utils.verifyElement(Home_Page.headerNotificationIcon());
			Log.info("Verification check has been completed for Header Notification Icon");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Notification_Alert_Link");
			Log.info("Verification check Failed for Header Notification Icon");
			throw (e);

		}

	}

	public static void Header_Public_Verify_Minicart_Functionality(int iTestCaseRow) throws Exception {
		try {

			Log.info("Verification for Header Minicart Icon");
	
			Utils.verifyElement(Home_Page.headerMiniCartIcon());
			Log.info("Verification check has been completed for Header Minicart Icon");

			Log.info("Verification for Mini Cart icon functionality in Header");
			Home_Page.headerMiniCartIcon().click();
			Log.info("Mini Cart icon clicked successfully");
			Utils.NewWindowAction();
			Utils.PageHeaderCheck("Your Shopping Bag | Shoppers Stop");
			Log.info("Verification check done for Mini Cart icon functionality");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Minicart_Functionality");
			Log.error("Verification check Failed for Mini Cart icon functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Minicart_Functionality");
			Log.error("Verification check Failed for Mini Cart icon functionality ");
			throw new Exception(BaseClass.errorValidation);
		}
		
	}

	public static void Header_Public_Verify_SearchBox_Field(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Search box field");
			Utils.verifyElement(Home_Page.Search_Box());
			Log.info("Verification check has been completed for Header Search box field");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method Header_Public_Verify_SearchBox_Field");
			Log.error("Verification check Failed for Header Search box field");
			throw (e);

		}
	
	}

	public static void Header_Public_Verify_SearchBox_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Search box field functionality");
			Home_Page.Search_Box().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.searchField));
			Log.info("Product name entered in search box");
			Home_Page.seeAllSearchResultButton().click();
			Log.info("Search button clicked successfully");
			Utils.waitForLoad("firefox");
			Utils.verifyElement(Home_Page.productListHeading());
			Log.info("Verification check has been completed for Header Search box field functionality");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method Header_Public_Verify_SearchBox_Functionality");
			Log.error("Verification check Failed for Header Search box field functionality");
			throw (e);

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_SearchBox_Functionality");
			Log.error("Verification check Failed for Header Search box field functionality");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void FooterLinkVerification_Customer_Public(int iTestCaseRow) throws Exception {

		try {

			
			Home_Page.Footer_Section.Help_FAQ().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("FAQ | Shoppers Stop");

			Home_Page.Footer_Section.Track_Order().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Shoppers Stop");

			Home_Page.Footer_Section.Size_Guide().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Size Guide | Shoppers Stop");

			Home_Page.Footer_Section.Buying_Guide().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("BuyingGuide | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Buy().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Purchase | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Pay().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("How do I pay Template | Shoppers Stop");

			Home_Page.Footer_Section.Place_We_Deliever().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Shoppers Stop");

			

	Log.info("Verification check has been completed for FooterLinks related to Customer- Public View");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Customer_Public");
			Log.error("Verification check Failed  for Footer Links related to customer- Public View");
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Customer_Public");
			Log.error("Verification check Failed  for Footer Links related to customer- Public View");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void FooterLinkVerification_Policy_Public(int iTestCaseRow) throws Exception {
		try {
			Home_Page.Footer_Section.TermsAndConditions().click();
			Utils.PageHeaderCheck("Term and Condition | Shoppers Stop");

			Home_Page.Footer_Section.Privacy().click();
			Utils.PageHeaderCheck("Privacy | Shoppers Stop");

			Home_Page.Footer_Section.Shipping_Policy().click();
			Utils.PageHeaderCheck("Shipping | Shoppers Stop");

			Home_Page.Footer_Section.Exchange_Returns().click();
			Utils.PageHeaderCheck("Returns | Shoppers Stop");

			Log.info("Verification check has been completed for FooterLinks related to Policy - Public View");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Policy_Public");
			Log.error("Verification check Failed  for Footer Links related to policy - Public View");

			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Policy_Public");
			Log.error("Verification check Failed  for Footer Links related to policy - Public View");
			throw new Exception(BaseClass.errorValidation);
		}

	}


	public static void selectProductCategoryfromMenuClinique(int iTestCaseRow) throws Exception {
		try {

			String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
			String submenu = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);
			
			
			Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategoryClinique(menu, submenu));
			Log.info("Product Category selected");
			Thread.sleep(3000);
			//Utils.scrollingToPageElementAdvanced(Home_Page.Clinique());
			Home_Page.Clinique().click();
			Log.info("Clinique Category selected");
			
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");

			throw (e);

		}
	}
	public static void FooterLinkVerification_StoreandSite_Public(int iTestCaseRow) throws Exception {
		try {
			Home_Page.Footer_Section.AboutUs().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("About us | Shoppers Stop");
			
			Home_Page.Footer_Section.Corporate_Site().click();
			Thread.sleep(5000);
			Utils.NewWindowPageHeaderValidation("Shoppers Stop | Home");

			Home_Page.Footer_Section.Store_Locator().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("StoreFinder | Shoppers Stop");

			Log.info("Verification check has been completed for Footer Links related to Store and Site - Public View");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_StoreandSite_Public");
			Log.error("Verification check Failed  for Footer Links related to Store and Site - Public View");
			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_StoreandSite_Public");
			Log.error("Verification check Failed  for Footer Links related to Store and Site - Public View");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void FooterLinkVerification_FirstCitizen_Public(int iTestCaseRow) throws Exception {
		try {
			Home_Page.Footer_Section.First_Citizen().click();
			Utils.PageHeaderCheck("First Citizen Non-Member | Shoppers Stop");

			Home_Page.Footer_Section.Instant_Gifting().click();
			Utils.PageHeaderCheck("Shoppers Stop");

			Log.info("Verification check has been completed for Footer Links related to First Citizen - Public View");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_FirstCitizen_Public");
			Log.error("Verification check Failed for Footer Links related to First Citizen - Public View");

			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_FirstCitizen_Public");
			Log.error("Verification check Failed for Footer Links related to First Citizen - Public View");

			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void selectProductCategoryfromMenuFilter(int iTestCaseRow) throws Exception {
		try {

			String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
			String submenu = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);
			Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategoryFilter(menu, submenu));
			Log.info("Product Category selected");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");

			throw (e);

		}
	}
	public static void FooterLinkVerification_FollowUs_Public(int iTestCaseRow) throws Exception {
		try {
			//Utils.scrollingToPageElementByCordinate(1259, 6250);
			//Static_Page.NewsletterEmail().click();
			Home_Page.Footer_Section.Twitter_Link().click();
			Utils.NewWindowAction();

			Utils.mouseHover(Home_Page.Footer_Section.Facebook_Link());
			Home_Page.Footer_Section.Facebook_Link().sendKeys(Keys.ENTER);
			Utils.NewWindowAction();

			Utils.mouseHover(Home_Page.Footer_Section.Pinterest_Link());
			Home_Page.Footer_Section.Pinterest_Link().sendKeys(Keys.ENTER);
			Utils.NewWindowAction();

			Utils.mouseHover(Home_Page.Footer_Section.GooglePlus_Link());
			Home_Page.Footer_Section.GooglePlus_Link().sendKeys(Keys.ENTER);
			Utils.NewWindowAction();
			Log.info("Verification check has been completed for Footer Links related to Follow Us - Public View");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_FollowUs_Public");
			Log.error("Verification check Failed for Footer Links related to Follow Us - Public View");

			throw (e);

		}

	}

	public static void FooterLinkVerification_ReachUs_Public(int iTestCaseRow) throws Exception {
		try {
			//Utils.performAssertEquals(Home_Page.Footer_Section.Toll_Free(), "#1-800-419-6648 (TOLL FREE)");
			//Utils.performAssertEquals(Home_Page.Footer_Section.Phone_Number(), "+91-22-61290400");
			Utils.performAssertEquals(Home_Page.Footer_Section.Estore_Link(), "estore@shoppersstop.com");

			Log.info("Verification check successfull for Footer text related to Reach Us - Public View");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_ReachUs_Public");
			Log.error("Verification check Failed for Footer text related to Reach Us - Public View");

			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_ReachUs_Public");
			Log.error("Verification check Failed for Footer text related to Reach Us - Public View");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void selectProductCategoryfromMenu(int iTestCaseRow) throws Exception {
		try {

			String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
			String submenu = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);
			Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategory(menu, submenu));
			Log.info("Product Category selected");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");

			throw (e);

		}
	}
		
		public static void selectProductCategoryMainfromMenu(int iTestCaseRow) throws Exception {
			try {

				String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
				String submenuMain = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);
				Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategoryMain(menu,submenuMain));
				Log.info("Product Category Main span selected");
			} catch (Exception e) {
				Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
				Log.error("Product category Main span not selected");

				throw (e);

			}

	}
}
