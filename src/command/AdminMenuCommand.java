package command;

import service.LetterService;

import java.util.Scanner;

public class AdminMenuCommand implements Command {
    private final LetterService letterService = new LetterService();

    @Override
    public Command execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Всего писем:" + letterService.countAll() + "\nEnter - выйти");
        sc.next();
        return new HelloCommand();
    }
}
