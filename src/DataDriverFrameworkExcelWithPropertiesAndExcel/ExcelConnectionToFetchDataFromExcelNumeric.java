package DataDriverFrameworkExcelWithPropertiesAndExcel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelConnectionToFetchDataFromExcelNumeric {

	public static void main(String[] args) throws Exception {
		FileInputStream fi=new FileInputStream("V:\\SeleniumExcel\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fi);
		Sheet sh=book.getSheet("Sheet1");
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(sh.getRow(5).getCell(4)); //optimized way
		System.out.println(data);
		

	}

}
 