package neoStoxBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility 
{
	public static String readDataFromProoertyFile(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream myFile = new FileInputStream("D:\\eclipse-workspace\\neoStox_MVN\\myProperty.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("Reading data from property file", true);
		Reporter.log("data is--> "+value, true);
		return value;
		
	}
	
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myFile = new File("D:\\\\eclipse-workspace\\\\NeoStock.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading data from excel row is->"+row+" cell is->"+cell, true);
		Reporter.log("data is--> "+value, true);
		return value;
		
	}
	
	public static void impliciteWait(int time, WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("watting for "+time+"ms", true);
	}
	
	public static void takescreenShot(WebDriver driver, String name) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String random = RandomString.make(3);
		File dest = new File("D:\\eclipse-workspace\\Screenshot\\"+name+random+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshort", true);
		Reporter.log("screenShort taken and saved at--> "+dest, true);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scroll into View to "+element, true);
	}
	
}
