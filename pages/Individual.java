package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.PSM;

public class Individual extends PSM {
	public Individual(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}
	public Individual clickIndividual( ) throws InterruptedException {
	Thread.sleep(3000)	;
    WebElement individuals = driver.findElement(By.xpath("(//span[text()='Individuals']//following::span)[1]"));
    driver.executeScript("arguments[0].click();",individuals );
    return this;
	}
	public NewIndividual clickNewIndividual( ) {
		WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", clk);
		return new NewIndividual(driver, node);
	}
	public Individual clicksearch(String Name ) throws InterruptedException {
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(Name);
		name.sendKeys(Keys.ENTER);
		return this;
	}
	public Individual clickdrop( ) throws InterruptedException {
		Thread.sleep(3000);
		WebElement pop = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", pop);
		return this;
		}
	
	public verificationPage clickDelete( ) throws InterruptedException {
		Thread.sleep(3000);
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(5000);
		WebElement clickdelete = driver.findElement(By.xpath("//span[text()='Delete']"));
		driver.executeScript("arguments[0].click();",clickdelete );
		return new verificationPage(driver, node);
	}
	public NewIndividual clickEdit( ) throws InterruptedException {
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("(//a[@title='Edit']/div)[1]"));
		driver.executeScript("arguments[0].click();", edit);
		return new NewIndividual(driver ,node);
	}
	
	
	
}
