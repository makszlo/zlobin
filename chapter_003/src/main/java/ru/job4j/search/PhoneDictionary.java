package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Класс
 * @author Zlobin Maxim
 * @version 1.0
 */
public class PhoneDictionary {

    /** Лист с людьми добавленными в справочник */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Метод для добавления нового человека в справочник
     * @param person
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод возвращающий список всех пользователей, который содержат ключевое слово в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        Person person;
        ListIterator<Person> iterator = persons.listIterator();
        while (iterator.hasNext()) {
            person = iterator.next();
            if (this.contains(person.getAddress(), key)
                    || this.contains(person.getName(), key)
                    || this.contains(person.getSurname(), key)
                    || this.contains(person.getPhone(), key)) {
                result.add(person);
            }
        }
        return result;
    }

    /**
     * Метод для поиска ключевого слова в текстовой строке
     * @param origin - слово в котором происходит поиск
     * @param key - ключевое слово
     * @return - содержится/не содержится
     */
    private boolean contains(String origin, String key) {
        int counter = 0;
        char[] originCh = origin.toCharArray();
        char[] subCh = key.toCharArray();
        int length = key.length();
        for (int i = 0; i <= origin.length() - length; i++) {
            if ((originCh[i] == subCh[0]) && (counter != length)) {
                counter = 1;
                for (int j = i + 1; j < i + length; j++) {
                    if (originCh[j] == subCh[j - i]) {
                        counter++;
                    } else {
                        break;
                    }
                }
            }
        }
        return counter == length;
    }
}
