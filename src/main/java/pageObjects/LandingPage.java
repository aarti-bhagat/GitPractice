package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.tagName("h2");
	By text = By.xpath("//a[text()='Videos']");
	By header = By.cssSelector("div[class*='video-banner'] h3");
	

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public LoginPage Login()
	{
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	
	public WebElement Text()
	{
		return driver.findElement(text);
		
	}
	
	public WebElement Header()
	{
		return driver.findElement(header);
	}

}
