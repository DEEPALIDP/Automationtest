package com.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Read  {
	 public String path;
	 public FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	 public  Xls_Read(String path) {
		
			this.path = path;
			try {
				  fis = new FileInputStream(path);
				  workbook = new XSSFWorkbook(fis);			
				fis.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	

	public String getCellData(String sheetName,int rowNumber, int cellNumber) {
		try {
			
			XSSFSheet sheet =workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNumber);
			Cell cell=row.getCell(cellNumber);
			String cellValue=cell.getStringCellValue();
			return cellValue;
	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return "";
		}
	}

	

}
