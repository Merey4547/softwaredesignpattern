package assignment5task3;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentViewModel viewModel = new StudentViewModel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    viewModel.addStudent(name, age, course);
                    break;
                case 2:
                    System.out.println("Students:");
                    for (int i = 0; i < viewModel.getStudents().size(); i++) {
                        Student s = viewModel.getStudents().get(i);
                        System.out.println((i + 1) + ". " + s.getName() + " - " + s.getAge() + " - " + s.getCourse());
                    }
                    break;
                case 3:
                    System.out.print("Enter Student Number to Update: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();
                    viewModel.updateStudent(index, newName, newAge, newCourse);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
