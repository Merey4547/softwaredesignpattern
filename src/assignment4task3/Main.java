package assignment4task3;

interface PricingStrategy {
    double calculatePrice(double value); // value: километры или минуты
}

class DistanceStrategy implements PricingStrategy {
    public double calculatePrice(double distance) {
        return distance * 10;
    }
}

class TimeStrategy implements PricingStrategy {
    public double calculatePrice(double time) {
        return time * 2;
    }
}

class FixedPriceStrategy implements PricingStrategy {
    public double calculatePrice(double value) {
        return 50; // Fixed price
    }
}

class TaxiOrder {
    private PricingStrategy strategy;

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateCost(double value) {
        return strategy.calculatePrice(value);
    }
}

public class Main {
    public static void main(String[] args) {
        TaxiOrder order = new TaxiOrder();

        order.setStrategy(new DistanceStrategy());
        System.out.println("Cost by distance: " + order.calculateCost(15));

        order.setStrategy(new TimeStrategy());
        System.out.println("Cost by time: " + order.calculateCost(30));

        order.setStrategy(new FixedPriceStrategy());
        System.out.println("Fixed cost: " + order.calculateCost(0));
    }
}
