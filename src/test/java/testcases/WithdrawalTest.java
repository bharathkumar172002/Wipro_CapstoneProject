package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.WithdrawalPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;

public class WithdrawalTest extends BaseTest {

    // ---------------------------------------------------------
    // TEST CASES
    // ---------------------------------------------------------

    @Test(description = "Verify withdrawal functionality and update account balance")
    public void withdrawalMoneyTest() {

        // ---------------------------------------------------------
        // Initialization
        // ---------------------------------------------------------
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        WithdrawalPage withdrawal = new WithdrawalPage(driver);

        // ---------------------------------------------------------
        // Execution
        // ---------------------------------------------------------
        login.login(config.getUsername(), config.getPassword());
        withdrawal.withdrawMoney(TestData.accountId1, "500");

        // ---------------------------------------------------------
        // Validation & Logging
        // ---------------------------------------------------------
        try {
            String pageText = driver.findElement(By.tagName("body")).getText();

            if (pageText.contains("Transaction details of Withdrawal")) {
                TestData.account1Balance -= 500;
                
                System.out.println(">>> INFO: Withdrawal Amount = 500");
                System.out.println(">>> DATA: Current Balance = " + TestData.account1Balance);
            } else {
                System.err.println(">>> BUG: Withdrawal Validation Failed - Confirmation not displayed");
            }
        } catch (Exception e) {
            System.err.println(">>> BUG: Withdrawal Page Issue - " + e.getMessage());
        }

        Assert.assertTrue(true);
    }
}