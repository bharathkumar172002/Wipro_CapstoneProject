package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

public class WithdrawalPage {

    private WebDriver driver;

    // =========================================================================
    // LOCATORS
    // =========================================================================
    private By withdrawalLink = By.linkText("Withdrawal");
    private By accountNo      = By.name("accountno");
    private By amount         = By.name("ammount");
    private By description    = By.name("desc");
    private By submit         = By.name("AccSubmit");

    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
    public WithdrawalPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================================
    // ACTIONS
    // =========================================================================
    public void withdrawMoney(String accNo, String amt) {
        WebElement withdrawal = WaitUtils.waitForElement(driver, withdrawalLink);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", withdrawal);
        
        driver.findElement(accountNo).sendKeys(accNo);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(description).sendKeys("Withdraw");
        
        WaitUtils.waitForElement(driver, submit).click();
    }
}