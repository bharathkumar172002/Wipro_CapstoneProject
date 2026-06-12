package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    // ---------------------------------------------------------
    // METHODS
    // ---------------------------------------------------------

    public static void captureScreenshot(WebDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("./screenshots/" + fileName + ".png"));
            System.out.println(">>> INFO: Screenshot captured: " + fileName);
        } catch (IOException e) {
            System.err.println(">>> ERROR: Unable to capture screenshot: " + e.getMessage());
        }
    }
}