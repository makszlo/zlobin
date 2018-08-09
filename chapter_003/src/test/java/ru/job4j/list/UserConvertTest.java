package ru.job4j.list;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс для UserConvert
 * @author Zlobin Maxim
 */
public class UserConvertTest {

    @Test
    public void listToHMapTest() {
        UserConvert userConvert = new UserConvert();
        User user1 = new User(0, "Max", "Voronezh");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        userConvert.process(list).get(0);
        assertThat(userConvert.process(list).get(0), is(user1));
    }
}