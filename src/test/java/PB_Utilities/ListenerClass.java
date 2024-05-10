package PB_Utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

import PB_Testcases.PB_BaseClass;

public class ListenerClass implements ITestListener{
	
	
	public ExtentHtmlReporter reporter;//it is provide the basic informtion about the report
	public ExtentReports extent;//it is provide the basic information about the user
	public ExtentTest test; //it is provide the test cases statuses(pass,fail,skip)
	
	//pre-defined methods(onStart,onTestSuccess,onTestFailure,onTestSkipped,onFinish)

	public void onStart(ITestContext context) {
		
		reporter=new ExtentHtmlReporter("D:\\SeleniumPracticeWork\\ParaBank_Project_11\\Reports\\Latest11.html");
		//provide the basic information about report
		
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Login Functionality report");
		reporter.config().setTheme(Theme.DARK);
		
		//provide the basic information about the user
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("hostname", "local host");
		extent.setSystemInfo("user","Kiran");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browsers", "Chrome,Firefox,Edge");
	}
	
	public void onTestSuccess(ITestResult tr) {
		 test=extent.createTest(tr.getName());
		 test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
	
	
	try {
		String imgPath=new PB_BaseClass().captureScreen(tr.getName());
		test.addScreenCaptureFromPath(imgPath);
		} 
	catch (IOException e) 
			{
			e.printStackTrace();
			}
	
	
	}
	public void onTestSkipped(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
}
