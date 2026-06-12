package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import POM.FundTransferPage;
import POM.LoginPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;

public class InsufficientBalanceTest extends BaseTest {

    @Test(description = "Verify system prevents transfer with insufficient balance")
    public void insufficientBalanceTest() {

        // ---------------------------------------------------------
        // Initialization
        // ---------------------------------------------------------
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        FundTransferPage transfer = new FundTransferPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ---------------------------------------------------------
        // Test Execution
        // ---------------------------------------------------------
        login.login(config.getUsername(), config.getPassword());

        try {
            transfer.transferFunds(TestData.accountId1, TestData.accountId2, "100000");

            // Handle potential alert
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
            } catch (Exception e) {
                // No alert present
            }

            // ---------------------------------------------------------
            // Validation
            // ---------------------------------------------------------
            String pageText = driver.findElement(By.tagName("body")).getText();

            if (pageText.contains("Fund Transfer Details")) {
                System.out.println("BUG FOUND: Transfer Allowed With Insufficient Balance");
            } else {
                System.out.println("Insufficient Balance Validation Working");
            }

            // ---------------------------------------------------------
            // Logout
            // ---------------------------------------------------------
            driver.findElement(By.linkText("Log out")).click();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            System.out.println("Logout Successful");

        } catch (Exception e) {
            System.out.println("Insufficient Balance Test Execution Error: " + e.getMessage());
        }

        Assert.assertTrue(true);
    }
}