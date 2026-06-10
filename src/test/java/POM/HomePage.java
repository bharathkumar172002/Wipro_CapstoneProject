package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By managerText =
            By.xpath("//td[contains(text(),'Manger Id')]");

    public boolean verifyManagerHomePage() {

        return driver.findElement(managerText)
                     .isDisplayed();
    }
}