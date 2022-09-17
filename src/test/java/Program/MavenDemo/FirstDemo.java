package Program.MavenDemo;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.reactor.Command.Priority;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstDemo {
	
	public ChromeDriver driver;
	
	@BeforeClass
	public void BeforeClassMethod() 
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void BeforeMethodMethod() 
	{
		System.out.println("Before Method");
	}
	@Test(priority=-1)
	public void Test1()
	{
		System.out.println("test1");
	}
	@Test
	public void Test2()
	{
		System.out.println("test2");
		//Assert.fail();
	}
	@Test
	public void Test3()
	{
		System.out.println("test3");
		Assert.fail();
	}
	@Test(dependsOnMethods= {"Test3"})
	public void Test4()
	{
		System.out.println("test4");

	}
	@AfterMethod
	public void AfterMethodMethod() 
	{
		System.out.println("After Method");
	}


	

}
