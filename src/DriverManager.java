public class DriverManager {
    private static DriverManager instance;

    private DriverManager() {
    }

    public String findNearestDriver(String location) {
        System.out.println("Nearest driver found: " + "Driver1");
        return "Driver1";
    }
}
