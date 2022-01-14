package service;


import entity.Letter;
import repository.LetterRepository;

/**
 * Сервис, в котором будут все методы
 * и бизнес логика (проверки, выполнение определенных условий и т.п.)
 * в отношении объектов класса Letter
 */
public class LetterService {
    private final LetterRepository letterRepository = new LetterRepository();

    /**
     * Метод, который находит письмо по логину пользователя.
     * Т.к. здесь не нужно доп нагрузки логикой, мы просто используем
     * метод репозитория.
     */
    public Letter findBySenderLogin(String senderLogin) {
        /*
         * Этот метод возвращает нам Letter,
         * соответственно можем сразу вернуть результат метода
         */
        return letterRepository.findBySenderLogin(senderLogin);
    }


    /**
     * Метод, который проверяет по логину,
     * есть ли у такого пользователя
     * отправленное письмо
     */
    public boolean existBySenderLogin(String senderLogin) {
        /*
         * Мы знаем, что метод
         * findBySenderLogin() вернет NULL
         * если письмо с таким автором не найдено
         */
        Letter letter = letterRepository.findBySenderLogin(senderLogin);

        /*
         * Возвращаем обратный (за счет ! ) результат сравнения letter и NULL
         * Если letter НЕ NULL, вернется TRUE
         * Если письмо пустое, то проверка letter != (не равно) NULL провалится и вернется FALSE
         */
        return letter != null;
    }

    public void save(Letter letter) {
        letterRepository.save(letter);
    }

    public Integer countAll() {
        return letterRepository.findAll().size();
    }
}
