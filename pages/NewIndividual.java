package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.PSM;

public class NewIndividual extends PSM {
	public NewIndividual(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}
	public NewIndividual enterLastName(String lName ) {
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(lName);
				return this;
	}
	public verificationPage clickSavebutton( ) {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return new verificationPage(driver , node);
	}
	public NewIndividual clickSalutation( ) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Ms.']")).click();
		return this;
	}
	public NewIndividual clickFirstName(String fName ) {
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(fName);
	return this;
	}
}
