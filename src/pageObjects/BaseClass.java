package pageObjects;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver Driver;
	public static boolean bResult;
	public static String errorValidation;
	public static String snapshotFolderPath;
	public static String failedSnapshotFolderPath;

	public BaseClass(WebDriver Driver) {
		BaseClass.Driver = Driver;
		BaseClass.bResult = true;
		BaseClass.errorValidation = "";
		BaseClass.failedSnapshotFolderPath = "";
	}
}
