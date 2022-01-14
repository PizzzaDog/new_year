package command;

import constant.ConsoleColor;
import service.UserService;

import java.util.Scanner;

public class LoginCommand implements Command {
    private final UserService userService = new UserService();

    @Override
    public Command execute() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Чтобы вернуться, введите пустую строку в любой момент");

            System.out.println("Введите логин");
            String login = sc.nextLine();
            if (login.isEmpty()) return new HelloCommand();
            System.out.println("Введите пароль" +
                    "");
            String pass = sc.nextLine();
            if (pass.isEmpty()) return new HelloCommand();
            if (userService.login(login, pass)) {
                break;
            } else {
                System.out.println(ConsoleColor.RED +
                        "Неверный логин или пароль");
            }
        }
        return new MenuCommand();
    }
}
