package neoStoxPOMClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class NeoStoxDashBoardPage 
{
	//1.
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	@FindBy(id = "lbl_username") private WebElement userName;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOut;
	@FindBy(xpath = "//span[@id='lbl_curbalancetop']") private WebElement acBalance;
	
	//2.
	public NeoStoxDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//3.
	public void handalPopUp(WebDriver driver) 
	{
		if (popUpOkButton.isDisplayed()) 
		{
			WebDriverWait w = new WebDriverWait(driver,Duration.ofMillis(40000));
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='OK'])[2]")));
			popUpOkButton.click();
			Reporter.log("handaling popUp", true);
		}
		else 
		{
			Reporter.log("there is no pop-up", true);
		}
		
	}
	
	public String getactualUserName() 
	{
		String actualUeserName = userName.getText();
		Reporter.log("gettting actual userName", true);
		Reporter.log("actual userName is--> "+actualUeserName, true);
		return actualUeserName;
	}
	
	public String getAcBalance() 
	{
		String balance = acBalance.getText();
		Reporter.log("gettting AC Balance", true);
		Reporter.log("Acaount balance is--> "+balance, true);
		return balance;
	}
	
	public void logOutFromNeoStox() 
	{
		userName.click();
		logOut.click();
		Reporter.log("logging out from NeoStox", true);
	}

}
