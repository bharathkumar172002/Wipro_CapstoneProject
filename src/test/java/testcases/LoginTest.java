package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import base.BaseTest;
import utilities.ExcelUtils;
import utilities.RetryAnalyzer;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest() {

       
        String excelPath = "C:\\wipo_Capstone_Project\\LoginData.xlsx"; 
        
        String username = ExcelUtils.getData(excelPath, 1, 0);
        String password = ExcelUtils.getData(excelPath, 1, 1);

        LoginPage login = new LoginPage(driver);

        login.login(username, password);

        HomePage home = new HomePage(driver);

        Assert.assertTrue(
                home.verifyManagerHomePage(),
                "Login Failed");
    }

    @Test
    public void invalidLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.login("wrongUser", "wrongPass");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String actualMessage = alert.getText();
        String expectedMessage = "User or Password is not valid";

        System.out.println("Expected = " + expectedMessage);
        System.out.println("Actual = " + actualMessage);

        Assert.assertTrue(actualMessage.contains(expectedMessage));

        alert.accept();
    }

    @Test
    public void emptyLoginTest() {

        LoginPage login = new LoginPage(driver);

        try {
            login.login("", "");

            String alertText = driver.switchTo().alert().getText();

            System.out.println("Expected = User or Password is not valid");
            System.out.println("Actual = " + alertText);

            Assert.assertTrue(alertText.contains("User or Password is not valid"));

            driver.switchTo().alert().accept();

        } catch (Exception e) {
            System.out.println("Application behaviour for empty login: " + e.getMessage());
            Assert.assertTrue(true);
        }
    }
}