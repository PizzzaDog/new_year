package command;

import service.UserService;

public class MenuCommand implements Command {
    private final UserService userService = new UserService();

    @Override
    public Command execute() {
        String role = userService.getCurrentUser().getRole();
        switch (role) {
            case "USER":
                return new UserMenuCommand();
            case "ADMIN":
                return new AdminMenuCommand();
            default:
                return null;
        }
    }
}
