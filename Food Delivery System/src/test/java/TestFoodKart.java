import Exceptions.InvalidSortParamException;
import Exceptions.UserNotFoundException;
import api.FoodKartController;
import org.junit.Test;

public class TestFoodKart {

    FoodKartController foodKartController = new FoodKartController();

    @Test
    public void testFoodController() throws UserNotFoundException, InvalidSortParamException {
        foodKartController.register_user("Pralove", "M", "phoneNumber-1", "HSR");
        foodKartController.register_user("Nitesh", "M", "phoneNumber-2", "BTM");
        foodKartController.register_user("Vatsal", "M", "phoneNumber-3", "BTM");
        foodKartController.login_user("phoneNumber-1");

        foodKartController.register_restaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);
        foodKartController.register_restaurant("Food Court-2", "BTM", "Burger", 120, 3);

        foodKartController.login_user("phoneNumber-2");
        foodKartController.register_restaurant("Food Court-3", "HSR", "SI Thali", 150, 1);

        foodKartController.login_user("phoneNumber-3");
        foodKartController.show_restaurant("price");

        foodKartController.place_order("Food Court-1", 2);
        foodKartController.place_order("Food Court-2", 7);

        foodKartController.create_review("Food Court-2",3,"Good Food");
        foodKartController.create_review("Food Court-1",5,"Nice Food");

        foodKartController.show_restaurant("rating");
        foodKartController.login_user("phoneNumber-1");
        foodKartController.update_quantity("Food Court-2",5);
        foodKartController.update_location("Food Court-2","BTM/HSR");

        foodKartController.order_history("phoneNumber-3");
    }

}
