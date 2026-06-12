package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestData;

public class AccountDetailsTest {

    @Test
    public void verifyAccountDetails() {
        // 1. Fetching data
        String acc1 = TestData.accountId1;
        String acc2 = TestData.accountId2;

      
        logAccountDetails();

        // 3. Validation
        Assert.assertNotNull(acc1, "Account ID 1 should not be null");
        Assert.assertNotNull(acc2, "Account ID 2 should not be null");
    }

    private void logAccountDetails() {
        System.out.println("--- Account Verification Report ---");
        System.out.println("Customer ID: " + TestData.customerId);
        System.out.println("Account 1  : " + TestData.accountId1);
        System.out.println("Account 2  : " + TestData.accountId2);
        System.out.println("-----------------------------------");
    }
}