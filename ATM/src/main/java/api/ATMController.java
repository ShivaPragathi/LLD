package api;

import exceptions.*;
import services.ATMService;
import services.BankService;
import services.UserService;

import java.util.Map;

public class ATMController {

    private UserService userService;
    private BankService bankService;
    private ATMService atmService;

    public ATMController(UserService userService, ATMService atmService, BankService bankService) {
        this.userService = userService;
        this.bankService = bankService;
        this.atmService = atmService;
    }

    public void deposit(float amt, String user) throws UserNotFoundException, UserNotValidException {
        userService.validateCustomer(user);
        double balance = atmService.deposit(amt, user);
        System.out.println("Amount deposited. Current balance - "+balance);
    }

    public void withDraw(double amt, String user) throws UserNotFoundException, UserNotValidException, AmountInsufficientException, DailyLimitReachedException {
        userService.validateCustomer(user);
        Map<Integer, Integer> amtMap = atmService.withDraw(amt, user);
        System.out.println("No. of thousands - " + amtMap.get(1000));
        System.out.println("No. of five hundreds - " + amtMap.get(500));
        System.out.println("No. of hundreds - " + amtMap.get(100));
    }

    public void enquireBalance(String user) throws UserNotFoundException, UserNotValidException {
        userService.validateCustomer(user);
        double balance = atmService.enquireBalance(user);
        System.out.println(balance);
    }

    public void fundsTransfer(String srcAcctNo, String destAcctNo, String user, double amt) throws UserNotFoundException, UserNotValidException, AmountInsufficientException, AccountDoesNotExist, DailyLimitReachedException {
        userService.validateCustomer(user);
        atmService.transfer(srcAcctNo, destAcctNo, amt);
        System.out.println();
    }

}
