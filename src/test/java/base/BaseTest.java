package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {

    public static WebDriver driver;
    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup() {
        String browser = config.getBrowser();
        String url = config.getUrl();

        System.out.println("\n╔" + "═".repeat(60) + "╗");
        System.out.println("║ 🚀  STARTING EXECUTION                                 ║");
        System.out.println("╠" + "═".repeat(60) + "╣");
        System.out.println("║ 🌐  Browser: " + browser + "                                   ║");
        System.out.println("║ 🔗  URL    : " + url + "          ║");
        System.out.println("╚" + "═".repeat(60) + "╝\n");

        if (browser == null || browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");

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
    public void tearDown() {
        if (driver != null) {
            
            System.out.println("\n🏁 [FINISHED] Test case execution completed.");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        }
    }
}