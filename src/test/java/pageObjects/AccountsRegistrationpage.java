package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsRegistrationpage extends BasePage  {
	
	public AccountsRegistrationpage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txttelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfrmpassword;
	@FindBy(xpath="//input[@value='0']") WebElement txtnewsletter;
	@FindBy(xpath="//input[@value='Continue']") WebElement txt_buttonContinue;
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setlastName(String Lname) {
		txtLastName.sendKeys(Lname);
	}
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void setTelephone(String tel) {
		txttelephone.sendKeys(tel);
	}
	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void setConfirrmpassword(String pwd1) {
		txtConfrmpassword.sendKeys(pwd1);
	}
	public void setnewsLetter() {
		txtnewsletter.click();
		
	}
	
	public void setContinueClickbtn() {
		txt_buttonContinue.click();
	}
	
	
	
}
