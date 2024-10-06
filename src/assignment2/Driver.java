package assignment2;

public class Driver {
    private String name;
    private Car car;

    public Driver(String name) {
        this.name = name;
    }

    public void addCar(Car car) {
        this.car = car;
        System.out.println("Driver " + name + " has rented a car: " + car.getModel());
    }

    public String getName() {
        return name;
    }
}