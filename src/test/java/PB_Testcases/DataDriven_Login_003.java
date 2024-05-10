package PB_Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PB_Utilities.ExcelReading;
import PageObjects.LoginPage;
import junit.framework.Assert;

public class DataDriven_Login_003 extends PB_BaseClass {
	
	@Test(dataProvider="DataDriven22")
	public void datadriventest(String user,String pwd) throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		log.info("username is enterred");
		lp.setPassword(pwd);
		log.info("password is entered");
		lp.clickLoginbtn();
		log.info("login button clickingg activity is completed");
		
		String Act_title=driver.getTitle();
		String Exp_title="Adactin.com - Search Hotel";
		
		if(Act_title.equals(Exp_title)) {
			
			Assert.assertTrue(true);
			log.info("testcase passed");
		}else {
			captureScreen("loginTest");
			Assert.assertTrue(false);
			log.info("testcase is failed");
		}
	}
	
	@DataProvider(name="DataDriven22")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/DataDriven22.xlsx";

		int rownum=ExcelReading.getRowCount(path, "Sheet1");
		int colcount=ExcelReading.getCellCount(path,"Sheet1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)//row
		{
			for(int j=0;j<colcount;j++)//col
			{
				logindata[i-1][j]=ExcelReading.getCellData(path,"Sheet1", i,j);//1 0
			}

		}
		return logindata;
	}
	

}
