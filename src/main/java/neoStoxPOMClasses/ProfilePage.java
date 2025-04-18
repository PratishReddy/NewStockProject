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

public class ProfilePage {

	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	
	public ProfilePage(WebDriver driver)
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
}
