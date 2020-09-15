package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports R2;
	public static ExtentReports getExtentReports()
	{
		String path = System.getProperty("user.dir")+"\\ExtentReports\\index.html";
		 
		ExtentSparkReporter R1 = new ExtentSparkReporter(path);
	
		R1.config().setDocumentTitle("Results");
		R1.config().setReportName("Extent Reports Phase one");
		
		R2 = new ExtentReports();
		R2.attachReporter(R1);
		R2.setSystemInfo("Tester1", "User1");
		R2.setSystemInfo("Tester2", "User2");
		return R2;
	}
}
