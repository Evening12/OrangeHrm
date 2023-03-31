package testutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchData {
	
	public static String fromExelSheet(int row , int cell) throws EncryptedDocumentException, IOException
	{
		String data="";
		
		String path="src"+ File.separator+"test"+File.separator+"resources"+File.separator+"testData"+File.separator+"sheet1.xlsx";
		FileInputStream file=new FileInputStream(path);
		
		Sheet s = WorkbookFactory.create(file).getSheet("Sheet1");
		Cell c=s.getRow(row).getCell(cell);
		CellType type=c.getCellType();
		if(type==CellType.STRING) {
			data=c.getStringCellValue();
		}else if(type==CellType.NUMERIC) {
			
			double d=c.getNumericCellValue();
			data=String.valueOf(d);
		}else if(type==CellType.BLANK) {
			data=c.getStringCellValue();
		}
		return data;
		
	}	

}
