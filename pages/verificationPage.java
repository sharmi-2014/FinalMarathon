package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.PSM;

public class verificationPage extends PSM {
	public verificationPage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public verificationPage verifyCreateInd() {
		String title = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(title);
		return this;
	}
	public verificationPage confirmDelete( ) {
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		 return this;
	}
	public void verifyDelete(String name ) throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(name,Keys.ENTER);
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		System.out.println(verify);
	}
public verificationPage verifyEditInd( ) {
	String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	System.out.println(msg);
	return this;
}
}
