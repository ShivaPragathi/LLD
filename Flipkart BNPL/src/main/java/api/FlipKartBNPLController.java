package api;

import exceptions.InvalidSortParamException;
import exceptions.UserNotFoundException;
import model.Order;
import model.User;
import model.enums.PaymentMode;
import services.InventoryService;
import services.OrderService;
import services.UserService;
import services.impl.InventoryServiceImpl;
import services.impl.OrderServiceImpl;
import services.impl.UserServiceImpl;

import java.util.List;

public class FlipKartBNPLController {

    InventoryService inventoryService = InventoryServiceImpl.INSTANCE;
    UserService userService = UserServiceImpl.INSTANCE;
    OrderService orderService = OrderServiceImpl.INSTANCE;

    public void seed_inventory(List<String> inventoryDetails) {
        inventoryService.seedInventory(inventoryDetails);
    }

    public void view_inventory(String sortParam) throws InvalidSortParamException {
        List<String> inventoryList = inventoryService.viewInventory(sortParam);
        for(String inventory : inventoryList) {
            System.out.println(inventory);
        }
    }

    public void register_user(String name, String email, String phoneNo, int BNPLCredit) {
        userService.registerUser(name, email, phoneNo, BNPLCredit);
    }

    public void buy(String user, List<String> itemDetails, PaymentMode paymentMethod, String purchaseDate) throws UserNotFoundException {
        orderService.placeOrder(user, itemDetails, paymentMethod, purchaseDate);
    }

    public void clear_dues(String user, List<String> orders, String clearingDate) {
        userService.clearDues(user, orders, clearingDate);
    }

    public void viewDues(String user, String duesTillDate) {
        userService.viewDues(user, duesTillDate);
    }

    public void order_status(String user) throws UserNotFoundException {
        List<Order> orders = orderService.orderHistory(user);
        User customer = userService.getUser(user);
        System.out.println(customer.getBNPLCredit());
        orders.stream().forEach(o -> System.out.println(o.getOrderID()+ " " + o.getPurchaseDate() + " " + o.getPaymentMethod() + " "+ o.getOrderDetails() +" "+ o.getOrderCost()));
    }

    public void getUser(String userName) throws UserNotFoundException {
        User user = userService.getUser(userName);
        System.out.println(user.name + " " + user.BNPLCredit);
    }
}
