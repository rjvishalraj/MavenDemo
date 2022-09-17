package Program.MavenDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {

	
public WebDriver driver;
	
	@BeforeSuite
	public void launchBrowser()  {
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver(); 
		

	}
	
	@BeforeTest
	public void basicsetUp() {
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	}
	
	@BeforeClass
	public void launchApp() { 
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	@BeforeMethod
	public void login() {
		driver.findElement(By.partialLinkText("Create New")).click();
	}
	
	@Test
	public void verifyUserProfile() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		FileInputStream ffile=new FileInputStream("E:\\Class\\java\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(ffile);
		Sheet sh = wb.getSheet("Sheet1");
		for(int i=1; i<=4; i++)
		{
			String firstname = sh.getRow(i).getCell(0).getStringCellValue();
			driver.findElement(By.name("firstname")).sendKeys(firstname);
		}
	
		
		
		
		
		/*String lastname = sh.getRow(1).getCell(1).getStringCellValue();
		int mnumber = (int) sh.getRow(1).getCell(2).getNumericCellValue();
		String password = sh.getRow(1).getCell(3).getStringCellValue();
		int date =(int) sh.getRow(1).getCell(4).getNumericCellValue();
		String month = sh.getRow(1).getCell(5).getStringCellValue();
		int year=(int) sh.getRow(1).getCell(6).getNumericCellValue();

		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);		
		driver.findElement(By.name("reg_email__")).sendKeys(Integer.toString(mnumber));
		driver.findElement(By.name("reg_passwd__")).sendKeys(password);
		Select d=new Select(driver.findElement(By.id("day")));
		d.selectByVisibleText(Integer.toString(date));
		
		Select m=new Select(driver.findElement(By.id("month")));
		m.selectByVisibleText(month);
		
		Select y=new Select(driver.findElement(By.id("year")));
		y.selectByVisibleText(Integer.toString(year));
		Thread.sleep(1000);
		//WebElement Gender = driver.findElement(By.xpath("//span[1]/input[@name='sex']"));	// For Female
		WebElement Gender = driver.findElement(By.xpath("//span[2]/input[@name='sex']"));	// For Male
		Gender.click();*/
	}
	
	@AfterMethod
	public void logout() {
		//System.out.println("Logout from facebook");
		
	}
	
	@AfterClass
	public void generateReport(){
		//System.out.println("log test execution/generate test report");
	}
	
	@AfterTest
	public void closeDriverInstance() throws InterruptedException{
		//driver.close();
	}
		
	@AfterSuite
	public void cleanUp() {
		//System.out.println("Perform clean up activity");
	}

}
