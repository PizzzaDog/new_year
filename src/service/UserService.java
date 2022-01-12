package service;

import constant.ConsoleColor;
import constant.Role;
import entity.City;
import entity.User;
import exception.UserAlreadyExistException;
import repository.UserRepository;
import security.MySecurityContext;

//TODO Дописать необходимые методы/проверки/исключения(если надо)
public class UserService {
    private UserRepository userRepository = new UserRepository();


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
            user.setRole(Role.USER.name());
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

    public void logout() {
        MySecurityContext.setCurrentUser(null);
    }

    public void delete() {
//        userRepository.delete();
//        asfds
    }
}
