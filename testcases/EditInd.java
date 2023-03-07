package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PSM;
import pages.LoginPage;

public class EditInd extends PSM{
	
	@BeforeTest
	public void setValues() {
		excelFileName = "EditInd";
		testName = "EditInd";
		testDescription = "Edit Individual with mandatory informations";
		testCategory = "functional";
		testAuthor = "Sharmila";
	}
	
	@Test(dataProvider = "getData")
	public void runEditInd(String uname, String pwd,String name, String firstname,String lastname) throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver,node);
		
		lp.enterUsername(uname).enterPassword(pwd).clickLoginButton().clickAppLauncherButton().clickviewAll()
		.clickIndividuals().clickIndividual().clicksearch(name).clickdrop().clickEdit().clickSalutation().clickFirstName(firstname)
		.enterLastName(lastname).clickSavebutton().verifyEditInd();
	
	}
}
