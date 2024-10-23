package assignment4task4;

abstract class OrderProcess {
    public final void processOrder() {
        checkAvailability();
        calculateCost();
        confirmOrder();
    }

    protected abstract void checkAvailability();
    protected abstract void calculateCost();
    protected abstract void confirmOrder();
}

class OnlineOrder extends OrderProcess {
    @Override
    protected void checkAvailability() {
        System.out.println("Checking taxi availability online.");
    }

    @Override
    protected void calculateCost() {
        System.out.println("Calculating cost for the online order.");
    }

    @Override
    protected void confirmOrder() {
        System.out.println("Order confirmed online.");
    }
}

public class Main {
    public static void main(String[] args) {
        OrderProcess order = new OnlineOrder();
        order.processOrder();
    }
}
