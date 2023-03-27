package TestComponents;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.utilities.BaseClass;

import Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
//	WebDriver driver;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	@Override
    public void onTestStart(ITestResult result) {
        test =  extent.createTest(result.getMethod().getMethodName());
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS,"Test is Passed");
       
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test.fail(result.getThrowable());
    	
    	
//    	try {
////		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 		
    	
    	try {
    		String filepath = "";
			 filepath = getScreenshot(result.getMethod().getMethodName(),BaseTest.driver);
			 
			 test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

      }
       

    @Override
    public void onTestSkipped(ITestResult result) {
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
//        test.log(Status.PASS,"Execution Ended");
        extent.flush();
    }

}
