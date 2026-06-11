package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestData;
import utilities.WaitUtils;

public class CustomerPage {

    WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    By newCustomerLink = By.linkText("New Customer");

    By customerName = By.name("name");
    By gender = By.xpath("//input[@value='m']");
    By dob = By.name("dob");
    By address = By.name("addr");
    By city = By.name("city");
    By state = By.name("state");
    By pin = By.name("pinno");
    By mobile = By.name("telephoneno");
    By email = By.name("emailid");
    By password = By.name("password");

    By submitBtn = By.name("sub");

    public void addCustomer() {
    WaitUtils.waitForElement(driver, newCustomerLink).click();
    							
    	       
//*********************************************************************************************
  //*********************************************************************************************
    	driver.findElement(customerName) .sendKeys("Bharath kumar");

              

        driver.findElement(gender).click();

        driver.findElement(dob) .sendKeys("01-07-2002");
               

        driver.findElement(address) .sendKeys("Delhi");
               

        driver.findElement(city) .sendKeys("Greater Noida");

               

        driver.findElement(state).sendKeys("Delhi");
              

        driver.findElement(pin) .sendKeys("201306");
             

        driver.findElement(mobile).sendKeys("7295015459");
              

        driver.findElement(email) .sendKeys("bharath"
             
                        + System.currentTimeMillis()
                        + "@gmail.com");

        driver.findElement(password)
                .sendKeys("Bharath123");

        WaitUtils.waitForElement(
                driver,
                submitBtn)
                .click();
        
        String customerId =
        		driver.findElement(
        		By.xpath("//td[text()='Customer ID']/following-sibling::td"))
        		.getText();

        		TestData.customerId = customerId;

        		System.out.println(
        		"Generated Customer ID = "
        		+ customerId);
    }
}