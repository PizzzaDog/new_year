package controller;

import entity.User;
import service.UserService;


//TODO можно переделать в UserController
public class AuthController {
    UserService userService = new UserService();


    //Лучше сделать входным параметром User
    public void login(User user) {
        if (user.getLogin() != null && user.getPass() != null) {
            userService.login(user);
        }
    }

    public void register(User user) {
        if (user.getLogin() != null && user.getPass() != null) {
            userService.register(user);
        }
    }

    public void logout() {

    }
}
