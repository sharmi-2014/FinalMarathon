package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.PSM;

public class AppLauncher extends PSM {
	public AppLauncher(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public Individual clickIndividuals() throws InterruptedException {
		Thread.sleep(2000);
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		return new Individual(driver,node);

	}

	
}
