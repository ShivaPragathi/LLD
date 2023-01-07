import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLot {
    public String parkingLotId;

    public List<Floor> floors;

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void create(String parkingLotId, int floors, int slots) {
        this.parkingLotId = parkingLotId;
        List<Floor> floorList = new ArrayList<>();
        for (int i = 1; i <= floors; i++) {
            Floor floor = new Floor(slots);
            floor.setFloor_no(i);
            floorList.add(floor);
        }
        this.setFloors(floorList);
        System.out.println("Created parking lot with "+floors+" floors and "+slots+" slots per floor");
    }

    public void display(String displayItem, String vehicleType) {
        //sorting
        for (int i = 1; i <= floors.size(); i++) {
            Floor floor = floors.get(i - 1);
            if (displayItem.equals("free_count"))
                System.out.println("No. of free slots for " + vehicleType + " on Floor " + i + ": " + floor.freeSlots.get(vehicleType).size());
            else if (displayItem.equals("free_slots")) {
                String disp = "Free slots for " + vehicleType + " on Floor " + i + ": ";
                System.out.print(disp);
                floor.freeSlots.get(vehicleType).stream().map(p -> p.getSlot_no()).forEach(p -> System.out.print(p + ","));
                System.out.println();
            }
            else {
                if(floor.occupiedSlots.get(vehicleType).stream().findAny().isPresent())
                System.out.println("Occupied slots for " + vehicleType + " on Floor " + i + ": " + floor.occupiedSlots.get(vehicleType).stream().map(p -> p.getSlot_no()));
            }
        }
    }

    public void park(String vehicleType, String reg_no, String color) {
        Vehicle vehicle = new Vehicle(vehicleType, reg_no, color);
        String ticketId = getAvailableSlot(vehicle);
        if (!ticketId.isEmpty())
            System.out.println("Parked vehicle. Ticket ID: " + ticketId);
        else
            System.out.println("Parking Lot Full");
    }

    public void unpark(String ticketId) {
        List<String> params = Arrays.asList(ticketId.split("_"));
        int floor_no = Integer.valueOf(params.get(1));
        int slot_no = Integer.valueOf(params.get(2));
        Slot slot = this.getFloors().get(floor_no).getSlots().get(slot_no);
        if (slot.getFilled() && slot.getVehicle().getRegNo().equals(params.get(0)))
            System.out.println("Unparked vehicle with Registration Number: " + slot.getVehicle().getRegNo() + " and Color: " + slot.getVehicle().getColor());
        else
            System.out.println("Invalid ticket");
        slot.setFilled(false);
        this.getFloors().get(floor_no).freeSlots.get(slot.getVehicleType()).add(slot);
        this.getFloors().get(floor_no).occupiedSlots.get(slot.getVehicleType()).remove(slot);
    }

    private String getAvailableSlot(Vehicle vehicle) {
        String ticketId = "";
        List<Floor> floorList = this.getFloors();
        String vehicleType = vehicle.getVehicleType();
        for (Floor floor : floorList) {
            if (!floor.freeSlots.get(vehicleType).isEmpty()) {
                Slot freeSlot = floor.freeSlots.get(vehicleType).get(0);
                ticketId = _buildTicket(floor.getFloor_no(), freeSlot.getSlot_no());
                floor.freeSlots.get(vehicleType).remove(0);
                floor.occupiedSlots.get(vehicleType).add(freeSlot);
                freeSlot.setFilled(true);
                break;
            }
        }
        return ticketId;
    }

    private String _buildTicket(int floor, int slot_no) {
        String ticketId = this.parkingLotId + "_" + String.valueOf(floor) + "_" + String.valueOf(slot_no);
        return ticketId;
    }
}
