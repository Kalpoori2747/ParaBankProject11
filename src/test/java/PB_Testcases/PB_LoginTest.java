package PB_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.PB_LoginPage;


public class PB_LoginTest extends PB_BaseClass {
	
	@Test
	public void logintest() throws IOException {
		
		PB_LoginPage pbl=new PB_LoginPage(driver);
		
		pbl.setUsername();
		pbl.setPassword();
		pbl.clickLoginbtn();
		
		
		String Exp_title="ParaBank | Accounts Overview11";
		String act_title=driver.getTitle();
		
		if(act_title.equals(Exp_title)) {
			
			Assert.assertTrue(true);//hard assert
			log.info("testcase is passed");
			
		}
		else {
			
			captureScreen("logintest");
			Assert.assertTrue(false);
			log.info("testcase is failed");
		}
	}

}
