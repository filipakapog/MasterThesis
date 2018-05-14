package cemadoare;

import cemadoare.service.impl.LoginResponsibleImpl;
import cemadoare.service.LoginResponsible;

public class AppController {

    private LoginResponsible loginResponsible = new LoginResponsibleImpl();

    public static void main(String[] args) {
        AppController app = new AppController();
        if (app.loginResponsible.successfulLogin("Filip", "filip")) {
            System.out.println("User successfully logged in");
        } else {
            System.out.println("User could not be logged in");
        }
    }
}
