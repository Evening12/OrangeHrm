package testpackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testutilities.OpenDriver;
import testutilities.TakeScreenShot;

public class BaseClass {
	 static WebDriver driver;
	 
	 public static ExtentReports report;
	 
	 public static ExtentHtmlReporter extent;
	 
	 public static ExtentTest logger;
	 
	@Parameters({"browserName"})
	@BeforeTest

	public void Test(String browserName) 
	
	{
		
		WebDriver driver=OpenDriver.openbrowser(browserName, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		this.driver=driver;
		extent=new ExtentHtmlReporter("test-output\\HtmlReport\\" + System.currentTimeMillis() +".html");
		report=new ExtentReports();
		report.attachReporter(extent);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			String path=TakeScreenShot.takeSS("error", driver);
			logger.fail( "this test case is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		report.flush();
	}
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
	
	
}
