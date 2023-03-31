package testpackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pomclass.LoginPage;
import testutilities.OpenDriver;
import testutilities.TakeScreenShot;

public class LoginTestClass extends BaseClass{
    
	LoginPage login;
	
	@BeforeMethod  
	public void initialisingLoginObject() 
	{
		login=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageWithInvalidCredentials() 
	{   
		logger=report.createTest("verify Login Page With Invalid Credentials");
	
		login.enterUsername("abc1");
		login.enterPassword("a123");
		login.ClickOnLoginButton();
		String expectedurl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualurl=driver.getCurrentUrl();
		Assert.assertNotEquals(expectedurl, actualurl);
	}
	
	@Test(priority=2)
	public void VerifyLoginPageWithValidCredentials() 
	{
		logger=report.createTest("Verify Login Page With Valid Credentials");
		
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.ClickOnLoginButton();
		String expectedurl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualurl=driver.getCurrentUrl();
		Assert.assertNotEquals(expectedurl, actualurl);
	}
	
}
