package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    // =========================================================================
    // LOCATORS
    // =========================================================================
    private By userId   = By.name("uid");
    private By password = By.name("password");
    private By loginBtn = By.name("btnLogin");

    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================================
    // ACTIONS
    // =========================================================================
    public void enterUserId(String uid) {
        WaitUtils.waitForElement(driver, userId).sendKeys(uid);
    }

    public void enterPassword(String pass) {
        WaitUtils.waitForElement(driver, password).sendKeys(pass);
    }

    public void clickLogin() {
        WaitUtils.waitForElement(driver, loginBtn).click();
    }

    public void login(String uid, String pass) {
        enterUserId(uid);
        enterPassword(pass);
        clickLogin();
    }
}