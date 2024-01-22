package DataDriverFrameworkWithPropertiesAndExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmLogin {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("V:\\SeleniumOrangeHrmLoginCredentials\\OrangeHrmLogin.Properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
