package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base {
	protected static WebDriver driver;
	
	public void launtchBrowser() throws IOException 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utility.readDataFromProoertyFile("url"));
		Reporter.log("Launching NeostoxApp", true);
		
		Utility.impliciteWait(100, driver);
		
		//Comment 1

	}

}
