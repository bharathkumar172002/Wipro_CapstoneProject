package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

public class FundTransferPage {

   
    private WebDriver driver;

    // =========================================================================
    // LOCATORS
    // =========================================================================
    private By fundTransferLink = By.linkText("Fund Transfer");
    private By payerAccount     = By.name("payersaccount");
    private By payeeAccount     = By.name("payeeaccount");
    private By amount           = By.name("ammount");
    private By description      = By.name("desc");
    private By submit           = By.name("AccSubmit");

    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================================
    // ACTIONS
    // =========================================================================
    public void transferFunds(String fromAcc, String toAcc, String amt) {
        WebElement fundTransfer = WaitUtils.waitForElement(driver, fundTransferLink);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", fundTransfer);

        driver.findElement(payerAccount).sendKeys(fromAcc);
        driver.findElement(payeeAccount).sendKeys(toAcc);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(description).sendKeys("Fund Transfer");

        WaitUtils.waitForElement(driver, submit).click();
    }
}