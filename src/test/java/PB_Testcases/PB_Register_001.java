package PB_Testcases;

import org.testng.annotations.Test;

import PageObjects.PB_RegisterPage;

public class PB_Register_001 extends PB_BaseClass {

	
	@Test
	public void RegisterTest() {
		
		PB_RegisterPage pbr=new PB_RegisterPage(driver);
		
		pbr.setFirstName(FName);
		log.info("enterd Fullname");
		pbr.setLastName(LName);
		log.info("entered Lastname");
		pbr.setAddress(Addr);
		log.info("address is entered");
		pbr.setCity(City);
		log.info("city name should be mention");
		pbr.setState(State);
		log.info("state name is entered");
		pbr.setZipcode(ZIPC);
		pbr.setPhoneNumber(PHNumber);
		pbr.setSSN(SSN);
		pbr.setUsername(UName);
		pbr.setPassword(PWD);
		pbr.setConfirmPassword(CPWD);
		pbr.clickRegisterbtn();
		
		
		
		
	}
	
}
