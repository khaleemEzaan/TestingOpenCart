package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginClass;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"sanity","Master"})
	public void verify_Login() {
		logger.info("*********Test Started*********");
		
		try 
		{
		HomePage hp= new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickonLogin();
		
		LoginClass lc= new LoginClass(driver);
		lc.setEmail(p.getProperty("email"));
		lc.setpassword(p.getProperty("password"));
		lc.Clicklogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
	boolean target	=macc.isMyAccountExist();
		Assert.assertEquals(target, true);
		logger.info("*********Test Completed *********");
		}
		catch(Exception e) {
			Assert.fail();
		}
	}

}
