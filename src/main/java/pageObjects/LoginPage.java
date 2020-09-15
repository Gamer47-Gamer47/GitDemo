package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
WebDriver driver;
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("Login");
	
	//create Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement username()
	{
		return(driver.findElement(username));
	}
	public WebElement password()
	{
		return(driver.findElement(password));
	}
	public WebElement loginButton()
	{
		return(driver.findElement(loginButton));
	}
}
