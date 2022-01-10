package controller;

import entity.User;
import service.UserService;

public class AuthController {
    UserService userService = new UserService();


    //Лучше сделать входным параметром User
    public void login(User user) {
        if (user.getLogin() != null && user.getPass() != null) {
            userService.login(user);
        }
    }

    public void register() {

    }

    public void logout() {

    }
}
