package utilities;

public class TestData {

    // ---------------------------------------------------------
    // TEST DATA FIELDS
    // ---------------------------------------------------------
    public static String customerId;
    public static String accountId1;
    public static String accountId2;
    
    public static int account1Balance = 5000;
    public static int account2Balance = 5000;

    // ---------------------------------------------------------
    // RESET METHOD
    // ---------------------------------------------------------
    public static void resetBalances() {
        account1Balance = 5000;
        account2Balance = 5000;
    }
}