package ru.job4j.compare;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс для сортировки пользователей
 * @author Zlobin Maxim
 */
public class SortUser {

    /**
     * Метод для сортировки списака пользователей
     * @param users - список пользователей
     * @return - отсортированное множество
     */
    public Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<>();
        for (User user : users) {
            result.add(user);
        }
        return result;
    }
}
