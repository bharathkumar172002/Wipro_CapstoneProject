package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ScreenshotUtil;
import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;

public class TestListener implements ITestListener {

	private static ExtentReports extent =
	        ExtentManager.getInstance();

	private static ExtentTest test;
	@Override
	public void onTestStart(
	        ITestResult result) {

	    test =
	            extent.createTest(
	                    result.getName());

	    System.out.println(
	            "STARTED : "
	                    + result.getName());
	}

	@Override
	public void onTestSuccess(
	        ITestResult result) {

	    test.pass("Test Passed");

	    System.out.println(
	            "VALIDATION PASSED : "
	                    + result.getName());
	}

	@Override
	public void onTestFailure(
	        ITestResult result) {

	    test.fail(
	            result.getThrowable());

	    ScreenshotUtil.captureScreenshot(
	            BaseTest.driver,
	            result.getName());

	    System.out.println(
	            "VALIDATION FAILED : "
	                    + result.getName());
	}

	@Override
	public void onTestSkipped(
	        ITestResult result) {

	    test.skip("Test Skipped");

	    System.out.println(
	            "SKIPPED : "
	                    + result.getName());
	}

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "Execution Started");
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();

        System.out.println(
                "Execution Completed");
    }
}