import java.util.ArrayList;
import java.util.List;

class CabBookingApplication {
    private List<User> users;
    private List<Driver> drivers;

    public CabBookingApplication() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    public void addUser(String name, String gender, int age) {
        users.add(new User(name, gender, age));
    }

    public void addDriver(String name, String gender, int age, String vehicleDetails, int[] currentLocation, boolean available) {
        drivers.add(new Driver(name, gender, age, vehicleDetails, currentLocation, available));
    }

    public List<Driver> findRide(String username, int[] source, int[] destination) {
        User user = getUserByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable() && isDriverInRange(driver, source, destination)) {
                availableDrivers.add(driver);
                System.out.println(driver + " [Available] for " + username);
                break;
            } else if (!driver.isAvailable() && isDriverInRange(driver, source, destination)) {
                System.out.println("No ride found for " + username + " [" + driver + " is set to not available] ");
                availableDrivers.add(driver);
            }
        }

        if (availableDrivers.isEmpty()) {
            System.out.println("No ride found [Since all drivers are more than 5 units away from " + username + "]");
        }
        return availableDrivers;
    }

    private User getUserByUsername(String username) {
        for (User user : users) {
            if (user.toString().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private boolean isDriverInRange(Driver driver, int[] source, int[] destination) {
        int distance = Math.abs(driver.currentLocation[0] - source[0]) + Math.abs(driver.currentLocation[1] - source[1]);
        return distance <= 5; // Assuming 5 units is the maximum distance for a ride
    }
}

