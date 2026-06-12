package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestData;
import utilities.WaitUtils;

public class AccountPage {

    // =========================================================================
    // FIELDS
    // =========================================================================
    private WebDriver driver;

    // =========================================================================
    // LOCATORS
    // =========================================================================
    private By newAccountLink = By.linkText("New Account");
    private By customerId     = By.name("cusid");
    private By accountType    = By.name("selaccount");
    private By initialDeposit = By.name("inideposit");
    private By submitBtn      = By.name("button2");
    private By accountIdText  = By.xpath("//td[text()='Account ID']/following-sibling::td");

    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================================
    // ACTIONS
    // =========================================================================
    public void createAccount(String custId) {
        WaitUtils.waitForElement(driver, newAccountLink).click();
        
        driver.findElement(customerId).sendKeys(custId);
        driver.findElement(accountType).sendKeys("Savings");
        driver.findElement(initialDeposit).sendKeys("3000");
        
        WaitUtils.waitForElement(driver, submitBtn).click();

        String accountId = driver.findElement(accountIdText).getText();

        if (TestData.accountId1 == null) {
            TestData.accountId1 = accountId;
        } else {
            TestData.accountId2 = accountId;
        }
        
        System.out.println("Generated Account ID = " + accountId);
    }
}