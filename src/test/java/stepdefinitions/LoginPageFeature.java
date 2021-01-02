package stepdefinitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginPageFeature extends Base{

	WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
    @Given("^Initialize the Driver$")
    public void initialize_the_driver() throws Throwable {
       
    	this.driver = InitialiseDriver();
    	
    }

    @When("^User invokes home page URL$")
    public void user_invokes_home_page_url() throws Throwable {
    	String urlname = "http://qaclickacademy.com/";
    	//String urlname = prop.getProperty("url");
		//System.out.println(urlname);
		driver.get(urlname);
        
    }

    @Then("^User clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
    	LandingPage lp = new LandingPage(driver);
		LoginPage l = lp.Login();
	
        
    }

    @And("User proivdes incorrect {string} and {string} and click on forgot password")
    public void user_proivdes_incorrect_credentials_and_click_on_forgot_password(String username, String pwd) throws Throwable {
        
         	LoginPage l = new LoginPage(driver);
    		l.email().sendKeys(username);
    		l.password().sendKeys(pwd);
    		l.login().click();
    		
    		ForgotPassword fp = l.forgotpassword();
    		fp.email().sendKeys("scds.fgm@afasnf.com");
    		fp.sendMeInstruction().click();
    		log.info("Home is passed");
    }
    
    @And("^User proivdes two incorrect (.+) and (.+) and click on forgot password$")
    public void user_proivdes_incorrect_and_and_click_on_forgot_password(String username, String password) throws Throwable {
    	LoginPage l = new LoginPage(driver);
		l.email().sendKeys(username);
		l.password().sendKeys(password);
		l.login().click();
		
		ForgotPassword fp = l.forgotpassword();
		fp.email().sendKeys("scds.fgm@afasnf.com");
		fp.sendMeInstruction().click();
		log.info("Home is passed");
    }

}