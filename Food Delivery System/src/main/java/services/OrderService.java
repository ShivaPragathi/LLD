package services;

import Exceptions.UserNotFoundException;

public interface OrderService {

    void place_order(String restaurantName, int quantity);

    void order_history(String phoneNo) throws UserNotFoundException;
}
