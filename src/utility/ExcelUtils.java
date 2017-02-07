package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	// This method is to set the File path and to open the Excel file
	// Excel Path and Sheet name as Arguments to this method
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			Log.info("Opening the excel file");
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Log.info("Excel sheet opened");
		} catch (Exception e) {
			Log.error("Exception in Class ExcelUtil | Method setExcelFile");
			Log.error("Issue in opening excel file");
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	@SuppressWarnings("static-access")
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			Cell.setCellType(Cell.CELL_TYPE_STRING);
			String CellData = Cell.getStringCellValue();
			Log.info("Getting data value from excel. The value is: " + CellData);
			return CellData;
		} catch (Exception e) {
			Log.error("Exception in Class ExcelUtil | Method getCellData");
			Log.error("Issue in getting data from excel file");
			throw e;
		}
	}

	// This method is to write in the Excel cell
	// Row num and Col num are the parameters
	@SuppressWarnings("static-access")
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			Log.info("Writing the value in excel file");
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}

			FileOutputStream fileOut = new FileOutputStream(
					Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
							+ Constant.File_TestData);

			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			Log.info("Writing process completed");
		} catch (Exception e) {
			Log.error("Exception in Class ExcelUtil | Method setCellData");
			Log.error("Error in writing the value in excel file");
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			Log.error("Exception in Class ExcelUtil | Method getRowContains");
			Log.error("Issue in getting row number");
			throw (e);
		}
	}

	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			Log.info("Total number of Row used are: " + RowCount);
			return RowCount;
		} catch (Exception e) {
			Log.error("Exception in Class ExcelUtil | Method getRowUsed");
			Log.error("Issue in getting used row count");
			throw (e);
		}

	}
}