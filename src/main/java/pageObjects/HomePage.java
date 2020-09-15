package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class HomePage extends base {
WebDriver driver;
	
	By LoginButton = By.cssSelector("div[class='global-nav-login-flydown global-login']");
	
	//create Constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement login()
	{
		return(driver.findElement(LoginButton));
	}

}
