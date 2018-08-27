package ru.job4j.compare;

/**
 *
 */
public class User implements Comparable<User> {
    /** Имя пользователя */
    public String name;
    /** Возраст пользователя */
    public Integer age;

    User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Метод для сравнения пользователей по возрасту
     * @param user - пользователь
     * @return - разница в возрасе пользователей
     */
    @Override
    public int compareTo(User user) {
        return this.age.compareTo(user.age);
    }
}
