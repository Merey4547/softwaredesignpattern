package assignment2;

public class CarSharingAdapter implements TaxiService {
    private CarSharing carSharing;
    private Driver driver;

    public CarSharingAdapter(CarSharing carSharing, Driver driver) {
        this.carSharing = carSharing;
        this.driver = driver;
    }

    @Override
    public void requestTaxi(Passenger passenger) {
        System.out.println("Processing car sharing request for " + passenger.getName());
        carSharing.rentFreeCar(driver);
    }
}