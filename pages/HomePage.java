package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.PSM;

public class HomePage extends PSM {
	public HomePage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public HomePage clickAppLauncherButton() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		return this;
	}

	public AppLauncher clickviewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
     
		return new AppLauncher(driver,node);

	}

}
