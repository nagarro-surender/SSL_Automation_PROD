package appModules;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import pageObjects.BaseClass;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class PLP_Action {

	public static void PLP_Verify_Default_Content(int iTestCaseRow) throws Exception {
		Log.info("Verification for Default content on PLP page");

		Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
		try {
			Utils.verifyElement(ProductListing_Page.ProductCount());
			Log.info("Product Item Count found on PLP page");
		} catch (Exception e) {
			Log.error("Product Item Count not found on PLP page");
			BaseClass.errorValidation += "Product Item Count not found on PLP page \n";
		}
		try {
			Select dropDown=ProductListing_Page.SortOptions();
			String defaultSort=dropDown.getFirstSelectedOption().getText();
			//Utils.verifyElement(ProductListing_Page.SortOptions());
			if(!(defaultSort.equals("Relevance"))){
			BaseClass.errorValidation += "Sort option not selected by default on PLP page \n";
			}
			Log.info("Sort option found on PLP page");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.error("Sort option not found on PLP page");
			BaseClass.errorValidation += "Sort option not found on PLP page \n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.GridViewIcon());
			Log.info("Grid View Icon found on PLP page");
		} catch (Exception e) {
			Log.error("Grid View Icon not found on PLP page");
			BaseClass.errorValidation += "Grid View Icon not found on PLP page \n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Default_Content");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Filter_On_Off_Functionality(int iTestCaseRow) throws Exception {
		boolean check;
		Log.info("Verification for Filter On Off Functionality on PLP page");
		try {
			ProductListing_Page.FilterOnOff().click();
			Log.info("Filter on link is clicked");
			check = Utils.CheckEnability(ProductListing_Page.DefaultFilterContainer());
			if (check) {
				BaseClass.errorValidation += "Default Filter Container should not be present on PLP when Filter is set to on\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Filter_On_Off_Functionality");
			throw e;
		}
		try {
			ProductListing_Page.FilterOnOff().click();
			Log.info("Filter off link is clicked");
			check = Utils.CheckEnability(ProductListing_Page.DefaultFilterContainer());
			if (!check) {
				BaseClass.errorValidation += "Default Filter Container should be present on PLP when Filter is set to off\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Filter_On_Off_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Filter_On_Off_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Default_Filter_Attributes_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for Default Filter Attributes Functionality on PLP page");

		productCount = ProductListing_Page.ProductCount().getText();
		try {
			if (!(ProductListing_Page.DefaultAttributeFilterCategoryContainer().size() > 0)) {
				BaseClass.errorValidation += "Default Filter Attributes container not present on PLP \n";
			}
			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter1))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilterPageLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue1))
					.click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter2))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue2)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter3))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue3)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Filters selected successfully on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product Count not changing on applying Default Attribute Filters on PLP \n";
			}
			if (!(ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0)) {
				BaseClass.errorValidation += "Default Attribute Filters applied on PLP are not displayed \n";
			}
			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter1))
					.click();
			Log.info("Default Filter attribute category removed on PLP page");
			ProductListing_Page
					.DefaultAttributeFilterPageLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue1))
					.click();
			Log.info("Default Filter attribute sub category removed on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter2))
					.click();
			Log.info("Default Filter attribute category removed on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue2)).click();
			Log.info("Default Filter attribute sub category removed on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter3))
					.click();
			Log.info("Default Filter attribute category removed applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue3)).click();
			Log.info("Default Filter attribute sub category removed on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Filters removed successfully on PLP page");
			if (!(ProductListing_Page.ProductCount().getText().equals(productCount))) {
				BaseClass.errorValidation += "Product Count not changing to default count on deselecting Default Attribute Filters on PLP \n";
			}
			if (ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0) {
				BaseClass.errorValidation += "Default Attribute Filters applied on PLP are not cleared on deselecting Default Attribute Filters on PLP\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Default_Filter_Attributes_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Default_Filter_Attributes_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void PLP_Verify_Brand_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {
			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterPriceDropDown());
			//Utils.scrollingToPageElementByCordinate(140, 700);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterBrandDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Brand is not present on PLP while it should be present \n";
			}

			//Utils.mouseHover(ProductListing_Page.PrimaryFilterBrandDropDown());
			//ProductListing_Page.PrimaryFilterBrandDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterBrandDropDown().click();
			Log.info("Primary filter Brand drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Brand Drop Down Compression on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterBrandDropDownContainer());
			if (check) {
				BaseClass.errorValidation += "Primary Filter Container for Brand is present on PLP while it should be compressed \n";
			}
           //Utils.mouseHover(ProductListing_Page.PrimaryFilterBrandDropDown());
			//ProductListing_Page.PrimaryFilterBrandDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterBrandDropDown().click();
			Log.info("Primary filter Brand drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterBrandDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Brand  is not present on PLP while it should be present  \n";
			}
			Log.info("Verification for Primary Filter Brand Drop Down Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Brand_FilterDropDown");
			throw e;
		}

	}

	public static void PLP_Verify_Price_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {
			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterColorDropDown());
			//Thread.sleep(5000);
			//Utils.scrollingToPageElementByCordinate(140, 50);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterPriceDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Price is not present on PLP while it should be present \n";
			}

			ProductListing_Page.PrimaryFilterPriceDropDown().click();
			//Utils.mouseHover(ProductListing_Page.PrimaryFilterPriceDropDown());
			
			//Thread.sleep(5000);
			//ProductListing_Page.PrimaryFilterPriceDropDown().sendKeys(Keys.ENTER);
			//ProductListing_Page.PrimaryFilterPriceDropDown().sendKeys(Keys.ENTER);
			Log.info("Primary filter Price drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Price Drop Down Compression on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterPriceDropDownContainer());
			if (check) {
				BaseClass.errorValidation += "Primary Filter Container for Price is present on PLP while it should be compressed \n";
			}

			//Utils.mouseHover(ProductListing_Page.PrimaryFilterPriceDropDown());
			//ProductListing_Page.PrimaryFilterPriceDropDown().sendKeys(Keys.ENTER);
			//Utils.mouseHover(ProductListing_Page.PrimaryFilterPriceDropDown());
			//Robot rob1 = new Robot();
			//rob1
			//.keyPress(KeyEvent.VK_ENTER);
			//Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			//check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterPriceDropDownContainer());
			//if (!check) {
			//	BaseClass.errorValidation += "Primary Filter Container for Price is not present on PLP while it should be present  \n";
			//}
			Log.info("Verification for Primary Filter Price Drop Down Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Price_FilterDropDown");
			throw e;
		}

	}

	public static void PLP_Verify_Size_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {
			//Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterSizeDropDown());
			//Utils.scrollingToPageElementByCordinate(140, 500);
			Log.info("Scrolled to Size Primary filter drop down on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterSizeDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Size is not present on PLP while it should be present \n";
			}
			//Utils.mouseHover(ProductListing_Page.PrimaryFilterSizeDropDown());
			ProductListing_Page.PrimaryFilterSizeDropDown().click();
			Log.info("Primary filter Size drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Size Drop Down Compression on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterSizeDropDownContainer());
			if (check) {
				BaseClass.errorValidation += "Primary Filter Container for Size is present on PLP while it should be compressed \n";
			}

			//Utils.mouseHover(ProductListing_Page.PrimaryFilterSizeDropDown());
			//ProductListing_Page.PrimaryFilterSizeDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterSizeDropDown().click();
			Log.info("Primary filter Size drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterSizeDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Size is not present on PLP while it should be present  \n";
			}
			Log.info("Verification for Primary Filter Size Drop Down Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Size_FilterDropDown");
			throw e;

		}

	}

	public static void PLP_Verify_Color_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {

			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterSizeDropDown());
			//Utils.scrollingToPageElementByCordinate(144, 900);
			Log.info("Scrolled to Color filter drop down on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterColorDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Color is not present on PLP while it should be present \n";
			}
			//Utils.mouseHover(ProductListing_Page.PrimaryFilterColorDropDown());
			//ProductListing_Page.PrimaryFilterColorDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterColorDropDown().click();
			Log.info("Primary filter Color drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Color Drop Down Compression on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterColorDropDownContainer());
			if (check) {
				BaseClass.errorValidation += "Primary Filter Container for Color is present on PLP while it should be compressed \n";
			}

			//Utils.mouseHover(ProductListing_Page.PrimaryFilterColorDropDown());
			//ProductListing_Page.PrimaryFilterColorDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterColorDropDown().click();
			Log.info("Primary filter Color drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterColorDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Color is not present on PLP while it should be present  \n";
			}
			Log.info("Verification for Primary Filter Color Drop Down Functionality completed on PLP page");
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Color_FilterDropDown");
			throw e;
		}

	}

	public static void PLP_Verify_OnSale_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {

			//Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterOnSaleDropDown());
			//Utils.scrollingToPageElementByCordinate(144, 1100);
			Log.info("Scrolled to On Sale filter drop down on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterOnSaleDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for On Sale is not present on PLP while it should be present \n";
			}
			//Utils.mouseHover(ProductListing_Page.PrimaryFilterOnSaleDropDown());
			//ProductListing_Page.PrimaryFilterOnSaleDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterOnSaleDropDown().click();
			//ProductListing_Page.PrimaryFilterOnSaleDropDown().click();
			Log.info("Primary filter On Sale drop down clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter On Sale Drop Down Compression on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterOnSaleDropDownContainer());
			if (check) {
				BaseClass.errorValidation += "Primary Filter Container for On Sale is present on PLP while it should be compressed \n";
			}

			//Utils.mouseHover(ProductListing_Page.PrimaryFilterOnSaleDropDown());
			//ProductListing_Page.PrimaryFilterOnSaleDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterOnSaleDropDown().click();
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterOnSaleDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for On Sale is not present on PLP while it should be present  \n";
			}
			Log.info("Verification for Primary Filter On Sale Drop Down Functionality completed on PLP page");
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_OnSale_FilterDropDown");
			throw e;
		}
	}

	public static void PLP_Verify_Primary_Filter_DropDown_Functionality(int iTestCaseRow) throws Exception {

		Log.info("Verification for Primary Filter Drop Down Functionality on PLP page");
		try {
			PLP_Verify_OnSale_FilterDropDown(iTestCaseRow);
			PLP_Verify_Size_FilterDropDown(iTestCaseRow);
			PLP_Verify_Color_FilterDropDown(iTestCaseRow);
			PLP_Verify_Price_FilterDropDown(iTestCaseRow);
			PLP_Verify_Brand_FilterDropDown(iTestCaseRow);
			
			
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Primary_Filter_DropDown_Functionality");
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Primary_Filter_DropDown_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void PLP_Verify_Select_Brand_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Brand checkbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterPriceDropDown());
			ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName))
					.sendKeys(Keys.SPACE);
			Log.info("Brand specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific Brand checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Brand_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Brand_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_Price_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Price checkbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterColorDropDown());
			ProductListing_Page.SelectPriceCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productPrice))
					.sendKeys(Keys.SPACE);
			Log.info("Price specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific price checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Price_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Price_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	
	public static void PLP_Verify_Select_Size_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Size checkbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			ProductListing_Page.SelectSizeCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productSize))
					.sendKeys(Keys.SPACE);
			Log.info("Size specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific Size checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Size_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Size_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_Color_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Color chckbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterSizeDropDown());
			ProductListing_Page.SelectColorCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productColor))
					.sendKeys(Keys.SPACE);
			Log.info("Color specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific color checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Color_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Color_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_On_Sale_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting On Sale Checkbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterPriceDropDown());
			ProductListing_Page.SelectOnSaleCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.onSaleValue))
					.sendKeys(Keys.SPACE);
			Log.info("On Sale specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific On Sale checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_On_Sale_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_On_Sale_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_LoadMore_Link_Functionality(int iTestCaseRow) throws Exception {
		String showing = "";

		try {
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product and sub product selected from Main Menu");
			showing = ProductListing_Page.DisplayResultCountSpan().getText();
			Thread.sleep(10000);
			Utils.mouseHover(ProductListing_Page.LoadMoreLink());
			ProductListing_Page.LoadMoreLink().click();
			
			Log.info("Load More link is clicked on PLP page");
			if (ProductListing_Page.DisplayResultCountSpan().getText().equals(showing)) {
				BaseClass.errorValidation += "Showing result count does not change after clicking Load More link\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_LoadMore_Link_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_LoadMore_Link_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Promotion_Image_Link(int iTestCaseRow) throws Exception {

		Log.info("Verification for Promotion image link on PLP page");
		try {
			ProductListing_Page.PromotionImageLink().click();
			Log.info("Promotional image link clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow,Constant.browser));
			Utils.PageHeaderCheck("Fifty Shades Of Polo - Style Hub");
			} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Promotion_Image_Link");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Promotion_Image_Link");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Clear_Refinements_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		int filterListSize;
		Log.info("Verification for Clear refinements functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter1))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilterPageLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue1))
					.click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter2))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue2)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter3))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue3)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Default Attribute Filters selected successfully on PLP page");

			if (!(ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0)) {
				BaseClass.errorValidation += "Filters applied container not present on PLP page\n";
			} else {
				filterListSize = ProductListing_Page.DefaultAttributeFilterAppliedList().size();
				for (int i = 1; i <= filterListSize; i++) {
					ProductListing_Page.DefaultAttributeFilterClose(1).click();
					Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
				}
				if (!(ProductListing_Page.ProductCount().getText().equals(productCount))) {
					BaseClass.errorValidation += "Product count not reset to default product count after clearing all filters \n";
				}
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Clear_Refinements_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Clear_Refinements_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_ClearAll_Refinements_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";

		Log.info("Verification for Clear refinements functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();

			ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName))
					.sendKeys(Keys.SPACE);
			Log.info("Brand specific check box applied on PLP page");
			ProductListing_Page.SelectPriceCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productPrice))
					.sendKeys(Keys.SPACE);
			Log.info("Price specific check box applied on PLP page");
			ProductListing_Page.SelectColorCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productColor))
					.sendKeys(Keys.SPACE);
			Log.info("Color specific check box applied on PLP page");

			Log.info("Primary Filters selected successfully on PLP page");

			if (!(ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0)) {
				BaseClass.errorValidation += "Filters applied container not present on PLP page\n";
			} else {
				ProductListing_Page.DefaultAttributeFilterCloseAll().click();
				Log.info("Close all link clicked to remove applied filters on PLP page");
				if (!(ProductListing_Page.ProductCount().getText().equals(productCount))) {
					BaseClass.errorValidation += "Product count not reset to default product count after clearing all filters \n";
				}
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ClearAll_Refinements_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ClearAll_Refinements_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Product_Details(int iTestCaseRow) throws Exception {

		Log.info("Verification for Product Information Details on PLP page");
		try {

			if (!(ProductListing_Page.ProductImage().size() > 0)) {
				BaseClass.errorValidation += "Product Images are not shown for Products on PLP\n";
			}
			if (!(ProductListing_Page.ProductNameInfo().size() > 0)) {
				BaseClass.errorValidation += "Product Name and Brand details are not shown for Products on PLP\n";
			}
			if (!(ProductListing_Page.ProductPriceInfo().size() > 0)) {
				BaseClass.errorValidation += "Product Price Details are not shown for Products on PLP\n";
			}
			//if (!(ProductListing_Page.ProductColorOption().size() > 0)) {
				//BaseClass.errorValidation += "Product Color options are not shown for Products on PLP\n";
			//}

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Product_Details");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Product_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_QuickView_Link(int iTestCaseRow) throws Exception {
		Log.info("Verification for Quick View Link on Product Image on PLP page");

		try {
			Utils.verifyElement(ProductListing_Page.QuickViewContainer());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Quick View Container not present\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_QuickView_Link");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_QuickView_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for Quick View Details For product on PLP page");
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewContainer());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Quick View Container not present on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewImageThumbnails().size() > 0)) {
			BaseClass.errorValidation += "Product Thumbnails are not shown on QickView for Products on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewImageSlider().size() > 0)) {
			BaseClass.errorValidation += "Product Image Slideris  not shown on QickView for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewBrandName());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Brand name not found in Quick View for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewProductName());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Product name not found in Quick View for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewPrice());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Price Tag not found in Quick View for Products on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewColorVariant().size() > 0)) {
			BaseClass.errorValidation += "Color Variants are not shown on QickView for Products on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewSizeVariant().size() > 0)) {
			BaseClass.errorValidation += "Size Variants are not shown on QickView for Products on PLP\n";
		}
		//try {
			//Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewAddToBagButton());
		//} catch (Exception e) {
		//	Log.error(e.getMessage());
		//	BaseClass.errorValidation += "Add to cart button not found in Quick View for Products on PLP\n";
		//}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewPRoductDetailsLink());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "View product details link not found in Quick View for Products on PLP\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_QuickView_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_AddToWishlist_RegisteredUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for Add to Wishlist link on Product Image on PLP page");

		try {
			Utils.verifyElement(ProductListing_Page.AddToWishList());
			ProductListing_Page.AddToWishList().click();
			Log.info("Clciked on Add to wishlist link on Product image on PLP page");
			Utils.verifyElement(ProductListing_Page.FirstProductImage());
			ProductListing_Page.AddToWishList().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add to Wishlist link not present on Product image on PLP\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_AddToWishlist_RegisteredUser");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_RemoveFromWishlist_RegisteredUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for Registered user links in QuickView on PLP page");

		try {
			Utils.scrollingToPageElementByCordinate(1205, 600);
			Log.info("Scrolled to Add to wishlist link in Quick View on PLP page");
			ProductListing_Page.QuickViewDetails.QuickViewAddToWishlist().click();
			Log.info("Clciked on Add to wishlist link in Quick View on PLP page");
			Utils.verifyElement(ProductListing_Page.QuickViewClose());
			ProductListing_Page.QuickViewClose().click();
			Log.info("Clciked on Close link in Quick View on PLP page");

			Utils.scrollingToPageElementByCordinate(462, 380);
			Log.info("Scrolled to first Product image on PLP page");
			Utils.mouseHover(ProductListing_Page.FirstProductImage());
			Log.info("Hovering on first Product image on PLP page");
			ProductListing_Page.ProductQuickViewTag().click();
			Log.info("Clciked on Quick View tag on product image on PLP page");

			Utils.scrollingToPageElementByCordinate(1205, 600);
			Log.info("Scrolled to Add to wishlist link in Quick View on PLP page");
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewRemoveFromWishlist());
			ProductListing_Page.QuickViewDetails.QuickViewRemoveFromWishlist().click();
			Log.info("Clciked on Remove to wishlist link in Quick View on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Remove From Wishlist link present in Quick View for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewClose());
			ProductListing_Page.QuickViewClose().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Close Quick View link present in Quick View for Products on PLP\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_AddToWishlist_RegisteredUser");
			throw new Exception(BaseClass.errorValidation);
		}
	}
}
