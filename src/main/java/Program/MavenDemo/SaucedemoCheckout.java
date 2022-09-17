package Program.MavenDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoCheckout {

	@FindBy (xpath ="//input[@id='first-name']")
	private WebElement firstname;

	@FindBy (xpath ="//input[@id='last-name']")
	private WebElement lastname;
	
	@FindBy (xpath ="//input[@id='postal-code']")
	private WebElement zipcode;
	
	@FindBy (xpath ="//input[@id='continue']")
	private WebElement bcontinue;
	
	@FindBy (xpath ="//button[@id='finish']")
	private WebElement bFinish;
	
	public SaucedemoCheckout(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void firstname()
	{
		firstname.sendKeys("vishal");
	}
	
	public void lastname()
	{
		lastname.sendKeys("kumbhar");
	}
	
	public void zipcode()
	{
		zipcode.sendKeys("416112");
	}
	public void bcontinue()
	{
		bcontinue.click();
	}
	public void bFinish()
	{
		bFinish.click();
	}
}
