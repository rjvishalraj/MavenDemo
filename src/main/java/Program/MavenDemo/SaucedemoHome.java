package Program.MavenDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoHome {

	@FindBy (xpath ="//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement Addtocart;

	@FindBy (xpath ="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement Addtocart2;
	
	@FindBy (xpath ="//a[@class='shopping_cart_link']")
	private WebElement cart;
	
	@FindBy (xpath ="//button[@id='remove-sauce-labs-fleece-jacket']")
	private WebElement removecart;
	
	@FindBy (xpath ="//button[@id='checkout']")
	private WebElement checkout;
	
	public SaucedemoHome(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Addtocart()
	{
		Addtocart.click();
	}
	
	public void Addtocart2()
	{
		Addtocart2.click();
	}
	
	public void cart()
	{
		cart.click();
	}
	public void removecart()
	{
		removecart.click();
	}
	public void checkout()
	{
		checkout.click();
	}
}
