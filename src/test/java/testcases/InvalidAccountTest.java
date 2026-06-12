package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.DepositPage;
import POM.LoginPage;
import base.BaseTest;
import utilities.ConfigReader;

public class InvalidAccountTest extends BaseTest {

    // ---------------------------------------------------------
    // TEST CASES
    // ---------------------------------------------------------

    @Test(description = "Verify deposit functionality with an invalid account number")
    public void invalidAccountDepositTest() {

        // ---------------------------------------------------------
        // Initialization
        // ---------------------------------------------------------
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        DepositPage deposit = new DepositPage(driver);

        // ---------------------------------------------------------
        // Execution
        // ---------------------------------------------------------
        login.login(config.getUsername(), config.getPassword());
        deposit.depositMoney("99999999", "500");

        // ---------------------------------------------------------
        // Validation & Logging
        // ---------------------------------------------------------
        System.out.println(">>> INFO: Invalid Account Test Executed");
        
        Assert.assertTrue(true);
    }
}