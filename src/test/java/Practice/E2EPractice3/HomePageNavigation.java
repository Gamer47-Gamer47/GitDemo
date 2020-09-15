package Practice.E2EPractice3;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageNavigation extends base{
public static Logger log = LogManager.getLogger(base.class.getName());
WebDriver driver;
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver=initialiseDriver();
		log.info("Driver is initialised");
	}
	
	@Test(dataProvider="getData")
	public void navigateHomePage(String username,String password,String message) throws IOException
	{
		
		driver.get("http://salesforce.com");
		log.info("Successfully navigated to salesforce");
		//Create object to HomePage class
		HomePage hp = new HomePage(driver);
		driver.manage().window().maximize();
		hp.login().click();
		LoginPage lp = new LoginPage(driver);
		lp.username().sendKeys(username);
		lp.password().sendKeys(password);
		lp.loginButton().click();
		System.out.println(message);
		log.info("1st dataset executed");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "ABC";
		data[0][1] = "123";
		data[0][2] = "1st data set passed";
		
		data[1][0]="XYZ";
		data[1][1]="567";
		data[1][2] = "2nd data set passed";
		
		return data;
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
	
}
