package assignment4task2;

interface OrderState {
    void next(OrderContext context);
    void prev(OrderContext context);
    void printStatus();
}

class CreatedState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new ConfirmedState());
    }

    public void prev(OrderContext context) {
        System.out.println("Order is in the initial state.");
    }

    public void printStatus() {
        System.out.println("Order created.");
    }
}

class ConfirmedState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new OnTheWayState());
    }

    public void prev(OrderContext context) {
        context.setState(new CreatedState());
    }

    public void printStatus() {
        System.out.println("Order confirmed.");
    }
}

class OnTheWayState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new FinishedState());
    }

    public void prev(OrderContext context) {
        context.setState(new ConfirmedState());
    }

    public void printStatus() {
        System.out.println("Order is on the way.");
    }
}

class FinishedState implements OrderState {
    public void next(OrderContext context) {
        System.out.println("Order is already finished.");
    }

    public void prev(OrderContext context) {
        context.setState(new OnTheWayState());
    }

    public void printStatus() {
        System.out.println("Order completed.");
    }
}

class OrderContext {
    private OrderState state;

    public OrderContext() {
        state = new CreatedState(); // Initial state
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public void prev() {
        state.prev(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}

public class Main {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();

        order.printStatus();
        order.next();
        order.printStatus();
        order.next();
        order.printStatus();
        order.next();
        order.printStatus();
    }
}
