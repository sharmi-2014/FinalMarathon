package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PSM;
import pages.HomePage;
import pages.LoginPage;

public class Login extends PSM{
	
	@BeforeTest
	public void setValues() {
		excelFileName = "Login";
		testName = "Login";
		testDescription = "Login for LeafTaps";
		testCategory = "smoke";
		testAuthor = "Sharmila";
	}
	
	@Test(dataProvider = "getData")
	public void runLoginLogout(String uName, String pWord) throws InterruptedException, IOException {
		System.out.println(driver);
		LoginPage lp = new LoginPage(driver, node);
		
	lp.enterUsername(uName)
	  .enterPassword(pWord)
	  .clickLoginButton();

	}
	

}
