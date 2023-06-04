package models;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private double balance;
    private Map<Integer, Integer> currencyMap;

    //reserve - 100*50, 500*10, 1000*10 = 5000+5000+10000 = 20000

    //public ATM atmObject = new ATM(); //Singleton: eager initialization

    public ATM() {
        this.balance = 20000.00;
        Map<Integer, Integer> notesMap = new HashMap();
        notesMap.put(100,50);
        notesMap.put(500,10);
        notesMap.put(1000,10);
        this.currencyMap = notesMap;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<Integer, Integer> getCurrencyMap() {
        return currencyMap;
    }

    public void setCurrencyMap(Map<Integer, Integer> currencyMap) {
        this.currencyMap = currencyMap;
    }
}
