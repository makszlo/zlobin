package ru.job4j.profession;

/**
 * Класс поставленного доктором диагноза
 */
public class Diagnose {
    public String name;
    public Diagnose(String name) {
        this.name = name;
    }

    /**
     * Метод для возвращения названия болезни пациента
     * @return - название болезни
     */
    public String getName() {
        return this.name;
    }
}
