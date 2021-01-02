package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;

	//if the method is declared as static then all the variables inside the method should be static
	public static ExtentReports getReportObject()
	{
		//to get the project path  and create a folder inside that
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				
				reporter.config().setReportName("Web Automation Result");
				reporter.config().setDocumentTitle("Test Results");
				
			    extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Aarti");
				return extent;
	}
}
