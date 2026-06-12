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

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest test;

    // --- Test Execution Methods ---

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        System.out.println(">>> STARTED: " + result.getName() + " <<<");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        System.out.println("✅ PASSED: " + result.getName());
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        ScreenshotUtil.captureScreenshot(BaseTest.driver, result.getName());
        System.err.println("❌ FAILED: " + result.getName());
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
        System.out.println("⚠️ SKIPPED: " + result.getName());
        System.out.println("--------------------------------------------------");
    }

    // --- Suite Execution Methods ---

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n==================================================");
        System.out.println("          TEST EXECUTION STARTED          ");
        System.out.println("==================================================\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("\n==================================================");
        System.out.println("          TEST EXECUTION COMPLETED        ");
        System.out.println("==================================================\n");
    }
}