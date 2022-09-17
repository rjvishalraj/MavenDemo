package Program.MavenDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemologin {

	@FindBy (xpath ="//input[@id='user-name']")
	private WebElement username;

	@FindBy (xpath ="//input[@id='password']")
	private WebElement password;
	
	@FindBy (xpath ="//input[@id='login-button']")
	private WebElement lbutton;
	
	
	public Saucedemologin(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void username()
	{
		username.sendKeys("standard_user");
	}
	
	public void password()
	{
		password.sendKeys("secret_sauce");
	}
	
	public void lbutton()
	{
		lbutton.click();
	}
}
