package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.PSM;

public class LoginPage extends PSM {
	
	public LoginPage(ChromeDriver driver, ExtentTest node) {
		
		this.driver = driver;
		this.node = node;
		
	}

	// action+ElementName
	public LoginPage enterUsername(String uName) throws InterruptedException, IOException {
		
		try {
			driver.findElement(By.id("username")).sendKeys(uName);
			reportStep(uName+ " Username is entered successfully", "pass");
			
		} catch (Exception e) {
			reportStep("Username is not entered successfully..." +e, "fail");
		}
		
	//	Thread.sleep(10000);
		return this;
	}

	public LoginPage enterPassword(String pWord) throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(pWord);
			reportStep(pWord+" password is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("password is not entered successfully..."+e, "fail");
		}
		
		return this;
	}

	public HomePage clickLoginButton() throws IOException {
		try {
			driver.findElement(By.id("Login")).click();
			reportStep("Login button is clicked", "pass");
		} catch (Exception e) {
			reportStep("Login button is not clicked..."+e, "fail");
		}
			
		return  new HomePage(driver, node);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
