package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	WebDriver driver;
	public WebDriver initialiseDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Job\\Selenium Course\\Eclipse Projects\\PracticeE2E\\src\\main\\java\\Scratch\\PracticeE2E\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
				{
			System.setProperty("webdriver.chrome.driver", "D:\\Job\\Selenium Course\\Eclipse Projects\\chromedriver_win32\\chromedriver.exe\\");
			driver = new ChromeDriver();
				}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+testcaseName+".png";
		FileUtils.copyFile(src, new File(destination));
		return destination;
		
	}

	
}
