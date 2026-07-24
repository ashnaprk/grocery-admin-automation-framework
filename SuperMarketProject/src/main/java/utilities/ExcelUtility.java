package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	public static String getStringData(int a, int b, String sheet) throws IOException {
		try (FileInputStream f = new FileInputStream(Constants.TESTDATA);
		     XSSFWorkbook w = new XSSFWorkbook(f)) {

			XSSFSheet sh = w.getSheet(sheet);
			XSSFRow r = sh.getRow(a);
			if (r == null) return "";
			XSSFCell c = r.getCell(b);
			if (c == null) return "";
			return c.getStringCellValue();
		}
	}

	public static String getIntData(int a, int b, String sheet) throws IOException {
		try (FileInputStream f = new FileInputStream(Constants.TESTDATA);
		     XSSFWorkbook w = new XSSFWorkbook(f)) {

			XSSFSheet sh = w.getSheet(sheet);
			XSSFRow r = sh.getRow(a);
			if (r == null) return "0";
			XSSFCell c = r.getCell(b);
			if (c == null) return "0";
			int val = (int) c.getNumericCellValue();
			return String.valueOf(val);
		}
	}
}





