package repository;

import entity.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserRepository {
    private static final String USER_PATH = "C:\\Work\\new_year\\src\\db\\user.txt";

    public boolean findByLogin() {
        return false;
    }

    public void save(User user) {
        try {
            String userString = "\n"
                    + user.getLogin() + "-" + user.getPass() + "-"
                    + user.getCity().getId() + "-" + user.getRole();
            FileWriter writer = new FileWriter(USER_PATH, true);
            writer.write(userString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
