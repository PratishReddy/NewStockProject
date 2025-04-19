package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPasswordPage 
{
	@FindBy(id = "accessPinModel_accsspin") private WebElement passwordField;
	@FindBy(id = "frmsubmit") private WebElement passSubmitButton;
	
	
	public NeoStoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterPassword(String password) 
	{
		passwordField.sendKeys(password);
		Reporter.log("entering password", true);
	}
	public void ClickonpassSubmitButton() 
	{
		passSubmitButton.click();
		Reporter.log("clicking on password submit button", true);
	}
	
	public void ClickonpassSubmitButton(int a) 
	{
		passSubmitButton.click();
		Reporter.log("clicking on password submit button", true);
	}

}
