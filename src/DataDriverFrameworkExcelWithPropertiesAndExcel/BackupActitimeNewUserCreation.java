package DataDriverFrameworkExcelWithPropertiesAndExcel;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackupActitimeNewUserCreation {


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
		Sheet sh=book.getSheet("sheet1");
		DataFormatter df=new DataFormatter();
		String Data=df.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
	
		return Data;
	}


	public static void main(String[] args) throws Exception {
		//READING DATA FROM PROPERTIES
		BackupActitimeNewUserCreation USING=new BackupActitimeNewUserCreation();
		String URL=USING.getDataFromProperties("url");
		String USERNAME=USING.getDataFromProperties("username");
		String PASSWORD=USING.getDataFromProperties("password");
		//READING DATA FROM EXCEL
		String FIRSTNAME=USING.getDataFromExcel("Sheet1",8,1);
		String LASTNAME=USING.getDataFromExcel("Sheet1",8,2);
		String EMAIL=USING.getDataFromExcel("Sheet1",8, 3);
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.findElement(By.xpath("//div[text()='Users']")).click();
		WebElement parent=driver.findElement(By.xpath("//div[text()='New User']"));
		parent.click();
		WebElement child=driver.findElement(By.xpath("//div[.='Add User']"));
		driver.findElement(By.name("firstName")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastName")).sendKeys(LASTNAME);
	    driver.findElement(By.name("email")).sendKeys(EMAIL);
	    driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
	    driver.findElement(By.xpath("(//span[text()='Close'])[1]")).click();
	    
//	    driver.quit();

	}

}
