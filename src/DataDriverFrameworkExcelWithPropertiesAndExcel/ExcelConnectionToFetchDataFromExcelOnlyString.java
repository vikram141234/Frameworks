package DataDriverFrameworkExcelWithPropertiesAndExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelConnectionToFetchDataFromExcelOnlyString {

	public static void main(String[] args) throws Exception {
		FileInputStream fi=new FileInputStream("V:\\SeleniumExcel\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fi);
		Sheet s=book.getSheet("Sheet1");
		
		String data=s.getRow(2).getCell(2).getStringCellValue(); //optimized way
		System.out.println(data);
/*		
		Row r=s.getRow(2);
		Cell c=r.getCell(2);                                     // normal way
		String value=c.getStringCellValue();
		System.out.println(value);
*/


	}

}
