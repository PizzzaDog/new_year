package command;

public class ShutdownCommand implements Command {
    @Override
    public Command execute() {
        System.exit(1);
        return null;
    }
}
