package PB_Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import PB_Utilities.ReadingData;

public class PB_BaseClass {



	//basic functionality of each every testcase
	//open application
	//close application
	//screenshots
	//log files 
	//assert conditons
	public static WebDriver driver;

	ReadingData rd=new ReadingData();

	public String url=rd.getApplicationurl();
	public String FName=rd.getFullName();
	public String LName=rd.getLastName();
	public String Addr=rd.getAddress();
	public String City=rd.getCity();
	public String State=rd.getState();
	public String ZIPC=rd.getZipCode();
	public String PHNumber=rd.getPhoneNumber();
	public String SSN=rd.getSSN();
	public String UName=rd.getUsername();
	public String PWD=rd.getPassword();
	public String CPWD=rd.getCpassword();
	public String AdacURL=rd.getAdactinAppURL();
	public String AdacUname=rd.getAdactinUsername();
	public String AdacPword=rd.getAdactinPword();

	public static Logger log;

	@BeforeClass
	@Parameters("browser")
	public void OpenApplication(String br) {

		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(AdacURL);
		driver.manage().window().maximize();

		log=Logger.getLogger("Parabank_Project_11");
		//./==> Project Home Directory
		PropertyConfigurator.configure("./Log4j.properties");
	}

//	@AfterClass
//	public void CloseApplication() {
//		driver.close();
//	}
	
	public String captureScreen(String name) throws IOException {
		
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		//system.getProperty("user.dir")
		String target=(System.getProperty("user.dir")+"\\Screenshots\\"+name+"_"+timeStamp+".png");
	    
		try {
		FileUtils.copyFile(src, new File(target));
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
	    log.info("screenshot is taken");
	    return target;
	
	}

}
