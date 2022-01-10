package service;

import entity.City;
import entity.User;
import exception.UserAlreadyExistException;
import repository.UserRepository;
import security.MySecurityContext;


//TODO Дописать необходимые методы/проверки/исключения(если надо)
public class UserService {
    private UserRepository userRepository = new UserRepository();


    public void login(User user) {

    }

    public void register(User user) {
        if (userRepository.findByLogin()) {
            throw new UserAlreadyExistException("Такой пользователь уже существует");
        }
        if (user.getCity() == null) {
            user.setCity(new City(1, "Minsk"));
        }
        user.setRole("USER");
        userRepository.save(user);
        MySecurityContext.setCurrentUser(user);
    }
    public void logout() {
        MySecurityContext.setCurrentUser(null);
    }
}
