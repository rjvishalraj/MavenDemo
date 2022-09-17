package Program.MavenDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaucedemoTestNG {
	public ChromeDriver driver;
	@BeforeClass
	public void Browser() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void Website() 
	{
		
	}
	@Test(priority=1)
	public void Saucedemologin() throws InterruptedException, IOException  
	{
		Saucedemologin login = new Saucedemologin(driver);
		login.username();
		login.password();
		login.lbutton();
		Thread.sleep(2000);
		Screenshot.TakeSceenshots(driver);
	}
	@Test(priority=2, dependsOnMethods="Saucedemologin")
	public void SaucedemoHome() throws InterruptedException, IOException	
	{
		SaucedemoHome addcart =new SaucedemoHome(driver);
		addcart.Addtocart();
		addcart.Addtocart2();
		addcart.cart();
		addcart.removecart();
		addcart.checkout();
		Thread.sleep(2000);
		Screenshot.TakeSceenshots(driver);
	}
	@Test(priority=3, dependsOnMethods="SaucedemoHome")
	public void SaucedemoCheckout() throws InterruptedException, IOException	
	{
		SaucedemoCheckout checkout =new SaucedemoCheckout(driver);
		checkout.firstname();
		checkout.lastname();
		checkout.zipcode();
		checkout.bcontinue();
		checkout.bFinish();
		Thread.sleep(2000);
		Screenshot.TakeSceenshots(driver);

	}
	@AfterMethod
	public void Screenshot() throws InterruptedException, IOException 
	{
		//Screenshot.TakeSceenshots(driver);
	}
	@AfterClass
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
