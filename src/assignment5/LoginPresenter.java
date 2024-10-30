package assignment5;

public class LoginPresenter {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void login(User user, String inputUsername, String inputPassword) {
        if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
            view.showLoginSuccess("Login successful!");
        } else {
            view.showLoginError("Invalid username or password.");
        }
    }
}
