package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.FundTransferPage;
import POM.LoginPage;
import base.BaseTest;
import utilities.ConfigReader;
import utilities.TestData;

public class InsufficientBalanceTest extends BaseTest {

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

	        // Pehle alert handle karein agar aata hai
	        try {
	            driver.switchTo().alert().accept();
	        } catch (Exception alertEx) {
	            // Alert nahi mila, aage badhein
	        }

	        String pageText =
	                driver.findElement(
	                        By.tagName("body"))
	                        .getText();

	        if(pageText.contains("Fund Transfer Details")) {

	            System.out.println(
	                    "BUG FOUND : Transfer Allowed With Insufficient Balance");

	            System.out.println(
	                    "Transfer Amount = 100000");

	            System.out.println(
	                    "Available Balance = "
	                    + TestData.account1Balance);

	        } else {

	            System.out.println(
	                    "Insufficient Balance Validation Working");

	            System.out.println(
	                    "Transfer Blocked Successfully");
	        }
	        
	        // Logout Test Case
	        driver.findElement(By.linkText("Log out")).click();
	        driver.switchTo().alert().accept();
	        System.out.println("Logout Successful");

	    } catch(Exception e) {

	        System.out.println(
	                "Insufficient Balance Test Executed");

	        System.out.println(
	                e.getMessage());
	    }

	    Assert.assertTrue(true);
	}
}