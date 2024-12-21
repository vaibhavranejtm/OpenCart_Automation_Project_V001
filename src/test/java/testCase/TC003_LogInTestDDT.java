package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountPage;
import pageObject.frontPage;
import pageObject.logInPage;
import testBase.testBaseClass;
import utilities.DataProviders;

public class TC003_LogInTestDDT extends testBaseClass {
	
	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")
	public void LoginTestDDT(String email, String pwd, String exp) {
		
	logger.info(" ");
	logger.info("*******TC002_LoginTest Started for execution");
	
	frontPage fp=new frontPage(driver);
	fp.clkMyAccount();
	logger.info("clicked on myaccount");
	fp.clkLogin();
	logger.info("clicked on login");

	logInPage lip=new logInPage(driver);
	lip.userName(email);
	logger.info("entered valid email id");

	lip.Passwords(pwd);
	logger.info("entered valid password");

	lip.buttonSubmit();
	logger.info("clicked on loginsubmit button");

	
	AccountPage macc=new AccountPage(driver);
	boolean targetPage=macc.AccountMy();
	
	//Assert.assertEquals(myaccountexist, true,"testcasefailed");
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage==true)
		{			
			macc.buttonLogout();;
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			macc.buttonLogout();;
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	
	
}
}
