package services;

import exceptions.UserNotFoundException;
import model.Order;
import model.enums.PaymentMode;

import java.util.List;

public interface OrderService {
    
    void placeOrder(String user, List<String> itemDetails, PaymentMode paymentMethod, String purchaseDate) throws UserNotFoundException;

    List<Order> orderHistory(String user);

    Order getOrder(String orderId);
}
