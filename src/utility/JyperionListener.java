package utility;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Log;
import pageObjects.BaseClass;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * JyperionListener
 * 
 * @author janaudy at jyperion dot org
 */
public class JyperionListener implements ITestListener {
	/** Document **/
	private Document document = null;

	/** PdfPTables **/
	PdfPTable successTable = null, failTable = null, infoTable = null, skipTable = null;

	/**
	 * throwableMap
	 */
	private HashMap<Integer, Throwable> throwableMap = null;

	private long testRunStartTime = 0L;
	private long testRunEndTime = 0L;
	private long testRunTime = 0L;

	/**
	 * nbExceptions
	 */
	// private int nbExceptions = 0;

	/**
	 * JyperionListener
	 */
	public JyperionListener() {
		Log.info("JyperionListener()");

		
		this.throwableMap = new HashMap<Integer, Throwable>();
	}

	/**
	 * @see com.beust.testng.ITestListener#onTestSuccess(com.beust.testng.ITestResult)
	 */
	public void onTestSuccess(ITestResult result) {
		Log.info("On Test Success Result is: " + result);
		try {
			if (successTable == null) {

				this.successTable = new PdfPTable(new float[] { .5f, .1f, .5f });
				this.successTable.setTotalWidth(500f);
				this.successTable.setLockedWidth(true);
				Paragraph p = new Paragraph("PASSED TESTS", new Font(Font.TIMES_ROMAN, 11f, Font.BOLD));
				PdfPCell cell = new PdfPCell(p);
				cell.setColspan(4);
				cell.setBackgroundColor(Color.GREEN);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				this.successTable.addCell(cell);

				cell = new PdfPCell(new Paragraph("TestCase Class", new Font(Font.TIMES_ROMAN, 10)));
				cell.setBackgroundColor(Color.LIGHT_GRAY);
				this.successTable.addCell(cell);
				cell = new PdfPCell(new Paragraph("Time(s)", new Font(Font.TIMES_ROMAN, 10)));
				cell.setBackgroundColor(Color.LIGHT_GRAY);
				this.successTable.addCell(cell);
				cell = new PdfPCell(new Paragraph("Exception", new Font(Font.TIMES_ROMAN, 10)));
				cell.setBackgroundColor(Color.LIGHT_GRAY);
				this.successTable.addCell(cell);
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
		}

		PdfPCell cell = new PdfPCell(
				new Paragraph(result.getTestClass().getName().split("\\.")[1], new Font(Font.TIMES_ROMAN, 8)));
		this.successTable.addCell(cell);
		double time = result.getEndMillis() - result.getStartMillis();
		cell = new PdfPCell(new Paragraph("" + time / 1000, new Font(Font.TIMES_ROMAN, 8)));
		this.successTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			// this.nbExceptions++;
			Paragraph excep = new Paragraph(
					new Chunk(throwable.toString(), new Font(Font.TIMES_ROMAN, Font.UNDERLINE, 8))
							.setLocalGoto("" + throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.successTable.addCell(cell);
		} else {
			this.successTable.addCell(new PdfPCell(new Paragraph("")));
		}
	}

	/**
	 * @see com.beust.testng.ITestListener#onTestFailure(com.beust.testng.ITestResult)
	 */
	public void onTestFailure(ITestResult result) {
		Log.info("On Test Failure Result is: " + result);

		// String file =
		// System.getProperty("user.dir")+Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_ScreenShot")+(new
		// Random().nextInt())+".png";
		/*
		 * String file =
		 * Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty(
		 * "Path_ScreenShot") + (new Random().nextInt()) + ".png";
		 */
		String file = BaseClass.failedSnapshotFolderPath;
		Log.info("The file name is: " + file);

		if (this.failTable == null) {
			this.failTable = new PdfPTable(new float[] { .5f, .1f, .5f });
			this.failTable.setTotalWidth(500f);
			this.failTable.setLockedWidth(true);
			Paragraph p = new Paragraph("FAILED TESTS", new Font(Font.TIMES_ROMAN, 11f, Font.BOLD));
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(Color.RED);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			this.failTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("TestCase Class", new Font(Font.TIMES_ROMAN, 10)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time(s)", new Font(Font.TIMES_ROMAN, 10)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception", new Font(Font.TIMES_ROMAN, 10)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
		}

		PdfPCell cell = new PdfPCell(
				new Paragraph(result.getTestClass().getName().split("\\.")[1], new Font(Font.TIMES_ROMAN, 8)));
		this.failTable.addCell(cell);
		double time = result.getEndMillis() - result.getStartMillis();
		cell = new PdfPCell(new Paragraph("" + time / 1000, new Font(Font.TIMES_ROMAN, 8)));
		this.failTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			// this.nbExceptions++;
			Log.info("Flag screenshot");
			Chunk imdb = new Chunk("  [ Linked SCREEN SHOT ]", new Font(Font.TIMES_ROMAN, 8, Font.UNDERLINE));
			imdb.setAction(new PdfAction("file:///" + file));
			Paragraph excep = new Paragraph(throwable.toString(), new Font(Font.TIMES_ROMAN, 8));
			excep.add(imdb);

			cell = new PdfPCell(excep);
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
		} else {
			this.failTable.addCell(new PdfPCell(new Paragraph("")));
		}
	}

	/**
	 * @see com.beust.testng.ITestListener#onTestSkipped(com.beust.testng.ITestResult)
	 */
	public void onTestSkipped(ITestResult result) {
		Log.info("On Test Skipped result is: " + result);

		try {
			if (skipTable == null) {

				this.skipTable = new PdfPTable(new float[] { .5f, .1f, .5f });
				this.skipTable.setTotalWidth(500f);
				this.skipTable.setLockedWidth(true);
				Paragraph p = new Paragraph("SKIPPED TESTS", new Font(Font.TIMES_ROMAN, 11f, Font.BOLD));
				PdfPCell cell = new PdfPCell(p);
				cell.setColspan(4);
				cell.setBackgroundColor(Color.ORANGE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				this.skipTable.addCell(cell);

				cell = new PdfPCell(new Paragraph("TestCase Class", new Font(Font.TIMES_ROMAN, 10)));
				cell.setBackgroundColor(Color.LIGHT_GRAY);
				this.skipTable.addCell(cell);
				cell = new PdfPCell(new Paragraph("Time(s)", new Font(Font.TIMES_ROMAN, 10)));
				cell.setBackgroundColor(Color.LIGHT_GRAY);
				this.skipTable.addCell(cell);
				cell = new PdfPCell(new Paragraph("Exception", new Font(Font.TIMES_ROMAN, 10)));
				cell.setBackgroundColor(Color.LIGHT_GRAY);
				this.skipTable.addCell(cell);
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
		}

		PdfPCell cell = new PdfPCell(
				new Paragraph(result.getTestClass().getName().split("\\.")[1], new Font(Font.TIMES_ROMAN, 8)));
		this.skipTable.addCell(cell);
		double time = result.getEndMillis() - result.getStartMillis();
		cell = new PdfPCell(new Paragraph("" + time / 1000, new Font(Font.TIMES_ROMAN, 8)));
		this.skipTable.addCell(cell);
		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			// this.nbExceptions++;
			Paragraph excep = new Paragraph(
					new Chunk(throwable.toString(), new Font(Font.TIMES_ROMAN, Font.UNDERLINE, 8))
							.setLocalGoto("" + throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.skipTable.addCell(cell);
		} else {
			this.skipTable.addCell(new PdfPCell(new Paragraph("")));
		}

	}

	/**
	 * @see com.beust.testng.ITestListener#onStart(com.beust.testng.ITestContext)
	 */
	public void onStart(ITestContext context) {
		Log.info("On Start context is: " + context);
		this.testRunStartTime  = context.getStartDate().getTime();
		this.document = new Document();
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(context.getName() + ".pdf"));
		} catch (Exception e) {
			Log.error("Exception in Class JyperionListener | Method onStart");
			e.printStackTrace();
		}
		this.document.open();

		Paragraph p = new Paragraph(context.getName().toUpperCase() + " TESTNG RESULTS",
				FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(0, 0, 255)));
		p.setAlignment(Element.ALIGN_CENTER);
		try {
			this.document.add(p);

			p = new Paragraph("EXECUTION SUMMARY",
					FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0, 150)));
			p.setAlignment(Element.ALIGN_CENTER);
			p.setSpacingBefore(20f);
			this.document.add(p);
			this.infoTable = new PdfPTable(new float[] { .4f, .5f });
			this.infoTable.setTotalWidth(200f);
			this.infoTable.setLockedWidth(true);
			PdfPCell cell = new PdfPCell(new Paragraph("Execution DateTime", new Font(Font.TIMES_ROMAN, 7)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.infoTable.addCell(cell);
			this.infoTable.addCell(new Paragraph(new Date().toString(), new Font(Font.TIMES_ROMAN, 7)));
		} catch (DocumentException e1) {
			Log.error("Exception in Class JyperionListener | Method onStart1");
			e1.printStackTrace();
		}
	}

	/**
	 * @see com.beust.testng.ITestListener#onFinish(com.beust.testng.ITestContext)
	 */
	public void onFinish(ITestContext context) {
		Log.info("On Finish context is: " + context);
		testRunEndTime = context.getEndDate().getTime();
		testRunTime = testRunEndTime-testRunStartTime;
		

		try {

			PdfPCell cell = new PdfPCell(new Paragraph("Total Test Run Time", new Font(Font.TIMES_ROMAN, 7)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.infoTable.addCell(cell);
			this.infoTable.addCell(new Paragraph(Utils.covertMillis(testRunTime), new Font(Font.TIMES_ROMAN, 7)));
			
			cell = new PdfPCell(new Paragraph("Testing URL", new Font(Font.TIMES_ROMAN, 7)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.infoTable.addCell(cell);
			this.infoTable.addCell(new Paragraph(Constant.URL, new Font(Font.TIMES_ROMAN, 7)));

			cell = new PdfPCell(new Paragraph("Total Tests", new Font(Font.TIMES_ROMAN, 7)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.infoTable.addCell(cell);
			this.infoTable
					.addCell(new Paragraph("" + context.getAllTestMethods().length, new Font(Font.TIMES_ROMAN, 7)));

			cell = new PdfPCell(new Paragraph("Test Passed", new Font(Font.TIMES_ROMAN, 7)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.infoTable.addCell(cell);
			this.infoTable.addCell(new Paragraph("" + context.getPassedTests().size(), new Font(Font.TIMES_ROMAN, 7)));

			cell = new PdfPCell(new Paragraph("Test Failed", new Font(Font.TIMES_ROMAN, 7)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.infoTable.addCell(cell);
			this.infoTable.addCell(new Paragraph("" + context.getFailedTests().size(), new Font(Font.TIMES_ROMAN, 7)));

			cell = new PdfPCell(new Paragraph("Test Skipped", new Font(Font.TIMES_ROMAN, 7)));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.infoTable.addCell(cell);
			this.infoTable.addCell(new Paragraph("" + context.getSkippedTests().size(), new Font(Font.TIMES_ROMAN, 7)));

			Log.info("Added info table");
			this.infoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
			this.infoTable.setSpacingBefore(10f);
			this.document.add(this.infoTable);
			this.infoTable.setSpacingAfter(20f);
			Paragraph p = new Paragraph("DETAILED TEST REPORT",
					FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0, 150)));
			p.setAlignment(Element.ALIGN_CENTER);
			p.setSpacingBefore(20f);
			this.document.add(p);

			if (this.failTable != null) {
				Log.info("Added fail table");
				this.failTable.setSpacingBefore(15f);
				this.document.add(this.failTable);
				this.failTable.setSpacingAfter(15f);
				this.failTable.setHorizontalAlignment(Element.ALIGN_CENTER);
			}

			if (this.skipTable != null) {
				Log.info("Added skip table");
				this.skipTable.setSpacingBefore(15f);
				this.document.add(this.skipTable);
				this.skipTable.setSpacingAfter(15f);
				this.skipTable.setHorizontalAlignment(Element.ALIGN_CENTER);
			}

			if (this.successTable != null) {
				Log.info("Added success table");
				this.successTable.setSpacingBefore(15f);
				this.document.add(this.successTable);
				this.successTable.setSpacingAfter(15f);
				this.successTable.setHorizontalAlignment(Element.ALIGN_CENTER);
			}
			
			this.failTable = null;
			this.successTable = null;
			this.skipTable = null;

		} catch (DocumentException e) {
			Log.error("Exception in Class JyperionListener | Method onFinish");
			e.printStackTrace();
		}

		/*
		 * Paragraph p = new Paragraph("EXCEPTIONS SUMMARY",
		 * FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new
		 * Color(255, 0, 0))); try { Log.info("Actual error");
		 * this.document.add(p); } catch (DocumentException e1) { Log.error(
		 * "duplicate error"); e1.printStackTrace(); }
		 * 
		 * Set<Integer> keys = this.throwableMap.keySet();
		 * 
		 * assert keys.size() == this.nbExceptions;
		 * 
		 * for (Integer key : keys) { Throwable throwable =
		 * this.throwableMap.get(key);
		 * 
		 * Chunk chunk = new Chunk(throwable.toString(),
		 * FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, new
		 * Color(255, 0, 0))); chunk.setLocalDestination("" + key); Paragraph
		 * throwTitlePara = new Paragraph(chunk); try {
		 * this.document.add(throwTitlePara); } catch (DocumentException e3) {
		 * Log.error("duplicate error1"); e3.printStackTrace(); }
		 * 
		 * 
		 * StackTraceElement[] elems = throwable.getStackTrace(); // String
		 * exception = ""; for (StackTraceElement ste : elems) { Paragraph
		 * throwParagraph = new Paragraph(ste.toString()); try {
		 * this.document.add(throwParagraph); } catch (DocumentException e2) {
		 * Log.error("duplicate error2"); e2.printStackTrace(); } }
		 * 
		 * }
		 */

		this.document.close();
	}

	/**
	 * log
	 * 
	 * @param o
	 */
	public static void log(Object o) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestStart(ITestResult arg0) {
		Log.info("New Test " + arg0.getMethod().toString().split("\\.")[0] + " started");

	}
}
