import java.util.*;

class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private boolean available;
    public int[] currentLocation;

    public Driver(String name, String gender, int age, String vehicleDetails, int[] currentLocation, boolean available) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.available = available;
        this.currentLocation = currentLocation;
    }

    // Getters and setters

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return name + " (" + vehicleDetails + ")";
    }
}