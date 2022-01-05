package service;

import entity.Letter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserMenuService {

    public static void menu(String login) {
        List<Letter> allLetters = FileService.getAllLetters();

        Optional<Letter> letter = allLetters.stream().filter(x -> x.getSenderLogin().equals(login)).findFirst();
        if (letter.isPresent()) {
            readLetter(letter.get());
        } else {
            writeLetter();
        }
//        System.out.println("1 - написать письмо");
//        Scanner sc = new Scanner(System.in);
    }

    private static void writeLetter() {

    }

    private static void readLetter(Letter letter) {
        System.out.println(letter.getText());
    }
}
