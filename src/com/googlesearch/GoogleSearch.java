package com.googlesearch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class GoogleSearch {
	
	public void interview(){
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.)
	}

	public List<String> readSearchText(){
		List<String> arrSearchText = new ArrayList<>();
		int lastRowNum = 0;
		try {

			FileInputStream testDataFile = new FileInputStream(new File(System.getProperty("user.dir") 
					+ File.separator + "TestData"+
					File.separator + "SearchData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(testDataFile);
			XSSFSheet worksheet = null;
						
			
			int noofsheets = workbook.getNumberOfSheets();

			
			
//			System.out.println(noofsheets);
			
			
			
//			XSSFSheet worksheet = workbook.getSheet("SearchData");
////			for(int i=0;i<noofsheets;i++){
//				worksheet = workbook.getSheetAt(1);
//				Row row = worksheet.getRow(0);
//				System.out.println("Row: " + row);
//				System.out.println("last row num: " + worksheet.getLastRowNum());
//				System.out.println("physical numbe of rows: " + worksheet.getPhysicalNumberOfRows());
//				System.out.println(worksheet.getFirstRowNum());
//				short cellnum = row.getFirstCellNum();
//				System.out.println("first cell num: " + cellnum);
//				System.out.println("last cell num: " + (row.getLastCellNum()-1));
//			/*	System.out.println(row.getPhysicalNumberOfCells());
//				System.out.println(row.getLastCellNum());
//				*/
//				
////			}
			
		
//			
//			
//			lastRowNum = worksheet.getLastRowNum(); 
//			System.out.println("lastrownumber" + lastRowNum);
			
	/*		for(int i=0;i<=lastRowNum;i++){
				Row row = worksheet.getRow(i);
				Cell cell = row.getCell(0);
				if(cell.getCellType() == Cell.CELL_TYPE_STRING){
					arrSearchText.add(cell.getStringCellValue());
				}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					arrSearchText.add(String.valueOf(cell.getNumericCellValue()));
				}
			}*/

		} catch (FileNotFoundException e) {
			System.out.println("Data file is not found: " + e.getLocalizedMessage());

		} catch (IOException e) {
			System.out.println("IO exception: " + e.getLocalizedMessage());
		}
		return arrSearchText;
	}


	public void enterGoogleSearchText(List<String> arrSearchText){
		WebDriver driver = null;
		SoftAssert sa = new SoftAssert();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") 
				+ File.separator + "drivers" + 
				File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(String text : arrSearchText){
			WebElement textbox = driver.findElement(By.name("q"));
			textbox.clear();
			textbox.sendKeys(text);
			textbox.sendKeys(Keys.ENTER);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			sa.assertTrue(driver.getTitle().contains(text), "Google Search not performed for text: " + text);

		}
		sa.assertAll();

		driver.quit();

	}

	public static void main(String[] args) {
		GoogleSearch search = new GoogleSearch();
		List<String> texts = search.readSearchText();
		System.out.println(texts);
		/*	for(int i=0; i<texts.size(); i++){
			System.out.println(texts.get(i));
		}*/
//		search.enterGoogleSearchText(texts);

	}

}
