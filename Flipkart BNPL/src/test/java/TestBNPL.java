import api.FlipKartBNPLController;
import exceptions.InvalidSortParamException;
import org.junit.Test;

import java.util.Arrays;

public class TestBNPL {



//    @Test
//    public void testBNPLController() throws InvalidSortParamException {
//        flipKartBNPLController.seed_inventory(Arrays.asList("Shoes 5 200" , "Watch 10 1000", "T-Shirt 14 300"));
//        flipKartBNPLController.view_inventory("name");
//    }

    public static void main(String[] args) throws InvalidSortParamException {
        FlipKartBNPLController flipKartBNPLController = new FlipKartBNPLController();
        flipKartBNPLController.seed_inventory(Arrays.asList("Shoes 5 200" , "Watch 10 1000", "T-Shirt 14 300"));
        flipKartBNPLController.view_inventory("name");
    }
}
