package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.io.FileInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		Random ran=new Random();
		int data = ran.nextInt(1000);
		FileInputStream fis=new FileInputStream("./src/test/resources/Dataprovider.xlsx");
		 Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		int lastrow = sh.getLastRowNum()+1;
		 int lastcol = sh.getRow(0).getLastCellNum();
		 DataFormatter format=new DataFormatter();
		
		 Object[][] obj=new Object[lastrow][lastcol];
		 for(int i=0;i<lastrow;i++)
		 {
			 for(int j=0;j<lastcol;j++)
			 {
				 
				 obj[i][j]=format.formatCellValue(book.getSheet(sheetName).getRow(i).getCell(j))+data;
			 }
		 }
		return obj;
		 
		 
		 
	}
	public String getDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable, IOException
	{
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Dataprovider.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		DataFormatter format = new DataFormatter();
		String value1 = format.formatCellValue(book.getSheet("organization").getRow(rowNum).getCell(cellNum));
		
		return value1;
		
		
	}
}

