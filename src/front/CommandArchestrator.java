package front;

import command.Command;
import command.HelloCommand;
import controller.SimpleCommandController;

public class CommandArchestrator {
    private final SimpleCommandController controller = new SimpleCommandController();
    public void likeARun() {
        Command command = new HelloCommand();
        //Решение богов
        while (true) {
            command = controller.runCommand(command);
        }
    }
}
