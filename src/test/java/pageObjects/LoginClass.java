package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginClass extends BasePage  {

	public LoginClass(WebDriver driver) {
		super(driver);
	}
		//
		
		//input[@id='input-email']
		
		
		
		@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
		@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
		@FindBy(xpath="//input[@value='Login']") WebElement btnlogin;
		
		
		public void setEmail(String email) {
			txtEmail.sendKeys(email);
			
		}
		public void setpassword(String pwd) {
			txtpassword.sendKeys(pwd);
		}
		public void Clicklogin() {
			btnlogin.click(); 
		}

}
