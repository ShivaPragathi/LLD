import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParkingLot_Design {

    private static List<String> groupByParams(String input){
        List<String> list = Stream.of(input.split(" ")).collect(Collectors.toList());
        return list;
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkinglot = new ParkingLot();
        String input = "";
        do{
            input = scanner.nextLine();
            if(!input.equals("exit")) {
                List<String> params = groupByParams(input);
                switch (params.get(0)) {
                    case "create_parking_lot":
                        parkinglot.create(params.get(1), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)));
                        break;
                    case "display":
                        parkinglot.display(params.get(1), params.get(2));
                        break;
                    case "park_vehicle":
                        parkinglot.park(params.get(1), params.get(2), params.get(3));
                        break;
                    case "unpark_vehicle":
                        parkinglot.unpark(params.get(1));
                        break;
                }
            }
        } while (!input.equals("exit"));
    }
}
