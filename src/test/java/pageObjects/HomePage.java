package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	

public HomePage(WebDriver driver) {
	
	super(driver);
	}
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement lnkMyAccount;
 @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
 WebElement lnkRegister;
 
 
 @FindBy(linkText="Login")
 WebElement lnkLogin;
 
 public void ClickMyAccount() {
	 lnkMyAccount.click();
 }
 
 public void clickOnRegister() {
	 lnkRegister.click();
 }
public void ClickonLogin() {
	lnkLogin.click();
}




}
