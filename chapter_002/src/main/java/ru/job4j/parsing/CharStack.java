package ru.job4j.parsing;

/**
 * Класс реализующий простой char стэк
 * @author Zlobin Maxim
 * @version 1.0
 */
public class CharStack {
    /** массив char **/
    private char[] stack;
    /** Индекс последнего элемента **/
    private int pos;

    /**
     * Создаёт стэк заданной длины
     * @param length - длина стэка
     */
    public CharStack(int length) {
        this.stack = new char[length];
        this.pos = -1;
    }

    /**
     * Помещает объект в стэк
     * @param item - объект
     */
    public void push(char item) {
        this.stack[++this.pos] = item;
    }

    /**
     * Извлекает объект из стэка
     */
    public char pop() {
        return this.stack[this.pos--];
    }


}
