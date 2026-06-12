package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.AccountPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;

public class AccountTest extends BaseTest {

    // =========================================================================
    @Test
    public void createAccountTest() {
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        AccountPage account = new AccountPage(driver);

        login.login(config.getUsername(), config.getPassword());

        account.createAccount(TestData.customerId);
        driver.findElement(By.linkText("New Account")).click();
        account.createAccount(TestData.customerId);

        Assert.assertNotNull(TestData.accountId1);
        Assert.assertNotNull(TestData.accountId2);

        System.out.println("Account 1 = " + TestData.accountId1);
        System.out.println("Account 2 = " + TestData.accountId2);
        System.out.println("Initial Deposit Account 1 = " + TestData.account1Balance);
        System.out.println("Initial Deposit Account 2 = " + TestData.account2Balance);

        Assert.assertTrue(driver.getPageSource().contains("Account Generated Successfully"));
    }
}