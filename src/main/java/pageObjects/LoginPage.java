package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	WebDriver driver;
	
	By email = By.id("user_email");
	By password = By.cssSelector("input[type='password']");
	By login = By.cssSelector("input[type='submit']");
	By forgotpassword = By.cssSelector("a[class='link-below-button']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	

	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
		
	}
	
	public ForgotPassword forgotpassword()
	{
		 driver.findElement(forgotpassword).click();
		 return new ForgotPassword(driver);
		 
	}
	
	
	

}
