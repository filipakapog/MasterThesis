package cemadoare;

import cemadoare.service.LoginResponsible;
import cemadoare.service.impl.LoginResponsibleImpl;

public class AppController {

    private LoginResponsible loginResponsible = new LoginResponsibleImpl();

    public static void main(String[] args) {
        AppController app = new AppController();
        if (app.loginResponsible.tryLoginUser("Filip", "filip")) {
            System.out.println("User successfully logged in");
        } else {
            System.out.println("User could not be logged in");
        }
    }
}
