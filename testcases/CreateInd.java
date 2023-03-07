package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PSM;
import pages.HomePage;
import pages.LoginPage;

public class CreateInd extends PSM{
	
	@BeforeTest
	public void setValues() {
		excelFileName = "CreateInd";
		testName = "CreateInd";
		testDescription = "Create Individual with mandatory informations";
		testCategory = "functional";
		testAuthor = "Sharmila";
	}
	
	@Test(dataProvider = "getData")
	public void runCreateInd(String uname, String pwd,String lastname) throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver,node);
		
		lp.enterUsername(uname).enterPassword(pwd).clickLoginButton().clickAppLauncherButton().clickviewAll()
		.clickIndividuals().clickIndividual().clickNewIndividual().enterLastName(lastname).clickSavebutton();
	}
	

}
