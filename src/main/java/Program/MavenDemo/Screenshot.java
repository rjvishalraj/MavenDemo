package Program.MavenDemo;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


public class Screenshot {
	public static ChromeDriver 
	TakeSceenshots(ChromeDriver driver)throws IOException{

	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path="D:\\ScreenShort"+System.currentTimeMillis()+".jpg";
	File dest= new File(path);
	FileUtils.copyFile(src,dest);
	return driver;
	
	}
}
