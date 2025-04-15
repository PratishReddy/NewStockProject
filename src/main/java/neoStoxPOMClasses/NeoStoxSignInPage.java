package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxSignInPage 
{
	
	@FindBy(id = "txt_mobilenumber") private WebElement mobileNoField;
	@FindBy(id = "frmsubmit") private WebElement submitButton;
		
		
	public NeoStoxSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		
	public void EnterMobileNo(String mobileNo) 
	{
		mobileNoField.sendKeys(mobileNo);
		Reporter.log("entering mobile No", true);
	}
	public void clickOnSubmitButton() 
	{
		submitButton.click();
		Reporter.log("clicking on submit button", true);
	}
	

}
