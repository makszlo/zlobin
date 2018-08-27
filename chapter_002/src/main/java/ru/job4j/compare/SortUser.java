package ru.job4j.compare;

import java.util.*;

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

    /**
     * Метод для сортировки по длине имени
     * @param users - список пользователей
     * @return - отсортированный список пользователей
     */
    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.name.length(), o2.name.length());
            }
        });
        return users;
    }

    /**
     * Метод для сортировки по лексикографическом порядке, а затем по возрастанию
     * @param users - список пользователей
     * @return - отсортированный список пользователей
     */
    public List<User> sortByAllFields(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int temp = o1.name.compareTo(o2.name);
                return temp == 0 ? Integer.compare(o1.age, o2.age) : temp;
            }
        });
        return users;
    }
}
