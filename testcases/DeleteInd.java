package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PSM;
import pages.HomePage;
import pages.LoginPage;

public class DeleteInd extends PSM {
	
	@BeforeTest
	public void setValues() {
		excelFileName = "DeleteInd";
		testName = "DeleteInd";
		testDescription = "Delete by using Name";
		testCategory = "functional";
		testAuthor = "Sharmila";
	}
	
	@Test(dataProvider = "getData")
	public void runDeleteInd( String uname,String pwd,String name1, String name2) throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver,node);
		
		lp.enterUsername(uname).enterPassword(pwd).clickLoginButton().clickAppLauncherButton().clickviewAll()
		.clickIndividuals().clickIndividual().clicksearch(name1).clickdrop().clickDelete().confirmDelete().verifyDelete(name2);
	}
	

}
