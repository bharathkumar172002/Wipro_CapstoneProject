package utilities;

public class TestData {

    // ---------------------------------------------------------
    // TEST DATA FIELDS
    // ---------------------------------------------------------
    public static String customerId;
    public static String accountId1;
    public static String accountId2;
    
    public static int account1Balance = 4000;
    public static int account2Balance = 6000;

    // ---------------------------------------------------------
    // RESET METHOD
    // ---------------------------------------------------------
    public static void resetBalances() {
        account1Balance = 4000;
        account2Balance = 6000;
    }
}