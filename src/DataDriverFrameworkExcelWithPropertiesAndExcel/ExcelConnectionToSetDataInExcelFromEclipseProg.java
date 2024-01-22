package DataDriverFrameworkExcelWithPropertiesAndExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelConnectionToSetDataInExcelFromEclipseProg {

	public static void main(String[] args) throws Exception {
		FileInputStream fi=new FileInputStream("V:\\SeleniumExcel\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fi);
		Sheet sh=book.getSheet("Sheet1");
		DataFormatter df=new DataFormatter();
		sh.createRow(8).createCell(9).setCellValue("123457");
		FileOutputStream fos=new FileOutputStream("V:\\SeleniumExcel\\Book1.xlsx");
		book.write(fos);
		System.out.println("Inserted");

	}

}
