public static void main(String[] args) {
    DriverManager driverManager = DriverManager.getInstance();
    String driver = driverManager.findNearestDriver("Location A");
}
