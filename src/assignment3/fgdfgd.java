package assignment3;

// Command Interface
interface Command {
    void execute();
}

// Receiver: Taxi Order
class TaxiOrder {
    private String orderId;
    private String destination;

    public TaxiOrder(String orderId) {
        this.orderId = orderId;
    }

    public void create() {
        System.out.println("Order " + orderId + " created.");
    }

    public void cancel() {
        System.out.println("Order " + orderId + " canceled.");
    }

    public void changeDestination(String newDestination) {
        this.destination = newDestination;
        System.out.println("Order " + orderId + " destination changed to " + destination);
    }
}

// Concrete Commands
class CreateOrderCommand implements Command {
    private TaxiOrder order;

    public CreateOrderCommand(TaxiOrder order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.create();
    }
}

class CancelOrderCommand implements Command {
    private TaxiOrder order;

    public CancelOrderCommand(TaxiOrder order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancel();
    }
}

class ChangeDestinationCommand implements Command {
    private TaxiOrder order;
    private String newDestination;

    public ChangeDestinationCommand(TaxiOrder order, String newDestination) {
        this.order = order;
        this.newDestination = newDestination;
    }

    @Override
    public void execute() {
        order.changeDestination(newDestination);
    }
}

// Invoker class to execute commands
class Dispatcher {
    public void sendCommand(Command command) {
        command.execute();
    }
}

// Test the commands
public class Main {
    public static void main(String[] args) {
        TaxiOrder order = new TaxiOrder("123");

        Command createOrder = new CreateOrderCommand(order);
        Command cancelOrder = new CancelOrderCommand(order);
        Command changeDestination = new ChangeDestinationCommand(order, "New Address");

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.sendCommand(createOrder);
        dispatcher.sendCommand(changeDestination);
        dispatcher.sendCommand(cancelOrder);
    }
}
