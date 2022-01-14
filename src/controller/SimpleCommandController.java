package controller;

import command.Command;

public class SimpleCommandController {
    public Command runCommand(Command command) {
        return command.execute();
    }
}
