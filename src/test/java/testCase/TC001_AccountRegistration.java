package testCase;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.frontPage;
import pageObject.registrationPage;
import testBase.testBaseClass;

public class TC001_AccountRegistration extends testBaseClass {
	
	
	
	@Test
	public void accountRegistration() {
		
		try {
		logger.info("**** TC001 Account Registration****");
		
		logger.info("Execution Started");
		frontPage fp=new frontPage(driver);
		fp.clkMyAccount();
		logger.info("Clicked on MyAccount");
		fp.clkRegister();
		logger.info("Clicked on Register");

		
		registrationPage rp=new registrationPage(driver);
		logger.info("Customer details page opend");


		rp.txtFirstName(randomAlphabetics());
		rp.txtLastName(randomAlphabetics());
		rp.txtEmail(randomAlphabetics()+"@gmail.com");
		rp.telephones(randomNumerics());
		String pwd= RandomAlphaNumeric();
		rp.txtPassword(pwd);
		rp.txtConfirmPassword(pwd);
		rp.chkNewsletter();
		rp.chkPolicy();
		
		logger.info("all details has been filled");
		
		rp.btnSubmit();
		
	if(rp.confirmsg().equalsIgnoreCase("Your Account Has Been Created!")) {
		Assert.assertTrue(true);
	}
	else {
		logger.error("Test case failed");
		logger.debug("failed");
		Assert.assertTrue(false);
	}
		}
		catch (Exception e) {
			Assert.fail();
		}

		
	}
	
	

}
