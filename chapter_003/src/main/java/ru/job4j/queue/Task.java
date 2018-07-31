package ru.job4j.queue;

/**
 * Класс реализующий задачу для очереди с приоритетом
 * @author Zlobin Maxim
 * @version 1.0
 */
public class Task {
    /** Описание */
    private String desc;
    /** Приоритет */
    private int priority;

    /**
     * Конструктор, создающий задачу с заданным приоритетом и описанием
     * @param desc - описание
     * @param priority - приоритет
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Метод, возвращающий опсание задачи
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Метод, возвращающий приоритет задачи
     */
    public int getPriority() {
        return priority;
    }
}
