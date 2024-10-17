package assignment3;

abstract class Handler {
    protected Handler nextHandler;

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    public abstract boolean handle(Request request);
}

// доступность машины
class CarAvailabilityHandler extends Handler {
    @Override
    public boolean handle(Request request) {
        if (request.isCarAvailable()) {
            System.out.println("Car is available.");
            if (nextHandler != null) return nextHandler.handle(request);
            return true;
        }
        System.out.println("No cars available.");
        return false;
    }
}

// баланс
class BalanceHandler extends Handler {
    @Override
    public boolean handle(Request request) {
        if (request.getClientBalance() >= request.getRequiredAmount()) {
            System.out.println("Client balance verified.");
            if (nextHandler != null) return nextHandler.handle(request);
            return true;
        }
        System.out.println("Insufficient balance.");
        return false;
    }
}

// можно ли доехать до указанного места
class LocationHandler extends Handler {
    @Override
    public boolean handle(Request request) {
        if (request.isLocationReachable()) {
            System.out.println("Location is reachable.");
            return true;
        }
        System.out.println("Location not reachable.");
        return false;
    }
}

// Request class to hold data
class Request {
    private boolean carAvailable;
    private double clientBalance;
    private double requiredAmount;
    private boolean locationReachable;

    public Request(boolean carAvailable, double clientBalance, double requiredAmount, boolean locationReachable) {
        this.carAvailable = carAvailable;
        this.clientBalance = clientBalance;
        this.requiredAmount = requiredAmount;
        this.locationReachable = locationReachable;
    }

    public boolean isCarAvailable() { return carAvailable; }
    public double getClientBalance() { return clientBalance; }
    public double getRequiredAmount() { return requiredAmount; }
    public boolean isLocationReachable() { return locationReachable; }
}

// Test the chain
public class Main {
    public static void main(String[] args) {
        Request request = new Request(true, 500, 100, true);

        Handler carHandler = new CarAvailabilityHandler();
        Handler balanceHandler = new BalanceHandler();
        Handler locationHandler = new LocationHandler();

        carHandler.setNext(balanceHandler);
        balanceHandler.setNext(locationHandler);

        boolean result = carHandler.handle(request);
        System.out.println("Request processing result: " + result);
    }
}
