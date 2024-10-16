package assignment3task4;

import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface Mediator {
    void sendMessage(String message, User user);
}

abstract class User {
    protected Mediator mediator;
    protected String name;

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// Client, Driver, Dispatcher
class Client extends User {
    public Client(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " (Client) sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " (Client) receives: " + message);
    }
}

class Driver extends User {
    public Driver(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " (Driver) sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " (Driver) receives: " + message);
    }
}

class DispatcherMediator implements Mediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

// Test the mediator
public class Main {
    public static void main(String[] args) {
        DispatcherMediator mediator = new DispatcherMediator();

        Client client = new Client(mediator, "John");
        Driver driver = new Driver(mediator, "Alice");

        mediator.addUser(client);
        mediator.addUser(driver);

        client.send("I need a taxi.");
        driver.send("On my way.");
    }
}
