import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {

    public Map<String, List<Slot>> freeSlots = new HashMap<>();
    public Map<String, List<Slot>> occupiedSlots = new HashMap<>();
    public List<Slot> slots;
    public int floor_no;

    public Floor(int no_of_slots) {
        List<Slot> newSlots = new ArrayList<>();
        for (int i = 1; i <= no_of_slots; i++) {
            Slot slot = new Slot(i);
            newSlots.add(slot);
        }
        this.setSlots(newSlots);
        freeSlots.put("TRUCK", new ArrayList<>());
        freeSlots.put("BIKE", new ArrayList<>());
        freeSlots.put("CAR", new ArrayList<>());
        for (int i = 0; i < no_of_slots; i++) {
            if (i == 0)
                freeSlots.get("TRUCK").add(slots.get(i));
            else if (i == 1 || i == 2)
                freeSlots.get("BIKE").add(slots.get(i));
            else
                freeSlots.get("CAR").add(slots.get(i));
        }
        occupiedSlots.put("TRUCK", new ArrayList<>());
        occupiedSlots.put("BIKE", new ArrayList<>());
        occupiedSlots.put("CAR", new ArrayList<>());
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public int getFloor_no() {
        return floor_no;
    }

    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }
}
