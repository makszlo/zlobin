package ru.job4j.profession;
/**
 * Класс для профессий
 */
public class Profession extends Man {
    public String profession;

    /**
     * Дефолтный конструктор
     */
    public Profession() {
    }
    /**
     * Конструктор для создания объекта класса Profession
     * @param name - имя
     * @param profession - профессия
     */
    public Profession(String name, String profession) {
        super(name);
        this.profession = profession;
    }
    /**
     * Метод для получения названия профессии
     * @return - название профессии
     */
    public String getProfession() {
        return this.profession;
    }
}
