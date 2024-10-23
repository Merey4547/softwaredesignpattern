package assignment4;

import java.util.ArrayList;
import java.util.List;


class Order {
        private List<Client> clients = new ArrayList<>();
        private String status;

        public void subscribe(Client client) {
                clients.add(client);
        }

        public void unsubscribe(Client client) {
                clients.remove(client);
        }

        public void setStatus(String status) {
                this.status = status;
                notifyClients();
        }

        public String getStatus() {
                return status;
        }

        private void notifyClients() {
                for (Client client : clients) {
                        client.update(this);
                }
        }
}


class Client {
        private String name;

        public Client(String name) {
                this.name = name;
        }

        public void update(Order order) {
                System.out.println("Notification to " + name + ": Order status changed to " + order.getStatus());
        }
}


public class Main {
        public static void main(String[] args) {
                Order order = new Order();
                Client client1 = new Client("Alice");
                Client client2 = new Client("Bob");

                order.subscribe(client1);
                order.subscribe(client2);

                order.setStatus("Confirmed");
                order.setStatus("On the way");
        }
}
