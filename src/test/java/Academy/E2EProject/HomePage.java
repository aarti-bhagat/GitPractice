package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base
{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void Initialisation() throws IOException
	{
		driver = InitialiseDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void BrowserNavigation(String username, String pwd) 
	{
		String urlname = prop.getProperty("url");
		//System.out.println(urlname);
		driver.get(urlname);
		//using method of other class through inheritance
		//using method of other class by creating the object of that class
		LandingPage lp = new LandingPage(driver);
		LoginPage l = lp.Login();
		
	//	LoginPage l = new LoginPage(driver);
		l.email().sendKeys(username);
		l.password().sendKeys(pwd);
		l.login().click();
		
		ForgotPassword fp = l.forgotpassword();
		fp.email().sendKeys("scds.fgm@afasnf.com");
		fp.sendMeInstruction().click();
		log.info("Home is passed");
		System.out.println("Git code");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[2][2];
		//row counts the number of tests that should run
		//column counts the number of values passed to one test
		//counting starts from 0 and 2 2 represents there are 2 rows and 2 columns 0, 1

		data[0][0] = "restrictedusr@g.com";
		data[0][1] = "restrictedusr";
		
		data[1][0] = "nonrestrictedusr@g.com";
		data[1][1] = "nonrestrictedusr";
		
		return data;
		
	}
	
	@AfterTest
	public void Dump()
	{
		driver.close();
	}

}
