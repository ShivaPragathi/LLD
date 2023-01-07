
public class Vehicle {
    public String vehicleType;
    public String color;
    public String regNo;

    public Vehicle(String vehicleType, String color, String regNo){
        this.vehicleType = vehicleType;
        this.color = color;
        this.regNo = regNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}