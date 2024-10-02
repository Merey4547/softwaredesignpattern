public static void main(String[] args) {
    DriverManager driverManager = DriverManager.getInstance();
    String driver = driverManager.findNearestDriver("Location A");


    Driver originalDriver = new Driver("John Doe", "Toyota Prius");
    System.out.println("Original Driver: " + originalDriver.getName());
    System.out.println("Original Driver’s car: " + originalDriver.getCarModel());

    Driver clonedDriver = originalDriver.clone();
    clonedDriver.setName("Jane Doe");
    System.out.println("Cloned Driver: " + clonedDriver.getName());
    System.out.println("Cloned Driver’s car: " + clonedDriver.getCarModel());

        Factory factory = new StandardTaxiFactory();
        Taxi taxi = factory.createTaxi("Daniele", "XYZ12345");
        taxi.takePassenger("John");

        factory = new PremiumTaxiFactory();
        taxi = factory.createTaxi("Daniele", "XYZ12345");
        taxi.takePassenger("Doe");
    }
