package assignment2;

public class Client {
    public static void main(String[] args) {
        Passenger passenger = new Passenger();
        Driver driver = new Driver("Sponge Bob");
        Car car = new Car("Porshe 911");

        CarSharing carSharing = new CarSharing(car);
        TaxiService taxiService = new CarSharingAdapter(carSharing, driver);

        taxiService.requestTaxi(passenger);
    }
}