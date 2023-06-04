package services;

import exceptions.AccountDoesNotExist;
import exceptions.AmountInsufficientException;
import exceptions.DailyLimitReachedException;
import models.ATM;
import models.Account;

import java.util.HashMap;
import java.util.Map;

public class ATMService {

    private BankService bankService;
    Map<String, Account> userAccountMap = new HashMap<>();
    private double DAILY_WITHDRAW_LIMIT = 10000;
    private double DAILY_TRANSFER_LIMIT = 20000;

    ATM atm = new ATM();

    public ATMService(BankService bankService) {
        Map<String, Account> accountMap = bankService.getAccountMap();
        Map<String, String> userMap = bankService.getUserAccountMap();
        for(String user : userMap.keySet()) {
            userAccountMap.put(user,accountMap.get(userMap.get(user)));
        }
        this.bankService = bankService;
    }

    public double deposit(float amt, String user) {
        Account account = userAccountMap.get(user);
        account.setBalance(account.getBalance()+amt);
        return account.getBalance();
    }

    public Map<Integer, Integer> withDraw(double amt, String user) throws AmountInsufficientException, DailyLimitReachedException {
        validateWithDraw(amt, user);
        Account account = userAccountMap.get(user);
        account.setBalance(account.getBalance()-amt);
        Map<Integer, Integer>  amtMap = withDrawFromATM(amt);
        return amtMap;
    }

    public double enquireBalance(String user) {
        Account account = userAccountMap.get(user);
        return account.getBalance();
    }

    public boolean transfer(String srcAccNo, String destAccNo, double amt) throws AmountInsufficientException, AccountDoesNotExist, DailyLimitReachedException {
        if(amt>DAILY_TRANSFER_LIMIT){
            throw new DailyLimitReachedException("Daily limit to transfer reached");
        }
        Account srcAccount = bankService.getAccount(srcAccNo);
        Account destAccount = bankService.getAccount(destAccNo);
        if(srcAccount.getBalance()<amt) {
            throw new AmountInsufficientException("Amount in source account is insufficient to transfer");
        }
        srcAccount.setBalance(srcAccount.getBalance()-amt);
        destAccount.setBalance(destAccount.getBalance()+amt);
        return true;
    }

    private void validateWithDraw(double amt, String user) throws AmountInsufficientException, DailyLimitReachedException {
        if(atm.getBalance()<amt) {
            throw new AmountInsufficientException("Amount in atm is insufficient to withdraw");
        }
        if(amt>DAILY_WITHDRAW_LIMIT){
            throw new DailyLimitReachedException("Daily limit to withdraw reached");
        }
        Account account = userAccountMap.get(user);
        if(account.getBalance()<amt) {
            throw new AmountInsufficientException("Amount in your account is insufficient to withdraw");
        }
    }

    private Map<Integer, Integer> withDrawFromATM(double amt) throws AmountInsufficientException {
        Map<Integer, Integer> notesMap = new HashMap<>();
        initNotesMap(notesMap);
        atm.setBalance(atm.getBalance()-amt);
        if(amt>=1000){
           Integer thousands = atm.getCurrencyMap().get(1000);
           int noRequiredThousands = (int) (amt/1000);
           int noOfThousandsDeducted = Math.min(thousands, noRequiredThousands);
           atm.getCurrencyMap().replace(1000, Math.abs(thousands-noRequiredThousands));
           notesMap.replace(1000, noOfThousandsDeducted);
           amt = amt - noOfThousandsDeducted*1000;
        }
        if(amt>=500){
            Integer fiveHundreds = atm.getCurrencyMap().get(500);
            int noRequiredFiveHundreds = (int) (amt/500);
            int noOfFiveHundredsDeducted = Math.min(fiveHundreds, noRequiredFiveHundreds);
            atm.getCurrencyMap().replace(500, Math.abs(fiveHundreds-noRequiredFiveHundreds));
            notesMap.replace(500, noOfFiveHundredsDeducted);
            amt = amt - noOfFiveHundredsDeducted*500;
        }
        if(amt>=100){
            Integer hundreds = atm.getCurrencyMap().get(100);
            int noRequiredHundreds = (int) (amt/100);
            int noOfHundredsDeducted = Math.min(hundreds, noRequiredHundreds);
            atm.getCurrencyMap().replace(100, Math.abs(hundreds-noRequiredHundreds));
            notesMap.replace(100, noOfHundredsDeducted);
            amt = amt - noOfHundredsDeducted*100;
        }
        if(amt>0) {
            throw new AmountInsufficientException("This amount cannot be withdrawn");
        }
        return notesMap;
    }

    private void initNotesMap(Map<Integer, Integer> notesMap) {
        notesMap.put(1000,0);
        notesMap.put(500,0);
        notesMap.put(100,0);
    }
}
