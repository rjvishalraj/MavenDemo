package Program.MavenDemo;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
	public ChromeDriver driver;
	@BeforeClass
	public void Browser() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void Website() 
	{
		driver.get("https://www.saucedemo.com/");
	}
	@Test(priority=1)
	public void LoginA() throws InterruptedException, IOException  
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath(("(//input[@class=\"input_error form_input\"])[2]"))).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Class\\New folder\\take1.jpg");
		FileUtils.copyFile(src, des);
	}
	@Test(enabled=false, priority=2)
	public void LoginB() throws InterruptedException, IOException	
	{
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath(("(//input[@class=\"input_error form_input\"])[2]"))).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Class\\New folder\\take2.jpg");
		FileUtils.copyFile(src, des);
		//Assert.fail();
	}
	@Test(priority=3)
	public void LoginC() throws InterruptedException, IOException	
	{
		driver.findElement(By.id("user-name")).sendKeys("problem_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath(("(//input[@class=\"input_error form_input\"])[2]"))).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Class\\New folder\\take3.jpg");
		FileUtils.copyFile(src, des);
	}
	@Test(priority=4)
	public void LoginD() throws InterruptedException, IOException	
	{
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath(("(//input[@class=\"input_error form_input\"])[2]"))).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Class\\New folder\\take4.jpg");
		FileUtils.copyFile(src, des);
	}
	@AfterMethod
	public void Logout() throws InterruptedException, IOException 
	{
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[1].click();", null,driver.findElement(By.xpath("//a[text()='Logout']")));
		Thread.sleep(2000);
	}
	@AfterClass
	public void Close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
