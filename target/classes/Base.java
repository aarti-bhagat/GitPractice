package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver InitialiseDriver() throws IOException
	{
		prop = new Properties();
		//FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis =new FileInputStream("C:\\Users\\aabhagat\\Desktop\\Eclipse_64_Workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		//this is used when we are running through maven parameterization
		// mvn test -Dbrowser=chrome
		String urllink = System.getProperty("url"); 
		//String urllink = "http://qaclickacademy.com/";
		System.out.println(urllink);
		//String browserName = System.getProperty("browser"); 
		//String browserName ="chrome";
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		//String urllink = System.getProperty("url"); 
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
			//running in headless mode
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			 options.addArguments("headless");
			//Step2- Create Driver Object	
			driver = new ChromeDriver(options);
			
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			//code for firefox
		}
		
		else
		{
			
	       System.out.println("browser not set up");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;	
		
	}
	
	public String getScreenshotpath(String testCaseName, WebDriver driver) throws IOException 
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;
	}	

}
