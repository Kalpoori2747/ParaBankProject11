package PB_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PB_Utilities.ExcelReading;
import PageObjects.PB_LoginPage;

public class Tc_DataDriven_Login extends PB_BaseClass {
	
	@Test(dataProvider="Datadriven")
	public void logintest(String user,String pwd) throws IOException {
		
		PB_LoginPage pbl=new PB_LoginPage(driver);
		
		pbl.setUsername(user);
		pbl.setPassword(pwd);
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
	

	@DataProvider(name="Datadriven")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/Datadriven.xlsx";

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

