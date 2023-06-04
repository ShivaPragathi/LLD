import api.ATMController;
import exceptions.*;
import models.Account;
import models.AccountType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.ATMService;
import services.BankService;
import services.UserService;

import java.util.HashMap;
import java.util.Map;

public class TestATMController {

    private static Map<String, Account> accountsMap = new HashMap<>();
    private static BankService bankService;
    private static ATMService atmService;
    private static UserService userService;

    @BeforeClass
    public static void setUp() throws UserAlreadyExistsException {
        bankService = new BankService();
        createAccounts(bankService);
        atmService = new ATMService(bankService);
        userService = new UserService();
    }

    @Test
    public void testATMTransactions() throws UserNotFoundException, UserNotValidException, DailyLimitReachedException, AmountInsufficientException, AccountDoesNotExist {
        ATMController atmController = new ATMController(userService, atmService, bankService);
        atmController.enquireBalance("A");
        atmController.deposit(2000,"A");
        atmController.enquireBalance("A");
        atmController.enquireBalance("B");
        String srcAccNo = bankService.getAccountNo("A");
        String destAccNo = bankService.getAccountNo("B");
        atmController.fundsTransfer(srcAccNo, destAccNo, "A", 500);
        atmController.enquireBalance("A");
        atmController.enquireBalance("B");
        atmController.withDraw( 200,"B");
        atmController.enquireBalance("B");
        atmController.withDraw( 1100,"B");
        atmController.enquireBalance("B");
        boolean thrown = false;
        try {
            atmController.withDraw( 3000,"B");
        } catch (AmountInsufficientException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown);
       // atmController.withDraw( 3000,"B");
    }

    private static void createAccounts(BankService bankService) throws UserAlreadyExistsException {
        accountsMap.put("A", bankService.register("A","xyz@gmail.com", null, "Hyderabad",
                "9876543210", AccountType.SAVINGS, "HDFC", 10000));
        accountsMap.put("B", bankService.register("B","wxyz@gmail.com", null, "Hyderabad",
                "9876543210", AccountType.SAVINGS, "HDFC", 1000));
        accountsMap.put("C", bankService.register("C","vwxyz@gmail.com", null, "Hyderabad",
                "9876543210", AccountType.SAVINGS, "ICICI", 5000));
        accountsMap.put("D", bankService.register("D","uvwxyz@gmail.com", null, "Hyderabad",
                "9876543210", AccountType.SAVINGS, "SBI", 2000));
    }
}
