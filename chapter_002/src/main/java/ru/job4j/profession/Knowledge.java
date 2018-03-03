package ru.job4j.profession;

/**
 * Класс для полученных знаний при учёбе
 */
public class Knowledge {
    public String subject;

    /**
     * Конструктор для создания объектра Knowledge
     * @param subject - изученая тема
     */
    public Knowledge(String subject) {
        this.subject = subject;
    }

    /**
     * Метод для получения изученной темы
     * @return - изученая тема
     */
    public String getSubject() {
        return this.subject;
    }
}
