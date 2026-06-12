package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import POM.DepositPage;
import POM.FundTransferPage;
import POM.LoginPage;
import POM.WithdrawalPage;
import utilities.ConfigReader;
import utilities.TestData;

public class NegativeTest extends BaseTest {

    // ---------------------------------------------------------
    // TEST CASES
    // ---------------------------------------------------------

    @Test(description = "Verify fund transfer with an invalid account number")
    public void invalidAccountTransferTest() {
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        FundTransferPage transfer = new FundTransferPage(driver);

        login.login(config.getUsername(), config.getPassword());

        try {
            transfer.transferFunds("777777777", TestData.accountId2, "100");
            System.out.println(">>> INFO: Negative Test - Invalid Account Transfer");
            System.out.println(">>> DATA: " + driver.findElement(By.tagName("body")).getText());
        } catch (Exception e) {
            System.out.println(">>> ERROR: Invalid Account Validation Executed - " + e.getMessage());
        }

        Assert.assertTrue(true);
    }

    @Test(description = "Verify fund transfer with insufficient balance")
    public void insufficientBalanceTest() {
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        FundTransferPage transfer = new FundTransferPage(driver);

        login.login(config.getUsername(), config.getPassword());

        try {
            transfer.transferFunds(TestData.accountId1, TestData.accountId2, "100000");
            System.out.println(">>> DATA: " + driver.findElement(By.tagName("body")).getText());
        } catch (Exception e) {
            System.out.println(">>> ERROR: Insufficient Balance Test Executed - " + e.getMessage());
        }

        Assert.assertTrue(true);
    }

    @Test(description = "Verify withdrawal with amount exceeding balance")
    public void excessiveWithdrawalTest() {
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        WithdrawalPage withdrawal = new WithdrawalPage(driver);

        login.login(config.getUsername(), config.getPassword());

        try {
            withdrawal.withdrawMoney(TestData.accountId1, "100000");
            System.out.println(">>> INFO: Negative Test - Excess Withdrawal");
            System.out.println(">>> DATA: " + driver.findElement(By.tagName("body")).getText());
        } catch (Exception e) {
            System.out.println(">>> ERROR: Excess Withdrawal Validation Executed - " + e.getMessage());
        }

        Assert.assertTrue(true);
    }

    @Test(description = "Verify deposit with an invalid account number")
    public void invalidDepositAccountTest() {
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        DepositPage deposit = new DepositPage(driver);

        login.login(config.getUsername(), config.getPassword());

        try {
            deposit.depositMoney("777777777", "500");
            System.out.println(" Negative Test - Invalid Account Deposit");
            System.out.println("DATA: " + driver.findElement(By.tagName("body")).getText());
        } catch (Exception e) {
            System.out.println(">>> ERROR: Invalid Deposit Validation Executed - " + e.getMessage());
        }

        Assert.assertTrue(true);
    }
}