public class Slot {
    public int slot_no;
    public String vehicleType;
    public Boolean isFilled;
    public Vehicle vehicle;

    public Slot(int slot_no){
        this.slot_no = slot_no;
        this.isFilled = false;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getFilled() {
        return isFilled;
    }

    public void setFilled(Boolean filled) {
        isFilled = filled;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
