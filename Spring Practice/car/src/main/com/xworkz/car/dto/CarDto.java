package main.com.xworkz.car.dto;

public class CarDto {
    private String carname;
    private String regnumber;
    private String location;

    public CarDto() {

    }

    @Override
    public String toString() {
        return "CarDto{" +
                "carname='" + carname + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public CarDto(String carname, String regnumber, String location) {
        this.carname = carname;
        this.regnumber = regnumber;
        this.location = location;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
