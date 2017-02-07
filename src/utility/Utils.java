package utility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;






import pageObjects.BaseClass;

public class Utils {
	public static WebDriver Driver = null;
	public static WebElement elem = null;

	static String StaticPageName = null;
	public static boolean actualValue;

	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception {
		String sBrowserName;
		try {
			Log.info("Getting Browser Name");
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.browser);

			if (sBrowserName.equals("Mozilla")) {
				ProfilesIni profile = new ProfilesIni();
				//System.setProperty("webdriver.chrome.driver",
					//	Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_Source")
							//	+ "//chromedriver.exe");
				//System.setProperty("webdriver.firefox.bin",
				//		"C:\\Users\\surenderkumar\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
				FirefoxProfile myprofile = profile.getProfile("default");
				Driver = new FirefoxDriver(myprofile);
				
				//Driver = new FirefoxDriver();
			

			} else if (sBrowserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_Source")
								+ "//chromedriver.exe");
				Driver = new ChromeDriver();

			} else if (sBrowserName.equals("IE")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				System.setProperty("webdriver.ie.driver",
						Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_Source")
								+ "//IEDriverServer.exe");
				Driver = new InternetExplorerDriver(capabilities);
			}
			Log.info("New driver instantiated in " + sBrowserName);
           
			Driver.manage().window().maximize();

			Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 20 seconds");

			Driver.get(Constant.URL);
			
			Log.info("Web application launched successfully");

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method OpenBrowser");
			Log.error("Issue in opening browser");
			throw e;
		}
		return Driver;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			Log.info("Getting Test case name");
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			Log.info("Test case name is: " + value);
			return value;
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method getTestCaseName");
			Log.error("Issue in getting test case name");
			throw (e);
		}
	}

	public static String getApplicationName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			Log.info("Getting Application name");
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			posi = value.lastIndexOf("_");
			value = value.substring(0, posi);
			Log.info("Application name is: "+value);

			return value;
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method getTestCaseName");
			Log.error("Issue in getting test application name");
			throw (e);
		}
	}

	public static Properties ReadProperties(String path) throws Exception {

		Properties config = new Properties();
		try {

			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\" + path);
			config.load(fis);

		} catch (IOException e) {
			Log.error("Exception in Class Utils | Method ReadProperties");
			Log.error("Issue in loading config file");
			throw e;
		}

		return config;

	}

	public static void mouseHover(WebElement mainElement) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Actions builder = new Actions(Driver);
			builder.moveToElement(mainElement).build().perform();
			Log.info("Mouse hovered successfully");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHover");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}
	
	public static void SelectDropdown(WebElement mainElement) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Robot rob = new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
			
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHover");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}

	
	public static void mouseHoverAction(WebElement mainElement, WebElement subElement) throws Exception {
		try {
			Log.info("Hovering mouse on the main element");
			Actions action = new Actions(Driver);

			action.moveToElement(mainElement).perform();
			Thread.sleep(5000);
			Log.info("Clicking on subelement");
			subElement.click();

			Log.info(
					"Mouse hover on main element and then Click action on subelement is performed on the entered objects");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHoverAction");
			Log.error("Issue in performing mouse hover and click action");
			throw e;
		}

	}

	public static void SecurityCertificateHandle() throws Exception {
		try {
			Log.info("Handling security certificates");
			Driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			Log.info("SecurityCertificateHandle : eelement got clicked");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method SecurityCertificateHandle");
			throw e;
		}
	}

	public List<WebElement> stripOutElementsThatAreNotVisible(List<WebElement> elementList) {

		List<WebElement> visibleElements = new ArrayList<WebElement>();
		for (int i = 0; i < elementList.size(); i++) {
			WebElement foo = elementList.get(i);
			if (foo.isDisplayed()) {
				visibleElements.add(foo);
			}
		}
		return visibleElements;
	}

	public static WebElement find(By by) throws Exception {
		try {
			elem = null;
			java.util.List<WebElement> list = Driver.findElements(by);
			if (list.size() < 1) {
				throw new NoSuchElementException(null);
			}
			if (list.size() == 1) {
				elem = list.get(0);
				return elem;
			}
			if (list.size() > 1) {
				for (WebElement el : list) {
					try {

						if (el.isDisplayed()) {
							System.out.println(el.getTagName() + " element Visible");
							elem = el;
						} else {
							System.out.println(el.getTagName() + " element Hidden");
						}
					} catch (Exception e) {
						throw e;
					}
				}
				return elem;
			}
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method find");
			throw e;
		}
		return elem;
	}

	public static void waitForElement(WebElement element) throws Exception {
		try {
			Log.info("Waiting for the element to be clickable");
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method waitForElement");
			Log.error("Issue in waiting for the element");
			throw e;
		}

	}

	public static void waitForLoad(String browser) throws InterruptedException {
		Log.info("Waiting for the page to load");
		WebDriverWait wait = new WebDriverWait(Driver, 30);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) Driver).executeScript("return document.readyState").equals("complete");
			}
		});

		if (browser.equalsIgnoreCase("chrome")) {
			Thread.sleep(4000);
			
		} else {
			Log.info("Waiting in Firefox.");
			Thread.sleep(10000);
		}

	}

	public static void verifyElement(WebElement element) throws Exception {
		try {
			Log.info("Verifying element");
			WebDriverWait wait = new WebDriverWait(Driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(element));

			Log.info("Element Present on the page, Verification Passed");

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method verifyElement");
			Log.error("Element Not Present on the page, Verification Failed");
			throw (e);
		}
	}

	public static void performAssertEquals(WebElement element, String expectedValue) {
		try {
			Log.info("Performing assert operation");
			Assert.assertEquals(element.getText(), expectedValue);
			Log.info("Expected value - '" + expectedValue + "match with Actual value - " + element.getText()
					+ "\n");
		} catch (Exception e) {
			Log.info(expectedValue + " - text validation failed");
			Log.error("Exception in Class Utils | Method performAssertEquals");
			BaseClass.errorValidation += "Expected value - '" + expectedValue + "does not match with Actual value - "
					+ element.getText() + "\n";
		}
	}

	public static void driverNavigation(String action) {
		Log.info("Performing navigation operations");
		switch (action) {
		case "forward":
			Driver.navigate().forward();
			break;
		case "backword":
			Driver.navigate().back();
			break;
		default:
			break;
		}
	}

	public static void waitForElementPresence(WebElement element) throws Exception {
		try {
			Log.info("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(Driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));

			Log.info("Element Present on the page, Verification Passed");

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method waitForElementPresence");
			Log.error("Element Not Present on the page, Verification Failed");
			throw (e);
		}
	}

	public static void captureScreenshot(String sTestCaseName, String snapshotType, String snapshotMessage)
			throws Exception {

		try {
			Log.info("Performing snapshot capture operation");
			if (snapshotType.equals("Pass")) {
				File scrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(
						BaseClass.snapshotFolderPath + "\\Pass\\" + sTestCaseName + "_" + snapshotMessage + ".jpg"));
			} else if (snapshotType.equals("Fail")) {
				BaseClass.failedSnapshotFolderPath = BaseClass.snapshotFolderPath + "\\Fail\\" + sTestCaseName + "_"
						+ snapshotMessage + ".jpg";
				File scrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(BaseClass.failedSnapshotFolderPath));
			}

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method captureScreenshot");
			Log.error("Issue in capturing the screenshot");
			throw e;
		}
	}

	public static void setSnapshotFolder()throws Exception {
		Log.info("Setting path for snapshot folder");
		try{
		String path = Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_ScreenShot")
				+ "Test Results\\Run_" + Utils.getTimeStamp();
		BaseClass.snapshotFolderPath = path;
		}catch(Exception e){
			Log.error("Exception in Class Utils | Method setSnapshotFolder");
			Log.error("Issue in setting snapshot folder");
			throw e;
		}

	}

	public static String getTimeStamp() {
		Date d = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String currentDate = sdf.format(d);
		return currentDate;
	}

	public static WebElement SendKeysJavaScript(WebElement element, String attributeN, String value) {

		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("element.setAttribute(attributeN,value)");
		Log.info(" Present on the page");

		return element;
	}

	public static void PageHeaderCheck(String StaticPageName) throws Exception {
		String actualPageHeader = "";
		try {
			Log.info("Performing page header check operation");
			actualPageHeader = Driver.getTitle().toString();
			if (StaticPageName.equals(actualPageHeader)) {
				Log.info(StaticPageName + " Page Header found on the page");

			} else {
				BaseClass.errorValidation = BaseClass.errorValidation + "Expected Page Header -' " + StaticPageName
						+ "' does not match with Actual Page Header -'" + actualPageHeader + "'\n";
			}

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method PageHeaderCheck");
			Log.error(" Page Header not found on the page");
			throw e;
		}

	}

	public static void PageVerification_OnLinkClick(WebElement LinkElem, WebElement PageElem, String PageName)
			throws Exception {

		try {
			LinkElem.click();
			WebDriverWait wait = new WebDriverWait(Driver, 30);
			wait.until(ExpectedConditions.visibilityOf(PageElem));

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method PageVerification_OnLinkClick");
			Log.error("Element Not found on the page on clicking the Link");
			throw (e);

		}

	}

	public static void NewWindowAction()throws Exception {
		// WebDriver Driver
		try {

			String handle = Driver.getWindowHandle();

			System.out.println(handle);

			java.util.Set<String> handles = Driver.getWindowHandles();

			System.out.println(handles);

			// Pass a window handle to the other window

			for (String handle1 : Driver.getWindowHandles()) {

				System.out.println(handle1);

				Driver.switchTo().window(handle1);

			}
			Driver.close();
			Driver.switchTo().window(handle);
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowAction");
			Log.error("Page Header not found on the page");
			throw (e);
		}

	}

	public static void NewWindowPageHeaderValidation(String StaticPageName) throws Exception {
		try {

			String handle = Driver.getWindowHandle();

			System.out.println(handle);

			java.util.Set<String> handles = Driver.getWindowHandles();

			System.out.println(handles);

			// Pass a window handle to the other window

			for (String handle1 : Driver.getWindowHandles()) {

				System.out.println(handle1);

				Driver.switchTo().window(handle1);

			}
			Utils.PageHeaderCheck(StaticPageName);
			Driver.close();
			Driver.switchTo().window(handle);

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowPageHeaderValidation");
			Log.error("Page Header not found on the page");
			throw (e);
		}
	}

	public static void CheckEnable(WebElement element) throws Exception {
		try {

			boolean actualValue = element.isEnabled();

			if (actualValue)
				System.out.println("Button is enabled");
			else
				System.out.println("Button is disabled");

		}

		catch (Exception e) {
			Log.error("Exception in Class Utils | Method CheckEnable");
			throw (e);
		}

	}

	public static boolean CheckEnability(WebElement element)throws Exception {
		try {

			actualValue = element.isDisplayed();

			if (actualValue)
				System.out.println("element is enabled");
			else
				System.out.println("element is disabled");

		}

		catch (Exception e) {
			Log.error("Exception in Class Utils | Method CheckEnability");
			throw (e);
		}

		return actualValue;

	}

	public static void takeScreenshot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(BaseClass.snapshotFolderPath + "\\Fail");
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static void scrollingToPageElement(WebElement element) {

		((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void scrollingToPageElementAdvanced(WebElement element) {
		Locatable element1 = (Locatable) element;
		Point p = element1.getCoordinates().onPage();
		System.out.println(p.getX());
		System.err.println(p.getY());
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollTo(" + p.getX() + "," + p.getY() + ");");

	}

	public static void scrollingToPageElementByCordinate(int x, int y) {

		((JavascriptExecutor) Driver).executeScript("window.scrollTo(" + x + "," + y + ")");

	}
	
	public static void scrollingToPageElementByelement(WebElement element) {

		((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView();"
                ,element);

	}


	public static void scrollingByAction(WebElement element) {

		Actions builder = new Actions(Driver);
		builder.moveToElement(element).build().perform();

	}
	public static List<String> csvDataReader(String data){
		System.out.println(data);
		List<String> testData = Arrays.asList(data.split("\\s*,\\s*"));
		return testData;
		
	}
	
	public static Double decimalReaderFromString(String data){
		Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
		 Matcher matcher = regex.matcher(data);
		 matcher.find();
		return Double.parseDouble(matcher.group());
	}
	
	public static String covertMillis(Long millis){
		long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        return String.format("%02d:%02d:%02d",hours, minutes,seconds);
	}
}
