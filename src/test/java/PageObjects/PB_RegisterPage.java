package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_RegisterPage {
	
	//pom class   3 parts (//constructor  //identify the element  // create the actions)

	WebDriver driver;
	public PB_RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//identify the  web elements
	
	@FindBy(id="customer.firstName")
	WebElement txtfname;
	
	@FindBy(id="customer.lastName")
	WebElement txtlname;
	
	@FindBy(id="customer.address.street")
	WebElement txtAddress;
	
	@FindBy(id="customer.address.city")
	WebElement txtCity;
	
	@FindBy(id="customer.address.state")
	WebElement txtstate;
	
	@FindBy(id="customer.address.zipCode")
	WebElement txtZipcode;
	
	@FindBy(id="customer.phoneNumber")
	WebElement txtPhone;
	
	@FindBy(id="customer.ssn")
	WebElement txtSSN;
	
	@FindBy(id="customer.username")
	WebElement txtusername;
	
	@FindBy(id="customer.password")
	WebElement txtPassword;
	
	@FindBy(id="repeatedPassword")
	WebElement txtCPassword;
	
	@FindBy(xpath="//input[@value='Register']")
	WebElement btnRegister;
	
	//create the Actions
	
	public void setFirstName(String fname) {
		txtfname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		
		txtlname.sendKeys(lname);
	}
	
	public void setAddress(String add) {
		txtAddress.sendKeys(add);
	}
	
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void setState(String state) {
		txtstate.sendKeys(state);
	}
	
	public void setZipcode(String Zcode) {
		txtZipcode.sendKeys(Zcode);
	}
	
	public void setPhoneNumber(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void setSSN(String ssn) {
		txtSSN.sendKeys(ssn);
	}
	
	public void setUsername(String uname) {
		txtusername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cpwd) {
		txtCPassword.sendKeys(cpwd);
	}
	
	public void clickRegisterbtn() {
		btnRegister.click();
	}
	
}
