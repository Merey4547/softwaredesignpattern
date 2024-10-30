package assignment5;

import java.util.Scanner;

public class LoginForm implements LoginView {
    public static void main(String[] args) {
        LoginForm form = new LoginForm();
        LoginPresenter presenter = new LoginPresenter(form);

        // Hardcoded user credentials for demonstration
        User user = new User("admin", "1234");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        presenter.login(user, username, password);
    }

    @Override
    public void showLoginSuccess(String message) {
        System.out.println(message);
    }

    @Override
    public void showLoginError(String error) {
        System.out.println(error);
    }
}
