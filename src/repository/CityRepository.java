package repository;

import entity.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CityRepository {
    private static final File cityFile = new File("src/resources/city.txt");


    public City findById(Integer id) {
        List<City> cities = findAll();
        Optional<City> result = cities.stream().filter(x -> x.getId().equals(id)).findFirst();
        return result.orElse(null);
    }

    public List<City> findAll() {
        List<City> result = new ArrayList<>();
        try {
            FileReader reader = new FileReader(cityFile);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                City city = new City();
                String[] citySplit = sc.nextLine().split("-");
                city.setId(Integer.parseInt(citySplit[0]));
                city.setName(citySplit[1]);
                result.add(city);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
