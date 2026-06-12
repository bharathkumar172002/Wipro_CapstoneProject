package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.FundTransferPage;
import POM.LoginPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.WaitUtils;

public class FundTransferTest extends BaseTest {

    @Test(description = "Verify fund transfer functionality between two accounts")
    public void fundTransferTest() {

        // ---------------------------------------------------------
        // Initialization
        // ---------------------------------------------------------
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        FundTransferPage transfer = new FundTransferPage(driver);

        // ---------------------------------------------------------
        // Test Steps
        // ---------------------------------------------------------
        login.login(config.getUsername(), config.getPassword());

        System.out.println("From Account: " + TestData.accountId1);
        System.out.println("To Account: " + TestData.accountId2);

        transfer.transferFunds(TestData.accountId1, TestData.accountId2, "200");

        // ---------------------------------------------------------
        // Data Verification & Logging
        // ---------------------------------------------------------
        TestData.account1Balance -= 200;
        TestData.account2Balance += 200;

        System.out.println("Transfer Amount: 200");
        System.out.println("Sender Balance: " + TestData.account1Balance);
        System.out.println("Receiver Balance: " + TestData.account2Balance);

        // ---------------------------------------------------------
        // Assertions
        // ---------------------------------------------------------
        WaitUtils.waitForText(driver, "Fund Transfer Details");
        Assert.assertTrue(driver.getPageSource().contains("Fund Transfer Details"), 
                          "Fund Transfer details page not found");
    }
}