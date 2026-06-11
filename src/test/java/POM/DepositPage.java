package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class DepositPage {

    WebDriver driver;

    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }

    By depositLink = By.linkText("Deposit");
    By accountNo =By.name("accountno");
   By amount = By.name("ammount");
   By description =By.name("desc");
   By submit =By.name("AccSubmit");
             
    public void depositMoney( String accNo, String amt) {
    		
    	WaitUtils.waitForElement( driver, depositLink)
        .click();
    	driver.findElement(accountNo)
                .sendKeys(accNo);

        driver.findElement(amount)
                .sendKeys(amt);

        driver.findElement(description)
                .sendKeys("Deposit");

        WaitUtils.waitForElement(
                driver,
                submit)
                .click();
    }
}