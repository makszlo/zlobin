package ru.job4j.queue;

import java.util.LinkedList;

/**
 * Класс реализующий очередь с приоритетом
 * @author Zlobin Maxim
 * @version 1.0
 */
public class PriorityQueue {
    /** Связанный список с задачами */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет в нужную позицию элемент.
     * @param task задача
     */
    public void put(Task task) {
        int current = task.getPriority();
        boolean added = false;
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getPriority() > current) {
                this.tasks.add(i, task);
                added = true;
                break;
            }
        }
        if (!added) {
            this.tasks.add(task);
        }
    }

    /**
     * Метод возвращающий первый элемент в списке
     */
    public Task take() {
        return this.tasks.poll();
    }
}

