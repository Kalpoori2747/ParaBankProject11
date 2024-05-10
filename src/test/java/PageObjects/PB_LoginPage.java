package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_LoginPage {
	
	WebDriver driver;
	public PB_LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement txtusername;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement btnLogin;
	
	
	public void setUsername(String username) {
		txtusername.sendKeys(username);
	}
	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void clickLoginbtn() {
		btnLogin.click();
	}

}
