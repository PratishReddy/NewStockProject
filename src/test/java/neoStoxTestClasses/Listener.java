package neoStoxTestClasses;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase.Base;
import neoStoxBase.Utility;



public class Listener extends Base implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			Utility.takescreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		try {
			Utility.takescreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC"+result.getName()+"Passed", true);
	}
	
}
