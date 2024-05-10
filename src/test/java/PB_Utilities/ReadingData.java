package PB_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadingData {
	
	
	//create the constructor
	 Properties pro;
	
	public ReadingData(){
		//configure the properties file
		
		File f=new File("D:\\SeleniumPracticeWork\\ParaBank_Project_11\\PropertiesFiles\\Data.properties");
	
		//convert that file into reading mode
		try {
		FileInputStream fis=new FileInputStream(f);
		 pro=new Properties();
		pro.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
	//corresponding methods for each and every property

	public String getApplicationurl() {
		
		String url=pro.getProperty("Url");
		return url;
	}
	
	public String getFullName() {
		String fname=pro.getProperty("Fullname");
	    return fname;
	}
	
	public String getLastName() {
		String Lname=pro.getProperty("Lastname");
	    return Lname;
	}
	
	public String getAddress() {
		String Add=pro.getProperty("Address");
		return Add;
	}
	
	public String getCity() {
		String City=pro.getProperty("City");
		return City;
	}
	
	public String getState() {
		String State=pro.getProperty("State");
		return State;
	}
	
	public String getZipCode() {
		
		String ZCode=pro.getProperty("ZipCode");
		return ZCode;
	}
	
	public String getPhoneNumber() {
		String PHnumber=pro.getProperty("PhoneNumber");
		return PHnumber;
	}
	
	public String getSSN() {
		String ssn=pro.getProperty("SSN");
		return ssn;
	}
	
	public String getUsername() {
		String Username=pro.getProperty("Username");
		return Username;
	}
	
	public String getPassword() {
		String PWord=pro.getProperty("Password");
		return PWord;
	}
	
	public String getCpassword() {
		String CPassword=pro.getProperty("Cpassword");
		return CPassword;
	}
	
	public String getAdactinAppURL() {
		String adacURL=pro.getProperty("Url2");
		return adacURL;
	}
	
	public String getAdactinUsername() {
		String adacUname=pro.getProperty("username2");
	    return adacUname;
	}
	
	public String getAdactinPword() {
		String adacPword=pro.getProperty("password2");
		return adacPword;
	}
	

}
