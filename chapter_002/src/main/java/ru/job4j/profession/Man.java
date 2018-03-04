package ru.job4j.profession;

/**
 * Класс человек
 */
public class Man {
    public String name;

    /**
     * Конструктор по умолчанию
     */
    public Man() {
        this.name = null;
    }
    /**
     * Конструктор для создания объекта класса Man
     * @param name - имя человека
     */
    public Man(String name) {
        this.name = name;
    }

    /**
     * Метод для получения имени человека
     * @return - имя человека
     */
    public String getName() {
        return this.name;
    }
}
