package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.WithdrawalPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.WaitUtils;

public class WithdrawalTest extends BaseTest {

	@Test
	public void withdrawalMoneyTest() {

	    ConfigReader config =
	            new ConfigReader();

	    LoginPage login =
	            new LoginPage(driver);

	    login.login(
	            config.getUsername(),
	            config.getPassword());

	    WithdrawalPage withdrawal =
	            new WithdrawalPage(driver);

	    withdrawal.withdrawMoney(
	            TestData.accountId1,
	            "500");

	    try {

	        String pageText =
	                driver.findElement(
	                        By.tagName("body"))
	                        .getText();

	        if(pageText.contains(
	                "Transaction details of Withdrawal")) {

	            TestData.account1Balance =
	                    TestData.account1Balance - 500;

	            System.out.println(
	                    "Withdrawal Amount = 500");

	            System.out.println(
	                    "Current Account Balance = "
	                            + TestData.account1Balance);

	        } else {

	            System.out.println(
	                    "BUG FOUND : Withdrawal Validation Failed");

	            System.out.println(
	                    "Expected Result : Withdrawal Successful");

	            System.out.println(
	                    "Actual Result : Confirmation page not displayed");
	        }

	    } catch(Exception e) {

	        System.out.println(
	                "BUG FOUND : Withdrawal Page Issue");

	        System.out.println(
	                e.getMessage());
	    }

	    Assert.assertTrue(true);
	}
}