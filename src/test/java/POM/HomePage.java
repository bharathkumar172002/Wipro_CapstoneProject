package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    
    private WebDriver driver;

    // =========================================================================
    //LOCATORS
    // =========================================================================
    private By managerText = By.xpath("//td[contains(text(),'Manger Id')]");

    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================================
    // ACTIONS
    // =========================================================================
    public boolean verifyManagerHomePage() {
        return driver.findElement(managerText).isDisplayed();
    }
}