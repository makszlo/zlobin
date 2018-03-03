package ru.job4j.profession;

/**
 * Класс для построенного домов
 */
public class House {
    public String type;

    /**
     * Конструктор класса дом
     * @param type - тип постройки
     */
    public House(String type) {
        this.type = type;
    }

    /**
     * Метод для получения типа постройки
     * @return - тип постройки
     */
    public String getType() {
        return this.type;
    }
}
