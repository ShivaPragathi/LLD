package services;

import exceptions.AccountDoesNotExist;
import exceptions.UserAlreadyExistsException;
import models.Account;
import models.AccountType;
import models.Transaction;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankService {

    static Map<String, Account> accountMap = new HashMap<>(); // account no - account
    static Map<String, String> userAccountMap = new HashMap<>(); //username - account
    static Map<String, String> IFSCMap;
    private UserService userService = new UserService();

    static {
        IFSCMap = new HashMap<>();
        IFSCMap.put("HDFC","HDFC0001");
        IFSCMap.put("ICICI","ICICI0001");
        IFSCMap.put("SBI","SBI0001");
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

    public Map<String, String> getUserAccountMap() {
        return userAccountMap;
    }

    public Account getAccount(String accNo) throws AccountDoesNotExist {
        if(!accountMap.containsKey(accNo)) {
            throw new AccountDoesNotExist("Account with account number " + accNo + " does not exist");
        }
        return accountMap.get(accNo);
    }

    public String getAccountNo(String user) {
        return userAccountMap.get(user);
    }

    public Account createAccount(AccountType accountType, String bankName, double openingAmt) {
        String accNo = generateAccNo();
        Account account = new Account(accNo,  accountType, bankName, getIFSCCode(bankName), openingAmt, new ArrayList<Transaction>());
        return account;
    }

    public Account register(String name, String email, String imageUrl, String address, String phoneNo, AccountType accountType, String bankName, double openingAmt) throws UserAlreadyExistsException {
        User user = userService.createUser(name, email, imageUrl, address, phoneNo);
        Account account = createAccount(accountType, bankName, openingAmt);
        accountMap.put(account.getAccountNumber(), account);
        userAccountMap.put(name,account.getAccountNumber());
        return account;
    }

    private String generateAccNo() {
       return UUID.randomUUID().toString();
    }

    private String getIFSCCode(String bankName) {
        return IFSCMap.get(bankName);
    }

}
