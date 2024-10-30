package assignment5task2;

import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        TodoController controller = new TodoController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Todos\n2. Add Todo\n3. Delete Todo\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Todos:");
                    for (int i = 0; i < controller.getTodos().size(); i++) {
                        System.out.println((i + 1) + ". " + controller.getTodos().get(i).getTitle());
                    }
                    break;
                case 2:
                    System.out.print("Enter Todo: ");
                    String title = scanner.nextLine();
                    controller.addTodo(title);
                    break;
                case 3:
                    System.out.print("Enter Todo Number to Delete: ");
                    int index = scanner.nextInt() - 1;
                    controller.deleteTodo(index);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
