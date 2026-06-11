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

    @Test
    public void createCustomerTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        CustomerPage customer =
                new CustomerPage(driver);

        customer.addCustomer();
        WaitUtils.waitForText(
                driver,
                "Customer Registered Successfully");

        Assert.assertTrue(
                driver.getPageSource()
                      .contains(
                              "Customer Registered Successfully"));
   
        System.out.println(
                "Customer ID = "
                + TestData.customerId);

        Assert.assertNotNull(
                TestData.customerId);
        
    }
}