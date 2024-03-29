package Util_Pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

	static Properties prop;
	FileInputStream file;
	Workbook book;
	Sheet sh;
	Row row;
	Cell cell;

	public static void Click(String xpath, WebDriver driver) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void SendKeys(String xpath, String text, WebDriver driver) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	public String getexceldata(String xlfile, String sheet, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException {

		file = new FileInputStream(xlfile);
		book = WorkbookFactory.create(file);
		sh = book.getSheet(sheet);
		row = sh.getRow(rownum);
		cell = row.getCell(cellnum);
		String data = cell.getStringCellValue();

		return data;
	}

	public int getCellCount(String xlfile, String sheet, int rownum)
			throws EncryptedDocumentException, IOException {

		file = new FileInputStream(xlfile);
		book = WorkbookFactory.create(file);
		sh = book.getSheet(sheet);
		row = sh.getRow(rownum);
		int cell = row.getLastCellNum();

		return cell;
	}

	public int getRowCount(String xlfile, String sheet)
			throws EncryptedDocumentException, IOException {

		file = new FileInputStream(xlfile);
		book = WorkbookFactory.create(file);
		sh = book.getSheet(sheet);
		int row = sh.getLastRowNum();

		return row;
	}

}
