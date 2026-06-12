package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class DepositPage {

    private WebDriver driver;

    // =========================================================================
    // LOCATORS
    // =========================================================================
    private By depositLink  = By.linkText("Deposit");
    private By accountNo    = By.name("accountno");
    private By amount       = By.name("ammount");
    private By description  = By.name("desc");
    private By submit       = By.name("AccSubmit");

    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================================
    // ACTIONS
    // =========================================================================
    public void depositMoney(String accNo, String amt) {
        WaitUtils.waitForElement(driver, depositLink).click();
        
        driver.findElement(accountNo).sendKeys(accNo);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(description).sendKeys("Deposit");
        
        WaitUtils.waitForElement(driver, submit).click();
    }
}