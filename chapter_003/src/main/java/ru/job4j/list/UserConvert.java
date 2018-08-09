package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для конвертации List<User> в HashMap<Integer, User>
 * @author Zlobin Maxim
 */
public class UserConvert {
    /**
     * Метод для конвертации List<User> в HashMap<Integer, User>
     * @param list - лист с пользователями
     * @return - HashMap с ключом id и всеми пользователями
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hm = new HashMap<Integer, User>();
        for (User current : list) {
            hm.put(current.getId(), current);
        }
        return hm;
    }
}
