package Program.MavenDemo;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucedemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		Saucedemologin login = new Saucedemologin(driver);
		
		login.username();
		login.password();
		login.lbutton();
		
		SaucedemoHome addcart =new SaucedemoHome(driver);
		
		addcart.Addtocart();
		addcart.Addtocart2();
		addcart.cart();
		addcart.removecart();
		addcart.checkout();
		
		SaucedemoCheckout checkout =new SaucedemoCheckout(driver);
		
		checkout.firstname();
		checkout.lastname();
		checkout.zipcode();
		checkout.bcontinue();
		checkout.bFinish();
		Thread.sleep(5000);
		driver.close();
	}

}
