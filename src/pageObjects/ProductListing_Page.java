package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;

public class ProductListing_Page extends BaseClass {
	private static WebElement element;
	private static List<WebElement> webElements;
	private static Select selectElement;

	public ProductListing_Page(WebDriver Driver) {
		super(Driver);

	}

	public static WebElement product() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath(".//*[@id='1HashPosition']/a/picture/div/div/div/ul/li/a/img"));
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}
	
	public static WebElement checkout_product() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath(".//*[@id='1HashPosition']/a/picture/div/div/div/ul/li/a/img"));
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}
	
	public static WebElement FCC_checkout_product() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath(".//*[@id='2HashPosition']/a/picture/div/div/div/ul/li[1]/a/img"));
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}
	
	public static WebElement sizeofproduct() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath("html/body/main/div[11]/section[2]/div/div/div/div[2]/div[3]/div[1]/div[4]/div[3]/ul/li[2]"));
			Log.info("Size of Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Size of product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement ProductCount() throws Exception {

		try {
			Log.info("Locating Product Item Count on PLP");
			element = Driver.findElement(By.xpath(
					"//div[@class='heading-filter-sec']/descendant::div[@class='pro-list-heading margB20 col-md-12 text-center']/h4/span"));
			Log.info("Product Item Count found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductCount");
			Log.error("Product Item Count not found on PLP");
			throw (e);
		}

		return element;

	}

	public static Select SortOptions() throws Exception {

		try {
			Log.info("Locating Sort Option Drop Down found on PLP");
			selectElement =new Select(Driver.findElement(By.xpath("//form[@id='sortForm1']/descendant::select[@id='sortOptions1']")));
			Log.info("Sort Option Drop Down found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SortOptions");
			Log.error("Sort Option Drop Down not found on PLP");
			throw (e);
		}

		return selectElement;

	}

	public static WebElement GridViewIcon() throws Exception {

		try {
			Log.info("Locating Grid View Icon on PLP ");
			element = Driver.findElement(By.xpath("//li[@class='grid-view active']"));
			Log.info("Grid View Icon found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method GridViewIcon");
			Log.error("Grid View Icon not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement FilterOnOff() throws Exception {

		try {
			Log.info("Locating Filter On Off Icon on PLP ");
			element = Driver.findElement(By.xpath("//span[@class='filters-txt']/span[@class='triangle-bottomright']"));
			Log.info("Filter On Off Icon found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method FilterOnOff");
			Log.error("Filter On Off Icon not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DefaultFilterContainer() throws Exception {

		try {
			Log.info("Locating Default Filter Container on PLP ");
			element = Driver.findElement(By.xpath(
					"//section[@class='product-listing-wrapper']/descendant::div[@class='yCmsComponent filter-inner']"));
			Log.info("Default Filter Container found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultFilterContainer");
			Log.error("Default Filter Container not found on PLP");
			throw (e);
		}

		return element;

	}
public static List<WebElement> DefaultAttributeFilterCategoryContainer()throws Exception {

	try {
		Log.info("Locating Default Attribute Filter Container elements on PLP ");
		webElements = Driver.findElements(By
				.xpath("//div[@id='product-facet']/descendant::div[contains(@class,'filter-category-heading')]"));
		Log.info("Default Attribute Filter Container elements found on PLP ");

	} catch (Exception e) {
		Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterCategoryContainer");
		Log.error("Default Attribute Filter Container not found on PLP");
		throw (e);
	}

	return webElements;

}

	public static WebElement DefaultAttributeFilterCategory(String filterCategary) throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Category - "+filterCategary+" on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@id='product-facet']/descendant::div[contains(@class,'filter-category-heading')]/span[contains(text(),'"
							+ filterCategary + "')]"));
			Log.info("Default Attribute Filter Category - "+filterCategary+" found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterCategory");
			Log.error("Default Attribute Filter Category- "+filterCategary+" not found on PLP");
			throw (e);
		}

		return element;

	}
	
	public static WebElement DefaultAttributeFilter(String filterValue) throws Exception {
		
		try {
			Log.info("Locating Default Attribute Filter Value - " + filterValue + "  on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@id='product-facet']/descendant::div[@class='tabs_item' and @style='display: block;']/ul/li/descendant::label[contains(text(),'"
							+ filterValue + "')]/preceding-sibling::input[@class='checkbox-sel']"));
			Log.info("Default Attribute Filter Value - " + filterValue + " found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilter");
			Log.error("Default Attribute Filter Value - " + filterValue + " not found on PLP");
			throw (e);
		}
		

		return element;

	}

	public static WebElement DefaultAttributeFilterPageLoad(String filterValue) throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Value - " + filterValue + " on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@id='product-facet']/descendant::div[@class='tabs_item']/ul/li/descendant::label[contains(text(),'"
							+ filterValue + "')]/preceding-sibling::input[@class='checkbox-sel']"));
			Log.info("Default Attribute Filter Value - " + filterValue + " found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterPageLoad");
			Log.error("Default Attribute Filter Value - " + filterValue + " not found on PLP");
			throw (e);
		}
		return element;

	}
	public static List<WebElement> DefaultAttributeFilterAppliedList()throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Applied List on PLP ");
			webElements = Driver.findElements(By
					.xpath("//div[@class='refine-pins']//span[@class='refine-txt']/following-sibling::ul/li"));
			Log.info("Default Attribute Filter Applied List is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterAppliedList");
			Log.error("Default Attribute Filter Applied List is not found on PLP");
			throw (e);
		}

		return webElements;

	}
	
	public static WebElement DefaultAttributeFilterClose(int i)throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Applied List close icons on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='refine-pins']//span[@class='refine-txt']/following-sibling::ul/li["+i+"]//a/span[@class='glyphicon-glyphicon-remove']"));
			Log.info("Default Attribute Filter Applied List has close icons present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterClose");
			Log.error("Default Attribute Filter Applied List close icons not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DefaultAttributeFilterCloseAll() throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Applied List close all icon on PLP ");
			element = Driver.findElement(By.xpath(
					"//div[@class='refine-pins']//label[contains(text(),'Clear')]/following-sibling::a/span[@class='glyphicon-glyphicon-remove']"));
			Log.info("Default Attribute Filter Applied List close all icon is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterCloseAll");
			Log.error("Default Attribute Filter Applied List close all icon is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterBrandDropDown()throws Exception {

		try {
			Log.info("Locating Brand related Primary Filter on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='brands-list js-facet-form']/preceding-sibling::div[contains(@class,'filter-category-heading')]"));
			Log.info("Brand related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterBrandDropDown");
			Log.error("Brand related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterBrandDropDownContainer()throws Exception {

		try {
			Log.info("Locating Brand related Primary Filter Container on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='brands-list js-facet-form']"));
			Log.info("Brand related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterBrandDropDownContainer");
			Log.error("Brand related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}
	
	
	public static WebElement PrimaryFilterPriceDropDown()throws Exception {

		try {
			Log.info("Locating Price related Primary Filter on PLP ");
			element = Driver.findElement(By.xpath("//div[@class='lists-names price-range js-facet-form']/preceding-sibling::div[contains(@class,'filter-category-heading')]"));
			//element = Driver.findElement(By
					//.xpath("//*[@id='tab13']/div[1]"));
			Log.info("Price related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterPriceDropDown");
			Log.error("Price related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterPriceDropDownContainer()throws Exception {

		try {
			Log.info("Locating Price related Primary Filter Container on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='lists-names price-range js-facet-form']"));
			Log.info("Price related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterPriceDropDownContainer");
			Log.error("Price related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterSizeDropDown()throws Exception {

		try {
			Log.info("Locating Size related Primary Filter on PLP ");

			element = Driver.findElement(By
					.xpath("//div[@class='size-list js-facet-form']/preceding-sibling::div[contains(@class,'filter-category-heading')]"));
			Log.info("Size related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterSizeDropDown");
			Log.error("Size related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterSizeDropDownContainer()throws Exception {

		try {
			Log.info("Locating Size related Primary Filter Container on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='size-list js-facet-form']"));
			Log.info("Size related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterSizeDropDownContainer");
			Log.error("Size related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterColorDropDown()throws Exception {

		try {
			Log.info("Locating Color related Primary Filter on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='lists-names color-combo js-facet-form']/preceding-sibling::div[contains(@class,'filter-category-heading')]"));
			Log.info("Color related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterColorDropDown");
			Log.error("Color related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterColorDropDownContainer()throws Exception {

		try {
			Log.info("Locating Color related Primary Filter Container on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='lists-names color-combo js-facet-form']"));
			Log.info("Color related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterColorDropDownContainer");
			Log.error("Color related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterOnSaleDropDown()throws Exception {

		try {
			Log.info("Locating On Sale related Primary Filter on PLP ");
			element = Driver.findElement(By
					.xpath("//div[@class='filter-scroll promo-list js-facet-form']/preceding-sibling::div[contains(@class,'filter-category-heading')]"));
			Log.info("On Sale related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterOnSaleDropDown");
			Log.error("On Sale related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement PrimaryFilterOnSaleDropDownContainer()throws Exception {

		try {
			Log.info("Locating On Sale related Primary Filter Container on PLP ");
			//element = Driver.findElement(By.xpath("//*[@class='filter-scroll l3-category js-facet-form']"));
			element = Driver.findElement(By.xpath("//*[@class='filter-scroll promo-list js-facet-form']"));
			//element = Driver.findElement(By
			//	.xpath("//div[@class='viewport']"));
			
			Log.info("On Sale related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterOnSaleDropDownContainer");
			Log.error("On Sale related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement SelectBrandCheckbox(String Brand)throws Exception {

		try {
			Log.info("Locating Brand name checkbox on PLP ");
			element = Driver.findElement(By
					.xpath("//input[@id='"+Brand+"' and @type='checkbox']"));
			Log.info("Brand name checkbox is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectBrandCheckbox");
			Log.error("Brand name checkbox is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement SelectPriceCheckbox(String PriceRange)throws Exception {

		try {
			Log.info("Locating Price Range checkbox on PLP ");
			element = Driver.findElement(By
					.xpath("//input[@id='"+PriceRange+"' and @type='checkbox']"));
			Log.info("Price Range checkbox is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectPriceCheckbox");
			Log.error("Price Range checkbox not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement SelectSizeCheckbox(String sizeValue)throws Exception {

		try {
			Log.info("Locating Price Range checkbox on PLP ");
			element = Driver.findElement(By
					.xpath("//input[@id='"+sizeValue+"' and @type='checkbox']"));
			Log.info("Price Range checkbox is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectPriceCheckbox");
			Log.error("Price Range checkbox not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement SelectColorCheckbox(String color)throws Exception {

		try {
			Log.info("Locating Color checkbox on PLP ");
			element = Driver.findElement(By
					.xpath("//input[@id='"+color+"' and @type='checkbox']"));
			Log.info("Color checkbox is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectColorCheckbox");
			Log.error("Color checkbox not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement SelectOnSaleCheckbox(String saleOffer)throws Exception {

		try {
			Log.info("Locating Sale offer on PLP ");
		element = Driver.findElement(By.xpath("//input[@id='Flat 40% Off' and @type='checkbox']"));
			
	//element = Driver.findElement(By
		//.xpath("//*[@class='filter-scroll promo-list js-facet-form']//*[@id='"+saleOffer+"']"));
			Log.info("Sale offer is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectOnSaleCheckbox");
			Log.error("Sale offer not found on PLP");
			throw (e);
		}

		return element;

	}
	public static WebElement LoadMoreLink()throws Exception {

		try {
			Log.info("Locating Load More Link on PLP ");
			element = Driver.findElement(By
					.xpath("//*[@id='loadmore']"));
			Log.info("Load More Link is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method LoadMoreLink");
			Log.error("Load More Link is not found on PLP");
			throw (e);
		}

		return element;

	}
	
	public static WebElement DisplayResultCountSpan()throws Exception {

		try {
			Log.info("Locating Display Result Count Span on PLP ");
			element = Driver.findElement(By
					.xpath(".//*[@id='loadmore']/following-sibling::span"));
			Log.info("Display Result Count Span is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DisplayResultCountSpan");
			Log.error("Display Result Count Span is not found on PLP");
			throw (e);
		}

		return element;

	}
	
	public static List<WebElement> ProductImage()throws Exception {

		try {
			Log.info("Location Product Image on PLP ");
			//webElements = Driver.findElements(By
				//	.xpath("//div[@class='styleImageData']/descendant::div[@class='lazyloaded']"));
			webElements = Driver.findElements(By
				.xpath("//img[contains(@src,'sys-master')]"));
			
		
			Log.info("Product Image is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductImage");
			Log.error("Product Image is not found on PLP");
			throw (e);
		}

		return webElements;

	}
	public static WebElement FirstProductImage()throws Exception {

		try {
			Log.info("Locating Product Image on PLP ");
			//element = Driver.findElement(By
					//.xpath("//ul[@id='qv-drop']//li[1]/descendant::div[@class='pro-img']"));
			
			element = Driver.findElement(By
					.xpath(".//*[@id='1HashPosition']/a/picture/div/div/div/ul/li[1]/a/img"));
			Log.info("Product Image is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method FirstProductImage");
			Log.error("Product Image is not found on PLP");
			throw (e);
		}

		return element;
	}	
		public static WebElement ThirdProductImage()throws Exception {

			try {
				Log.info("Locating Product Image on PLP ");
				//element = Driver.findElement(By
						//.xpath("//ul[@id='qv-drop']//li[1]/descendant::div[@class='pro-img']"));
				
				element = Driver.findElement(By
						.xpath(".//*[@id='3HashPosition']/a/picture/div/div/div/ul/li[1]/a/img"));
				Log.info("Product Image is present on PLP ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method FirstProductImage");
				Log.error("Product Image is not found on PLP");
				throw (e);
			}

			return element;

	}
	public static WebElement QuickViewContainer()throws Exception {

		try {
			Log.info("Locating Quick View Container on PLP ");
			element = Driver.findElement(By
					.xpath("//li[@class='quickbox-li']//div[@id='quick-view-box']"));
			Log.info("Quick View Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method QuickViewContainer");
			Log.error("Quick View Container is not found on PLP");
			throw (e);
		}

		return element;

	}
	public static List<WebElement> ProductNameInfo()throws Exception {

		try {
			Log.info("Locating Product name information on PLP ");
			webElements = Driver.findElements(By
					.xpath("//ul[@id='qv-drop']/descendant::div[@class='pro-info']/descendant::div[@class='pro-name']"));
			Log.info("Product name information is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductNameInfo");
			Log.error("Product name information is not found on PLP");
			throw (e);
		}

		return webElements;

	}
	public static List<WebElement> ProductPriceInfo()throws Exception {

		try {
			Log.info("Locating Product price information on PLP ");
			webElements = Driver.findElements(By
					.xpath("//ul[@id='qv-drop']/descendant::div[@class='pro-info']/descendant::div[@class='price']"));
			Log.info("Product price information is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductPriceInfo");
			Log.error("Product price information is not found on PLP");
			throw (e);
		}

		return webElements;

	}
	public static List<WebElement> ProductColorOption()throws Exception {

		try {
			Log.info("Locating Product color option information on product image ");
			webElements = Driver.findElements(By
					.xpath("//ul[@id='qv-drop']/descendant::div[@class='pro-img']/descendant::div[@class='color-type']/ul"));
			Log.info("Product color option information is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductColorOption");
			Log.error("Product color option information is not present on product image ");
			throw (e);
		}

		return webElements;

	}
	public static WebElement ProductQuickViewTag()throws Exception {

		try {
			Log.info("Locating Product Quick View Tag on product image ");
			element = Driver.findElement(By.xpath("//ul[@id='qv-drop']/li[1]/descendant::div[@class='pro-img restore']/descendant::div[@class='quick-view-lbl']"));
			//element = Driver.findElement(By.xpath("//ul[@id='qv-drop']descendant::div[@class='quick-view-lbl']"));
			//element = Driver.findElement(By
				//	.xpath(".//*[@id='1HashPosition']/a/picture/div/div/div/ul/li[1]/a/img/descendant::div[@class='quick-view-lbl']"));
			Log.info("Product Quick View Tag is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductQuickViewTag");
			Log.error("Product Quick View Tag is not present on product image ");
			throw (e);
		}
		return element;

	}
	
	public static WebElement WishListProductQuickViewTag()throws Exception {

		try {
			Log.info("Locating Product Quick View Tag on product image ");
			//element = Driver.findElement(By.xpath("//ul[@id='qv-drop']/li[1]/descendant::div[@class='pro-img restore']/descendant::div[@class='quick-view-lbl']"));
			//element = Driver.findElement(By.xpath("//ul[@id='qv-drop']descendant::div[@class='quick-view-lbl']"));
			element = Driver.findElement(By
					.xpath(".//*[@id='1HashPosition']/div[2]"));
			Log.info("Product Quick View Tag is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductQuickViewTag");
			Log.error("Product Quick View Tag is not present on product image ");
			throw (e);
		}
		return element;

	}
	
	public static class QuickViewDetails{
		public static WebElement element;
		public static List<WebElement> webElements;
		public static List<WebElement> QuickViewImageThumbnails()throws Exception {

			try {
				Log.info("Locating Quick View Image Thumbnails for Product Quick View Tag on product image ");
				webElements = Driver.findElements(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='thumbnails']/descendant::ul/li"));
				Log.info("Quick View Image Thumbnails for Product Quick View Tag is present on product image ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewImageThumbnails");
				Log.error("Quick View Image Thumbnails for Product Quick View Tag is not present on product image ");
				throw (e);
			}
			return webElements;

		}
		public static List<WebElement> QuickViewImageSlider()throws Exception {

			try {
				Log.info("Locating Quick View Image Slider for Product Quick View Tag on product image ");
				webElements = Driver.findElements(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='slider']/descendant::ul/li/picture"));
				Log.info("Quick View Image Slider for Product Quick View Tag is present on product image ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewImageSlider");
				Log.error("Quick View Image Slider for Product Quick View Tag is not present on product image ");
				throw (e);
			}
			return webElements;

		}
		
		public static WebElement QuickViewBrandName()throws Exception {

			try {
				Log.info("Locating Brand Name under Quick View on PLP Page ");
				element = Driver.findElement(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_rightside wishListQuickView']/descendant::h2"));
				Log.info("Brand Name is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewBrandName");
				Log.error("Brand Name is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}
		public static WebElement QuickViewProductName()throws Exception {

			try {
				Log.info("Locating Product Name under Quick View on PLP Page ");
				element = Driver.findElement(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_rightside wishListQuickView']/descendant::h1"));
				Log.info("Product Name is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewProductName");
				Log.error("Product Name is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}
		public static WebElement QuickViewPrice()throws Exception {

			try {
				Log.info("Locating Product Price under Quick View on PLP Page ");
				element = Driver.findElement(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_rightside wishListQuickView']/descendant::div[@class='price_div']"));
				Log.info("Product Price is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewPrice");
				Log.error("Product Price is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}
		public static List<WebElement> QuickViewColorVariant()throws Exception {

			try {
				Log.info("Locating Product Color Variant option under Quick View on PLP Page ");

				webElements = Driver.findElements(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::div[@class='color_div']/ul/li"));
				Log.info("Product Color Variant option is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewColorVariant");
				Log.error("Product Color Variant option is not present under Quick View on PLP Page ");
				throw (e);
			}
			return webElements;

		}
		public static List<WebElement> QuickViewSizeVariant()throws Exception {

			try {
				Log.info("Locating Product Size Variant option under Quick View on PLP Page ");
				//webElements = Driver.findElements(By.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::div[@class='size_width']/ul/li"));
				
webElements = Driver.findElements(By.xpath("//div[@class='product_rightside wishListQuickView']/descendant::div[@class='size_width']/ul/li"));
				Log.info("Product Size Variant option is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewSizeVariant");
				Log.error("Product Size Variant option is not present under Quick View on PLP Page ");
				throw (e);
			}
			return webElements;

		}
		public static WebElement QuickViewAddToBagButton()throws Exception {

			try {
				Log.info("Locating Add to bag button under Quick View on PLP Page ");
				element = Driver.findElement(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::button[@id='addToCartButtonCart_id']"));
				Log.info("Add to bag button is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewAddToBagButton");
				Log.error("Add to bag button is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}
		
		public static WebElement QuickViewPRoductDetailsLink()throws Exception {

			try {
				Log.info("Locating View Product details link under Quick View on PLP Page ");
				element = Driver.findElement(By
						.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::p[@class='viewProduct']"));
				Log.info("View Product details link is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewPRoductDetailsLink");
				Log.error("View Product details link is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}
		
		public static WebElement QuickViewRemoveFromWishlist()throws Exception {

			try {
				Log.info("Locating Remove from wishlist link under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::button[@id='removewishlistId' and @type='submit']"));
				Log.info("Remove from wishlist link is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewRemoveFromWishlist");
				Log.error("Remove from wishlist link is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}
		
	
	public static WebElement QuickViewAddToWishlist()throws Exception {

		try {
			Log.info("Locating Add to wishlist link under Quick View on PLP Page ");
			element = Driver.findElement(By.xpath(
					"//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::button[@id='addwishlistId' and @type='submit']"));
			Log.info("Add to wishlist link is present under Quick View on PLP Page ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method QuickViewAddToWishlist");
			Log.error("Add to wishlist link is not present under Quick View on PLP Page ");
			throw (e);
		}
		return element;

	}
	
}
	
	
	public static WebElement PromotionImageLink()throws Exception {

		try {
			Log.info("Locating Promotion image link on product image ");
			element = Driver.findElement(By
					.xpath(".//*[@id='qv-drop']/a/div[@class='cmsimage']/img"));
			Log.info("Promotion image link is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PromotionImageLink");
			Log.error("Promotion image link is not present on product image ");
			throw (e);
		}

		return element;

	}
	public static WebElement AddToWishList()throws Exception {

		try {
			Log.info("Locating Add to wishlist on product image ");
			element = Driver.findElement(By.xpath(
					"//ul[@id='qv-drop']/li[1]/descendant::button[@id='addwishlistId' and @type='submit']"));
			Log.info("Add to wishlist is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method AddToWishList");
			Log.error("Add to wishlist is not present on product image ");
			throw (e);
		}

		return element;

	}
	public static WebElement QuickViewClose()throws Exception {

		try {
			Log.info("Locating Close Link on Qick View ");
			element = Driver.findElement(By.xpath(
					"//section[@class='product-listing-wrapper']/descendant::div[@class='close-box qv-close']"));
			Log.info("Close Link is present on Qick View ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method QuickViewClose");
			Log.error("Close Link is not present on Qick View");
			throw (e);
		}

		return element;

	}
}
