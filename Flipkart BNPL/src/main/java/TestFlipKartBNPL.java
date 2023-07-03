import api.FlipKartBNPLController;
import exceptions.InvalidSortParamException;
import exceptions.UserNotFoundException;
import model.enums.PaymentMode;
//import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestFlipKartBNPL {

  //  FlipKartBNPLController flipKartBNPLController = new FlipKartBNPLController();

    public static void main(String[] args) throws InvalidSortParamException, UserNotFoundException {
        FlipKartBNPLController flipKartBNPLController = new FlipKartBNPLController();
        flipKartBNPLController.seed_inventory(Arrays.asList("Shoes 5 200" , "Watch 10 1000", "T-Shirt 14 300"));
        flipKartBNPLController.view_inventory("quantity");
        flipKartBNPLController.register_user("Pragathi", "happy","123456789",10000);
        flipKartBNPLController.getUser("Pragathi");
        List<String> items = Arrays.asList("Shoes,2","Watch,1");
        flipKartBNPLController.buy("Pragathi",items, PaymentMode.BNPL,"20-Oct-2021" );
        flipKartBNPLController.view_inventory("quantity");
        flipKartBNPLController.order_status("Pragathi");

    }
}
