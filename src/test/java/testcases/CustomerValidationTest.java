package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestData;

public class CustomerValidationTest {

    // =========================================================================
    // TEST METHODS
    // =========================================================================

    @Test(description = "Verify that the Customer ID is generated and not null")
    public void validateCustomerId() {
        
      
        String customerId = TestData.customerId;
        
        
        System.out.println(">>> VALIDATION: Customer ID = " + customerId);
        
    
        Assert.assertNotNull(customerId, "Customer ID was null, validation failed!");
    }
}