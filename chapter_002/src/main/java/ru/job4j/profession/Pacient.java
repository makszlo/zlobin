package ru.job4j.profession;

/**
 * Класс для пациентов
 */
public class Pacient extends Man {
    public Diagnose diagnose;

    /**
     * Конструктор для создания объекта Pacient
     * @param name - имя пациента
     */
    public Pacient(String name) {
        super(name);
    }
}
