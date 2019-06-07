package com.ls.generics;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	static String filePath = UtilityConstants.EXCEL_PATH;

	public static void writeExcelSheet(String sheetName, int rowNum, int cellNum, String inputData)
			throws InvalidFormatException, IOException {

		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum, Row.CREATE_NULL_AS_BLANK);
		cell.setCellValue(inputData);
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
	}

	public static String readExcelSheet(String sheetName, int rowNum, int cellNum)
			throws InvalidFormatException, IOException {
		FileInputStream fis;
		fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String cellValue = cell.getStringCellValue();

		return cellValue;
	}
}
//}
