package ru.job4j.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тестовый класс для сортировки пользователей
 * @author Zlobin Maxim
 */
public class SortUserTest {

    @Test
    public void sortingTest() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Иван", 39));
        list.add(new User("Иван", 20));
        list.add(new User("Ольга", 15));
        list.add(new User("Александр", 60));
        TreeSet<User> result = (TreeSet<User>) sort.sort(list);
        int[] expected = {15, 20, 39, 60};
        for (int i = 0; i < list.size(); i++) {
            assertThat(result.pollFirst().age, is(expected[i]));
        }
    }

    @Test
    public void sortingByLength() {
        SortUser sort = new SortUser();
        User[] users = {new User("Сергей", 25),
                new User("Иван", 30),
                new User("Александр", 20),
                new User("Иван", 25)};
        List<User> list = Arrays.asList(users);
        sort.sortNameLength(list);
        String[] expected = {"Иван", "Иван", "Сергей", "Александр"};
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).name, is(expected[i]));
        }

    }

    @Test
    public void sortingByAllFields() {
        SortUser sort = new SortUser();
        User[] users = {new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)};
        List<User> list = new ArrayList<>();
        for (User user : users) {
            list.add(user);
        }
        sort.sortByAllFields(list);
        int[] expected = {3, 1, 2, 0};
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i), is(users[expected[i]]));
        }

    }
}
