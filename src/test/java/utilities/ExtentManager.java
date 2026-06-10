package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "test-output/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Project",
                    "Guru99_Banking_Automation");

            extent.setSystemInfo(
                    "Tester",
                    "Bharath kumar");

            extent.setSystemInfo(
                    "Browser",
                    "Chrome");
        }

        return extent;
    }
}