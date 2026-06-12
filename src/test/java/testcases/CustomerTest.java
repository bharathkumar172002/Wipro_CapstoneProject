package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.CustomerPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.WaitUtils;

public class CustomerTest extends BaseTest {

    // =========================================================================
    // TEST CASES
    // =========================================================================

    @Test
    public void createCustomerTest() {
        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage(driver);
        CustomerPage customer = new CustomerPage(driver);

        // Login
        login.login(config.getUsername(), config.getPassword());

        // Perform Action
        customer.addCustomer();
        WaitUtils.waitForText(driver, "Customer Registered Successfully");

        // Verification
        Assert.assertTrue(driver.getPageSource().contains("Customer Registered Successfully"));
        
        System.out.println("Customer ID = " + TestData.customerId);
        Assert.assertNotNull(TestData.customerId);
    }
}