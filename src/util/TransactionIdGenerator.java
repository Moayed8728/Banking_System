package util;

/**
 * Creates transaction and loan IDs using the same timestamp style as the original project.
 */
public class TransactionIdGenerator {

    private TransactionIdGenerator() {
    }

    public static String transactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    public static String transactionIdPlusOne() {
        return "TXN" + (System.currentTimeMillis() + 1);
    }

    public static String loanId() {
        return "LN" + System.currentTimeMillis();
    }
}
