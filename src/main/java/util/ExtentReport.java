package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getExtentReport() {
		String extentReportFilePath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
ExtentSparkReporter sparkReporter = new ExtentSparkReporter (extentReportFilePath);		
sparkReporter.config().setReportName("EOA AUTOMATION RESULT");
	sparkReporter.config().setDocumentTitle("Automation Report");
	
	ExtentReports extentReport = new ExtentReports();
	extentReport.attachReporter(sparkReporter);
	extentReport.setSystemInfo("Selenium Version", "4.15.0");
	extentReport.setSystemInfo("Operating System", "Windows 10");
	extentReport.setSystemInfo("Executed By", "NAMAN GOEL");
	
	return extentReport;
	
	}
}
