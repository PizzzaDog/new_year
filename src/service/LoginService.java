package service;

import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginService {
    private static final String SANTA_LOGIN = "Santa";

    public static void login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = sc.nextLine();
        System.out.println("Введите пароль");
        String pass = sc.nextLine();
        Map<String, String> creds;
        List<User> allUsers = FileService.getAllUsers();
        creds = allUsers.stream().collect(Collectors.toMap(User::getLogin, User::getPass));
        if (creds.containsKey(login)) {
            if (creds.containsValue(pass)) {
                if (SANTA_LOGIN.equals(login)) {
                    AdminMenuService.menu();
                }
                UserMenuService.menu(login);
            } else {
                System.out.println("Неверный пароль");
            }
        } else {
            System.out.println("Нет пользователя с таким username");
            login();
        }
    }
}
