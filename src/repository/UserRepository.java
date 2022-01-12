package repository;

import entity.User;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserRepository {
    private static final File userFile = new File("src/resources/user.txt");
    private CityRepository cityRepository = new CityRepository();

    public boolean existByLogin(String login) {
        List<User> allUsers = getAllUsers();
        Optional<User> first = allUsers.stream().filter(x -> x.getLogin().equals(login)).findFirst();
        return first.isPresent();
    }

    public User findByLogin(String login) {
        return getAllUsers().stream().filter(x -> x.getLogin().equals(login)).findFirst().get();
    }

    //Дописать необходимые методы
    public void save(User user) {
        try {
            String userString = "\n"
                    + user.getLogin() + "-" + user.getPass() + "-"
                    + user.getCity().getId() + "-" + user.getRole();
            FileWriter writer = new FileWriter(userFile, true);
            writer.write(userString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try {
            FileReader reader = new FileReader(userFile);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                User user = new User();
                String[] userSplit = sc.nextLine().split("-");
                user.setLogin(userSplit[0]);
                user.setPass(userSplit[1]);
                user.setCity(cityRepository.findById(Integer.parseInt(userSplit[2])));
                user.setRole(userSplit[3]);
                result.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
