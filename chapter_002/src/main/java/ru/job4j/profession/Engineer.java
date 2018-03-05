package ru.job4j.profession;

/**
 * Класс профессии инженер
 */
public class Engineer extends Profession {
    /**
     * Конструктор для класса инженер
     * @param name - имя инженера
     */
    public Engineer(String name) {
        super(name, "Инженер");
    }

    /**
     * Конструктор для класса инженер, в случае если профессия инженера имеет отличное от стандартного название
     * @param name - имя
     * @param profession -название профессии
     */
    public Engineer(String name, String profession) {
        super(name, profession);
    }

    /**
     * Метод стоительства дома
     * @param type - тип постройки
     * @return - объект Дом
     */
    public House build(String type) {
        return new House(type);
    }
}

