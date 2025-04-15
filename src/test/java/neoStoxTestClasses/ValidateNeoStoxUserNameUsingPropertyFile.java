package neoStoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase.Base;
import neoStoxPOMClasses.NeoStoxDashBoardPage;
import neoStoxPOMClasses.NeoStoxHomePage;
import neoStoxPOMClasses.NeoStoxPasswordPage;
import neoStoxPOMClasses.NeoStoxSignInPage;
import neoStoxBase.Utility;


@Listeners(neoStoxTestClasses.Listener.class)

public class ValidateNeoStoxUserNameUsingPropertyFile extends Base{
	
	NeoStoxHomePage home;
	NeoStoxSignInPage sigIn;
	NeoStoxPasswordPage pass;
	NeoStoxDashBoardPage dash;
	
	@BeforeClass
	public void launchNeoStox() throws IOException
	{
		launtchBrowser();
		home = new NeoStoxHomePage(driver);
		sigIn = new NeoStoxSignInPage(driver);
		pass = new NeoStoxPasswordPage(driver);
		dash = new NeoStoxDashBoardPage(driver);
	}
	@BeforeMethod
	public void signInNeoStox() throws EncryptedDocumentException, IOException
	{
		home.clickOnSignInButton();
		neoStoxBase.Utility.impliciteWait(1000, driver);
		sigIn.EnterMobileNo(neoStoxBase.Utility.readDataFromProoertyFile("mobile"));
		sigIn.clickOnSubmitButton();
		
		neoStoxBase.Utility.impliciteWait(1000, driver);
		pass.enterPassword(neoStoxBase.Utility.readDataFromProoertyFile("password"));
		pass.ClickonpassSubmitButton();
		neoStoxBase.Utility.impliciteWait(1000, driver);
		dash.handalPopUp(driver);
		 
	}
  @Test
  public void validateNeostoxUserName() throws EncryptedDocumentException, IOException 
  {
	  Assert.assertEquals(dash.getactualUserName(), Utility.readDataFromProoertyFile("userName") ,"actual and expected userName not matching, TC is Failed");
	  neoStoxBase.Utility.takescreenShot(driver, Utility.readDataFromProoertyFile("TCID"));
	  
  }
  @Test
  public void validateAcBalance()
  {
	  Assert.assertNotNull(dash.getAcBalance(), "AC balance is null, TC is failed");
  }
  @AfterMethod
  public void logOutFromNeoStox() throws InterruptedException
  {
  	dash.logOutFromNeoStox();
  	Thread.sleep(100);
  }
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		Reporter.log("Closing Browser", true);
	}

}
