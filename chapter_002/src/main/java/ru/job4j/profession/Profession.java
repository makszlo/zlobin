package ru.job4j.profession;
/**
 * Класс для профессий
 */
public class Profession extends Man {
    public String profession;

    /**
     * Конструктор по умолчанию
     */
    public Profession() {
        this.name = null;
        this.name = null;
    }
    /**
     * Конструктор для создания объекта класса Profession
     * @param name - имя
     * @param profession - профессия
     */
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = name;
    }
    /**
     * Метод для получения названия профессии
     * @return - название профессии
     */
    public String getProfession() {
        return this.profession;
    }
}
