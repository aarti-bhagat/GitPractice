package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword 
{
	WebDriver driver;
	
	By email = By.id("user_email");
	By sendMeInstruction = By.cssSelector("input[type='submit']");
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstruction()
	{
		return driver.findElement(sendMeInstruction);
	}
	
	
	
	
	
	
	

}
