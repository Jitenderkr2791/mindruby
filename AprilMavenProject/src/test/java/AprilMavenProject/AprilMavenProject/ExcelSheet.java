package AprilMavenProject.AprilMavenProject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class ExcelSheet
{
	WebDriver driver;
@BeforeMethod
public void startDriver()
{
	 driver=Driver.getDriver("chrome");
}

@Test(priority = 1 , description = "read data from excel sheet")
public void readDataFromExcel() throws Throwable
{
	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Testddata\\Book1.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(file);
	XSSFSheet Sheet = workBook.getSheet("Sheet1");       //XSSFSheet Sheet = workBook.getSheetAt(1);
	
	int totalRows = Sheet.getLastRowNum();
	
	int totalcells = Sheet.getRow(1).getLastCellNum();
	
	System.out.println(totalRows);
	System.out.println(totalcells);	
	
		for(int r=0;r<=totalRows;r++)
		{	
			XSSFRow CurrentRow = Sheet.getRow(r);
			{
			
			  for(int c=0;c<totalcells;c++)
			  	{ 
				  XSSFCell cell =CurrentRow.getCell(c);
			  
			  	  System.out.print(cell.toString()+"\t"); 
			  	}
			 
			System.out.println();
			}
		workBook.close();
		}
}

//@Test(priority = 2,description = "write data into the excel sheet")
public void writeIntoExcelsheet() throws Throwable

{	FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Testddata\\myfile.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("datasheet");

	XSSFRow row = sheet.createRow(0);
	row.createCell(0).setCellValue("welcome");
	row.createCell(1).setCellValue("to");
	row.createCell(2).setCellValue("java");
	row.createCell(3).setCellValue("automation");
	
	XSSFRow row1 = sheet.createRow(1);
	row1.createCell(0).setCellValue("MY");
	row1.createCell(1).setCellValue("NAME");
	row1.createCell(2).setCellValue("JITENDER");
	row1.createCell(3).setCellValue("KUMAR");
	
	XSSFRow row2 = sheet.createRow(2);
	row2.createCell(0).setCellValue("MY");
	row2.createCell(1).setCellValue("Phone.No.");
	row2.createCell(2).setCellValue("+91");
	row2.createCell(3).setCellValue("9871922723");
	
	workbook.write(file);
	workbook.close();
	file.close();
}
	
@Test(priority = 3,description = "userdefined data writing into the excel sheet")
public void userInputDataWriteIntoExcelsheetfromUserInput() throws Throwable
{	
	FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Testddata\\dynamic.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("dynamicdatasheet");

	Scanner sc = new Scanner(System.in);
	System.out.println("enter no. of rows");
	int noofrows = sc.nextInt();

	System.out.println("enter no. of columns");
	int noofcolumns = sc.nextInt();

	for(int r=0;r<=noofrows;r++)
	{
		XSSFRow currentrow = sheet.createRow(r);
			for(int c=0;c<noofcolumns;c++)
			{
				XSSFCell cell = currentrow.createCell(c);
				cell.setCellValue(sc.next());
			}
	}
	
	workbook.write(file);
	workbook.close();
	file.close();
	sc.close();
}

@Test(priority = 4,description = "write data into the excel sheet")
public void RandomdataIntoExcelsheet() throws Throwable
{	
	FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Testddata\\randomDataEntered.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("datasheet");

	XSSFRow row = sheet.createRow(0);
	row.createCell(1).setCellValue("to");
	row.createCell(3).setCellValue("automation");
	
	XSSFRow row1 = sheet.createRow(1);
	row1.createCell(0).setCellValue("MY");
	row1.createCell(2).setCellValue("JITENDER");
	
	XSSFRow row2 = sheet.createRow(2);
	row2.createCell(1).setCellValue("Phone.No.");
	row2.createCell(2).setCellValue("+91");
	
	workbook.write(file);
	workbook.close();
	file.close();
}
@AfterMethod 
public void closedriver()
{
	Driver.quitDriver();
	}

}