package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountPage;
import pageObject.frontPage;
import pageObject.logInPage;
import testBase.testBaseClass;

public class TC002_LogInTest extends testBaseClass {
	
	@Test
	public void logintest() {
		
		logger.info("*******TC002_LoginTest Started for execution");
		
		frontPage fp=new frontPage(driver);
		fp.clkMyAccount();
		logger.info("clicked on myaccount");
		fp.clkLogin();
		logger.info("clicked on login");

		logInPage lip=new logInPage(driver);
		lip.userName(properties.getProperty("email"));
		logger.info("entered valid email id");

		lip.Passwords(properties.getProperty("password"));
		logger.info("entered valid password");

		lip.buttonSubmit();
		logger.info("clicked on loginsubmit button");

		
		AccountPage ap=new AccountPage(driver);
		boolean myaccountexist=ap.AccountMy();
		
		Assert.assertEquals(myaccountexist, true,"testcasefailed");
		
		
		
		logger.info("****TC002_LoginTest finished");

		
		
		
	}

}
