package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutills 
{
    public static FileInputStream fi;
    public static Workbook wb;
    public static Sheet ws;
    public static  Row row;
    public static Cell cell;
    public static CellStyle style;
    public static FileOutputStream fo;
	
	public static int getrowcount(String xlfile, String xlsheet) throws IOException
	{
		 fi= new FileInputStream(xlfile);
		 wb=new XSSFWorkbook(fi);
		 ws=wb.getSheet(xlsheet);
		  int rowcount=ws.getLastRowNum();
		  wb.close();
		  fi.close();
		  return rowcount;	
	}
	
	public static Short getcolmncount(String xlfile, String sheet, int row) throws IOException
	{
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		Row rowcunt=ws.getRow(row);
		Short colcount=rowcunt.getLastCellNum();
		wb.close();
		fi.close();
		return colcount;
		}
	public static String getstringcelldata(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		String data;
		try
		{
			cell=row.getCell(colnum);
			data=cell.getStringCellValue();
		} catch (Exception e) 
		{
			data="";	
		}
		wb.close();
		fi.close();
		return data;	
	}
	
	public static double getnumericcelldata(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		
		
		double data;
		try 
		{
			cell=row.getCell(colnum);
			data=cell.getNumericCellValue();
		} catch (Exception e) 
		{
		  data= 0.0;
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static boolean getbooleancelldata(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		
		boolean data5;
		try 
		{
			cell=row.getCell(colnum);
		    data5 =cell.getBooleanCellValue();
			
		} catch (Exception e)
		{

		data5= false;			
		}
		wb.close();
		return data5;
	}
	
	public static void setcelldata(String xlfile, String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell= row.createCell(colnum);
        cell.setCellValue(data);
        FileOutputStream fo=new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
	}
	
	public static void fillgreencolor(String xlfile, String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
       row= ws.getRow(rownum);
        cell=row.getCell(colnum);
        
       style=wb.createCellStyle();
       style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);
       style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
       cell.setCellStyle(style);
       
       fo=new FileOutputStream(xlfile);
       wb.write(fo);
       wb.close();
       fi.close();   
	}
	
	public static void fillredcolor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		
		
	}
}
