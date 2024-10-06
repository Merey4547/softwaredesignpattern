package assignment2;

public class CarSharing {
    private Car car;

    public CarSharing(Car car) {
        this.car = car;
    }

    public void rentFreeCar(Driver driver) {
        driver.addCar(car);
    }
}