package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityPom.Wait;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String uName) 
	{
		Wait.explicitWait(driver, 5, username );
		username.sendKeys(uName);
	}
	
	public void enterPassword(String pwd)
	{
		Wait.explicitWait(driver, 10, password);
		password.sendKeys(pwd);
	}
	
	public void ClickOnLoginButton()
	{
		Wait.explicitWait(driver, 5, loginButton);
		loginButton.click();
	}
	

}
