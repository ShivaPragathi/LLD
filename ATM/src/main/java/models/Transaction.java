package models;

import java.util.Date;

public class Transaction {
    private final String transactionId;
    private final Date transactionDate;
    private final TransactionStatus status;
    private final String accountNo;

    public Transaction(String transactionId, Date transactionDate, TransactionStatus status, String accountNo) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.status = status;
        this.accountNo = accountNo;
    }
}
