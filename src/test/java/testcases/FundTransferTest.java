package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.FundTransferPage;
import POM.LoginPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.WaitUtils;

public class FundTransferTest
        extends BaseTest {

    @Test
    public void fundTransferTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        System.out.println(
                "From Account = "
                + TestData.accountId1);

        System.out.println(
                "To Account = "
                + TestData.accountId2);

        
        FundTransferPage transfer =
                new FundTransferPage(driver);

        transfer.transferFunds(
                TestData.accountId1,
                TestData.accountId2,
                "200");
        
        TestData.account1Balance =
                TestData.account1Balance - 200;

        TestData.account2Balance =
                TestData.account2Balance + 200;

        System.out.println(
                "Transfer Amount = 200");

        System.out.println(
                "Sender Balance = "
                        + TestData.account1Balance);

        System.out.println(
                "Receiver Balance = "
                        + TestData.account2Balance);
        
        WaitUtils.waitForText(
                driver,
                "Fund Transfer Details");

        Assert.assertTrue(
                driver.getPageSource()
                      .contains(
                              "Fund Transfer Details"));
        
    }
}