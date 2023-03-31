package utilityPom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	public static WebDriverWait explicitWait(WebDriver driver , int duration , WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(element));
		return wait;
	}
}
