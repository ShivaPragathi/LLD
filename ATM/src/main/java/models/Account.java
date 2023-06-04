package models;

import java.util.List;


public class Account {

    public String accountNumber;
    public AccountType accountType;
    public String bankName;
    public String IFSCcode;
    public double balance;
    public List<Transaction> transactionList;

    public Account() {

    }

    public Account(String accountNumber, AccountType accountType, String bankName, String ifscCode, double balance, List<Transaction> transactionList) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.bankName = bankName;
        this.IFSCcode = ifscCode;
        this.balance = balance;
        this.transactionList = transactionList;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getIFSCcode() {
        return IFSCcode;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setIFSCcode(String IFSCcode) {
        this.IFSCcode = IFSCcode;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
