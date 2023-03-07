package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class PSM {

	public ChromeDriver driver;
	public String excelFileName; // null value

	public static ExtentReports extent;
	public ExtentTest test, node;
	public String testName, testDescription, testCategory, testAuthor;

	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void setTestCaseDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	public int takeSnap() throws IOException {
		int ranNum = (int) (Math.random() * 999999 + 1000000); //1114249
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" + ranNum + ".png");
		FileUtils.copyFile(source, target);
		return ranNum; //4234324
	}

	public void reportStep(String stepDesc, String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			throw new RuntimeException("Please look into report for failure details");
		}

	}

	@AfterSuite
	public void stopReport() {
		extent.flush();

	}

	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException {
		return ReadExcel.readData(excelFileName); 
	}

	@BeforeMethod
	public void preCondition() {
		node = test.createNode(testName);
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
	}

	@AfterMethod
	public void postCondition() {
		driver.close();

	}

}
