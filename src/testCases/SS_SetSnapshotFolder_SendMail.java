package testCases;

import javax.mail.internet.InternetAddress;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utility.Constant;
import utility.PDFReport;
import utility.Utils;
import utility.JyperionListener;


@Listeners(JyperionListener.class)
public class SS_SetSnapshotFolder_SendMail {

	public WebDriver Driver;


	@BeforeSuite
	public void setSnapShotFolder() throws Exception {
		Utils.setSnapshotFolder();
	}


	@AfterSuite
	public void tearDown() throws Exception {
		PDFReport.sendPDFReportByGMail(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("from"),
				Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("password"),
				InternetAddress.parse(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("to")),
				Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("subject"), "");
	}

}
