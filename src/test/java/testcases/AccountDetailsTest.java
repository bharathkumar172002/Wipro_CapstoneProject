package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.TestData;

public class AccountDetailsTest {

    @Test
    public void verifyAccountDetails() {

        System.out.println(
                "Customer ID = "
                + TestData.customerId);

        System.out.println(
                "Account 1 = "
                + TestData.accountId1);

        System.out.println(
                "Account 2 = "
                + TestData.accountId2);

        Assert.assertNotNull(
                TestData.accountId1);

        Assert.assertNotNull(
                TestData.accountId2);
    }
}