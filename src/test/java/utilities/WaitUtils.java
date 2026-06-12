package utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    // ---------------------------------------------------------
    // CONSTANTS
    // ---------------------------------------------------------
    private static final int TIMEOUT = 20;

    // ---------------------------------------------------------
    // METHODS
    // ---------------------------------------------------------
    public static WebElement waitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForText(WebDriver driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
    }
}