package security;

import entity.User;

/**
 * Класс, который хранит текущего пользователя, который пользуется приложением
 */
public class MySecurityContext {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        MySecurityContext.currentUser = currentUser;
    }
}
