package service;

import entity.City;
import entity.Letter;
import entity.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    private static final String USER_PATH = "C:\\Work\\new_year\\src\\db\\user.txt";
    private static final String CITY_PATH = "C:\\Work\\new_year\\src\\db\\city.txt";
    private static final String LETTER_PATH = "C:\\Work\\new_year\\src\\db\\letter.txt";

    public static void saveUser(User user) {

    }

    public static List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try {
            FileReader reader = new FileReader(USER_PATH);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String[] userFields = sc.nextLine().split("-");
                User user = new User();
                user.setLogin(userFields[0]);
                user.setPass(userFields[1]);
                user.setCity(getCityById(Integer.parseInt(userFields[2])));
                user.setRole(userFields[3]);
                result.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + USER_PATH + " не найден");
        }
        return result;
    }

    public static List<City> getAllCities() throws FileNotFoundException {
        FileReader reader = new FileReader(CITY_PATH);
        Scanner sc = new Scanner(reader);
        List<City> result = new ArrayList<>();
        while (sc.hasNextLine()) {
            City city = new City();
            String[] cityFields = sc.nextLine().split("-");
            city.setId(Integer.parseInt(cityFields[0]));
            city.setName(cityFields[1]);
            result.add(city);
        }

        return result;
    }

    public static List<Letter> getAllLetters() {
        try {
            FileReader reader = new FileReader(LETTER_PATH);
            Scanner sc = new Scanner(reader);
            List<Letter> result = new ArrayList<>();
            while (sc.hasNextLine()) {
                Letter letter = new Letter();
                String[] letterFields = sc.nextLine().split("-");
                letter.setStatus(letterFields[0]);
                letter.setSenderLogin(letterFields[1]);
                letter.setText(letterFields[2]);
                result.add(letter);
            }

            return result;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
        return null;
    }

    public static City getCityById(Integer id) throws FileNotFoundException {
        List<City> cities = getAllCities();
        return cities.stream().filter(x -> x.getId() == id).findFirst().get();
    }
}
