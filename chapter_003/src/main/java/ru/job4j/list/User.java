package ru.job4j.list;

/**
 * Класс для хранения данных о пользователе
 * @author Zlobin Maxim
 */
public class User {
    /** Уникальный номер */
    private int id;
    /** Имя пользователя*/
    private String name;
    /** Гороод */
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

}
