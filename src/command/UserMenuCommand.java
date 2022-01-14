package command;

import constant.ConsoleColor;
import entity.Letter;
import entity.User;
import service.LetterService;
import service.UserService;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserMenuCommand implements Command {
    private final UserService userService = new UserService();
    private final LetterService letterService = new LetterService();

    @Override
    public Command execute() {
        User currentUser = userService.getCurrentUser();
        Scanner sc = new Scanner(System.in);
        if (letterService.existBySenderLogin(currentUser.getLogin())) {
            Letter letter = letterService.findBySenderLogin(currentUser.getLogin());
            System.out.println(ConsoleColor.RED + "СТАТУС ПИСЬМА: " + letter.getStatus() + ConsoleColor.RESET
            );
            System.out.println("ТЕКСТ ПИСЬМА:" + letter.getText() + "\nEnter - выйти");
            sc.nextLine();
            return new HelloCommand();
        } else {
            System.out.println("Напишите письмо:");
            String letterText = sc.nextLine();
            Letter letter = new Letter();
            letter.setStatus("SENT");
            letter.setText(letterText);
            letter.setSenderLogin(currentUser.getLogin());
            letterService.save(letter);
            return new UserMenuCommand();
        }
    }
}
