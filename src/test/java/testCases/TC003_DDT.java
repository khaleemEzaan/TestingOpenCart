package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginClass;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DDT extends BaseClass {
	WebDriver driver;
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email,String pwd, String exp){
		logger.info("******Test DDT TC-003 STARTED*  *******");
		try {
		HomePage hp= new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickonLogin();
		
		LoginClass lc= new LoginClass(driver);
		lc.setEmail(email);
		lc.setpassword(pwd);
		lc.Clicklogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
	boolean target=macc.isMyAccountExist();
		// Data is Valid -Login Success -test pass -Logout
						//Login Fail--test fail
	//Data is Invalid -Login Success -test fail Logout
						//Login failed test pass
	if(exp.equalsIgnoreCase("Valid")) {
		
		if(target==true) {
			macc.logoutclick();
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	if (exp.equalsIgnoreCase("Invalid")) {
		
		if(target==true) {
			macc.logoutclick();
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
		}
	}
	}
		catch(Exception e) {
			Assert.fail();
			
		}
	logger.info("******Test DDT TC-003 Finsihed********");
		}
		}

