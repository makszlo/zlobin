package ru.job4j.search;

/**
 * Класс для хранения данных о человеке в телефонном справочнике
 * @author Zlobin Maxim
 * @version 1.0
 */
public class Person {
    /** Имя человека */
    private String name;

    /** Фамилия человека */
    private String surname;

    /** Телефонный номер человека */
    private String phone;

    /** Адрес соответствующий данному номеру */
    private String address;

    /**
     * Создаёт объекст с заданными значениями
     * @param name - см. выше
     * @param surname - см. выше
     * @param phone - см. выше
     * @param address - см. выше
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Методы для получнеия значений полей объекта
     */
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}