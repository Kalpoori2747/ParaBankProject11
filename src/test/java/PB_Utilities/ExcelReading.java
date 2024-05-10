package PB_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	
	public static FileInputStream fis;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	//it is get the row count from the excel sheet
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		 fis=new FileInputStream(xlfile);
		 //excel sheet(file)==>wb==>sheets==>rows==>cells
		 wb=new XSSFWorkbook(fis);
		 ws=wb.getSheet(xlsheet);
		 int rowCount=ws.getLastRowNum();
		 wb.close();
		 fis.close();
		 return rowCount;
	}
	
	//get the cell count from the excel sheet
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException {
		
		 fis=new FileInputStream(xlfile);
		 //excel sheet(file)==>wb==>sheets==>rows==>cells
		 wb=new XSSFWorkbook(fis);
		 ws=wb.getSheet(xlsheet);
		 row=ws.getRow(rownum);
		 int cellcount=row.getLastCellNum();
		 wb.close();
		 fis.close();
		 return cellcount;
		 
	}
	
	//get the cell data from the excel sheet
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException {
		 fis=new FileInputStream(xlfile);
		 //excel sheet(file)==>wb==>sheets==>rows==>cells
		 wb=new XSSFWorkbook(fis);
		 ws=wb.getSheet(xlsheet);
		 row=ws.getRow(rownum);
		 cell=row.getCell(cellnum);
		 
		 String data;
		 try {
			 
			 DataFormatter formatter=new DataFormatter();
			 
			 String celldata=formatter.formatCellValue(cell);
			 return celldata;
		 }catch(Exception e) {
			 data="";
		 }
		 wb.close();
		 fis.close();
		 return data;
		
	
	}
	
	//set the data into the excel sheet 
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int cellnum,String data) throws IOException {
		
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		
		fo=new FileOutputStream(xlfile); // ==> //write
		
		wb.write(fo);
		wb.close();
		fis.close();
		fo.close();
		
	}

}
