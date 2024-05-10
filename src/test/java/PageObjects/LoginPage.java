package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//3 parts(constructor,identify the elements, create actions)
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//identify the elements
	
	@FindBy(id="username")
	WebElement txtusername;
	
	@FindBy(id="password")
	WebElement txtpassword;
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	//create the corresponding actions
	
	public void setUsername(String uname) {
		
		txtusername.sendKeys(uname);
	}
	
	public void setPassword(String pword) {
		txtpassword.sendKeys(pword);
	}
	
	public void clickLoginbtn() {
		btnLogin.click();
	}
	

}
