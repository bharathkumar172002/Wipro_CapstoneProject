package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.TestData;
import utilities.WaitUtils;

public class NewAccountPage {

    WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By newAccountLink = By.linkText("New Account");

    By customerId = By.name("cusid");

    By accountType =
            By.name("selaccount");

    By initialDeposit =
            By.name("inideposit");

    By submitBtn = By.name("button2");

    public void createAccount(String custId) {

    	WaitUtils.waitForElement(
    	        driver,
    	        newAccountLink)
    	        .click();

        driver.findElement(customerId)
                .sendKeys(custId);

        driver.findElement(accountType)
                .sendKeys("Savings");

        driver.findElement(initialDeposit)
                .sendKeys("3000");

        WaitUtils.waitForElement(
                driver,
                submitBtn)
                .click();
        String accountId =
                driver.findElement(
                        By.xpath("//td[text()='Account ID']/following-sibling::td"))
                        .getText();
        if(TestData.accountId1 == null) {

            TestData.accountId1 = accountId;

        } else {

            TestData.accountId2 = accountId;
        }
        System.out.println(
                "Generated Account ID = "
                        + accountId);

        
    }
}