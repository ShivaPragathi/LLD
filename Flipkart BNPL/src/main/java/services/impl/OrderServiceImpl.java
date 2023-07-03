package services.impl;

import exceptions.UserNotFoundException;
import model.Due;
import model.Inventory;
import model.Order;
import model.User;
import model.enums.DueStatus;
import model.enums.PaymentMode;
import services.InventoryService;
import services.OrderService;
import services.UserService;
import util.BnplUtil;

import java.util.*;

public class OrderServiceImpl implements OrderService {

    public static OrderService INSTANCE = new OrderServiceImpl();
    InventoryService inventoryService = InventoryServiceImpl.INSTANCE;
    UserService userService = UserServiceImpl.INSTANCE;
    private Map<String, Order> orderMap = new HashMap<>();
    private Map<String, List<Order>> userOrders = new HashMap<>();


    @Override
    public void placeOrder(String user, List<String> itemDetails, PaymentMode paymentMethod, String purchaseDate) throws UserNotFoundException {
        Order order = new Order();
        User user1 = userService.getUser(user);
        order.setOrderedByUser(user1);
        order.setPurchaseDate(new Date(purchaseDate));
        order.setOrderID(BnplUtil.generateNewId());
        int cost = 0;
        Map<String, Integer> itemMap = new HashMap<>();
        for(String item : itemDetails) {
            String[] itemAttr = item.split(",");
            String itemName = itemAttr[0];
            int quantity = Integer.parseInt(itemAttr[1]);
            itemMap.put(itemName,quantity);
            Inventory inventory = inventoryService.getInventory(itemName);
            inventoryService.removeInventory(inventory.name, inventory.quantity-quantity);
            cost += inventory.price*quantity;
        }
        if(paymentMethod.equals(PaymentMode.BNPL) && user1.BNPLCredit<cost) {
            System.out.println("Credit limit not sufficient");
        }
        order.setOrderDetails(itemMap);
        order.setOrderCost(cost);
        order.setPaymentMethod(paymentMethod);

        if(paymentMethod.equals(PaymentMode.BNPL)) {
            user1.BNPLCredit -= cost;
            Due due = new Due();
            due.setAmount(cost);
            due.setStatus(DueStatus.PENDING);
            order.setOrderDue(due);
        }
        orderMap.put(order.orderID, order);
        List<Order> userOrders1 = userOrders.get(user);
        if(userOrders1==null) {
            userOrders1 = new ArrayList<>();
        }
        userOrders1.add(order);
        userOrders.put(user, userOrders1);
    }

    @Override
    public List<Order> orderHistory(String user) {
        return userOrders.get(user);
    }

    @Override
    public Order getOrder(String orderId) {
       return orderMap.get(orderId);
    }
}
