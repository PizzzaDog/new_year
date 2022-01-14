package command;

import java.util.Scanner;

public class HelloCommand implements Command {
    public Command execute() {
        System.out.println("Здравствуйте! \n1 - Login\n2 - Register\nДругое - EXIT");
        Scanner sc = new Scanner(System.in);
        int answer = checkAnswer(sc.nextLine());
        switch (answer) {
            case 1:
                return new LoginCommand();
            case 2:
                return new RegisterCommand();
            default:
                return new ShutdownCommand();
        }
    }

    private int checkAnswer(String answer) {
        try {
            int i = Integer.parseInt(answer);
            return i;
        } catch (final NumberFormatException e) {
            return 0;
        }
    }
}
