package assignment3task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Driver class
class Driver1 {
    private String name;
    private double distance;

    public Driver1(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() { return name; }
    public double getDistance() { return distance; }
}

// Iterator for drivers
class DriverIterator implements Iterator<Driver1> {
    private List<Driver1> drivers;
    private int position = 0;

    public DriverIterator(List<Driver1> drivers) {
        this.drivers = drivers;
    }

    @Override
    public boolean hasNext() {
        return position < drivers.size();
    }

    @Override
    public Driver1 next() {
        return drivers.get(position++);
    }
}

// Test the iterator
public class Main {
    public static void main(String[] args) {
        List<Driver1> drivers = new ArrayList<>();
        drivers.add(new Driver1("Alice", 2.5));
        drivers.add(new Driver1("Bob", 1.2));
        drivers.add(new Driver1("Charlie", 3.0));

        DriverIterator iterator = new DriverIterator(drivers);

        System.out.println("Available drivers:");
        while (iterator.hasNext()) {
            Driver1 driver = iterator.next();
            System.out.println(driver.getName() + " - Distance: " + driver.getDistance() + " km");
        }
    }
}
