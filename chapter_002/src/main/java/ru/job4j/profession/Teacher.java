package ru.job4j.profession;

/**
 * Класс для учителя
 */
public class Teacher extends Profession {
    /**
     * Конструктор для создания объекта учитель
     * @param name - имя учителя
     */
    public Teacher(String name) {
        this.name = name;
        this.profession = "Учитель";
    }

    /**
     * Конструктор для создания объекта учитель, в случае если профессия учителя имеет отличное от стандартного название
     * @param name - имя учителя
     * @param profession - профессия учителя
     */
    public Teacher(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Метод для обучения студентов
     * @param student - студент
     * @param subject - тема занятия
     * @return - полученые знания
     */
    public Knowledge teach(Student student, String subject) {
        return new Knowledge(subject);
    }
}
