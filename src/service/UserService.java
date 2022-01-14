package service;

import constant.ConsoleColor;
import entity.City;
import entity.User;
import repository.UserRepository;
import security.MySecurityContext;

//TODO Дописать необходимые методы/проверки/исключения(если надо)
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public void login(User user) {
        if (userRepository.existByLogin(user.getLogin())) {

            MySecurityContext.setCurrentUser(user);
        }
    }

    public boolean login(String login, String pass) {
        if (userRepository.existByLogin(login)) {
            User user = userRepository.findByLogin(login);
            if (pass.equals(user.getPass())) {
                MySecurityContext.setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public void register(String login, String password) {
        if (userRepository.existByLogin(login)) {
            System.out.println(ConsoleColor.RED + "ERROR: Пользователь с таким логином уже существует");
        } else {
            User user = new User();
            user.setLogin(login);
            user.setPass(password);
            user.setRole("USER");
            user.setCity(new City(1, "Minsk"));
            userRepository.save(user);
        }
    }

    public void register(User user) {
        if (userRepository.existByLogin(user.getLogin())) {
            System.out.println(ConsoleColor.RED + "Такой пользователь уже существует");
        } else {
            if (user.getCity() == null) {
                user.setCity(new City(1, "Minsk"));
            }
            user.setRole("USER");
            userRepository.save(user);
            MySecurityContext.setCurrentUser(user);
        }
    }

    public User getCurrentUser() {
        User currentUser = MySecurityContext.getCurrentUser();
        if (currentUser == null) {
            System.out.println(ConsoleColor.RED + "На данный момент нет авторизованного пользователя");
        }
        return currentUser;
    }

    public void logout() {
        MySecurityContext.setCurrentUser(null);
    }

}
