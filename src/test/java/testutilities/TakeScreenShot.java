package testutilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot {
	public static String takeSS(String filename , WebDriver driver) throws IOException
	{
		String path="D:\\eclipse-workspace\\OrngHRM\\src\\test\\resources\\screenshot" + filename + System.currentTimeMillis()+ ".png ";
		
		
		TakesScreenshot t=(TakesScreenshot)driver;
		
		File source=t.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileHandler.copy(source, dest);
		
		return path;
	}

}
