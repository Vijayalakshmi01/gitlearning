package com.googlesearch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Project\\Students.xlsx");
		FileInputStream testFile = new FileInputStream(file);
	
		XSSFWorkbook workbookObj = new XSSFWorkbook(testFile);
		XSSFSheet worksheetObj = workbookObj.getSheet("StudentList");
		
		int noOfRows = worksheetObj.getLastRowNum();
		
		for(int i=0; i<=noOfRows; i++){
			Row row = worksheetObj.getRow(i);
			int noOfCells = row.getLastCellNum();
			for(int j=0; j<noOfCells; j++){
				Cell cell = row.getCell(j);
				if(cell.getCellType() == Cell.CELL_TYPE_STRING){
					System.out.println(cell.getStringCellValue());
				} else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					System.out.println(cell.getNumericCellValue());
				} 
			}
			
		}
		
		
	}

}
