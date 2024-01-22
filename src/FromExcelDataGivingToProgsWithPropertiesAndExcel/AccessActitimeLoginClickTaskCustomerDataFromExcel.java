package FromExcelDataGivingToProgsWithPropertiesAndExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.agile.DataIntegrity;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessActitimeLoginClickTaskCustomerDataFromExcel { 

	public String getDataFromProperties(String data) throws Exception {
		FileInputStream fis=new FileInputStream("V:\\SeleniumActitimeLoginCredentials\\ActitimeLogin.Properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String commonData=pobj.getProperty(data);
		return commonData;
	}
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception, IOException {
		FileInputStream fi=new FileInputStream("V:\\SeleniumExcel\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fi);
		Sheet sh=book.getSheet("sheet2");
		DataFormatter df=new DataFormatter();
		String Data=df.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
	
		return Data;
	}
	
	public static void main(String[] args) throws Exception {
		//READING DATA FROM PROPERTIES
		AccessActitimeLoginClickTaskCustomerDataFromExcel util=new AccessActitimeLoginClickTaskCustomerDataFromExcel();
		String URL=util.getDataFromProperties("url");
		String USERNAME=util.getDataFromProperties("username");
		String PASSWORD=util.getDataFromProperties("password");
		//READING DATA FROM EXCEL
		String CUSTOMERNAME=util.getDataFromExcel("Sheet2",1,1);
		String CUSTOMERDESCRIPTION=util.getDataFromExcel("Sheet2",2,2);
		Random r=new Random();
		int random=r.nextInt(1000);
		//LAUNCHING BROWSER
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(CUSTOMERNAME+random);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(CUSTOMERDESCRIPTION);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
}
