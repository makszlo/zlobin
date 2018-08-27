package ru.job4j.compare;

import org.junit.Test;

import java.util.ArrayList;
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
}
