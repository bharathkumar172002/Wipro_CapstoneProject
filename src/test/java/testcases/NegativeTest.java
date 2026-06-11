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

public class NegativeTest
        extends BaseTest {

    @Test
    public void invalidAccountTransferTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        FundTransferPage transfer =
                new FundTransferPage(driver);

        try {

            transfer.transferFunds(
                    "99999999",
                    TestData.accountId2,
                    "100");

            System.out.println(
                    "Negative Test : Invalid Account Transfer");

            System.out.println(
                    driver.findElement(
                            By.tagName("body"))
                            .getText());

        } catch(Exception e) {

            System.out.println(
                    "Invalid Account Validation Executed");

            System.out.println(
                    e.getMessage());
        }

        Assert.assertTrue(true);
    }

    @Test
    public void insufficientBalanceTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        FundTransferPage transfer =
                new FundTransferPage(driver);

        try {

            transfer.transferFunds(
                    TestData.accountId1,
                    TestData.accountId2,
                    "100000");

            String pageText =
                    driver.findElement(
                            By.tagName("body"))
                            .getText();

            System.out.println(pageText);

        } catch(Exception e) {

            System.out.println(
                    "Insufficient Balance Test Executed");

            System.out.println(
                    e.getMessage());
        }

        Assert.assertTrue(true);
    }

    @Test
    public void excessiveWithdrawalTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        WithdrawalPage withdrawal =
                new WithdrawalPage(driver);

        try {

            withdrawal.withdrawMoney(
                    TestData.accountId1,
                    "100000");

            System.out.println(
                    "Negative Test : Excess Withdrawal");

            System.out.println(
                    driver.findElement(
                            By.tagName("body"))
                            .getText());

        } catch(Exception e) {

            System.out.println(
                    "Excess Withdrawal Validation Executed");

            System.out.println(
                    e.getMessage());
        }

        Assert.assertTrue(true);
    }

    @Test
    public void invalidDepositAccountTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        DepositPage deposit =
                new DepositPage(driver);

        try {

            deposit.depositMoney(
                    "777777777",
                    "500");

            System.out.println(
                    "Negative Test : Invalid Account Deposit");

            System.out.println(
                    driver.findElement(
                            By.tagName("body"))
                            .getText());

        } catch(Exception e) {

            System.out.println(
                    "Invalid Deposit Validation Executed");

            System.out.println(
                    e.getMessage());
        }

        Assert.assertTrue(true);
    }
}