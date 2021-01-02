package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;


public class Assertions extends Base{

	public WebDriver driver; //this would help in parallel testing
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage lp ;
	@BeforeTest
	public void Initialisation() throws IOException
	{
		driver = InitialiseDriver();
		log.info("Browser is initiated");
		String urlname = prop.getProperty("url");
		//System.out.println(urlname);
		driver.get(urlname);
		log.info("URL is invoked");;
	}
	@Test
	public void BrowserNavigation() 
	{
		//using method of other class through inheritance

		//using method of other class by creating the object of that class
		lp = new LandingPage(driver);
		//lp.Login().click();
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(lp.Text().isDisplayed());
		log.info("Assertion is passed");
}
	
	@Test
	public void validateHeader() 
	{

		lp = new LandingPage(driver);
		
		Assert.assertEquals(lp.Header().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Assertion is passed");
}
	
	@AfterTest
	public void Dump()
	{
		driver.close();
		driver=null;
	}
}
