import java.util.*;

public class Main {
    public static void main(String[] args) {
        CabBookingApplication cabApp = new CabBookingApplication();

        // Onboard users
        cabApp.addUser("Abhishek", "M", 23);
        cabApp.addUser("Rahul", "M", 29);
        cabApp.addUser("Nandini", "F", 22);

        // Onboard drivers
        cabApp.addDriver("Driver1", "M", 22, "Swift, KA-01-12345", new int[]{16, 3}, false);
        cabApp.addDriver("Driver2", "M", 29, "Swift, KA-01-12345", new int[]{11, 1}, true);
        cabApp.addDriver("Driver3", "M", 24, "Swift, KA-01-12345", new int[]{5, 3}, true);

        // Find rides
        cabApp.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1}); // Output: No ride found
        cabApp.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3}); // Output: Driver2 [Available]
        cabApp.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4}); // Output: No ride found [Driver1 set to not available]
    }
}