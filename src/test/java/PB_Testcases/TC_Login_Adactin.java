package PB_Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import junit.framework.Assert;

public class TC_Login_Adactin extends PB_BaseClass {
	
@Test
	public void loginTest() throws IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(AdacUname);
		log.info("username is enterred");
		lp.setPassword(AdacPword);
		log.info("password is entered");
		lp.clickLoginbtn();
		log.info("login button clickingg activity is completed");
		
		String Act_title=driver.getTitle();
		String Exp_title="Adactin.com - Search Hotel123";
		
		if(Act_title.equals(Exp_title)) {
			
			Assert.assertTrue(true);
			log.info("testcase passed");
		}else {
			captureScreen("loginTest");
			Assert.assertTrue(false);
			log.info("testcase is failed");
		}
		
	}
}
