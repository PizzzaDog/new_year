import entity.User;
import service.UserService;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setLogin("check");
        user.setPass("pass");
        UserService service = new UserService();
        service.register(user);

    }
}
