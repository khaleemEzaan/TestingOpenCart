package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountsRegistrationpage ;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Master","Regression"})
	public void verify_Account_RegPage() {
		try 
		{
		logger.info("***Started TEST Case**********");
		
		HomePage hp= new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("***Clicked on MyAccount**********");
		hp.clickOnRegister();
		logger.info("***Clicked on Register**********");
		AccountsRegistrationpage regPage =new  AccountsRegistrationpage(driver);
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setlastName(randomeString().toUpperCase());
		regPage.setEmail(randomeString()+"@gmail.com");
		regPage.setTelephone("23123131");
		regPage.setpassword("kalee123");
		regPage.setConfirrmpassword("kalee123");
		logger.info("***Passord entered in Confirm password**********");
		regPage.setnewsLetter();
		regPage.setContinueClickbtn();
		logger.info("***Clicked on ContinueButton**********");
		}
		catch(Exception e) {
			logger.error("test Failed");
			logger.debug("Debug Logs");
			Assert.fail();
		}
	
		logger.info("***Finished Test Case**********");
	}
	
	}
