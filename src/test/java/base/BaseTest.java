package base;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {

    public static WebDriver driver;
    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup(Method method) {
        String browser = config.getBrowser();
        String url = config.getUrl();
        String moduleName = this.getClass().getSimpleName().toUpperCase();
        String testName = method.getName().toUpperCase();

        System.out.println("\n┌──────────────────────────────────────────────────────────┐");
        System.out.printf("│  %-56s  │%n", "MODULE : " + moduleName);
        System.out.printf("│  %-56s  │%n", "TEST   : " + testName);
        System.out.println("└──────────────────────────────────────────────────────────┘");

        if (browser == null || browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");
//            options.addArguments("--headless=new"); 
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            driver.get(url);
            System.out.println("✨ [SUCCESS] Browser launched successfully.\n");
        } else {
            System.err.println("❌ [CRITICAL ERROR] Driver initialization failed!");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            String status = (result.isSuccess()) ? "PASSED ✅" : "FAILED ❌";
            System.out.println("\n🏁 [FINISHED] Test case execution completed.");
            System.out.println("   RESULT: " + status);
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        }
    }
}