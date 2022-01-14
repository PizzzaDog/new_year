package repository;

import entity.Letter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterRepository {
    private final File LETTER_FILE = new File("src/resources/letter.txt");

    public Letter findBySenderLogin(String senderLogin) {
        // Достаем все письма
        List<Letter> allLetters = findAll();
        /*
           Пробегаемся циклом по всем письмам
           и ищем то, у которого senderLogin (логин отправителя)
           совпадает с тем, которое поступило на вход в этот метод
         */
        for (Letter letter : allLetters) {
            // Если логин совпадает, возвращаем это письмо
            if (letter.getSenderLogin().equals(senderLogin)) {
                return letter;
            }
        }
        // NULL возвращать плохо
        return null;
    }

    public List<Letter> findAll() {
        /*
         * Заранее готовим контейнер в виде List<Letter>,
         * куда мы будем складывать наши письма
         */
        List<Letter> result = new ArrayList<>();
        // try/catch, потому что файл может быть не найден
        try {
            /*
             * Создаем объект fileReader, кладем в него File,
             * который указан final полем в начале класса
             * fileReader - считывает данные из файла
             */
            FileReader reader = new FileReader(LETTER_FILE);

            /*
             * Кладем reader в наш Scanner,
             * чтобы сканировать данные, которые прочитал reader
             */
            Scanner sc = new Scanner(reader);

            /*
             * Цикл - если сканнер видит,
             * что есть следующая строка (sc.hasNextLine() ),
             * заходим в тело цикла
             */
            while (sc.hasNextLine()) {
                /*
                 * Заранее создаем пустой объект Letter, в который будем
                 * складывать все его поля, полученные из строки
                 * в letter.txt
                 */
                Letter letter = new Letter();
                /*
                 * С помощью sc.nextLine() достаем из .txt
                 * файла всю строку (возвращается String объект)
                 * С помощью .split на String объекте (строке из файла)
                 * разделяем строку на поля Letter объекта по символу "-"
                 */
                String[] letterFields = sc.nextLine().split("-");
                /*
                 * Знаем, что в разделенной строке (letterFields)
                 * первым лежит логин отправителя (letterFields[0])
                 */
                letter.setSenderLogin(letterFields[0]);
                // Вторым лежит текст письма (letterFields[1])
                letter.setText(letterFields[1]);
                // Третьим лежит его статус (letterFields[2])
                letter.setStatus(letterFields[2]);
                /*
                 * Мы дополнили все поля Letter'а,
                 * который заранее создали.
                 * Теперь добавляем этот letter в result (List<Letter>)
                 * который мы создали перед циклом.
                 * В следующей итерации (пробеге) цикла
                 * объект Letter заново создастся пустым,
                 * мы заполним его новыми полями
                 * из новой строки
                 */
                result.add(letter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(Letter letter)  {
        // true означает, что мы будем дописывать данные к уже существующим в этом файле
        try {

            FileWriter writer = new FileWriter(LETTER_FILE, true);
            // Создаем строку, которую добавим в файл (в формате логин-текст-статус)
            String letterToString = "";
            letterToString += letter.getSenderLogin() + "-";
            letterToString += letter.getText() + "-";
            letterToString += letter.getStatus() + "\n";

            // Говорим writer'у записать файл
            writer.write(letterToString);

            // Говорим writer'у исполнить запись
            writer.flush();

            // Закрываем writer, т.к. он будет работать в отдельном потоке
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
